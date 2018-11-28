package reporte.manager;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import manager.BaseManager;


public class CobranzasDelDiaManager extends BaseManager{
    
    public Double getTotal(Date fechaInicio, Date fechaFin, String tipoPago, String usuario){
        Query query = getEm().createQuery("select sum(o.totalPagar) from ComprobanteCabecera o "
                + "where o.anulado = :anulado "
                + "and o.pagado = :pagado "
                + "and o.tipoPago = :tipoPago "
                + "and o.fechaPago >= :fechaIncio "
                + "and o.fechaPago <= :fechaFin "
                + "and o.usuarioPago = :usuario");
        query.setParameter("anulado", false);
        query.setParameter("pagado", true);
        query.setParameter("tipoPago", tipoPago);
        query.setParameter("fechaIncio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        query.setParameter("usuario", usuario);
        List result = query.getResultList();
        if(result.isEmpty()){
            return 0.0;
        }else if(result.get(0) == null){
            return 0.0;
        }else{
            return (Double) result.get(0);
        }
    }
}
