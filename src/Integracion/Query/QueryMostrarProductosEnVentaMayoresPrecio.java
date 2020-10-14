package Integracion.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Integracion.Transaccion.Transaccion;
import Integracion.Transaccion.TManager.TManager;
import Negocio.Productos.TransferProducto;

public class QueryMostrarProductosEnVentaMayoresPrecio implements QueryVenta {
	
	public List<TransferProducto> execute(TransferQuery datos) {

		List<TransferProducto> result = null;
		TManager transactionManager = TManager.getInstance();

		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();
		
		//select * ... for update, sqlite no permite
		String sql = "SELECT * FROM Productos WHERE id_producto IN (SELECT id_producto FROM LineaVentas lv, Ventas v WHERE lv.id_venta = "
				+ datos.getIdVenta() + " AND lv.precio > " + datos.getPrecio() + ")";

		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			result = new ArrayList<>(rs.getFetchSize());

			while (rs.next()) {
				TransferProducto producto = new TransferProducto();
				producto.setID(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setCategoria(rs.getString("categoria"));
				producto.setPrecio(rs.getFloat("precio"));
				producto.setStock(rs.getInt("stock"));
				result.add(producto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			result = null;

		}
		return result;
	}
}