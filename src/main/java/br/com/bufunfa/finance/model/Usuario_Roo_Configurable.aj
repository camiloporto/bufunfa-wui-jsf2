package br.com.bufunfa.finance.model;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Usuario_Roo_Configurable {
    
    declare @type: Usuario: @Configurable;
    
}