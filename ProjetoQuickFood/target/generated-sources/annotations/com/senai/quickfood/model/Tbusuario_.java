package com.senai.quickfood.model;

import com.senai.quickfood.model.Tbavaliacao;
import com.senai.quickfood.model.Tbcomentario;
import com.senai.quickfood.model.Tbpessoa;
import com.senai.quickfood.model.Tbreceita;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-19T21:01:58")
@StaticMetamodel(Tbusuario.class)
public class Tbusuario_ { 

    public static volatile CollectionAttribute<Tbusuario, Tbavaliacao> tbavaliacaoCollection;
    public static volatile SingularAttribute<Tbusuario, Integer> bdID;
    public static volatile CollectionAttribute<Tbusuario, Tbreceita> tbreceitaCollection;
    public static volatile CollectionAttribute<Tbusuario, Tbcomentario> tbcomentarioCollection;
    public static volatile SingularAttribute<Tbusuario, Tbpessoa> bdFKPessoa;
    public static volatile SingularAttribute<Tbusuario, String> bdSenha;
    public static volatile SingularAttribute<Tbusuario, Boolean> bdUsuarioAdministrador;
    public static volatile SingularAttribute<Tbusuario, String> bdLogin;

}