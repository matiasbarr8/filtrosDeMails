package ar.edu.unahur.obj2.composite.mail;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.agrupable.Agrupable;
import ar.edu.unahur.obj2.composite.filtros.Adjunto;
import ar.edu.unahur.obj2.composite.filtros.AsuntoContiene;
import ar.edu.unahur.obj2.composite.filtros.FiltroCompuesto;
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
}
