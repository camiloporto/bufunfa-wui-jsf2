/**
 * 
 */
package br.com.bufunfa.finance.ui;

import org.springframework.roo.addon.serializable.RooSerializable;

import br.com.bufunfa.finance.model.Usuario;

/**
 * @author camilo
 *
 */
//@Component("loginView")
//@Controller
@RooSerializable
public class LoginView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6264338977016965309L;
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
