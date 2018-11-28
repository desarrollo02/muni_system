package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InmuebleValuacionAjuste.class)
public abstract class InmuebleValuacionAjuste_ {

	public static volatile SingularAttribute<InmuebleValuacionAjuste, Inmueble> idInmueble;
	public static volatile SingularAttribute<InmuebleValuacionAjuste, Double> valorViejoMonto;
	public static volatile SingularAttribute<InmuebleValuacionAjuste, Integer> porcentajeAjuste;
	public static volatile SingularAttribute<InmuebleValuacionAjuste, Date> fechaAlta;
	public static volatile SingularAttribute<InmuebleValuacionAjuste, Double> valorNuevoMonto;
	public static volatile SingularAttribute<InmuebleValuacionAjuste, Integer> idInmuebleValuacion;
	public static volatile SingularAttribute<InmuebleValuacionAjuste, Integer> anio;

}

