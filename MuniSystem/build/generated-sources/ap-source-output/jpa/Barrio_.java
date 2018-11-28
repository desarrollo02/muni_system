package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Barrio.class)
public abstract class Barrio_ {

	public static volatile SingularAttribute<Barrio, String> descripcion;
	public static volatile ListAttribute<Barrio, UbicacionCementerio> ubicacionCementerioList;
	public static volatile ListAttribute<Barrio, Comercio> comercioList;
	public static volatile SingularAttribute<Barrio, Integer> idBarrio;
	public static volatile ListAttribute<Barrio, Contribuyente> contribuyenteList;

}

