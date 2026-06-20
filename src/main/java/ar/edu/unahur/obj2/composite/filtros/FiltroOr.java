package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.mail.Mail;

public class FiltroOr extends FiltroSimple{
    private String texto;
    private Integer valorMinimo;

    public FiltroOr(Mail mail,String texto,Integer valorMinimo) {
        super(mail);
        this.texto = texto;
        this.valorMinimo = valorMinimo;
    }

    @Override
    protected Boolean doAplicar() {
        return mail.getAsunto().contains(texto) || Boolean.valueOf(mail.getTamanio() >= valorMinimo);
    }

}
