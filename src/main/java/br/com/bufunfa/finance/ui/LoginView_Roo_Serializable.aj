package br.com.bufunfa.finance.ui;

import java.io.Serializable;

privileged aspect LoginView_Roo_Serializable {
    
    declare parents: LoginView implements Serializable;
    
    private static final long LoginView.serialVersionUID = -3674917173525946009L;
    
}
