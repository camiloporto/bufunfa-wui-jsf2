/**
 * 
 */
package br.com.bufunfa.finance.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.bufunfa.finance.model.Usuario;

/**
 * @author camilo
 *
 */
@ManagedBean(name="loginView")
@SessionScoped
public class LoginView {
	//FIXME Implementar logica de login (como um servico a parte??)
	private final String USUARIO_VALIDO = "camiloporto";
	private final String SENHA_VALIDA = "nunes";
	
	private Usuario usuario = new Usuario();
	
	public LoginView() {
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String login() {
		//FIXME Implementar logica de login
//		if(USUARIO_VALIDO.equals(getUsuario().getEmail())
//				&& SENHA_VALIDA.equals(getUsuario().getSenha()))
		return "pages/conta";
//		return null;
	}

}
