package br.com.bufunfa.finance.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;

import br.com.bufunfa.finance.ui.conta.ContaView;
import br.com.bufunfa.finance.ui.conta.TreeTableItem;
import br.com.bufunfa.finance.ui.transacao.TransacaoItem;
import br.com.bufunfa.finance.ui.transacao.TransacaoView;

public class TestUtils {
	
	
	@Test
	public void testFoo() {
		//XXX como fazer o maven ignorar essa classe e nao tentar executar ela como teste
	}
	
	public static void fillTransacaoViewItem(TransacaoView view, TransacaoItem item) {
		view.getTransacaoEdit().setContaOrigem(item.getContaOrigem());
		view.getTransacaoEdit().setContaDestino(item.getContaDestino());
		view.getTransacaoEdit().setData(item.getData());
		view.getTransacaoEdit().setValor(item.getValor());
	}
	
	public static void assertDateEquals(Date expected, Date actual) {
		if((expected != null && actual == null) || (expected == null && actual != null))
			Assert.fail("as datas esperadas e informadas não sao iguais. uma eh nula e outra nao");
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(expected);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(actual);
		
		Assert.assertEquals(c1.get(Calendar.DAY_OF_MONTH), c2.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(c1.get(Calendar.MONTH), c2.get(Calendar.MONTH));
		Assert.assertEquals(c1.get(Calendar.YEAR), c2.get(Calendar.YEAR));
		
	}
	
	public static ContaView criaContaViewTemplate() {
		ContaView c = new ContaView();
		TreeTableItem ativos = c.findLeafItemByName("Ativos");
		TreeTableItem passivos = c.findLeafItemByName("Passivos");
		TreeTableItem receitas = c.findLeafItemByName("Receitas");
		TreeTableItem despesas = c.findLeafItemByName("Despesas");
		
		addContaToView(c, ativos, "Petr4", null);
		addContaToView(c, passivos, "Visa", null);
		addContaToView(c, receitas, "Salario", null);
		addContaToView(c, despesas, "Bar", null);
		
		return c;
	}
	
	public static TransacaoView criaTransacaoViewTemplate() {
		TransacaoView t = new TransacaoView();
		t.setContaView(criaContaViewTemplate());
		
		return t;
	}
	
	private static void addContaToView(ContaView template, TreeTableItem parent, String nome, String descricao) {
		template.getTreeTableWidget().getEditingItem().setNomeConta(nome);
		template.getTreeTableWidget().getEditingItem().setDescricaoConta(descricao);
		template.getTreeTableWidget().setSelectedItem(parent);
		template.addItem();
	}

	public static Date criaData1Jan2010() {
		return new GregorianCalendar(2010, Calendar.JANUARY, 1).getTime();
	}

	public static void verifyTransacaoItemEquals(TransacaoItem expected,
			TransacaoItem informed) {
		if(expected == null && informed != null) {
			Assert.fail("item expected null. informed not null");
		}
		Assert.assertEquals("item.origem", expected.getContaOrigem(), informed.getContaOrigem());
		Assert.assertEquals("item.destino", expected.getContaDestino(), informed.getContaDestino());
		assertDateEquals(expected.getData(), informed.getData());
		Assert.assertEquals("item.valor", expected.getValor(), informed.getValor());
		Assert.assertEquals("item.comentario", expected.getComentario(), informed.getComentario());
		
	}

	public static TransacaoItem criaTransacaoItemSalarioToBar30() {
		TransacaoItem i = new TransacaoItem();
		i.setContaOrigem("Salario");
		i.setContaDestino("Bar");
		i.setData(TestUtils.criaData1Jan2010());
		i.setValor(new BigDecimal("30.00").doubleValue());
		
		return i;
	}

	public static TransacaoItem criaTransacaoVazia() {
		return criaTransacao("", "", null, 0.0);
	}

	public static TransacaoItem criaTransacao(String origem, String destino,
			Date data, double valor) {
		TransacaoItem t = new TransacaoItem();
		t.setComentario("comentario");
		t.setContaDestino(destino);
		t.setContaOrigem(origem);
		t.setData(data);
		t.setValor(valor);
		
		return t;
	}

}
