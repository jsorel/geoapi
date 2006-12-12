/*
 * Copyright (c) 2006 - Gipuzkoako Foru Aldundia
 * http://b5m.gipuzkoa.net.  All rights reserved.
 */
package org.opengis.catalog.manager;

/**
 * TransactionException 
 * 
 * <p>
 * Esta Excepci�n se produce en caso de un fallo durante la transacci�n
 * del subsistema de mantenimiento de datos.
 * </p>
 *
 * @author Mauricio Pazos, Axios Engineering
 * @version $Id$
 */
public final class TransactionFailedException extends Exception {
    private static final long serialVersionUID = 809042024592351650L;

    /**
     * Creates a new TransactionException object.
     *
     * @param msg descripci�n del fallo
     */
    public TransactionFailedException(String msg) {
        super(msg);
    }

    /**
     * Creates a new TransactionException object.
     *
     * @param msg descripci�n del fallo
     * @param e excepci�n
     */
    public TransactionFailedException(String msg, Throwable e) {
        super(msg, e);
    }
}
