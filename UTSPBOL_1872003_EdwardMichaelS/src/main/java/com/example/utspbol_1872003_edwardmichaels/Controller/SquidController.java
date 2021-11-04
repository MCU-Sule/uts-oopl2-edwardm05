package com.example.utspbol_1872003_edwardmichaels.Controller;

import com.example.utspbol_1872003_edwardmichaels.DAO.HutangDAO;
import com.example.utspbol_1872003_edwardmichaels.DAO.PlayerDAO;
import com.example.utspbol_1872003_edwardmichaels.Model.Hutang;
import com.example.utspbol_1872003_edwardmichaels.Model.Player;
import com.example.utspbol_1872003_edwardmichaels.SquidApplication;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
//1872003 - Edward Michael S
public class SquidController implements Initializable {

    public TableView<Player> tablePemain;
    public TableColumn<Player, Integer> colID;
    public TableColumn<Player, String> colNama;
    public TableColumn<Player, Integer> colUmur;
    public TableColumn<Player, String> colKeahlian;
    public Button btnAdd;
    public Button btnEdit;
    public Button btnHapus;
    public Button btnTambahhutang;
    public ComboBox cmbPeserta;
    public TextField txtPemberiUtang;
    public TextField txtJumlah;
    public TableView<Hutang> tableHutang;
    public TableColumn<Hutang, Integer> colID2;
    public TableColumn<Hutang, String> colHutang;
    public TableColumn<Hutang, Double> colJumlah;
    public Button btnHapushutang;

    ObservableList<Player> pList;
    ObservableList<Hutang> hList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pList = FXCollections.observableArrayList();
        PlayerDAO pDao = new PlayerDAO();
        ObservableList<Player> pList = pDao.showData();
        tablePemain.setItems(pList);
        colID.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        colNama.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));
        colUmur.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getUmur()).asObject());
        colKeahlian.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKeahlian()));

        hList = FXCollections.observableArrayList();
        HutangDAO hDao = new HutangDAO();
        ObservableList<Hutang> hList = hDao.showData();
        tableHutang.setItems(hList);
        colID2.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        colHutang.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPemberihutang()));
        colJumlah.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getJumlah()).asObject());

        cmbPeserta.setItems(pList);
    }

    public void btnAddClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(SquidApplication.class.getResource("ModalPage.fxml"));
        Parent root = loader.load();
        StageModalController sm = loader.getController();
        Stage secondStage = new Stage();
        secondStage.setTitle("");
        secondStage.setScene(new Scene(root));
        secondStage.initModality(Modality.APPLICATION_MODAL);
        secondStage.showAndWait();

        PlayerDAO pDao = new PlayerDAO();
        ObservableList<Player> pList = pDao.showData();
        tablePemain.setItems(pList);
    }

    public void btnEditClicked(ActionEvent actionEvent) throws IOException {
        Player selected;
        selected = (Player) tablePemain.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(SquidApplication.class.getResource("ModalPage.fxml"));
        Parent root = loader.load();
        StageModalController sm = loader.getController();
        int getid = selected.getId();
        sm.txtId.setText(String.valueOf(getid));
        sm.txtId.setDisable(true);
        Stage secondStage = new Stage();
        secondStage.setTitle("");
        secondStage.setScene(new Scene(root));
        secondStage.initModality(Modality.APPLICATION_MODAL);
        secondStage.showAndWait();

        PlayerDAO pDao = new PlayerDAO();
        ObservableList<Player> pList = pDao.showData();
        tablePemain.setItems(pList);
    }

    public void btnHapusClicked(ActionEvent actionEvent) {
        Player selected;
        selected = tablePemain.getSelectionModel().getSelectedItem();

        PlayerDAO pDao = new PlayerDAO();
        int result  = pDao.delData(selected);

        ObservableList<Player> pList = pDao.showData();
        tablePemain.setItems(pList);
    }

    public void btnTambahhutangClicked(ActionEvent actionEvent) {
//        Hutang hutang = new Hutang();
//        hutang.setPlayer((Player) cmbPeserta.getValue());
//        hutang.setPemberihutang(txtPemberiUtang.getText());
//        hutang.setJumlah(Double.parseDouble(txtJumlah.getText()));
//        HutangDAO hDao = new HutangDAO();
//        hDao.addData(hutang);
//
//        ObservableList<Hutang> hList = hDao.showData();
//        tableHutang.setItems(hList);
    }

    public void btnHapushutangClicked(ActionEvent actionEvent) {
        Hutang selected;
        selected = (Hutang) tableHutang.getSelectionModel().getSelectedItem();

        HutangDAO hDao = new HutangDAO();
        int result = hDao.delData(selected);

        ObservableList<Hutang> hList = hDao.showData();
        tableHutang.setItems(hList);
    }
}
