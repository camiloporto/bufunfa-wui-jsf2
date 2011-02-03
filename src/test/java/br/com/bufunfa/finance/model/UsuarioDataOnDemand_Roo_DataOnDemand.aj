package br.com.bufunfa.finance.model;

import br.com.bufunfa.finance.model.Usuario;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect UsuarioDataOnDemand_Roo_DataOnDemand {
    
    declare @type: UsuarioDataOnDemand: @Component;
    
    private Random UsuarioDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Usuario> UsuarioDataOnDemand.data;
    
    public Usuario UsuarioDataOnDemand.getNewTransientUsuario(int index) {
        br.com.bufunfa.finance.model.Usuario obj = new br.com.bufunfa.finance.model.Usuario();
        obj.setEmail("email_" + index);
        obj.setNome("nome_" + index);
        obj.setSenha("senha_" + index);
        return obj;
    }
    
    public Usuario UsuarioDataOnDemand.getSpecificUsuario(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Usuario obj = data.get(index);
        return Usuario.findUsuario(obj.getId());
    }
    
    public Usuario UsuarioDataOnDemand.getRandomUsuario() {
        init();
        Usuario obj = data.get(rnd.nextInt(data.size()));
        return Usuario.findUsuario(obj.getId());
    }
    
    public boolean UsuarioDataOnDemand.modifyUsuario(Usuario obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void UsuarioDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = br.com.bufunfa.finance.model.Usuario.findUsuarioEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Usuario' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<br.com.bufunfa.finance.model.Usuario>();
        for (int i = 0; i < 10; i++) {
            br.com.bufunfa.finance.model.Usuario obj = getNewTransientUsuario(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
