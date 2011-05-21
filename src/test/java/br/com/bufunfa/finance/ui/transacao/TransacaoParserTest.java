/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.bufunfa.finance.ui.conta.ContaView;
import br.com.bufunfa.finance.ui.conta.ContaViewTest;
import br.com.bufunfa.finance.ui.conta.TreeTableItem;
import br.com.bufunfa.finance.ui.conta.TreeTableWidget;
import br.com.bufunfa.finance.util.TestUtils;

/**
 * @author camilo
 *
 */
public class TransacaoParserTest {
	
	private TransacaoParser parser = new TransacaoParser();
	
	private ContaViewTest contaViewTest = new ContaViewTest();
	
	final String transacaoBasica = "de: Ativos; para: Passivos; valor: 12; data: 25/02/2011; comentario: o comentario geral";
	
	final String transacaoSomenteComParteDaOrigem = "de: des";//inicio de DESpesa...
	
	final String transacaoComParteDaOrigemEDestino = "de: des";//inicio de DESpesa...
	
	public TransacaoParserTest() {
		
	}
	
	@BeforeClass
	public static void setUp() {
		
	}
	
	@Before
	public void initTest() {
		TreeTableItem despesas = contaViewTest.getContaViewTemplate().findLeafItemByName("despesas");
		Assert.assertNotNull(despesas);
		
		contaViewTest.addConta(despesas, "Despesa 1", null);
		contaViewTest.addConta(despesas, "Despesa 2", null);
		parser.setContaView(contaViewTest.getContaViewTemplate());
		
	}
	
	

	@Test
	public void testParseTransacaoBasica() {
		
		TransacaoItem parsed = parser.getTransactionFromTemplate(transacaoBasica);
		Assert.assertNotNull(parsed);
		TreeTableItem origemEsperada = contaViewTest.getContaViewTemplate().findLeafItemByName("ativos");
		TreeTableItem destinoEsperada = contaViewTest.getContaViewTemplate().findLeafItemByName("passivos");
		Double valorEsperado = new Double(12.0);
		String comentarioEsperado = "o comentario geral";
		Date dataEsperada = createDate(2011, 02, 25);
		
		Assert.assertEquals(origemEsperada.getNomeConta(), parsed.getContaOrigem());
		Assert.assertEquals(destinoEsperada.getNomeConta(), parsed.getContaDestino());
		Assert.assertEquals(valorEsperado, parsed.getValor(), 0.005);
		Assert.assertEquals(comentarioEsperado, parsed.getComentario());
		TestUtils.assertDateEquals(dataEsperada, parsed.getData());
		
	}
	
	@Test
	public void testGetSugestoesInformandoOrigem() {
		
		List<TransacaoItem> sugestoes = parser.getSuggestedTransaction(transacaoSomenteComParteDaOrigem);
		Assert.assertNotNull(sugestoes);
		Assert.assertFalse(sugestoes.isEmpty());
		Assert.assertEquals(2, sugestoes.size());
		
		//verifica que as origens sugeridas estão dentro das contas de origem cadastradas
		List<TreeTableItem> origensSugeridas = contaViewTest.getContaViewTemplate().findLeafItemsByNameLike("des");//pegar contas de DESpesas
		for (TransacaoItem item : sugestoes) {
			boolean achou = false;
			String origemSugerida = item.getContaOrigem();
			for (TreeTableItem contatem : origensSugeridas) {
				if(origemSugerida.equalsIgnoreCase(contatem.getNomeConta()))
					achou = true;
				
			}
			Assert.assertTrue(achou);
		}
		
		//TODO adicionar teste para proximo passo de iteracao do usuario. ele digitou origem e agora vai digitar destino.. verificar sugestoes
		
	}
	
	@Test
	public void testGetSugestoesInformandoOrigemEDestino() {
		
	}
	
	
	private Date createDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		
		return c.getTime();
	}

}
