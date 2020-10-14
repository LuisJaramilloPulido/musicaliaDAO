/**
 * 
 */
package Integracion.Ventas;

import Integracion.Transaccion.TManager.TManager;
import Integracion.Transaccion.Transaccion;
import Negocio.Ventas.LineaVenta;
import Negocio.Ventas.TransferVenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOVentaImp implements DAOVenta {
    
    @Override
    public Integer crearVentaDAO(TransferVenta tVenta) {
        Integer result = null;
        TManager transactionManager = TManager.getInstance();

        Transaccion transaccion = transactionManager.getTransaccion();
        Connection connection = (Connection) transaccion.getResource();

        String sql = "INSERT INTO Ventas(id_cliente, precioTotal) VALUES(?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, tVenta.getIDCliente());
            pstmt.setFloat(2, tVenta.getPrecioTotal());
            pstmt.executeUpdate();

            // sacamos el id del nuevo cliente
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            if (result != null) {
                String sqlLV = "INSERT INTO LineaVentas(id_venta, id_producto, cantidad, precio) VALUES(?,?,?,?)";
                try (PreparedStatement pstmtLV = connection.prepareStatement(sqlLV)) {
                    for (LineaVenta lineaVenta : tVenta.getCarrito()) {
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

		String sql = "SELECT id_venta, id_cliente, precioTotal FROM Ventas WHERE activo = 1";
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);

			result = new ArrayList<>(rs.getFetchSize());

			while (rs.next()) {
				TransferVenta venta = new TransferVenta();
				venta.setIDVenta(rs.getInt("id_venta"));
				venta.setIDCliente(rs.getInt("id_cliente"));
				venta.setPrecioTotal(rs.getFloat("precioTotal"));
				result.add(venta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}

	@Override
	public TransferVenta consultarVentaDAO(Integer idVenta) {
		TransferVenta result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();
		String sql = "SELECT id_venta, id_cliente, precioTotal, activo FROM Ventas WHERE id_venta=? AND activo=1";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, idVenta);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new TransferVenta();
				result.setIDVenta(rs.getInt("id_venta"));
				result.setIDCliente(rs.getInt("id_cliente"));
				result.setPrecioTotal(rs.getFloat("precioTotal"));
				result.setActivo(rs.getBoolean("activo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}
}