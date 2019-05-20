package com.senai.quickfood.model;

import com.senai.quickfood.model.Tbingrediente;
import com.senai.quickfood.model.Tbreceita;
import com.senai.quickfood.model.Tbunidademedida;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-19T21:01:58")
@StaticMetamodel(Tbingredientereceita.class)
public class Tbingredientereceita_ { 

    public static volatile SingularAttribute<Tbingredientereceita, Integer> bdID;
    public static volatile SingularAttribute<Tbingredientereceita, Double> bdQuantidadeIngrediente;
    public static volatile SingularAttribute<Tbingredientereceita, Tbunidademedida> bdFKUnidadeMedida;
    public static volatile SingularAttribute<Tbingredientereceita, Tbingrediente> bdFKIngrediente;
    public static volatile SingularAttribute<Tbingredientereceita, Tbreceita> bdFKReceita;

}