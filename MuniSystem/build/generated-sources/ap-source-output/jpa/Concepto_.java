package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Concepto.class)
public abstract class Concepto_ {

	public static volatile SingularAttribute<Concepto, String> descripcion;
	public static volatile ListAttribute<Concepto, ImpuestoDetalle> impuestoDetalleList;
	public static volatile SingularAttribute<Concepto, Integer> idConcepto;

}

