package br.com.bufunfa.finance.ui.conta;

import java.lang.String;
import org.primefaces.model.TreeNode;

privileged aspect TreeTableItem_Roo_JavaBean {
    
    public String TreeTableItem.getNomeConta() {
        return this.nomeConta;
    }
    
    public void TreeTableItem.setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }
    
    public String TreeTableItem.getDescricaoConta() {
        return this.descricaoConta;
    }
    
    public void TreeTableItem.setDescricaoConta(String descricaoConta) {
        this.descricaoConta = descricaoConta;
    }
    
    public TreeNode TreeTableItem.getNode() {
        return this.node;
    }
    
    public void TreeTableItem.setNode(TreeNode node) {
        this.node = node;
    }
    
}
