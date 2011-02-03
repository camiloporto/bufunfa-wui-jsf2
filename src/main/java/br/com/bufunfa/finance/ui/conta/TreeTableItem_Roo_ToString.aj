package br.com.bufunfa.finance.ui.conta;

import java.lang.String;

privileged aspect TreeTableItem_Roo_ToString {
    
    public String TreeTableItem.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Leaf: ").append(isLeaf()).append(", ");
        sb.append("NomeConta: ").append(getNomeConta()).append(", ");
        sb.append("DescricaoConta: ").append(getDescricaoConta()).append(", ");
        sb.append("Node: ").append(getNode());
        return sb.toString();
    }
    
}
