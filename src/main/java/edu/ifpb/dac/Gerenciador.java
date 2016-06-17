package edu.ifpb.dac;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ricardo Job
 */
//@ManagedBean(name =  "gerenciador")
@Named("gerenciador")
//@ViewScoped
//@SessionScoped
@RequestScoped

public class Gerenciador implements Serializable {

    @EJB
    private ExemploSingleton singleton;
//    @Inject
//    private ExemploSingleton singletons;

    @PostConstruct
    public void inicializar() {
        singleton.incrementarContador();
    }

    public int getContador() {
        return singleton.obterContador();
    }
}
