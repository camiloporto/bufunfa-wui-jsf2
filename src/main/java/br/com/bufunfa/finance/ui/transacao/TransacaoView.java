/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.stereotype.Controller;

import br.com.bufunfa.finance.ui.conta.ContaView;
import br.com.bufunfa.finance.ui.conta.TreeTableItem;

/**
 * @author camilo
 *
 */
//@ManagedBean(name="transacaoView")
//@SessionScoped
@Controller(value="transacaoView")
@Scope(value="Session")
@RooSerializable
public class TransacaoView {
	
	//TODO Fazer com que o Spring tome conta dos Beans. Injetar nesse Bean o Bean de ContaView
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3764510014597231583L;
	
	private ContaView contaView;
	
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
	
	public List<String> complete(String userInput) {
		//FIXME Pesquisar por contas sugeridas na arvore de contas do Usuario. Considerar se a sugestao eh da Origem ou Destino
		//FIXME Povoar lista com Objetos Contas e nao apenas com String
		
		List<TreeTableItem> items = contaView.findItemsByNameLike(userInput);
		
		
		List<String> result = new ArrayList<String>();
		for (Iterator<TreeTableItem> iterator = items.iterator(); iterator.hasNext();) {
			TreeTableItem i = iterator.next();
			result.add(i.getNomeConta());
			System.out.println("TransacaoView.complete()");
		}
		
		return result;
		
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
