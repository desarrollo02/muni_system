package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegistroConducir.class)
public abstract class RegistroConducir_ {

	public static volatile SingularAttribute<RegistroConducir, String> grupoSangre;
	public static volatile SingularAttribute<RegistroConducir, Date> fechaAlta;
	public static volatile SingularAttribute<RegistroConducir, Integer> idRegistroConducir;
	public static volatile SingularAttribute<RegistroConducir, Integer> licenciaNro;
	public static volatile SingularAttribute<RegistroConducir, Date> vencicimiento;
	public static volatile SingularAttribute<RegistroConducir, Contribuyente> idContribuyente;
	public static volatile SingularAttribute<RegistroConducir, RegistroCategoria> idCategoria;

}

