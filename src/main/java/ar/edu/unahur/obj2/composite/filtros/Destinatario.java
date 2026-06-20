package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.mail.Mail;

public class Destinatario extends FiltroSimple{
    private String destinatario;

    public Destinatario(Mail mail, String destinatario) {
        super(mail);
        this.destinatario = destinatario;
    }

    @Override
    protected Boolean doAplicar() {
        return mail.getTo().equals(destinatario);
    }
}
