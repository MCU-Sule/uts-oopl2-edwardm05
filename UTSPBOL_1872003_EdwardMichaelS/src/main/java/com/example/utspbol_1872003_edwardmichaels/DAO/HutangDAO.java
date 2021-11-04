package com.example.utspbol_1872003_edwardmichaels.DAO;

import com.example.utspbol_1872003_edwardmichaels.Model.Hutang;
import com.example.utspbol_1872003_edwardmichaels.Model.Player;
import com.example.utspbol_1872003_edwardmichaels.Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//1872003 - Edward Michael S
public class HutangDAO implements daoInterface<Hutang> {
    @Override
    public int addData(Hutang data) {
        return 0;
    }

    @Override
    public int delData(Hutang data) {
        int result = 0;

        try {
            String query = "delete from hutang where id=?;";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setInt(1, data.getId());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Hutang data) {
        return 0;
    }

    @Override
    public ObservableList<Hutang> showData() {
        ObservableList<Hutang> hList = FXCollections.observableArrayList();

        try {
            String query = "select h.id as id, h.pemberiutang as pemberiutang, h.jumlah as jumlah, h.player_id as player_id, p.id as id_player, p.nama as nama_player, p.umur as umur, p.keahlian as keahlian from hutang h join player p on h.player_id = p.id";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int idP = res.getInt("id_player");
                String namaP = res.getString("nama_player");
                int umurP = res.getInt("umur");
                String keahlianP = res.getString("keahlian");
                Player player = new Player(idP, namaP, umurP, keahlianP);

                int idH = res.getInt("id");
                String pemberihutangH = res.getString("pemberiutang");
                double jumlahH = res.getDouble("jumlah");
                Hutang hutang = new Hutang(idH, pemberihutangH, jumlahH, player);
                hList.add(hutang);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return hList;
    }
}
