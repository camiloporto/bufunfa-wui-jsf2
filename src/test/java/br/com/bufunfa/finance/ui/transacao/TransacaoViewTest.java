/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.util.Calendar;
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
		verificaTransacaoEditVaziaEDiferenteDeNull(t);
	}
	
	@Test
	public void testAddTransacao_contaOrigemVazia() {
		
		TransacaoView t = TestUtils.criaTransacaoViewTemplate();
		TransacaoItem itemSemOrigem = TestUtils.criaTransacao("","destino",TestUtils.criaData1Jan2010(), 12.0);
		
		TestUtils.fillTransacaoViewItem(t, itemSemOrigem);
		t.addTransacaoPadrao();
		
		List<TransacaoItem> items = t.getTransacaoList();
		Assert.assertEquals(0, items.size());
		verificaTransacaoEditVaziaEDiferenteDeNull(t);
		
	}
	
	@Test
	public void testAddTransacao_valorZero() {
		
		TransacaoView t = TestUtils.criaTransacaoViewTemplate();
		TransacaoItem itemComValorZero = TestUtils.criaTransacaoItemSalarioToBar30();
		itemComValorZero.setValor(0.0);
		
		TestUtils.fillTransacaoViewItem(t, itemComValorZero);
		t.addTransacaoPadrao();
		
		List<TransacaoItem> items = t.getTransacaoList();
		Assert.assertEquals(0, items.size());
		verificaTransacaoEditVaziaEDiferenteDeNull(t);
		
	}
	
	@Test
	public void testAddTransacao_dataNaoInformada() {
		
		TransacaoView t = TestUtils.criaTransacaoViewTemplate();
		TransacaoItem itemComDataNaoInformada = TestUtils.criaTransacaoItemSalarioToBar30();
		itemComDataNaoInformada.setData(null);
		
		TransacaoItem expected = TestUtils.criaTransacaoItemSalarioToBar30();
		expected.setData(Calendar.getInstance().getTime());
		
		TestUtils.fillTransacaoViewItem(t, itemComDataNaoInformada);
		t.addTransacaoPadrao();
		
		List<TransacaoItem> items = t.getTransacaoList();
		Assert.assertEquals(1, items.size());
		
		TransacaoItem added = items.get(0);
		
		TestUtils.verifyTransacaoItemEquals(expected, added);
		verificaTransacaoEditVaziaEDiferenteDeNull(t);
		
	}
	
	@Test
	public void testAddTransacao_contaDestinoVazia() {
		
		TransacaoView t = TestUtils.criaTransacaoViewTemplate();
		TransacaoItem itemSemDestinoInformada = TestUtils.criaTransacao("origem","",TestUtils.criaData1Jan2010(), 12.0);
		
		TestUtils.fillTransacaoViewItem(t, itemSemDestinoInformada);
		t.addTransacaoPadrao();
		
		List<TransacaoItem> items = t.getTransacaoList();
		Assert.assertEquals(0, items.size());
		verificaTransacaoEditVaziaEDiferenteDeNull(t);
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
	
	private void verificaTransacaoEditVaziaEDiferenteDeNull(TransacaoView transacaoView) {
		Assert.assertNotNull(transacaoView.getTransacaoEdit());
		Assert.assertNull(transacaoView.getTransacaoEdit().getComentario());
		Assert.assertNull(transacaoView.getTransacaoEdit().getContaDestino());
		Assert.assertNull(transacaoView.getTransacaoEdit().getContaOrigem());
//		Assert.assertNull(transacaoView.getTransacaoEdit().getData());
		Assert.assertNull(transacaoView.getTransacaoEdit().getIdContaOrigem());
		Assert.assertNull(transacaoView.getTransacaoEdit().getValor());
	}
	
	
	//TODO fazer mais testes: argumentos obrigatorios invalidos, inexistentes, etc..

}
