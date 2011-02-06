/**
 * 
 */
package br.com.bufunfa.finance.ui.conta;

import org.primefaces.model.TreeNode;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * @author camilo
 *
 */
@RooToString
@RooJavaBean
@RooSerializable
public class TreeTableItem {
	
	private String nomeConta;
	
	private String descricaoConta;
	
	private TreeNode node;
	
	private boolean actionPanelVisible = true;

	public TreeTableItem(String nomeConta, String descricaoConta) {
		super();
		this.nomeConta = nomeConta;
		this.descricaoConta = descricaoConta;
	}
	
	public TreeTableItem() {
		
	}
	
	public boolean isLeaf() {
		return node != null ? node.isLeaf() : false;
	}
	
	/**
	 * Verifica se o item da arvore refere-se aos nos de
	 * primeiro nivel (ativo, passivo, receita, despesa)
	 * @return
	 */
	public boolean isFirstLevel() {
		if(node != null) {
			TreeNode parent = node.getParent();
			if(parent != null) {
				return parent.getParent() == null;
			}
		}
		return false;
	}
	
	public String getActionPanelVisibilityAttribute() {
		return isActionPanelVisible() ? "visibility:visible" : "visibility:hidden";
	}

}
