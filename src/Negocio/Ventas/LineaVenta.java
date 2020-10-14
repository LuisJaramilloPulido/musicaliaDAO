/**
 *
 */
package Negocio.Ventas;


public class LineaVenta {

    private Integer idProducto;
    private Integer cantidad;
    private Float precio;

    public LineaVenta() {
    
    }
    
    public LineaVenta(Integer id, Integer cantidad, Float precio) {
    	this.idProducto=id;
    	this.cantidad=cantidad;
    	this.precio = precio;
        
    }
    public Integer getIdProducto() {
        return idProducto;
    }

  
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    
    public Integer getCantidad() {
        return cantidad;
    }

    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
    public Float getPrecio() {
        return precio;
    }

    
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return idProducto + ": x" + cantidad + "  =  " + precio + "€";
    }
}
