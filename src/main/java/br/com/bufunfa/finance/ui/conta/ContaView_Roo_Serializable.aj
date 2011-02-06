package br.com.bufunfa.finance.ui.conta;

import java.io.Serializable;

privileged aspect ContaView_Roo_Serializable {
    
    declare parents: ContaView implements Serializable;
    
    private static final long ContaView.serialVersionUID = -3342637748568406899L;
    
}
