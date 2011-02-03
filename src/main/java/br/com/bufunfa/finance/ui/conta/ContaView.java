/**
 * 
 */
package br.com.bufunfa.finance.ui.conta;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author camilo
 *
 */
@ManagedBean(name="contaView")
@SessionScoped
public class ContaView {
	
	private TreeTableWidget treeTableWidget = new TreeTableWidget();
	
	public ContaView() {
		
	}
	
	public TreeTableWidget getTreeTableWidget() {
		return treeTableWidget;
	}

}
