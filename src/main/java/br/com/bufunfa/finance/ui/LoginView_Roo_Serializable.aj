package br.com.bufunfa.finance.ui;

import java.io.Serializable;

privileged aspect LoginView_Roo_Serializable {
    
    declare parents: LoginView implements Serializable;
    
    private static final long LoginView.serialVersionUID = -6004855204433951726L;
    
}
