/**
 * 
 */
package Integracion.FactoriaQuery;

import Integracion.Query.QueryVenta;
import Integracion.Query.QueryMostrarProductosEnVentaMayoresPrecio;

public class FactoriaQueryImp extends FactoriaQuery {
   
	private QueryVenta queryVenta;
	
    @Override
    public QueryVenta getQueryVenta() {
    	  if (queryVenta == null) {
    		  return new QueryMostrarProductosEnVentaMayoresPrecio();
    		  
    	  }
        return queryVenta;
    }
}