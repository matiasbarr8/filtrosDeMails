package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.mail.Mail;

public class Adjunto extends FiltroSimple{

    public Adjunto(Mail mail) {
        super(mail);
    }

    @Override
    protected Boolean doAplicar() {
        return mail.getAdjunto();
    }

}
