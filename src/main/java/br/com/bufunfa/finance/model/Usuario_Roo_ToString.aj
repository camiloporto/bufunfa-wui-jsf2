package br.com.bufunfa.finance.model;

import java.lang.String;

privileged aspect Usuario_Roo_ToString {
    
    public String Usuario.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Nome: ").append(getNome()).append(", ");
        sb.append("Email: ").append(getEmail()).append(", ");
        sb.append("Senha: ").append(getSenha());
        return sb.toString();
    }
    
}
