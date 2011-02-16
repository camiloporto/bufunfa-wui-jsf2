package br.com.bufunfa.finance.ui.transacao;

import java.lang.Double;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

privileged aspect TransacaoItem_Roo_JavaBean {
    
    public Long TransacaoItem.getIdContaOrigem() {
        return this.idContaOrigem;
    }
    
    public void TransacaoItem.setIdContaOrigem(Long idContaOrigem) {
        this.idContaOrigem = idContaOrigem;
    }
    
    public String TransacaoItem.getContaOrigem() {
        return this.contaOrigem;
    }
    
    public void TransacaoItem.setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }
    
    public String TransacaoItem.getContaDestino() {
        return this.contaDestino;
    }
    
    public void TransacaoItem.setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }
    
    public String TransacaoItem.getComentario() {
        return this.comentario;
    }
    
    public void TransacaoItem.setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public Date TransacaoItem.getData() {
        return this.data;
    }
    
    public void TransacaoItem.setData(Date data) {
        this.data = data;
    }
    
    public Double TransacaoItem.getValor() {
        return this.valor;
    }
    
    public void TransacaoItem.setValor(Double valor) {
        this.valor = valor;
    }
    
}
