package com.senai.quickfood.model;

import com.senai.quickfood.model.Tbusuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-19T21:01:58")
@StaticMetamodel(Tbpessoa.class)
public class Tbpessoa_ { 

    public static volatile SingularAttribute<Tbpessoa, Integer> bdID;
    public static volatile CollectionAttribute<Tbpessoa, Tbusuario> tbusuarioCollection;
    public static volatile SingularAttribute<Tbpessoa, String> bdSexo;
    public static volatile SingularAttribute<Tbpessoa, String> bdNome;
    public static volatile SingularAttribute<Tbpessoa, Date> bdDataNascimento;

}