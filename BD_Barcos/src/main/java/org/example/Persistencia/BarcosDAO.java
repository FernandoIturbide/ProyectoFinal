package org.example.Persistencia;

import org.example.Modelo.Barcos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BarcosDAO implements IntefazDAO {
    public BarcosDAO() {
    }

    @Override
    public boolean insertar(Object o) throws SQLException {
        String sql = "INSERT INTO Barcos (Nombre,Tipo,Anio,Pasajaeros,URL) VALUES (?,?,?,?,?);";
        int rowCount=0;
        PreparedStatement pstm= Singleton.getInstance("Barcos_BD.db").getConnection().prepareStatement(sql);
        pstm.setString(1,((Barcos)o).getNombre());
        pstm.setString(2,((Barcos)o).getTipo());
        pstm.setInt(3,((Barcos)o).getAno());
        pstm.setInt(4,((Barcos)o).getPasajeros());
        pstm.setString(5,((Barcos)o).getURL());
        rowCount=pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public boolean update(Object o) throws SQLException {
        String sqlUpdate = "UPDATE Barcos SET Nombre=?,Tipo=?,Anio=?,Pasajaeros=?,URL=? WHERE Id=?;";
        int rowCount=0;
        PreparedStatement pstm=Singleton.getInstance("Barcos_BD.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((Barcos)o).getNombre());
        pstm.setString(2,((Barcos)o).getTipo());
        pstm.setInt(3,((Barcos)o).getAno());
        pstm.setInt(4,((Barcos)o).getPasajeros());
        pstm.setString(5,((Barcos)o).getURL());
        pstm.setInt(6,((Barcos)o).getId());
        rowCount=pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        String sql = "DELETE FROM Barcos WHERE Id=?;";
        int rowCount=0;
        PreparedStatement pstm=Singleton.getInstance("Barcos_BD.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(Id));
        rowCount=pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Barcos";
        ArrayList<Barcos> resultado=new ArrayList<>();

        Statement stm=Singleton.getInstance("Barcos_BD.db").getConnection().createStatement();
        ResultSet res=stm.executeQuery(sql);
        while (res.next()){
            resultado.add(new Barcos(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getString(6)) );
        }

        return resultado;
    }

    @Override
    public Object buscarPorID(String id) throws SQLException {
        String sql = "SELECT * FROM Barcos WHERE id = ?;";
        Barcos barcos=null;
        PreparedStatement pstm=Singleton.getInstance("Barcos_BD.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        ResultSet res=pstm.executeQuery();
        if (res.next()){
            barcos=new Barcos(res.getInt(1), res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getString(6));
            return barcos;
        }
        return null;
    }
}