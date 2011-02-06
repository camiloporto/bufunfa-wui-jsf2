/**
 * 
 */
package br.com.bufunfa.finance.ui.conta;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.roo.addon.serializable.RooSerializable;

/**
 * @author camilo
 *
 */
@ManagedBean(name="contaView")
@SessionScoped
@RooSerializable
public class ContaView {
	
	private TreeTableWidget treeTableWidget = new TreeTableWidget();
	
	public ContaView() {
		
	}
	
	public TreeTableWidget getTreeTableWidget() {
		return treeTableWidget;
	}

	public void addItem() {
		treeTableWidget.addItem();
	}

	public void deleteItem() {
		treeTableWidget.deleteItem();
	}

	public boolean isEditing() {
		return treeTableWidget.isEditing();
	}

	public void saveItem() {
		treeTableWidget.saveItem();
	}

	public void showEditItemForm() {
		treeTableWidget.showEditItemForm();
	}

	public void showNewItemForm() {
		treeTableWidget.showNewItemForm();
	}

	public void updateItem() {
		treeTableWidget.updateItem();
	}
	
	

}
