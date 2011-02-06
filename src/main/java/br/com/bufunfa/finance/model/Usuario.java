package br.com.bufunfa.finance.model;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.validation.constraints.NotNull;

@Entity
@RooJavaBean
@RooToString
@RooEntity
@RooSerializable
public class Usuario {

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    private String senha;
}
