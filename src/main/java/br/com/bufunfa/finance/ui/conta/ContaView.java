/**
 * 
 */
package br.com.bufunfa.finance.ui.conta;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.TreeNode;
import org.springframework.roo.addon.serializable.RooSerializable;

/**
 * @author camilo
 *
 */
//@Component
@RooSerializable
public class ContaView {
	
	//FIXME Nao esta criando os Beans! Verificar
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4111788223857609995L;
	
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
	
	/**
	 * Busca o item de conta pelo nome (ignorando case)
	 * @param name nome da conta
	 * @return o item. null se nao encontrar
	 */
	public TreeTableItem findLeafItemByName(String name) {
		if(name == null) throw new IllegalArgumentException("param name is required");
		List<TreeTableItem> singleResult = findLeafItemsByNameLike(name);
		for (TreeTableItem candidate : singleResult) {
			if(candidate.getNomeConta().toLowerCase().equals(name.toLowerCase())) {
				return candidate;
			}
		}
		
		return null;
	}
	
	
	/**
	 * Retorna contas folhas por um nome parcial
	 * @param name parte do nome da conta
	 * @return
	 */
	public List<TreeTableItem> findLeafItemsByNameLike(String name) {
		List<TreeTableItem> itemsFound = new ArrayList<TreeTableItem>();
		return findItemsByNameLike2(name, getTreeTableWidget().getRootNode(), itemsFound);
	}
	
	private List<TreeTableItem> findItemsByNameLike2(String name, TreeNode root, List<TreeTableItem> result) {
		if(root.isLeaf()) {
			TreeTableItem item = (TreeTableItem) root.getData();
			if(item == null)
				return result;
			if(item.getNomeConta().toLowerCase().contains(name.toLowerCase())) {
				result.add(item);
			}
		} else {
			List<TreeNode> children = root.getChildren();
			for (TreeNode nextChild : children) {
				result = findItemsByNameLike2(name, nextChild, result);
			}
		}
		
		return result;
		
	}
	
	

}
