package com.peluqueriacanina.gui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import com.peluqueriacanina.logica.ControladorLogica;
import com.peluqueriacanina.logica.Mascota;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerDatos extends JFrame {
    ControladorLogica control = new ControladorLogica();
    JPanel panel = new JPanel();
    JTable tablaMascotas = new JTable(); // La grilla visual
    DefaultTableModel modeloTabla = new DefaultTableModel();

    public VerDatos() {
        initComponents();
    }

    private void initComponents() {
        // 1. Configuración básica
        setTitle("Visualización de Datos");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setLayout(null);
        getContentPane().add(panel);

        // 2. Título
        JLabel lblTitulo = new JLabel("Visualización de Datos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitulo.setBounds(250, 20, 400, 40);
        panel.add(lblTitulo);

        // Botón Editar
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(650, 100, 110, 50); // A la derecha de la tabla
        panel.add(btnEditar);
        btnEditar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // 1. Verificar que haya fila seleccionada
        if (tablaMascotas.getRowCount() > 0) {
            if (tablaMascotas.getSelectedRow() != -1) {
                
                // 2. Obtener el ID de la mascota a editar
                int num_cliente = Integer.parseInt(String.valueOf(tablaMascotas.getValueAt(tablaMascotas.getSelectedRow(), 0)));
                
                // 3. Abrir la ventana de edición pasando el ID
                ModificarDatos pantallaModif = new ModificarDatos(num_cliente);
                pantallaModif.setVisible(true);
                pantallaModif.setLocationRelativeTo(null);
                
                // 4. (Opcional) Cerrar la ventana vieja para que no estorbe
                dispose(); 
                
            } else {
                mostrarMensaje("No seleccionó ninguna mascota", "Error", "Error al editar");
            }
        } else {
            mostrarMensaje("No hay nada para editar en la tabla", "Error", "Error al editar");
        }
    }
});

// Botón Eliminar
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(650, 170, 110, 50); // Debajo del de Editar
        panel.add(btnEliminar);

       btnEliminar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) { // <--- ESTO FALTABA
        
        // 1. Controlar que la tabla no esté vacía
        if (tablaMascotas.getRowCount() > 0) {
            
            // 2. Controlar que se haya seleccionado una fila
            if (tablaMascotas.getSelectedRow() != -1) {
                
                // 3. Obtener el ID de la mascota (Columna 0)
                // getValueAt devuelve un Object, lo convertimos a String y luego a Int
                int num_cliente = Integer.parseInt(String.valueOf(tablaMascotas.getValueAt(tablaMascotas.getSelectedRow(), 0)));
                
                // 4. Llamar a la lógica para borrar (ESTO DARÁ ERROR ROJO POR AHORA)
                control.borrarMascota(num_cliente);

                // 5. Avisar al usuario
                mostrarMensaje("Mascota eliminada correctamente", "Info", "Borrado de Mascota");
                
                // 6. Recargar la tabla para que desaparezca el viejo
                cargarTabla();
                
            } else {
                mostrarMensaje("No seleccionó ninguna mascota", "Error", "Error al eliminar");
            }
        } else {
            mostrarMensaje("No hay nada para eliminar en la tabla", "Error", "Error al eliminar");
        }
    }
});
        // 3. Método para configurar la tabla (Lo escribiremos abajo)
        cargarTabla();
         }
        private void cargarTabla() {
        // 1. Definir Columnas (Agregamos las que faltaban para que sean 8 igual que los datos)
        modeloTabla.addColumn("Num"); // Agregado
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Raza");
        modeloTabla.addColumn("Alergico");
        modeloTabla.addColumn("At. Esp."); // Agregado
        modeloTabla.addColumn("Dueño");
        modeloTabla.addColumn("Celular"); // Agregado (Es util tener el cel)
        modeloTabla.addColumn("Observaciones");

        // 2. Pedir la lista (con la 's' al final)
        List<Mascota> listaMascotas = control.traerMascota();

        if (listaMascotas != null) {
            for (Mascota masco : listaMascotas) {
                Object[] objeto = {
                    masco.getNum_cliente(),
                    masco.getNombre_de_perro(),
                    masco.getColor(),
                    masco.getRaza(),
                    masco.isAlergico(),        // Ojo: Si es boolean usa isAlergico, si es String usa getAlergico
                    masco.getAtencion_especial(),
                    masco.getDuenio().getNombre(),
                    masco.getDuenio().getCelular(), // Agregamos el celular
                    masco.getObservaciones()
                };
                modeloTabla.addRow(objeto);
            }
        }
        
        tablaMascotas.setModel(modeloTabla);
        
        // Configuración del Scroll
        JScrollPane scroll = new JScrollPane(tablaMascotas);
        scroll.setBounds(10, 80, 600, 400);
        panel.add(scroll);
    }
    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
    JOptionPane optionPane = new JOptionPane(mensaje);
    if (tipo.equals("Info")) {
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
    } else if (tipo.equals("Error")) {
        optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
    }
    JDialog dialog = optionPane.createDialog(titulo);
    dialog.setAlwaysOnTop(true);
    dialog.setVisible(true);
}
}
