/**
 * 
 */
package br.com.bufunfa.finance.ui;

import org.springframework.context.annotation.Scope;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.stereotype.Controller;

import br.com.bufunfa.finance.model.Usuario;

/**
 * @author camilo
 *
 */
//@ManagedBean(name="loginView")
//@SessionScoped
@Controller(value="loginView")
@Scope(value="Session")
@RooSerializable
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
