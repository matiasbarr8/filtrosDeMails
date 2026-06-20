package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.mail.Mail;

public class FiltroNot extends FiltroSimple{
    private String texto;
    public FiltroNot(Mail mail,String texto) {
        super(mail);
        this.texto = texto;
    }

    @Override
    protected Boolean doAplicar() {
        return !mail.getAsunto().contains(texto) && !mail.getAdjunto();
    }

}
