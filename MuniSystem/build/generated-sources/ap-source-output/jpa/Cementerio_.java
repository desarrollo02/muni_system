package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cementerio.class)
public abstract class Cementerio_ {

	public static volatile SingularAttribute<Cementerio, Usuario> idUsuModif;
	public static volatile SingularAttribute<Cementerio, Usuario> idUsuAlta;
	public static volatile SingularAttribute<Cementerio, Date> fecModif;
	public static volatile SingularAttribute<Cementerio, Double> valuacion;
	public static volatile SingularAttribute<Cementerio, Integer> idCementerio;
	public static volatile SingularAttribute<Cementerio, Integer> nroLote;
	public static volatile SingularAttribute<Cementerio, Contribuyente> idContribuyente;
	public static volatile SingularAttribute<Cementerio, Date> fecAlta;
	public static volatile SingularAttribute<Cementerio, UbicacionCementerio> idUbicacionCementerio;

}

