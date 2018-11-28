package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VehiculoTipo.class)
public abstract class VehiculoTipo_ {

	public static volatile SingularAttribute<VehiculoTipo, String> descripcion;
	public static volatile ListAttribute<VehiculoTipo, VehiculoValuacion> vehiculoValuacionList;
	public static volatile SingularAttribute<VehiculoTipo, Integer> idCategoria;
	public static volatile ListAttribute<VehiculoTipo, Vehiculo> vehiculoList;

}

