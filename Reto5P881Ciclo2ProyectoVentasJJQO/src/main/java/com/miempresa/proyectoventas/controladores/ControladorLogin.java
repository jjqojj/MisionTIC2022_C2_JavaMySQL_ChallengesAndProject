
package com.miempresa.proyectoventas.controladores;

//Elaborado por: John Jairo Quiroga Orozco
//Plantilla base del curso P81
//MisionTic 2021
//ngjquiroga@gmail.com
//Fecha finalización edición 12/10/2021


import com.miempresa.proyectoventas.modelos.ModeloUsuarios;
import com.miempresa.proyectoventas.vistas.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ControladorLogin {
    private VistaLogin ventanaLogin;
    public ControladorLogin() {
        ventanaLogin = new VistaLogin();
        ventanaLogin.setTitle("Ingreso al Sistema Ventas JJQO");
        ImageIcon icono = new ImageIcon("src/main/java/com/miempresa/proyectoventas/vistas/LogoJJQO.png");
        ventanaLogin.setIconImage(icono.getImage());
        ventanaLogin.setVisible(true);
        ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton botonLogin = ventanaLogin.getjBtnEntrar();
        botonLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                validarLogin(ventanaLogin.getLogin(),ventanaLogin.getPassword());
            }
            
        });
        ventanaLogin.getRootPane().setDefaultButton(botonLogin);
        
        
    }
    public void validarLogin(String nombreUsuario, String password){
        ModeloUsuarios modeloUsuarios = new ModeloUsuarios();
        if(!modeloUsuarios.validarPassword(nombreUsuario, password)){
            ventanaLogin.setMsgError("Error de Entrada. Verifique Login y Password");
            return;
        }
        ventanaLogin.setMsgError("");
        ventanaLogin.setPassword("");
        new ControladorMenuPrincipal(ventanaLogin);
    };
    
    
}
