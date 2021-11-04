package com.example.utspbol_1872003_edwardmichaels.Controller;

import com.example.utspbol_1872003_edwardmichaels.DAO.PlayerDAO;
import com.example.utspbol_1872003_edwardmichaels.Model.Player;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
//1872003 - Edward Michael S
public class StageModalController implements Initializable {
    public TextField txtId;
    public TextField txtNama;
    public TextField txtUmur;
    public TextField txtKeahlian;
    public Button btnSubmit;
    public Button btnCancel;

    ObservableList<Player> pList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PlayerDAO pDao = new PlayerDAO();
    }

    public void btnSubmitClicked(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtId.getText());
        String nama = txtNama.getText();
        int umur = Integer.parseInt(txtUmur.getText());
        String keahlian = txtKeahlian.getText();
        PlayerDAO pDao = new PlayerDAO();
        Player player = new Player(id, nama, umur, keahlian);

        pDao.addData(player);

        txtId.setText(null);
        txtNama.setText(null);
        txtUmur.setText(null);
        txtKeahlian.setText(null);

        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void btnCancelClicked(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}
