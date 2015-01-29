package edu.ifpb.dac;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ricardo Job
 */
@Named(value = "gerenciador")
@ViewScoped
public class Gerenciador {

    @EJB
    private ExemploSingleton singleton;

    @PostConstruct
    public void inicializar() {
        singleton.incrementarContador();
    }

    public int getContador() {
        return singleton.obterContador();
    }
}
