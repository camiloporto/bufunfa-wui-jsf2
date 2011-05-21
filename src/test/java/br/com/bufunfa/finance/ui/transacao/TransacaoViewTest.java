/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.bufunfa.finance.util.TestUtils;

/**
 * @author camilo
 *
 */
public class TransacaoViewTest {
	
	
	@Test
	public void testAddTransacaoBasica() {
		
		TransacaoView t = TestUtils.criaTransacaoViewTemplate();
		TransacaoItem expected = TestUtils.criaTransacaoItemSalarioToBar30();
		
		TestUtils.fillTransacaoViewItem(t, expected);
		t.addTransacaoPadrao();
		
		List<TransacaoItem> items = t.getTransacaoList();
		Assert.assertEquals(1, items.size());
		
		TransacaoItem added = items.get(0);
		TestUtils.verifyTransacaoItemEquals(expected, added);
	}
	
	@Test
	public void testRemoveTransacaoValida() {
		
		TransacaoView view = TestUtils.criaTransacaoViewTemplate();
		addTransacaoItemSalarioToBar30(view);
		TransacaoItem added = view.getTransacaoList().get(0);
		
		view.setTransacaoSelected(added);
		view.removeTransacaoSelected();
		
		verificaListaDeTransacaoVazia(view);
		
	}
	
	@Test
	public void testRemoveTransacaoNula() {
		
		TransacaoView view = TestUtils.criaTransacaoViewTemplate();
		
		view.setTransacaoSelected(null);
		try {
			view.removeTransacaoSelected();
		} catch (Throwable e) {
			Assert.fail("remocao de transacao nula - lancou excecao");
		}
		
		
	}
	
	private void verificaListaDeTransacaoVazia(TransacaoView view) {
		Assert.assertTrue(view.getTransacaoList().isEmpty());
		
	}

	private TransacaoItem addTransacaoItemSalarioToBar30(TransacaoView view) {
		TransacaoItem expected = TestUtils.criaTransacaoItemSalarioToBar30();
		
		TestUtils.fillTransacaoViewItem(view, expected);
		view.addTransacaoPadrao();
		
		return expected;
	}
	
	
	//TODO fazer mais testes: argumentos obrigatorios invalidos, inexistentes, etc..

}
