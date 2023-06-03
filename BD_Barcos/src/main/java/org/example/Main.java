package org.example;

import org.example.Constrolador.ControladorTabla;
import org.example.Modelo.Barcos;
import org.example.Persistencia.BarcosDAO;
import org.example.Persistencia.Singleton;
import org.example.Vista.VentanaBarcos;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaBarcos ventanaBarcos=new VentanaBarcos("Proyecto MVC Barcos");
        ControladorTabla controladorTabla=new ControladorTabla(ventanaBarcos);
    }
}