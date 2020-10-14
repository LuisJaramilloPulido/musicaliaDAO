/**
 * 
 */
package Integracion.Transaccion.FactoriaTransaccion;

import Integracion.Transaccion.Transaccion;
import Integracion.Transaccion.TransaccionImp;

public class FactoriaTransaccionImp extends FactoriaTransaccion {

    // Evitamos que se pueda acceder al constructor desde fuera
    protected FactoriaTransaccionImp() {}

    
    @Override
    public Transaccion nuevaTransaccion() {
        Transaccion transaccion = new TransaccionImp();
        return transaccion;
    }
}