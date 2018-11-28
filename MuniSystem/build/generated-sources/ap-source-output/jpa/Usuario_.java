package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> descripcion;
	public static volatile SingularAttribute<Usuario, Rol> idRol;
	public static volatile ListAttribute<Usuario, Comercio> comercioList;
	public static volatile ListAttribute<Usuario, Cementerio> cementerioList1;
	public static volatile SingularAttribute<Usuario, Integer> idUsuario;
	public static volatile SingularAttribute<Usuario, String> contrasena;
	public static volatile ListAttribute<Usuario, Comercio> comercioList1;
	public static volatile ListAttribute<Usuario, Comercio> comercioList2;
	public static volatile ListAttribute<Usuario, Cementerio> cementerioList;
	public static volatile SingularAttribute<Usuario, Boolean> activo;

}

