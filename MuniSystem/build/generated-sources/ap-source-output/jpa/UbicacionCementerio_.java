package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UbicacionCementerio.class)
public abstract class UbicacionCementerio_ {

	public static volatile SingularAttribute<UbicacionCementerio, Barrio> idBarrio;
	public static volatile SingularAttribute<UbicacionCementerio, String> direccion;
	public static volatile SingularAttribute<UbicacionCementerio, Integer> idUbicacionCementerio;
	public static volatile SingularAttribute<UbicacionCementerio, String> nombre;
	public static volatile ListAttribute<UbicacionCementerio, Cementerio> cementerioList;

}

