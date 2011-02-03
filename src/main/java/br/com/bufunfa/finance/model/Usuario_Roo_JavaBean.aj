package br.com.bufunfa.finance.model;

import java.lang.String;

privileged aspect Usuario_Roo_JavaBean {
    
    public String Usuario.getNome() {
        return this.nome;
    }
    
    public void Usuario.setNome(String nome) {
        this.nome = nome;
    }
    
    public String Usuario.getEmail() {
        return this.email;
    }
    
    public void Usuario.setEmail(String email) {
        this.email = email;
    }
    
    public String Usuario.getSenha() {
        return this.senha;
    }
    
    public void Usuario.setSenha(String senha) {
        this.senha = senha;
    }
    
}
