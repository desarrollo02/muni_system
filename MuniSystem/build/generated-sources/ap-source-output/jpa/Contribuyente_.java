package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contribuyente.class)
public abstract class Contribuyente_ {

	public static volatile SingularAttribute<Contribuyente, String> apellidos;
	public static volatile ListAttribute<Contribuyente, RegistroConducir> registroConducirList;
	public static volatile SingularAttribute<Contribuyente, String> ruc;
	public static volatile ListAttribute<Contribuyente, Comercio> comercioList;
	public static volatile SingularAttribute<Contribuyente, Integer> nroCasa;
	public static volatile SingularAttribute<Contribuyente, String> cedula;
	public static volatile SingularAttribute<Contribuyente, String> direccion;
	public static volatile ListAttribute<Contribuyente, ComprobanteCabecera> comprobanteCabeceraList;
	public static volatile SingularAttribute<Contribuyente, Integer> idContribuyente;
	public static volatile SingularAttribute<Contribuyente, Boolean> personaJuridica;
	public static volatile SingularAttribute<Contribuyente, String> nombres;
	public static volatile SingularAttribute<Contribuyente, String> razonSocial;
	public static volatile SingularAttribute<Contribuyente, String> lineaBaja;
	public static volatile SingularAttribute<Contribuyente, Barrio> idBarrio;
	public static volatile SingularAttribute<Contribuyente, String> celular;
	public static volatile SingularAttribute<Contribuyente, String> email;
	public static volatile ListAttribute<Contribuyente, Vehiculo> vehiculoList;
	public static volatile ListAttribute<Contribuyente, Cementerio> cementerioList;
	public static volatile SingularAttribute<Contribuyente, Boolean> activo;

}

