/**
 * 
 */
package Negocio.Query;


public abstract class FactoriaQuery {
	private static class SingletonHelper {
		
		private static final FactoriaQuery INSTANCE = new FactoriaQueryImp();
	}

	
	public static FactoriaQuery getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public abstract Query getQuery();
}