package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> descripcion;
	public static volatile SingularAttribute<Usuario, String> apellidos;
	public static volatile SingularAttribute<Usuario, Rol> idRol;
	public static volatile SingularAttribute<Usuario, String> cedula;
	public static volatile SingularAttribute<Usuario, Integer> idUsuario;
	public static volatile SingularAttribute<Usuario, String> contrasena;
	public static volatile SingularAttribute<Usuario, Boolean> activo;
	public static volatile SingularAttribute<Usuario, String> nombres;

}

