package com.example.utspbol_1872003_edwardmichaels.DAO;

import com.example.utspbol_1872003_edwardmichaels.Model.Player;
import com.example.utspbol_1872003_edwardmichaels.Utility.JDBCConnection;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//1872003 - Edward Michael S
public class PlayerDAO implements daoInterface<Player> {
    @Override
    public int addData(Player data) {
        int result = 0;

        try {
            String query = "insert into player (id, nama, umur, keahlian) values (?,?,?,?);";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setInt(1, data.getId());
            ps.setString(2, data.getNama());
            ps.setInt(3, data.getUmur());
            ps.setString(4, data.getKeahlian());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int delData(Player data) {
        int result = 0;

        try {
            String query = "delete from player where id=?;";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setInt(1, data.getId());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Player data) {
        int result = 0;

        try{
            String query = "update player set nama=?, umur=?, keahlian=? where id =?;";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, data.getNama());
            ps.setInt(2, data.getUmur());
            ps.setString(3, data.getKeahlian());
            ps.setInt(4, data.getId());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public ObservableList<Player> showData() {
        ObservableList<Player> pList = FXCollections.observableArrayList();

        try {
            String query = "select * from player";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String nama = res.getString("nama");
                int umur = res.getInt("umur");
                String keahlian = res.getString("keahlian");
                Player player = new Player(id, nama, umur, keahlian);
                pList.add(player);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pList;
    }
}
