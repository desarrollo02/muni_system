package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ImpuestoDetalle.class)
public abstract class ImpuestoDetalle_ {

	public static volatile SingularAttribute<ImpuestoDetalle, Integer> idFormaPago;
	public static volatile SingularAttribute<ImpuestoDetalle, Double> monto;
	public static volatile SingularAttribute<ImpuestoDetalle, Concepto> idConcepto;
	public static volatile SingularAttribute<ImpuestoDetalle, UnidadMedida> idUnidadMedida;
	public static volatile SingularAttribute<ImpuestoDetalle, Impuesto> idImpuesto;

}

