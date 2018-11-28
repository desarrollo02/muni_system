package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VehiculoValuacion.class)
public abstract class VehiculoValuacion_ {

	public static volatile SingularAttribute<VehiculoValuacion, Double> monto;
	public static volatile SingularAttribute<VehiculoValuacion, Integer> idAutomotorValuacion;
	public static volatile SingularAttribute<VehiculoValuacion, VehiculoTipo> idTipo;
	public static volatile SingularAttribute<VehiculoValuacion, Modelos> idModelo;
	public static volatile SingularAttribute<VehiculoValuacion, Marcas> idMarca;
	public static volatile SingularAttribute<VehiculoValuacion, Integer> anio;

}

