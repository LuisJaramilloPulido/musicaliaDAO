package Negocio.Ventas;

import java.util.List;

import Integracion.Query.TransferQuery;
import Negocio.Productos.TransferProducto;

public interface SAVenta {
	
	public Integer crearVentaSA(TransferVenta datos);
	public List<TransferVenta> listarVentasSA();
	public TransferTOA EnsambladorObjetosTransfererencia(Integer idVenta);
	public List<TransferProducto> mostrarProductosEnVentaMayoresPrecioSA(TransferQuery datos );
}