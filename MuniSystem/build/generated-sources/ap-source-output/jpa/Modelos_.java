package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Modelos.class)
public abstract class Modelos_ {

	public static volatile SingularAttribute<Modelos, String> descripcion;
	public static volatile ListAttribute<Modelos, VehiculoValuacion> vehiculoValuacionList;
	public static volatile SingularAttribute<Modelos, Integer> idModelo;
	public static volatile SingularAttribute<Modelos, Marcas> idMarca;
	public static volatile ListAttribute<Modelos, Vehiculo> vehiculoList;

}

