package com.senai.quickfood.model;

import com.senai.quickfood.model.Tbreceita;
import com.senai.quickfood.model.Tbusuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-19T21:01:58")
@StaticMetamodel(Tbavaliacao.class)
public class Tbavaliacao_ { 

    public static volatile SingularAttribute<Tbavaliacao, Integer> bdNota;
    public static volatile SingularAttribute<Tbavaliacao, Integer> bdID;
    public static volatile SingularAttribute<Tbavaliacao, Tbreceita> bdFKReceita;
    public static volatile SingularAttribute<Tbavaliacao, Tbusuario> bdFKUsuario;

}