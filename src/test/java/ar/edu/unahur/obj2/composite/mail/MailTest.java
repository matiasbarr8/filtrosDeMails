package ar.edu.unahur.obj2.composite.mail;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.agrupable.Agrupable;
import ar.edu.unahur.obj2.composite.filtros.Adjunto;
import ar.edu.unahur.obj2.composite.filtros.AsuntoContiene;
import ar.edu.unahur.obj2.composite.filtros.Destinatario;
import ar.edu.unahur.obj2.composite.filtros.FiltroCompuesto;
import ar.edu.unahur.obj2.composite.filtros.FiltroNot;
import ar.edu.unahur.obj2.composite.filtros.FiltroOr;
import ar.edu.unahur.obj2.composite.filtros.Remitente;
import ar.edu.unahur.obj2.composite.filtros.Tamanio;

public class MailTest {
    @Test
    void dadoUnMailConAsuntoMuyImportanteYTamaño250ConAdjuntoCumpleFiltroConTieneAdjuntoYTamanioMayorA230YAsuntoContieneImportante() {
        Mail mail = new Mail("m.barrientos@gmail.com", "l.barrientos@gmail.com", "Muy importante", 250, true, "Reunión de consorcio para tratar problema con ascensor 1");
        Agrupable tam = new Tamanio(mail, 230);
        Agrupable adj = new Adjunto(mail);
        Agrupable asu = new AsuntoContiene(mail, "importante");
        Agrupable compuesto = new FiltroCompuesto(Arrays.asList(tam,adj,asu));
        mail.setFiltro(compuesto);
        assertTrue(mail.filtrate());
    }

    //Desafío adicional
    @Test
    void dadoUnMailConAsuntoMuyImportanteYTamaño1200SinAdjuntoCumpleConElFiltroFiltroOr() {
        Mail mail = new Mail("m.barrientos@gmail.com", "l.barrientos@gmail.com", "Muy Importante", 1200, false, "Reunión de consorcio para tratar problema con ascensor 2");
        Agrupable unoUOtro = new FiltroOr(mail, "pesado", 1200);
        mail.setFiltro(unoUOtro);
        assertTrue(mail.filtrate());
    }
    @Test
    void dadoUnMailConAsuntoArchivoPesadoYTamaño1200SinAdjuntoCumpleConElFiltroFiltroNot() {
        Mail mail = new Mail("m.barrientos@gmail.com", "l.barrientos@gmail.com", "Archivo pesado", 1200, false, "Reunión de consorcio para tratar problema con ascensor 3");
        Agrupable not = new FiltroNot(mail, "pequeño");
        mail.setFiltro(not);
        assertTrue(mail.filtrate());
    }
    @Test
    void dadoUnMailEnviadoPorMatiasConAsuntoMuyImportanteYTamaño800SinAdjuntoCumpleConElFiltroRemitente() {
        Mail mail = new Mail("m.barrientos@gmail.com", "l.barrientos@gmail.com", "Muy Importante",800, false, "Reunión de consorcio para tratar problema con ascensor 4");
        Agrupable remi = new Remitente(mail, "m.barrientos@gmail.com");
        mail.setFiltro(remi);
        assertTrue(mail.filtrate());
    }
    @Test
    void dadoUnMailEnviadoALucasConAsuntoReunionUrgenteYTamaño640ConAdjuntoCumpleConElFiltroDestinatario() {
        Mail mail = new Mail("m.barrientos@gmail.com", "l.barrientos@gmail.com", "Reunion Urgente",640, true, "Reunión de consorcio para tratar problema con ascensor 5");
        Agrupable desti = new Destinatario(mail, "l.barrientos@gmail.com");
        mail.setFiltro(desti);
        assertTrue(mail.filtrate());
    }
    @Test
    void dadoUnMailEnviadoPorMatiasALucasConAsuntoReunionUrgenteYTamaño1400ConAdjuntoCumpleConElFiltroTamanioElFiltroAdjuntoElFiltroAsuntoContieneElFiltroRemitenteYElFiltroDestinatario() {
        //Armo el mail
        Mail mail = new Mail("m.barrientos@gmail.com", "l.barrientos@gmail.com", "Reunion urgente",1400, true, "Reunión de consorcio para tratar problema con ascensor 6");
        
        //Armo mis filtros y luego el primer filtro compuesto
        Agrupable tam = new Tamanio(mail, 640);
        Agrupable adj = new Adjunto(mail);
        Agrupable asu = new AsuntoContiene(mail, "urgente");
        Agrupable compuesto = new FiltroCompuesto(Arrays.asList(tam,adj,asu));

        //Armo mas filtros y luego el segundo filtro compuesto
        Agrupable remi = new Remitente(mail, "m.barrientos@gmail.com");
        Agrupable desti = new Destinatario(mail, "l.barrientos@gmail.com");
        Agrupable compuesto2 = new FiltroCompuesto(Arrays.asList(remi,desti));

        //Armo el filtro compuesto con mis 2 filtros compuestos y se lo seteo al mail
        Agrupable filtrosCompuestos = new FiltroCompuesto(Arrays.asList(compuesto,compuesto2));
        mail.setFiltro(filtrosCompuestos);
        assertTrue(mail.filtrate());
    }
}
