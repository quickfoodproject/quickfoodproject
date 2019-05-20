package com.senai.quickfood.model;

import com.senai.quickfood.model.Tbreceita;
import com.senai.quickfood.model.Tbusuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-19T21:01:58")
@StaticMetamodel(Tbcomentario.class)
public class Tbcomentario_ { 

    public static volatile SingularAttribute<Tbcomentario, Integer> bdID;
    public static volatile SingularAttribute<Tbcomentario, String> bdDescricao;
    public static volatile SingularAttribute<Tbcomentario, Tbreceita> bdFKReceita;
    public static volatile SingularAttribute<Tbcomentario, Tbusuario> bdFKUsuario;

}