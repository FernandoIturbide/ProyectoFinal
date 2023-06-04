package org.example.Constrolador;

import org.example.Modelo.Barcos;
import org.example.Modelo.ModeloTablaBarcos;
import org.example.Vista.VentanaBarcos;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class ControladorTabla extends MouseAdapter {
    private VentanaBarcos view;
    private ModeloTablaBarcos modelo;
    private int index;
    private String id,nombre,tipo,url,pasajeros,ano;
    private boolean actualizar=false;

    public ControladorTabla(VentanaBarcos view) {
        this.view = view;
        modelo=new ModeloTablaBarcos();
        this.view.getTblBarcos().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblBarcos().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
        this.view.getBtnActualizar2().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==this.view.getBtnCargar()){

            modelo.CargarDatos();
            this.view.getTblBarcos().setModel(modelo);
            this.view.getTblBarcos().updateUI();
            actualizar=true;
        }
        if(e.getSource()==this.view.getBtnAgregar()){
            Barcos barcos=new Barcos();
            barcos.setId(0);
            barcos.setNombre(this.view.getTxtNombre().getText());
            barcos.setTipo(this.view.getTxtTipo().getText());
            barcos.setAno(Integer.parseInt(this.view.getTxtAno().getText()));
            barcos.setPasajeros(Integer.parseInt(this.view.getTxtPasajeros().getText()));
            barcos.setURL(this.view.getTxtURL().getText());

            if(modelo.agregarBarco(barcos)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblBarcos().updateUI();
            }else{
                JOptionPane.showMessageDialog(view,"No se pudo agregar a la base de datos, por favor revise su conexión","Error al insertar",JOptionPane.ERROR_MESSAGE);
            }
            view.Limpiar1();
        }
        if (e.getSource()==this.view.getBtnActualizar()){
           view.Actualizar(id,nombre,tipo,ano,pasajeros,url);
        }
        if(e.getSource()==view.getTblBarcos()){
            this.index=this.view.getTblBarcos().getSelectedRow();
            Barcos tmp = modelo.getBarcosIndex(index);
            id=Integer.toString(tmp.getId());
            nombre=tmp.getNombre();
            tipo= tmp.getTipo();
            ano=Integer.toString(tmp.getAno());
            pasajeros=Integer.toString(tmp.getPasajeros());
            url=tmp.getURL();
            try{
                this.view.getImagenPanel3().setText("");
                this.view.getImagenPanel3().setIcon(tmp.getImagen());

            }catch (MalformedURLException mue){
                System.out.println(e.toString());
            }

        }
        if (e.getSource()==this.view.getBtnActualizar2()){

            try{
                Barcos barcos=new Barcos();
                barcos.setId(Integer.parseInt(this.view.getTxtID().getText()));
                barcos.setNombre(this.view.getTxtNombre().getText());
                barcos.setTipo(this.view.getTxtTipo().getText());
                barcos.setAno(Integer.parseInt(this.view.getTxtAno().getText()));
                barcos.setPasajeros(Integer.parseInt(this.view.getTxtPasajeros().getText()));
                barcos.setURL(this.view.getTxtURL().getText());

                int Res=JOptionPane.showConfirmDialog(
                        view,
                        "¿Estas seguro de querer actualizar el registro con ID: "+id+"?",
                        "Actualizar campos",
                        JOptionPane.YES_NO_CANCEL_OPTION

                );
                switch (Res){
                    case 0:
                        modelo.update(barcos);
                        modelo.CargarDatos();
                        view.Limpiar2();
                        break;
                    case 1:
                        view.Limpiar2();
                        break;
                        case 2:
                            break;

                }
                this.view.getTblBarcos().updateUI();
            }catch (SQLException sqle){
                System.out.println("Error al actualizar");
            }

        }
        if(e.getSource()==view.getBtnEliminar()){
            view.Limpiar2();
            int Res=JOptionPane.showConfirmDialog(
                    view,
                    "¿Estas seguro de borrar el registro con ID: "+id+"?",
                    "Eliminar campos",
                    JOptionPane.YES_NO_OPTION

            );
            System.out.println(Res);
            switch (Res){
                case 0:
                    try{

                        modelo.delete(id);
                    }catch (SQLException sqle){
                        System.out.println("No se pudo eliminar");
                    }
                    break;
                case 1:
                    break;

            }

            modelo.CargarDatos();
            this.view.getTblBarcos().updateUI();
            id="0";
            nombre="";
            tipo= "";
            ano="";
            pasajeros="";
            url="";
        }
        if(actualizar==true){
            modelo.CargarDatos();
            this.view.getTblBarcos().updateUI();
        }
    }
}
