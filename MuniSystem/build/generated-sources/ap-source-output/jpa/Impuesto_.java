package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Impuesto.class)
public abstract class Impuesto_ {

	public static volatile ListAttribute<Impuesto, ImpuestoDetalle> impuestoDetalleList;
	public static volatile SingularAttribute<Impuesto, PeriodoCobro> idPeriodoCobro;
	public static volatile SingularAttribute<Impuesto, Integer> idImpuesto;
	public static volatile SingularAttribute<Impuesto, String> nombre;

}

