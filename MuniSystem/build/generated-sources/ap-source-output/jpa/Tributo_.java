package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tributo.class)
public abstract class Tributo_ {

	public static volatile SingularAttribute<Tributo, String> descripcion;
	public static volatile SingularAttribute<Tributo, String> tipo;
	public static volatile SingularAttribute<Tributo, Integer> primerVencimiento;
	public static volatile SingularAttribute<Tributo, String> registrar;
	public static volatile SingularAttribute<Tributo, Integer> valor;
	public static volatile SingularAttribute<Tributo, PeriodoCobro> idPeriodoCobro;
	public static volatile SingularAttribute<Tributo, UnidadMedida> idUnidadMedida;
	public static volatile SingularAttribute<Tributo, String> nombre;
	public static volatile SingularAttribute<Tributo, Integer> idTributo;

}

