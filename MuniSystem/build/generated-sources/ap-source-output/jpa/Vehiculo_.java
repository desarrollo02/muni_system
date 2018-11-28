package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vehiculo.class)
public abstract class Vehiculo_ {

	public static volatile SingularAttribute<Vehiculo, String> motor;
	public static volatile SingularAttribute<Vehiculo, Integer> idVehiculo;
	public static volatile SingularAttribute<Vehiculo, String> color;
	public static volatile SingularAttribute<Vehiculo, Date> fechaAlta;
	public static volatile SingularAttribute<Vehiculo, String> chasis;
	public static volatile SingularAttribute<Vehiculo, Contribuyente> idContribuyente;
	public static volatile SingularAttribute<Vehiculo, VehiculoTipo> idTipo;
	public static volatile SingularAttribute<Vehiculo, Modelos> idModelo;
	public static volatile SingularAttribute<Vehiculo, Marcas> idMarca;
	public static volatile SingularAttribute<Vehiculo, String> chapa;
	public static volatile SingularAttribute<Vehiculo, Integer> anio;

}

