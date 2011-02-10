/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * @author camilo
 *
 */
@RooJavaBean
@RooSerializable
@RooToString
public class TransacaoItem {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1586288883354391713L;

	//FIXME AJustar formulario da view aos atributos daqui.. formalizar tudo bunitim.. tirar strings e colocar tipos corretos
	/**
	 * implementar acao de adicionar transacao
	 */
	
	private String contaOrigem;
	
	private String contaDestino;
	
	private String comentario;
	
	private Date data;
	
	private Double valor;
	
	public TransacaoItem() {
		
	}

}
