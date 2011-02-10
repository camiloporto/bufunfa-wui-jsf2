package br.com.bufunfa.finance.ui.transacao;

import java.io.Serializable;

privileged aspect TransacaoView_Roo_Serializable {
    
    declare parents: TransacaoView implements Serializable;
    
}
