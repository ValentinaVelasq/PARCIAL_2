package gestioninventario;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ProductoServicio {
     private List<Producto> productos;

private ProductoRepositorio repositorio;

    public ProductoServicio() {
        this.repositorio = new ProductoRepositorio();
    }

    public void agregarProducto(Producto producto) {
        repositorio.crearProducto(producto);
    }

    public Producto obtenerProductoPorId(int id) {
        return repositorio.obtenerProductoPorId(id);
    }

    public void listarProductos() {
        repositorio.obtenerTodosLosProductos().forEach(System.out::println);
    }

    public void actualizarProducto(Producto producto) {
        repositorio.actualizarProducto(producto);
    }

    public void eliminarProducto(int id) {
        repositorio.eliminarProducto(id);
    }
    
    public List<Producto> obtenerTodosLosProductos() {
    return new ArrayList<>(productos);}

    public void vincularProveedor(int idProducto, String proveedor) {
        Producto producto = obtenerProductoPorId(idProducto);
        if (producto != null) {
            producto.setProveedor(proveedor);
            System.out.println("Proveedor vinculado al producto: " + producto.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
