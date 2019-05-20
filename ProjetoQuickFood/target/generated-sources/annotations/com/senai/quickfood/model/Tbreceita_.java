package com.senai.quickfood.model;

import com.senai.quickfood.model.Tbavaliacao;
import com.senai.quickfood.model.Tbcomentario;
import com.senai.quickfood.model.Tbingredientereceita;
import com.senai.quickfood.model.Tbusuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-19T21:01:58")
@StaticMetamodel(Tbreceita.class)
public class Tbreceita_ { 

    public static volatile CollectionAttribute<Tbreceita, Tbingredientereceita> tbingredientereceitaCollection;
    public static volatile CollectionAttribute<Tbreceita, Tbavaliacao> tbavaliacaoCollection;
    public static volatile SingularAttribute<Tbreceita, Integer> bdID;
    public static volatile SingularAttribute<Tbreceita, String> bdDescricao;
    public static volatile SingularAttribute<Tbreceita, String> bdURLlmagem;
    public static volatile CollectionAttribute<Tbreceita, Tbcomentario> tbcomentarioCollection;
    public static volatile SingularAttribute<Tbreceita, String> bdNome;
    public static volatile SingularAttribute<Tbreceita, Tbusuario> bdDKUsuario;

}