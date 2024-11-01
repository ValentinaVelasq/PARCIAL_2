package gestioninventario;

import java.util.ArrayList;
import java.util.List;

public class InventarioServicio {
    private ProductoServicio productoServicio;
    private MovimientoServicio movimientoServicio;

    public InventarioServicio(ProductoServicio productoServicio, MovimientoServicio movimientoServicio) {
        this.productoServicio = productoServicio;
        this.movimientoServicio = movimientoServicio;
    }

    public List<Producto> consultarPorNombre(String nombre) {
        List<Producto> productos = productoServicio.obtenerTodosLosProductos();
        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    public List<Producto> consultarPorCategoria(String categoria) {
        List<Producto> productos = productoServicio.obtenerTodosLosProductos();
        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    public List<Producto> consultarTodoElInventario() {
        return productoServicio.obtenerTodosLosProductos();
    }
    // Método para calcular la cantidad disponible de un producto
    private int calcularCantidadDisponible(Producto producto) {
        int cantidadEntradas = movimientoServicio.obtenerEntradasPorProducto(producto);
        int cantidadSalidas = movimientoServicio.obtenerSalidasPorProducto(producto);
        return cantidadEntradas - cantidadSalidas;
    }
}
