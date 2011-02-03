package br.com.bufunfa.finance.ui.conta;

import java.io.Serializable;

privileged aspect TreeTableItem_Roo_Serializable {
    
    declare parents: TreeTableItem implements Serializable;
    
    private static final long TreeTableItem.serialVersionUID = 4679140156694290089L;
    
}
