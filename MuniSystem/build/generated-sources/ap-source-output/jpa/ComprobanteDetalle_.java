package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ComprobanteDetalle.class)
public abstract class ComprobanteDetalle_ {

	public static volatile SingularAttribute<ComprobanteDetalle, String> descripcion;
	public static volatile SingularAttribute<ComprobanteDetalle, Double> monto;
	public static volatile SingularAttribute<ComprobanteDetalle, Boolean> pagado;
	public static volatile SingularAttribute<ComprobanteDetalle, Date> fechaVencimiento;
	public static volatile SingularAttribute<ComprobanteDetalle, ComprobanteCabecera> idComprobanteCab;
	public static volatile SingularAttribute<ComprobanteDetalle, Concepto> concepto;
	public static volatile SingularAttribute<ComprobanteDetalle, Integer> idComprobanteDetalle;

}

