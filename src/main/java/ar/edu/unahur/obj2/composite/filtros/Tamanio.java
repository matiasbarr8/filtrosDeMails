package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.mail.Mail;

public class Tamanio extends FiltroSimple{
    private Integer valorMinimo;

    public Tamanio(Mail mail, Integer valorMinimo) {
        super(mail);
        this.valorMinimo = valorMinimo;
    }

    @Override
    protected Boolean doAplicar() {
        return Boolean.valueOf(mail.getTamanio() >= valorMinimo);
    }
}
