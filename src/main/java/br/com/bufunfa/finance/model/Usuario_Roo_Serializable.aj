package br.com.bufunfa.finance.model;

import java.io.Serializable;

privileged aspect Usuario_Roo_Serializable {
    
    declare parents: Usuario implements Serializable;
    
    private static final long Usuario.serialVersionUID = 3325769688435748407L;
    
}
