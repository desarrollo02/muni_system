package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VehiculoValuacionAjuste.class)
public abstract class VehiculoValuacionAjuste_ {

	public static volatile SingularAttribute<VehiculoValuacionAjuste, VehiculoValuacion> idVehiculoValuacion;
	public static volatile SingularAttribute<VehiculoValuacionAjuste, Double> valorViejoMonto;
	public static volatile SingularAttribute<VehiculoValuacionAjuste, Integer> porcentajeAjuste;
	public static volatile SingularAttribute<VehiculoValuacionAjuste, Date> fechaAlta;
	public static volatile SingularAttribute<VehiculoValuacionAjuste, Integer> idVehiculoValuacionAjuste;
	public static volatile SingularAttribute<VehiculoValuacionAjuste, Double> valorNuevoMonto;
	public static volatile SingularAttribute<VehiculoValuacionAjuste, Integer> anio;

}

