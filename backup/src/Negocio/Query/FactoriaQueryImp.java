/**
 * 
 */
package Negocio.Query;


public class FactoriaQueryImp extends FactoriaQuery {
   
    @Override
    public Query getQuery() {
        return new QueryImp();
    }

}