package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CementerioAjuste.class)
public abstract class CementerioAjuste_ {

	public static volatile SingularAttribute<CementerioAjuste, Double> valorNeuvoMonto;
	public static volatile SingularAttribute<CementerioAjuste, Double> valorViejoMonto;
	public static volatile SingularAttribute<CementerioAjuste, Integer> porcentajeAjuste;
	public static volatile SingularAttribute<CementerioAjuste, Date> fechaAlta;
	public static volatile SingularAttribute<CementerioAjuste, Integer> idCementerioAjuste;
	public static volatile SingularAttribute<CementerioAjuste, Cementerio> idCementerio;
	public static volatile SingularAttribute<CementerioAjuste, Integer> anio;

}

