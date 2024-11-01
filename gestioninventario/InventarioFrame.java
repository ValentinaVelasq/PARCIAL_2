package gestioninventario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioFrame extends JFrame {
    public InventarioFrame() {
        setTitle("Gestión de Inventario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear botones para acciones de inventario
        JButton btnAgregarExistencias = new JButton("Agregar Existencias");
        JButton btnDisminuirExistencias = new JButton("Disminuir Existencias");
        JButton btnVerMovimientos = new JButton("Ver Movimientos");
        JButton btnVerInventario = new JButton("Ver Inventario");

        // Panel para los botones
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(btnAgregarExistencias);
        panel.add(btnDisminuirExistencias);
        panel.add(btnVerMovimientos);
        panel.add(btnVerInventario);
        
        add(panel);

        // Acción para agregar existencias
        btnAgregarExistencias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir una ventana o cuadro de diálogo para agregar existencias
                JOptionPane.showMessageDialog(InventarioFrame.this, "Funcionalidad para agregar existencias.");
            }
        });

        // Acción para disminuir existencias
        btnDisminuirExistencias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir una ventana o cuadro de diálogo para disminuir existencias
                JOptionPane.showMessageDialog(InventarioFrame.this, "Funcionalidad para disminuir existencias.");
            }
        });

        // Acción para ver movimientos
        btnVerMovimientos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí podrías llamar a MovimientoServicio.mostrarMovimientos() y mostrar la información
                JOptionPane.showMessageDialog(InventarioFrame.this, "Movimientos del inventario.");
            }
        });

        // Acción para ver inventario
        btnVerInventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar inventario actual
                JOptionPane.showMessageDialog(InventarioFrame.this, "Inventario actual de productos.");
            }
        });
    }
}
