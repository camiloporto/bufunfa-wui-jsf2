package br.com.bufunfa.finance.ui.transacao;

import java.lang.String;

privileged aspect TransacaoItem_Roo_ToString {
    
    public String TransacaoItem.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IdContaOrigem: ").append(getIdContaOrigem()).append(", ");
        sb.append("ContaOrigem: ").append(getContaOrigem()).append(", ");
        sb.append("ContaDestino: ").append(getContaDestino()).append(", ");
        sb.append("Comentario: ").append(getComentario()).append(", ");
        sb.append("Data: ").append(getData()).append(", ");
        sb.append("Valor: ").append(getValor());
        return sb.toString();
    }
    
}
