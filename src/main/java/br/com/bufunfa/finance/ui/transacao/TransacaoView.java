/**
 * 
 */
package br.com.bufunfa.finance.ui.transacao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.springframework.roo.addon.serializable.RooSerializable;

import br.com.bufunfa.finance.ui.conta.ContaView;
import br.com.bufunfa.finance.ui.conta.TreeTableItem;

/**
 * @author camilo
 *
 */
//@Component
@RooSerializable
public class TransacaoView {
	
	//TODO Fazer com que o Spring tome conta dos Beans. Injetar nesse Bean o Bean de ContaView
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3764510014597231583L;
	
//	@Autowired
	private ContaView contaView;
	
	private String shortTransaction;
	
	private TransacaoItem transacaoEdit = new TransacaoItem();
	
	private TransacaoItem transacaoSelected = new TransacaoItem();
	
	private List<TransacaoItem> transacaoList = new ArrayList<TransacaoItem>();
	
	//FIXME Internacionalizar isso
	//FIXME Internacionalizar o Pattern de selecao do calendario
	private Locale locale = new Locale("pt", "BR");
	
	public TransacaoView() {
		
	}
	
	/**
	 * Adiciona uma msg generica (nao atrelada a um componente)
	 * ao faces context
	 * @param msg a msg
	 * @param severity severidade da msg
	 */
	void addFacesMessage(String msg, Severity severity) {
		FacesMessage fmsg = new FacesMessage(severity, msg, msg);
		FacesContext ctx = FacesContext.getCurrentInstance();
		if(ctx != null)
			ctx.addMessage(null, fmsg);
	}
	
	public TransacaoItem getTransacaoSelected() {
		return transacaoSelected;
	}



	public void setTransacaoSelected(TransacaoItem transacaoSelected) {
		this.transacaoSelected = transacaoSelected;
	}



	public String getShortTransaction() {
		return shortTransaction;
	}
	
	public void setShortTransaction(String shortTransaction) {
		this.shortTransaction = shortTransaction;
	}
	
	public void setContaView(ContaView contaView) {
		this.contaView = contaView;
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
	
	//FIXME Implementar futuramente esse componente
	/**
	 * Sugere transacoes a partir das entrada do usuario no formulario
	 * de atalho
	 * @param input entrada do usuario
	 * @return sugestao de transacao
	 */
	public List<String> completeSuggestedTransaction(String input) {
		
		//TODO Fazer um parser para criar templates de transacoes com base no que o usuario digitou
		
		String s1 = "De: Salario Petro; Para: Ativos; valor: R$12,00; data: 01/02/2011; comentario: transacao template";
		String s2 = "De: Conta Origem; Para: Conta Destino; valor: R$32,00; data: 23/02/2011; comentario: outra transacao";
		
		List<String> suggestions = new ArrayList<String>();
		suggestions.add(s1);
		suggestions.add(s2);
		
		return suggestions;
		
	}
	
	public List<String> complete(String userInput) {
		
		//FIXME Pesquisar por contas sugeridas na arvore de contas do Usuario. Considerar se a sugestao eh da Origem ou Destino
		//FIXME Povoar lista com Objetos Contas e nao apenas com String
		
		List<TreeTableItem> items = contaView.findLeafItemsByNameLike(userInput);
		
		
		List<String> result = new ArrayList<String>();
		for (Iterator<TreeTableItem> iterator = items.iterator(); iterator.hasNext();) {
			TreeTableItem i = iterator.next();
			result.add(i.getNomeConta());
		}
		
		return result;
	}
	
	/**
	 * Adiciona uma transacao usando o formulario padrao
	 */
	public void addTransacaoPadrao() {
		//FIXME adicionar transacao ao negocio. pegar id das contas para mandar para o negocio
		TreeTableItem origem = contaView.findLeafItemByName(getTransacaoEdit().getContaOrigem());
		TreeTableItem destino = contaView.findLeafItemByName(getTransacaoEdit().getContaDestino());

		getTransacaoList().add(getTransacaoEdit());
		clearTransacaoEdit();
		addFacesMessage("Transação salva com sucesso", FacesMessage.SEVERITY_INFO);
	}

	private void clearTransacaoEdit() {
		this.transacaoEdit = new TransacaoItem();
		
	}


	public void removeTransacaoSelected() {
		//FIXME invocar negocio para remover transacao
		
		getTransacaoList().remove(getTransacaoSelected());
		addFacesMessage("Transação excluida com sucesso", FacesMessage.SEVERITY_INFO);
		
	}
	
	

}
