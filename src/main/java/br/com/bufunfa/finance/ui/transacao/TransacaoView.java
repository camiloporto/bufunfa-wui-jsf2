/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.roo.addon.serializable.RooSerializable;

/**
 * @author camilo
 *
 */
@ManagedBean(name="transacaoView")
@SessionScoped
@RooSerializable
public class TransacaoView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3764510014597231583L;
	
	private TransacaoItem transacaoEdit = new TransacaoItem();
	
	private List<TransacaoItem> transacaoList = new ArrayList<TransacaoItem>();
	
	//FIXME Internacionalizar isso
	//FIXME Internacionalizar o Pattern de selecao do calendario
	private Locale locale = new Locale("pt", "BR");
	
	public TransacaoView() {
	}
	
	public Locale getLocale() {
		return locale;
	}
	
	public TransacaoItem getTransacaoEdit() {
		return transacaoEdit;
	}
	
	public List<TransacaoItem> getTransacaoList() {
		return transacaoList;
	}
	
	/**
	 * Adiciona uma transacao usando o formulario padrao
	 */
	public void addTransacaoPadrao() {
		//FIXME adicionar transacao ao negocio
		getTransacaoList().add(getTransacaoEdit());
		clearTransacaoEdit();
	}

	private void clearTransacaoEdit() {
		this.transacaoEdit = new TransacaoItem();
		
	}
	
	

}
