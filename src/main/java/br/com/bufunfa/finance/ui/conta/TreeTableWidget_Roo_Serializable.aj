package br.com.bufunfa.finance.ui.conta;

import java.io.Serializable;

privileged aspect TreeTableWidget_Roo_Serializable {
    
    declare parents: TreeTableWidget implements Serializable;
    
    private static final long TreeTableWidget.serialVersionUID = 3705481481615942435L;
    
}
