package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ComprobanteCabecera.class)
public abstract class ComprobanteCabecera_ {

	public static volatile SingularAttribute<ComprobanteCabecera, Date> vencimiento;
	public static volatile ListAttribute<ComprobanteCabecera, ComprobanteDetalle> comprobanteDetalleList;
	public static volatile SingularAttribute<ComprobanteCabecera, Date> fechaAlta;
	public static volatile SingularAttribute<ComprobanteCabecera, Integer> periodo;
	public static volatile SingularAttribute<ComprobanteCabecera, Contribuyente> idContribuyente;
	public static volatile SingularAttribute<ComprobanteCabecera, String> usuarioAlta;
	public static volatile SingularAttribute<ComprobanteCabecera, Date> fechaPago;
	public static volatile SingularAttribute<ComprobanteCabecera, Tributo> idTributo;
	public static volatile SingularAttribute<ComprobanteCabecera, Integer> idComprobanteCabecera;
	public static volatile SingularAttribute<ComprobanteCabecera, Boolean> pagado;
	public static volatile SingularAttribute<ComprobanteCabecera, String> nroCheque;
	public static volatile SingularAttribute<ComprobanteCabecera, Integer> id_ref;
	public static volatile SingularAttribute<ComprobanteCabecera, String> usuarioPago;
	public static volatile SingularAttribute<ComprobanteCabecera, String> tipoPago;
	public static volatile SingularAttribute<ComprobanteCabecera, Double> totalPagar;
	public static volatile SingularAttribute<ComprobanteCabecera, Boolean> anulado;
	public static volatile SingularAttribute<ComprobanteCabecera, Integer> anio;

}

