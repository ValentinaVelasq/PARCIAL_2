package gestioninventario;

import javax.swing.*; // Clases que permiten crear interfaces gráficas de usuario
import java.util.List;

public class GestionInventario {

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión de inventario");

        // Crear servicios
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        ProductoServicio productoServicio = new ProductoServicio();
        MovimientoServicio movimientoServicio = new MovimientoServicio();
        InventarioServicio inventarioServicio = new InventarioServicio(productoServicio, movimientoServicio);
        ProveedorServicio proveedorServicio = new ProveedorServicio(); 
        
        // Mostrar la pantalla de login
        LoginFrame login = new LoginFrame(usuarioServicio);
        login.setVisible(true);

        //Agregar productos y registrar movimientos después del login
        SwingUtilities.invokeLater(() -> {
            // Crear un producto
            Producto productoCafé = new Producto(1, "Café", "Alimentos", 10, 5000, null);
            productoServicio.agregarProducto(productoCafé);
            System.out.println("Producto agregado: " + productoCafé.getNombre());

            // Registrar un movimiento (entrada)
            movimientoServicio.registrarMovimiento(productoCafé, 4, "entrada", "Se ingresan 4 bolsas de café por cambio de proveedor.");
            System.out.println("Movimiento registrado: Entrada de 4 bolsas de café");

            // Consultar inventario por nombre
            System.out.println("\nConsulta por nombre: Café");
            List<Producto> productosPorNombre = inventarioServicio.consultarPorNombre("Café");
            productosPorNombre.forEach(producto -> System.out.println(producto.getNombre() + ", Cantidad: " + producto.getCantidad()));

            // Consultar inventario por categoría
            System.out.println("\nConsulta por categoría: Alimentos");
            List<Producto> productosPorCategoria = inventarioServicio.consultarPorCategoria("Alimentos");
            productosPorCategoria.forEach(producto -> System.out.println(producto.getNombre() + ", Cantidad: " + producto.getCantidad()));

            // Consultar todo el inventario
            System.out.println("\nTodo el inventario:");
            List<Producto> todosLosProductos = inventarioServicio.consultarTodoElInventario();
            todosLosProductos.forEach(producto -> System.out.println(producto.getNombre() + ", Cantidad: " + producto.getCantidad()));

            // Crear y agregar proveedores
            Proveedor proveedor1 = new Proveedor(1, "Proveedor A", "Calle 1", "123456789");
            Proveedor proveedor2 = new Proveedor(2, "Proveedor B", "Calle 2", "987654321");
            
            proveedorServicio.agregarProveedor(proveedor1);
            proveedorServicio.agregarProveedor(proveedor2);

            // Consultar todos los proveedores
            System.out.println("Proveedores:");
            proveedorServicio.obtenerTodosLosProveedores().forEach(System.out::println);

            // Actualizar un proveedor
            proveedor1.setNombre("Proveedor A Actualizado");
            proveedorServicio.actualizarProveedor(proveedor1);

            // Consultar un proveedor por ID
            Proveedor proveedorConsultado = proveedorServicio.obtenerProveedor(1);
            System.out.println("\nProveedor consultado:");
            System.out.println(proveedorConsultado);

            // Eliminar un proveedor
            proveedorServicio.eliminarProveedor(2);
            System.out.println("\nProveedores después de eliminar:");
            proveedorServicio.obtenerTodosLosProveedores().forEach(System.out::println);
        });
    }
}