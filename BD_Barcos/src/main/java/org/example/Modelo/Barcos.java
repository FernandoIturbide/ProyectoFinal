package org.example.Modelo;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Barcos {
    private int Id;
    private String Nombre;
    private String Tipo;
    private int Ano;
    private int Pasajeros;
    private String URL;

    public Barcos() {
    }

    public Barcos(int id, String nombre, String tipo, int ano, int pasajeros, String URL) {
        Id = id;
        Nombre = nombre;
        Tipo = tipo;
        Ano = ano;
        Pasajeros = pasajeros;
        this.URL = URL;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int ano) {
        Ano = ano;
    }

    public int getPasajeros() {
        return Pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        Pasajeros = pasajeros;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Barcos{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", Ano=" + Ano +
                ", Pasajeros=" + Pasajeros +
                ", URL='" + URL + '\'' +
                '}';
    }
    public ImageIcon getImagen () throws MalformedURLException {
        URL urlImagen=new URL(this.URL);
        //Image imagen=new ImageIcon(urlImagen).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        return new ImageIcon(urlImagen);
    }

}
