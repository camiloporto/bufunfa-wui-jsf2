package br.com.bufunfa.finance.ui.transacao;

import java.io.Serializable;

privileged aspect TransacaoItem_Roo_Serializable {
    
    declare parents: TransacaoItem implements Serializable;
    
}
