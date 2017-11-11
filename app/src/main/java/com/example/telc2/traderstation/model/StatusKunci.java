package com.example.telc2.traderstation.model;

/**
 * Created by TELC2 on 6/16/2017.
 */

public class StatusKunci {
    private String bts, statusAkhir, tglPinjam, namaPeminjam, instansi, tglKembali, jmlKunci, keterangan;

    public StatusKunci(String bts, String statusAkhir, String tglPinjam, String namaPeminjam, String instansi, String tglKembali, String jmlKunci, String keterangan) {
        this.bts = bts;
        this.statusAkhir = statusAkhir;
        this.tglPinjam = tglPinjam;
        this.namaPeminjam = namaPeminjam;
        this.instansi = instansi;
        this.tglKembali = tglKembali;
        this.jmlKunci = jmlKunci;
        this.keterangan = keterangan;
    }

    public StatusKunci() {}

    public String getBts() {

        return bts;
    }

    public void setBts(String bts) {
        this.bts = bts;
    }

    public String getStatusAkhir() {
        return statusAkhir;
    }

    public void setStatusAkhir(String statusAkhir) {
        this.statusAkhir = statusAkhir;
    }

    public String getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

    public String getJmlKunci() {
        return jmlKunci;
    }

    public void setJmlKunci(String jmlKunci) {
        this.jmlKunci = jmlKunci;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
