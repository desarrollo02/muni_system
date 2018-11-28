package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RolPantalla.class)
public abstract class RolPantalla_ {

	public static volatile SingularAttribute<RolPantalla, Integer> idRolPantalla;
	public static volatile SingularAttribute<RolPantalla, Rol> idRol;
	public static volatile SingularAttribute<RolPantalla, Boolean> eliminar;
	public static volatile SingularAttribute<RolPantalla, Boolean> alta;
	public static volatile SingularAttribute<RolPantalla, Boolean> editar;
	public static volatile SingularAttribute<RolPantalla, Pantalla> idPantalla;
	public static volatile SingularAttribute<RolPantalla, Boolean> consultar;

}

