package br.com.bufunfa.finance.ui.conta;

import java.lang.String;

privileged aspect TreeTableItem_Roo_ToString {
    
    public String TreeTableItem.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Leaf: ").append(isLeaf()).append(", ");
        sb.append("FirstLevel: ").append(isFirstLevel()).append(", ");
        sb.append("ActionPanelVisibilityAttribute: ").append(getActionPanelVisibilityAttribute()).append(", ");
        sb.append("NomeConta: ").append(getNomeConta()).append(", ");
        sb.append("DescricaoConta: ").append(getDescricaoConta()).append(", ");
        sb.append("Node: ").append(getNode()).append(", ");
        sb.append("ActionPanelVisible: ").append(isActionPanelVisible());
        return sb.toString();
    }
    
}
