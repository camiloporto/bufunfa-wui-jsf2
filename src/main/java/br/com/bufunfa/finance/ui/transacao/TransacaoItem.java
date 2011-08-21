/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.util.Calendar;
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

	private Long id;
	
	private Long idContaOrigem;
	
	private String contaOrigem;
	
	private String contaDestino;
	
	private String comentario;
	
	private Date data;
	
	private Double valor;
	
	private boolean editMode = false;
	
	public TransacaoItem() {
		
	}
	
	public Date getData() {
		if(this.data == null)
			return Calendar.getInstance().getTime();
		return this.data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result
				+ ((contaDestino == null) ? 0 : contaDestino.hashCode());
		result = prime * result
				+ ((contaOrigem == null) ? 0 : contaOrigem.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((idContaOrigem == null) ? 0 : idContaOrigem.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransacaoItem other = (TransacaoItem) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (contaDestino == null) {
			if (other.contaDestino != null)
				return false;
		} else if (!contaDestino.equals(other.contaDestino))
			return false;
		if (contaOrigem == null) {
			if (other.contaOrigem != null)
				return false;
		} else if (!contaOrigem.equals(other.contaOrigem))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idContaOrigem == null) {
			if (other.idContaOrigem != null)
				return false;
		} else if (!idContaOrigem.equals(other.idContaOrigem))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	

}
