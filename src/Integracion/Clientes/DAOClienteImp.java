/**
 * 
 */
package Integracion.Clientes;

import Integracion.Transaccion.TManager.TManager;
import Negocio.Clientes.TransferCliente;
import Integracion.Transaccion.Transaccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOClienteImp implements DAOCliente {
	
	@Override
	public Integer altaClienteDAO(TransferCliente datos) {
		Integer result = null;
		TManager transactionManager = TManager.getInstance();

		Transaccion transaccion = transactionManager.getTransaccion();
		Connection connection = (Connection) transaccion.getResource();

        String sql = "INSERT INTO Clientes(nombre, apellido, dni, direccion, socio, activo) VALUES(?,?,?,?,?,?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, datos.getNombre());
            pstmt.setString(2, datos.getApellido());
            pstmt.setString(3, datos.getDNI());
            pstmt.setString(4, datos.getDireccion());
            pstmt.setBoolean(5, datos.getSocio());
            pstmt.setBoolean(6, true);
			pstmt.executeUpdate();

            // sacamos el id del nuevo cliente
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
		}
		catch (SQLException e) {
			e.printStackTrace();
            result = null;
		}

		return result;
	}

	
	@Override
	public Integer bajaClienteDAO(Integer id) {
        Integer result = null;
        TManager transactionManager = TManager.getInstance();

        Transaccion transaccion = transactionManager.getTransaccion();
        Connection connection = (Connection) transaccion.getResource();
        String sql = "UPDATE Clientes SET activo=0 WHERE id_cliente=?"; // LUIS
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            result = id;
        }
        catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
	}

	
	@Override
	public Integer modificarClienteDAO(TransferCliente datos) {
        Integer result = null;
        TManager transactionManager = TManager.getInstance();

        Transaccion transaccion = transactionManager.getTransaccion();
        Connection connection = (Connection) transaccion.getResource();

        String sql = "UPDATE Clientes SET nombre=?, apellido=?, dni=?, direccion=?, socio=?, activo=? WHERE id_cliente=?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, datos.getNombre());
            pstmt.setString(2, datos.getApellido());
            pstmt.setString(3, datos.getDNI());
            pstmt.setString(4, datos.getDireccion());
            pstmt.setBoolean(5, datos.getSocio());
            pstmt.setBoolean(6, true);
            
            pstmt.setInt(7, datos.getID());
            pstmt.executeUpdate();

            result = datos.getID();
        }
        catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
	}

    
    @Override
    public TransferCliente consultarClienteDAO(String dni) {
        TransferCliente result = null;
        TManager transactionManager = TManager.getInstance();

        Transaccion transaccion = transactionManager.getTransaccion();
        Connection connection = (Connection) transaccion.getResource();

        //query + FOR UPDATE, el sqlite no reconoce el for update
        String sql = "SELECT id_cliente, nombre, apellido, dni, direccion, socio, activo FROM Clientes WHERE dni=? ";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, dni);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new TransferCliente();
                result.setID(rs.getInt("id_cliente"));
                result.setNombre(rs.getString("nombre"));
                result.setApellido(rs.getString("apellido"));
                result.setDNI(rs.getString("dni"));
                result.setDireccion(rs.getString("direccion"));
                result.setSocio(rs.getBoolean("socio"));
                result.setActivo(rs.getBoolean("activo"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    
    @Override
    public TransferCliente consultarClienteDAO(Integer id) {
        TransferCliente result = null;
        TManager transactionManager = TManager.getInstance();

        Transaccion transaccion = transactionManager.getTransaccion();
        Connection connection = (Connection) transaccion.getResource();

     // query + FOR UPDATE, el sqlite no reconoce el for update
        String sql = "Select id_cliente, nombre, apellido, dni, direccion, socio,activo FROM Clientes WHERE id_cliente=? ";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new TransferCliente();
                result.setID(rs.getInt("id_cliente"));
                result.setNombre(rs.getString("nombre"));
                result.setApellido(rs.getString("apellido"));
                result.setDNI(rs.getString("dni"));
                result.setDireccion(rs.getString("direccion"));
                result.setSocio(rs.getBoolean("socio"));
                result.setActivo(rs.getBoolean("activo"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

	
	@Override
	public List<TransferCliente> listarClientesDAO() {
        List<TransferCliente> result = null;
        TManager transactionManager = TManager.getInstance();

        Transaccion transaccion = transactionManager.getTransaccion();
        Connection connection = (Connection) transaccion.getResource();

     // query + FOR UPDATE, el sqlite no reconoce el for update
        String sql = "Select id_cliente, nombre, apellido, dni, direccion, socio,activo FROM Clientes";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
   
        	ResultSet rs = pstmt.executeQuery();
            result = new ArrayList<>(rs.getFetchSize());

            while (rs.next()) {
                TransferCliente cliente = new TransferCliente();
                cliente.setID(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDNI(rs.getString("dni"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setSocio(rs.getBoolean("socio"));
                cliente.setActivo(rs.getBoolean("activo"));
                result.add(cliente);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
	}
}