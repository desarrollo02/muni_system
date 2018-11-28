package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PeriodoCobro.class)
public abstract class PeriodoCobro_ {

	public static volatile SingularAttribute<PeriodoCobro, String> descripcion;
	public static volatile ListAttribute<PeriodoCobro, Tributo> tributoList;
	public static volatile SingularAttribute<PeriodoCobro, Integer> valor;
	public static volatile SingularAttribute<PeriodoCobro, Integer> idPeriodoCobro;

}

