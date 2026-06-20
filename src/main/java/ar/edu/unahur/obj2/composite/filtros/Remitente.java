package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.mail.Mail;

public class Remitente extends FiltroSimple{
    private String remitente;

    public Remitente(Mail mail, String remitente) {
        super(mail);
        this.remitente = remitente;
    }

    @Override
    protected Boolean doAplicar() {
        return mail.getFrom().equals(remitente);
    }
}
