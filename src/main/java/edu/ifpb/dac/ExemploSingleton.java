 
package edu.ifpb.dac;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Ricardo Job
 */
@Startup
@Singleton
public class ExemploSingleton {
 
    private int contador;
 
    @PostConstruct
    public void inicializar(){
        contador = 0;
    }
 
    public void incrementarContador(){
        contador++;
    }
 
    public int obterContador(){
        return contador;
    }
}
