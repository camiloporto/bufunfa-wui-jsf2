/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import br.com.bufunfa.finance.ui.conta.ContaViewTest;
import br.com.bufunfa.finance.ui.conta.TreeTableItem;
import br.com.bufunfa.finance.util.TestUtils;

/**
 * @author camilo
 *
 */
public class TransacaoParserTest {
	
	private TransacaoParser parser = new TransacaoParser();
	
	private ContaViewTest contaViewTest = new ContaViewTest();
	
	final String transacaoBasica = "de: Ativos; para: Passivos; valor: 12; data: 25/02/2011; comentario: o comentario geral";
	
	public TransacaoParserTest() {
		
	}
	
	@Test
	public void testParseTransacaoBasica() {
		
		//FIXME fazer esse teste passar
		
		TransacaoItem parsed = parser.getTransactionFromTemplate(transacaoBasica);
		Assert.assertNotNull(parsed);
		TreeTableItem origemEsperada = contaViewTest.getContaViewTemplate().findItemByName("ativos");
		TreeTableItem destinoEsperada = contaViewTest.getContaViewTemplate().findItemByName("passivos");
		Double valorEsperado = new Double(12.0);
		String comentarioEsperado = "o comentario geral";
		Date dataEsperada = createDate(2011, 02, 25);
		
		Assert.assertEquals(origemEsperada.getNomeConta(), parsed.getContaOrigem());
		Assert.assertEquals(destinoEsperada.getNomeConta(), parsed.getContaDestino());
		Assert.assertEquals(valorEsperado, parsed.getValor(), 0.005);
		Assert.assertEquals(comentarioEsperado, parsed.getComentario());
//		Assert.assertEquals(dataEsperada, parsed.getData());
		TestUtils.assertDateEquals(dataEsperada, parsed.getData());
		
	}

	
	private Date createDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		
		return c.getTime();
	}

}
