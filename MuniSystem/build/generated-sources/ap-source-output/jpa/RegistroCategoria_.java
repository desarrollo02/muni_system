package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegistroCategoria.class)
public abstract class RegistroCategoria_ {

	public static volatile SingularAttribute<RegistroCategoria, String> descripcion;
	public static volatile ListAttribute<RegistroCategoria, RegistroConducir> registroConducirList;
	public static volatile SingularAttribute<RegistroCategoria, Double> monto;
	public static volatile SingularAttribute<RegistroCategoria, Integer> idCategoria;

}

