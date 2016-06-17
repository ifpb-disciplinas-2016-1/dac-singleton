package edu.ifpb.dac;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Ricardo Job
 */
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.READ)
public class ExemploSingleton implements Serializable {
    private int contador;
    @PostConstruct
    public void inicializar() {
        contador = 0;
    }
    private StringBuilder b;

    @Lock(LockType.WRITE)
    public void incrementarContador() {
        contador++;
    }
//    @Lock(LockType.READ)
    public int obterContador() {
        return contador;
    }
}
