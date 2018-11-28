package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Inmueble.class)
public abstract class Inmueble_ {

	public static volatile SingularAttribute<Inmueble, Integer> idInmueble;
	public static volatile SingularAttribute<Inmueble, Double> supEdificadaM2;
	public static volatile SingularAttribute<Inmueble, String> tipo;
	public static volatile SingularAttribute<Inmueble, Integer> nroFinca;
	public static volatile SingularAttribute<Inmueble, Date> fechaAlta;
	public static volatile SingularAttribute<Inmueble, String> unidadMedida;
	public static volatile ListAttribute<Inmueble, InmuebleValuacionAjuste> inmuebleValuacionAjusteList;
	public static volatile SingularAttribute<Inmueble, Contribuyente> idContribuyente;
	public static volatile SingularAttribute<Inmueble, Boolean> mantenimientoPavimento;
	public static volatile SingularAttribute<Inmueble, Double> valuacionFiscal;
	public static volatile SingularAttribute<Inmueble, Integer> superficie;
	public static volatile SingularAttribute<Inmueble, Boolean> recoleccionBasura;
	public static volatile SingularAttribute<Inmueble, Integer> padron;
	public static volatile SingularAttribute<Inmueble, String> ctaCte;

}

