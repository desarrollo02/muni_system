package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comercio.class)
public abstract class Comercio_ {

	public static volatile SingularAttribute<Comercio, String> nombreFantasia;
	public static volatile SingularAttribute<Comercio, Date> ultimoAnio;
	public static volatile SingularAttribute<Comercio, Usuario> idUsuModif;
	public static volatile SingularAttribute<Comercio, String> obs;
	public static volatile SingularAttribute<Comercio, Integer> nroPatente;
	public static volatile SingularAttribute<Comercio, String> direccion;
	public static volatile SingularAttribute<Comercio, Contribuyente> idContribuyente;
	public static volatile SingularAttribute<Comercio, Date> fecVigencia;
	public static volatile SingularAttribute<Comercio, ComercioRubro> idRubro;
	public static volatile SingularAttribute<Comercio, Integer> nroReferencia;
	public static volatile SingularAttribute<Comercio, Double> valorActivo;
	public static volatile SingularAttribute<Comercio, Usuario> idUsuAlta;
	public static volatile SingularAttribute<Comercio, Integer> idComercio;
	public static volatile SingularAttribute<Comercio, Usuario> idUsuBaja;
	public static volatile SingularAttribute<Comercio, Date> fecModif;
	public static volatile SingularAttribute<Comercio, Barrio> idBarrio;
	public static volatile SingularAttribute<Comercio, Date> fecAlta;
	public static volatile SingularAttribute<Comercio, Date> fecBaja;
	public static volatile SingularAttribute<Comercio, Boolean> activo;

}

