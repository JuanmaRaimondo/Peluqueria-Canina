package com.peluqueriacanina.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {

    // Constructor: Aquí configuramos la ventana
    public Principal() {
        initComponents();
    }

    private void initComponents() {
        // 1. Configuración de la Ventana Principal
        setTitle("Peluquería Canina - Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la x, mata el programa
        setSize(800, 500); // Ancho x Alto
        setLocationRelativeTo(null); // Centrar en pantalla
        setResizable(false); // Que no se pueda estirar

        // 2. Crear el Panel Principal (El lienzo)
        JPanel panel = new JPanel();
        panel.setLayout(null); // Layout null para posicionar manual (Coordenadas X, Y)
        getContentPane().add(panel);

        // 3. Título Grande
        JLabel lblTitulo = new JLabel("PELUQUERÍA CANINA");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        lblTitulo.setBounds(200, 20, 500, 50); // x, y, ancho, alto
        panel.add(lblTitulo);

        // 4. Botón "Cargar Datos"
        JButton btnCarga = new JButton("Cargar Datos");
        btnCarga.setFont(new Font("Arial", Font.PLAIN, 18));
        btnCarga.setBounds(100, 150, 250, 50);
        panel.add(btnCarga);

        // Acción del botón Cargar
        btnCarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí abriremos la otra pantalla más adelante
                System.out.println("Clic en Cargar Datos");
                 CargaDatos pantalla = new CargaDatos();
                 pantalla.setVisible(true);
                 dispose(); // Cierra esta ventana
            }
        });

        // 5. Botón "Ver Datos"
        JButton btnVer = new JButton("Ver Datos");
        btnVer.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVer.setBounds(100, 220, 250, 50);
        panel.add(btnVer);
        btnVer.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        VerDatos pantalla = new VerDatos();
        pantalla.setVisible(true);
    }
});

        // 6. Botón "Salir"
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial", Font.PLAIN, 18));
        btnSalir.setBounds(100, 290, 250, 50);
        panel.add(btnSalir);
        
        // Acción de Salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // --- AQUÍ PODRÍAS AGREGAR UNA IMAGEN (LABEL CON ICONO) ---
    }
}