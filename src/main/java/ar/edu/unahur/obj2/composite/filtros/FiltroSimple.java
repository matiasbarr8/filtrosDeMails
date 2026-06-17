package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.agrupable.Agrupable;
import ar.edu.unahur.obj2.composite.mail.Mail;

public abstract class FiltroSimple implements Agrupable{
    protected Mail mail;

    public FiltroSimple(Mail mail){
        this.mail = mail;
    }

    @Override
    public Boolean aplicar() {
        return doAplicar();
    }

    protected abstract Boolean doAplicar();
    
}
