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
	
	/**
	 * Testa a busca de Item de conta por nome
	 * Deve retornar apenas um resultado
	 */
	@Test
	public void testFindItemByNome() {
		TreeTableItem ativo = template.findItemByName("ativos");
		Assert.assertNotNull(ativo);
		Assert.assertTrue("ativos".toLowerCase().equals(ativo.getNomeConta().toLowerCase()));
		
		//testa buscando uma conta em um nivel mais profundo
		addConta(ativo, "filho do ativo", "o filho do ativo");
		ativo = template.findItemByName("filho do ativo");
		Assert.assertNotNull(ativo);
		Assert.assertTrue("filho do ativo".toLowerCase().equals(ativo.getNomeConta().toLowerCase()));
		
		//o nome informado tem que ser exato ao nome da conta, exceto o case
		ativo = template.findItemByName("ativ");
		Assert.assertNull(ativo);
		
		//o nome informado deve ser obrigatorio
		try {
			ativo = template.findItemByName(null);
			Assert.fail("nome eh obrigatorio");
		} catch (IllegalArgumentException e) {
		}
		
		
		
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
