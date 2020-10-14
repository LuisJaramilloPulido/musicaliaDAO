
package Integracion.Productos;

import Integracion.Transaccion.TManager.TManager;
import Negocio.Productos.TransferProducto;
import Integracion.Transaccion.Transaccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOProductoImp implements DAOProducto {

	@Override
	public Integer altaProductoDAO(TransferProducto tProducto) {
		Integer result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();
		String sql = "INSERT INTO Productos(nombre, categoria, precio,stock) VALUES(?,?,?,?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, tProducto.getNombre());
			pstmt.setString(2, tProducto.getCategoria());
			pstmt.setFloat(3, tProducto.getPrecio());
			pstmt.setInt(4, tProducto.getStock());
			pstmt.executeUpdate();
			// sacamos el id del nuevo producto
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				//Obtiene el id del producto
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}

	@Override
	public Integer bajaProductoDAO(Integer datos) {
		Integer result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();
		String sql = "UPDATE Productos SET activo=0 WHERE id_producto=?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, datos);
			pstmt.executeUpdate();
			result = datos;
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}

	
	@Override
	public Integer modificarProductoDAO(TransferProducto datos) {
		Integer result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();
		String sql = "UPDATE Productos SET nombre=?, categoria=?, precio=?, stock=?, activo=?  WHERE id_producto=? ";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, datos.getNombre());
			pstmt.setString(2, datos.getCategoria());
			pstmt.setFloat(3, datos.getPrecio());
			pstmt.setInt(4, datos.getStock());
			pstmt.setBoolean(5, true);
			pstmt.setInt(6, datos.getID());
			pstmt.executeUpdate();
			result = datos.getID();
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}

	
	@Override
	public TransferProducto consultarProductoDAO(String nombre, String categoria) {
		TransferProducto result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();
		String sql = "SELECT id_producto, nombre, categoria, precio,stock,activo FROM Productos WHERE nombre=? AND categoria=?"  ;
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, nombre);
			pstmt.setString(2, categoria);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new TransferProducto();
				result.setID(rs.getInt("id_producto"));
				result.setNombre(rs.getString("nombre"));
				result.setCategoria(rs.getString("categoria"));
				result.setPrecio(rs.getFloat("precio"));
				result.setStock(rs.getInt("stock"));
				result.setActivo(rs.getBoolean("activo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}
	
	
	
	@Override
	public TransferProducto consultarProductoDAO(Integer id) {
		TransferProducto result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();
		String sql = "SELECT id_producto, nombre, categoria, precio,stock,activo FROM Productos WHERE id_producto=? ";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new TransferProducto();
				result.setID(rs.getInt("id_producto"));
				result.setNombre(rs.getString("nombre"));
				result.setCategoria(rs.getString("categoria"));
				result.setPrecio(rs.getFloat("precio"));
				result.setStock(rs.getInt("stock"));
				result.setActivo(rs.getBoolean("activo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}

	
	@Override
	public List<TransferProducto> listarProductosDAO() {
		List<TransferProducto> result = null;
		TManager transactionManager = TManager.getInstance();

		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();

		String sql = "SELECT id_producto, nombre, categoria, precio,stock,activo FROM Productos";
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
				producto.setActivo(rs.getBoolean("activo"));
				result.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}
}