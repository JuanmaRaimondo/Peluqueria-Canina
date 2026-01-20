package com.peluqueriacanina;

import com.peluqueriacanina.gui.Principal;

public class App 
{
    public static void main( String[] args )
    {
        Principal princ = new Principal();
        
        // Hacerla visible
        princ.setVisible(true);
        
        // Centrarla (opcional, ya lo pusimos en la clase)
        princ.setLocationRelativeTo(null);
    }
}
