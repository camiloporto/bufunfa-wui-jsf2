/**
 * 
 */
package br.com.bufunfa.finance.ui.conta;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author camilo
 *
 */
public class ContaViewTest {
	
	private ContaView template = new ContaView();
	
	public ContaViewTest() {
		
	}
	
	@Test
	public void testFindItemsByNomeLike() {
		List<TreeTableItem> result = new ArrayList<TreeTableItem>();
		result = template.findItemsByNameLike("ativo");
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() == 1);
		TreeTableItem item = result.get(0);
		Assert.assertTrue(item.getNomeConta().toLowerCase().contains("ativo"));
		
		//testa com Case Insensitive
		result.clear();
		result = template.findItemsByNameLike("AtIvO");
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() == 1);
		item = result.get(0);
		Assert.assertTrue(item.getNomeConta().toLowerCase().contains("ativo"));
		
		//testa busca com mais de um nivel
		
		addConta(item, "filho do ativo", "o filho do ativo");
		
		//testa com no filho. Aqui nao eh para a conta Ativo aparecer, pois ela nao eh mais folha
		result.clear();
		result = template.findItemsByNameLike("AtIvO");
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() == 1);
		item = result.get(0);
		Assert.assertTrue(item.getNomeConta().toLowerCase().contains("filho"));
	}
	
	void addConta(TreeTableItem parent, String nome, String descricao) {
		template.getTreeTableWidget().getEditingItem().setNomeConta(nome);
		template.getTreeTableWidget().getEditingItem().setDescricaoConta(descricao);
		template.getTreeTableWidget().setSelectedItem(parent);
		template.addItem();
	}

}
