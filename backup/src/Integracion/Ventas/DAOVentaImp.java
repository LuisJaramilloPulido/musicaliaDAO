/**
 * 
 */
package Integracion.Ventas;

import Integracion.Transaccion.TManager.TManager;
import Integracion.Transaccion.Transaccion;
import Negocio.Ventas.TransferLineaVenta;
import Negocio.Ventas.TransferVenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOVentaImp implements DAOVenta {
    
    @Override
    public Integer altaVentaDAO(TransferVenta datos) {
        Integer result = null;
        TManager transactionManager = TManager.getInstance();

        Transaccion transaccion = transactionManager.getTransaccion();
        Connection connection = (Connection) transaccion.getResource();

        String sql = "INSERT INTO Ventas(id_cliente) VALUES(?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, datos.getIDCliente());

            pstmt.executeUpdate();

            // sacamos el id del nuevo cliente
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            if (result != null) {
                String sqlLV = "INSERT INTO LineaVentas(id_venta, id_producto, cantidad, precio) VALUES(?,?,?,?)";
                try (PreparedStatement pstmtLV = connection.prepareStatement(sqlLV)) {
                    for (TransferLineaVenta lineaVenta : datos.getLineaVentas()) {
                        pstmtLV.setInt(1, result);
                        pstmtLV.setInt(2, lineaVenta.getIdProducto());
                        pstmtLV.setInt(3, lineaVenta.getCantidad());
                        pstmtLV.setFloat(4, lineaVenta.getPrecio());

                        pstmtLV.executeUpdate();
                    }
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    result = null;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

	@Override
	public List<TransferVenta> listarVentasDAO() {
		List<TransferVenta> result = null;
		TManager transactionManager = TManager.getInstance();

		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();

		String sql = "SELECT id_venta, id_cliente FROM Ventas WHERE activo = 1";
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);

			result = new ArrayList<>(rs.getFetchSize());

			while (rs.next()) {
				TransferVenta venta = new TransferVenta();
				venta.setIDVenta(rs.getInt("id_venta"));
				venta.setIDCliente(rs.getInt("id_cliente"));

				result.add(venta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}
}