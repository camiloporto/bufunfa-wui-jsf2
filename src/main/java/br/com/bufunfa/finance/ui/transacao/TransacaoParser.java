/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.bufunfa.finance.ui.conta.ContaView;
import br.com.bufunfa.finance.ui.conta.TreeTableItem;

/**
 * @author camilo
 *
 */
public class TransacaoParser {
	
	private static final Logger logger = Logger.getLogger(TransacaoParser.class);
	
	//FIXME Internacionalizar os tokens dessa classe (de, para - from, to..)
	private final String _DE = "de";
	
	private final String _PARA = "para";
	
	private final String _VALOR = "valor";
	
	private final String _DATA = "data";
	
	private final String _COMENTARIO = "comentario";
	
	private ContaView contaView;

	public TransacaoParser() {
		
	}
	
	public void setContaView(ContaView contaView) {
		this.contaView = contaView;
	}
	
	/**
	 * Retorna uma lista de transacaoItem preenchidas
	 * apenas com sugestos dos parametros pacialmente
	 * fornecidos pelo usuario
	 * @param userParcialInput
	 * @return
	 */
	public List<TransacaoItem> getSuggestedTransaction(
			String userParcialInput) {
		
		List<TransacaoItem> result = new ArrayList<TransacaoItem>();
		TransacaoItem userTemplate = getTransactionFromTemplate(userParcialInput);
		String nomeParcialContaOrigem = userTemplate.getContaOrigem();
		List<TreeTableItem> sugestoesDeContaOrigem = contaView.findLeafItemsByNameLike(nomeParcialContaOrigem);
		for (TreeTableItem proximaOrigem : sugestoesDeContaOrigem) {
			TransacaoItem transacaoSugerida = new TransacaoItem();
			transacaoSugerida.setContaOrigem(proximaOrigem.getNomeConta());
			logger.info("sugerindo transacao: " + transacaoSugerida);
			result.add(transacaoSugerida);
		}
		
		return result;
	}
	
	public TransacaoItem getTransactionFromTemplate(String transacaoBasica) {
		String[] args = transacaoBasica.split(";");
		String[] param = null;
		int argCount = args.length;
		String contaOrigem = null;
		String contaDestino = null;
		String valorStr = null;
		String dataStr = null;
		String comentario = null;
		
		for(int i = 0; i < argCount; i++) {
			String nextArg = args[i];
			if(isContaOrigemParam(nextArg)) {
				param = nextArg.split(":");
				if(param.length == 2) {
					contaOrigem = param[1].trim();
				}
			}
			
			if(isContaDestinoParam(nextArg)) {
				param = nextArg.split(":");
				if(param.length == 2) {
					contaDestino = param[1].trim();
				}
			}
			
			if(isValorParam(nextArg)) {
				param = nextArg.split(":");
				if(param.length == 2) {
					valorStr = param[1].trim();
				}
			}
			
			if(isDateParam(nextArg)) {
				param = nextArg.split(":");
				if(param.length == 2) {
					dataStr = param[1].trim();
				}
			}
			
			if(isComentarioParam(nextArg)) {
				param = nextArg.split(":");
				if(param.length == 2) {
					comentario = param[1].trim();
				}
			}
		}
		
		return createTransactionTemplate(contaOrigem, contaDestino, valorStr, dataStr, comentario);
	}
	
	
	private TransacaoItem createTransactionTemplate(String contaOrigem,
			String contaDestino, String valorStr, String dataStr,
			String comentario) {
		
		logger.info("criando transacao: " + contaOrigem + " # " + contaDestino + " # " + valorStr + " # " + dataStr + " # " + comentario);
		
		TransacaoItem t = new TransacaoItem();
		t.setComentario(comentario);
		t.setContaOrigem(contaOrigem);
		t.setContaDestino(contaDestino);
		
		Double valor = null;
		Date data = null;
		
		if(valorStr != null)
			valor = parseDouble(valorStr);
		
		if(dataStr == null)
			data = Calendar.getInstance().getTime();
		else
			data = parseData(dataStr);
		
		t.setData(data);
		t.setValor(valor);
		
		return t;
	}

	
	private Date parseData(String dataStr) {
		//FIXME Incrementar isso.. tratar internacionalizacao
		String[] values = dataStr.split("/");
		Calendar c = Calendar.getInstance();
		c.set(
				Integer.parseInt(values[2]), 
				Integer.parseInt(values[1]), 
				Integer.parseInt(values[0]));
		
		return c.getTime();
	}

	private Double parseDouble(String valorStr) {
		try {
			return Double.parseDouble(valorStr);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("br.com.bufunfa.finance.numeroInvalido");
		}
	}

	private boolean isComentarioParam(String nextArg) {
		String[] values = nextArg.split(":");
		String paramName = values[0];
		return isParamEquals(_COMENTARIO, paramName);
	}

	private boolean isDateParam(String nextArg) {
		String[] values = nextArg.split(":");
		String paramName = values[0];
		return isParamEquals(_DATA, paramName);
	}

	private boolean isValorParam(String nextArg) {
		String[] values = nextArg.split(":");
		String paramName = values[0];
		return isParamEquals(_VALOR, paramName);
	}

	private boolean isContaDestinoParam(String nextArg) {
		String[] values = nextArg.split(":");
		String paramName = values[0];
		return isParamEquals(_PARA, paramName);
	}

	private boolean isContaOrigemParam(String nextArg) {
		String[] values = nextArg.split(":");
		String paramName = values[0];
		return isParamEquals(_DE, paramName);
	}

	private String extractParamValue(String[] param) {
		if(param.length == 2 && _DE.equals(param[0])) {
			return param[1];
		}
		return null;
	}
	
	private boolean isParamEquals(String paramToken, String paramName) {
		if(paramName == null)
			return false;
		return paramToken.toLowerCase().equals(paramName.toLowerCase().trim());
	}

	

}
