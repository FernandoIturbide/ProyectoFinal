package org.example.Modelo;

import org.example.Persistencia.BarcosDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaBarcos extends BarcosDAO implements TableModel {
    public static final int COLUMNAS=6;
    private ArrayList<Barcos> datos;
    private BarcosDAO bDAO;

    public ModeloTablaBarcos() {
        bDAO=new BarcosDAO();
        datos=new ArrayList<>();
    }

    public ModeloTablaBarcos(ArrayList<Barcos> datos) {
        this.datos = datos;
        bDAO=new BarcosDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Tipo";
            case 3:
                return "Anio";
            case 4:
                return "Pasajaeros";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Barcos tmp=datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getTipo();
            case 3:
                return tmp.getAno();
            case 4:
                return tmp.getPasajeros();
            case 5:
                return tmp.getURL();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:

                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setTipo((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setId((int) aValue);
                break;
            case 4:
                datos.get(rowIndex).setAno((int) aValue);
                break;
            case 5:
                datos.get(rowIndex).setURL((String) aValue);
                break;

            default:
                System.out.println("No se modifica nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void CargarDatos(){
        try {
            ArrayList<Barcos> tirar=bDAO.obtenerTodo();
            System.out.println(tirar);
            datos=bDAO.obtenerTodo();
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }

    }
    public boolean agregarBarco(Barcos barcos){
        boolean resultado=false;
        try {
            if(bDAO.insertar(barcos)){
                datos.add(barcos);
                resultado=true;
            }else{
                resultado=false;
            }
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
        return resultado;
    }
    public Barcos getBarcosIndex(int index){
        return datos.get(index);
    }
}
