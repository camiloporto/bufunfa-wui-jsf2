/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author camilo
 *
 */
public class TransacaoParser {
	
	//FIXME Internacionalizar os tokens dessa classe (de, para - from, to..)
	private final String _DE = "de";
	
	private final String _PARA = "para";
	
	private final String _VALOR = "valor";
	
	private final String _DATA = "data";
	
	private final String _COMENTARIO = "comentario";

	public TransacaoParser() {
		
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
		TransacaoItem t = new TransacaoItem();
		t.setComentario(comentario);
		t.setContaOrigem(contaOrigem);
		t.setContaDestino(contaDestino);
		
		Double valor = parseDouble(valorStr);
		Date data = parseData(dataStr);
		
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
