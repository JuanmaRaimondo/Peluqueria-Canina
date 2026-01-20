package com.peluqueriacanina.gui;

import com.peluqueriacanina.logica.ControladorLogica;
import com.peluqueriacanina.logica.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarDatos extends JFrame {

    ControladorLogica control = new ControladorLogica();
    int num_cliente;
    Mascota masco;
    JPanel panel = new JPanel();
    JTextField txtNombre = new JTextField();
    JTextField txtRaza = new JTextField();
    JTextField txtColor = new JTextField();
    JTextField txtNomDuenio = new JTextField();
    JTextField txtCelDuenio = new JTextField();
    JTextField txtDireccion = new JTextField();
    JTextArea txtObservaciones = new JTextArea();
    


    // Combos (Listas desplegables)
    JComboBox<String> cmbAlergico = new JComboBox<>();
    JComboBox<String> cmbAtEspecial = new JComboBox<>();

    public ModificarDatos(int num_cliente) {
        this.num_cliente = num_cliente;
        initComponents();
        cargarDatos(num_cliente);
    }

    private void cargarDatos(int num_cliente) {
        // 1. Buscamos la mascota en la BD
        this.masco = control.findMascota(num_cliente);

        // 2. Seteamos los valores en los TextFields
        txtNombre.setText(masco.getNombre_de_perro());
        txtRaza.setText(masco.getRaza());
        txtColor.setText(masco.getColor());
        txtNomDuenio.setText(masco.getDuenio().getNombre());
        txtCelDuenio.setText(masco.getDuenio().getCelular());
        txtDireccion.setText(masco.getDuenio().getDireccion());
        txtObservaciones.setText(masco.getObservaciones());

        // 3. Seteamos los ComboBox (Listas)
        if (masco.isAlergico().equals("SI")) {
            cmbAlergico.setSelectedIndex(1);
        } else {
            cmbAlergico.setSelectedIndex(2); // Asumiendo que "NO" es el índice 2
        }
        
        if (masco.getAtencion_especial().equals("SI")) {
            cmbAtEspecial.setSelectedIndex(1);
        } else {
            cmbAtEspecial.setSelectedIndex(2);
        }
    }

    private void initComponents() {
        // 1. Configuración básica de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana, no todo el programa
        setTitle("Modificar los Datos");
        setSize(800, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        crearEtiqueta("Dirección:", 50, 425); // Ajusta la altura si es necesario
        txtDireccion.setBounds(150, 425, 250, 30);
        panel.add(txtDireccion);

        panel.setLayout(null); // Diseño absoluto (manual)
        getContentPane().add(panel);

        // 2. Título
        JLabel lblTitulo = new JLabel("CARGA DE DATOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        lblTitulo.setBounds(200, 20, 400, 50);
        panel.add(lblTitulo);

      
        crearEtiqueta("Nombre:", 50, 100);
        crearEtiqueta("Raza:", 50, 150);
        crearEtiqueta("Color:", 50, 200);
        crearEtiqueta("Alérgico:", 50, 250);
        crearEtiqueta("At. Especial:", 50, 300);
        crearEtiqueta("Nombre Dueño:", 50, 350);
        crearEtiqueta("Cel. Dueño:", 50, 400);
        crearEtiqueta("Observaciones:", 50, 450);

        // --- COLUMNA DE CAMPOS (INPUTS) ---
        
        // Nombre Perro
        txtNombre.setBounds(150, 100, 250, 30);
        panel.add(txtNombre);

        // Raza
        txtRaza.setBounds(150, 150, 250, 30);
        panel.add(txtRaza);

        // Color
        txtColor.setBounds(150, 200, 250, 30);
        panel.add(txtColor);

        // Alérgico (Combo Box)
        cmbAlergico.addItem("-");
        cmbAlergico.addItem("SI");
        cmbAlergico.addItem("NO");
        cmbAlergico.setBounds(150, 250, 100, 30);
        panel.add(cmbAlergico);

        // At. Especial (Combo Box)
        cmbAtEspecial.addItem("-");
        cmbAtEspecial.addItem("SI");
        cmbAtEspecial.addItem("NO");
        cmbAtEspecial.setBounds(150, 300, 100, 30);
        panel.add(cmbAtEspecial);

        // Nombre Dueño
        txtNomDuenio.setBounds(150, 350, 250, 30);
        panel.add(txtNomDuenio);

        // Celular Dueño
        txtCelDuenio.setBounds(150, 400, 250, 30);
        panel.add(txtCelDuenio);

        // Observaciones (TextArea - Caja Grande)
        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        JScrollPane scroll = new JScrollPane(txtObservaciones); // Scroll por si escribe mucho
        scroll.setBounds(150, 450, 250, 80);
        panel.add(scroll);

        // --- IMAGEN DECORATIVA (Opcional) ---
        // Si tienes una imagen en assets, podrías cargarla aquí.
        // Por ahora dejamos un Label vacío o con texto
        JLabel lblImagen = new JLabel("                [ FOTO PERRO ] ");
        lblImagen.setBounds(500, 150, 200, 200);
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Un recuadro negro
        panel.add(lblImagen);

        // --- BOTONES ---

        // Botón LIMPIAR
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnLimpiar.setBounds(50, 540, 150, 40);
        panel.add(btnLimpiar);

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para borrar todo
                txtNombre.setText("");
                txtRaza.setText("");
                txtColor.setText("");
                txtNomDuenio.setText("");
                txtCelDuenio.setText("");
                txtObservaciones.setText("");
                cmbAlergico.setSelectedIndex(0);
                cmbAtEspecial.setSelectedIndex(0);
            }
        });

        // Botón GUARDAR
        JButton btnGuardar = new JButton("Guardar Cambios");
        btnGuardar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnGuardar.setBounds(250, 540, 150, 40);
        panel.add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // 1. Extraer todos los datos (igual que tenías)
        String nombreMasco = txtNombre.getText();
        String raza = txtRaza.getText();
        String color = txtColor.getText();
        String observaciones = txtObservaciones.getText();
        String nomDuenio = txtNomDuenio.getText();
        String celDuenio = txtCelDuenio.getText();
        
        // Nota: Si agregaste "Direccion" en la lógica, agrégala aquí también. 
        // Si no la pusiste en el método modificarMascota de la lógica, no la pases todavía.
        
        String alergico = (String) cmbAlergico.getSelectedItem();
        String atencEsp = (String) cmbAtEspecial.getSelectedItem();

        // 2. LLAMAR AL MÉTODO MODIFICAR (Esta es la clave)
        // Le pasamos 'masco' (el objeto original con el ID) + los datos nuevos
        control.modificarMascota(masco, nombreMasco, raza, color, observaciones, alergico, atencEsp, nomDuenio, celDuenio);
        
        // 3. Mostrar mensaje de éxito
        mostrarMensaje("Edición realizada correctamente", "Info", "Edición correcta");
        
        // 4. Cerrar esta ventana y volver a abrir la lista para ver los cambios
        VerDatos pantalla = new VerDatos();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        
        dispose(); // Cerramos la ventana de edición
    }
});
    }

    // Método auxiliar para no repetir código creando etiquetas
    private void crearEtiqueta(String texto, int x, int y) {
        JLabel lbl = new JLabel(texto);
        lbl.setBounds(x, y, 100, 30);
        panel.add(lbl);
    }

    // Método auxiliar para mostrar mensajes
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