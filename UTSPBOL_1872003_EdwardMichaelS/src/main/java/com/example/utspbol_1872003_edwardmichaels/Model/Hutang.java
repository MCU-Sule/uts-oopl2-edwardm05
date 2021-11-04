package com.example.utspbol_1872003_edwardmichaels.Model;
//1872003 - Edward Michael S
public class Hutang {
    private int id;
    private String pemberihutang;
    private double jumlah;
    private Player player;

    public Hutang(int id, String pemberihutang, double jumlah, Player player) {
        this.id = id;
        this.pemberihutang = pemberihutang;
        this.jumlah = jumlah;
        this.player = player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPemberihutang() {
        return pemberihutang;
    }

    public void setPemberihutang(String pemberihutang) {
        this.pemberihutang = pemberihutang;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
