package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on promotion8/webinar7/2017.
 */

public class DataPeminjam {
    private String id, namaPeminjam, nohp, noid, instansi, pekerjaan, kdsite, tglPinjam, tglKembali, cekin, fotoIn, cekout, fotoOut, jmlKunci, surat;

    public DataPeminjam(String id, String namaPeminjam, String nohp, String noid, String instansi, String pekerjaan, String kdsite, String tglPinjam, String tglKembali, String cekin, String fotoIn, String cekout, String fotoOut, String jmlKunci, String surat) {
        this.id = id;
        this.namaPeminjam = namaPeminjam;
        this.nohp = nohp;
        this.noid = noid;
        this.instansi = instansi;
        this.pekerjaan = pekerjaan;
        this.kdsite = kdsite;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.cekin = cekin;
        this.fotoIn = fotoIn;
        this.cekout = cekout;
        this.fotoOut = fotoOut;
        this.jmlKunci = jmlKunci;
        this.surat = surat;
    }

    public DataPeminjam(String id, String namaPeminjam, String nohp, String noid, String instansi, String pekerjaan, String kdsite, String tglPinjam, String tglKembali, String jmlKunci, String surat) {
        this.id = id;
        this.namaPeminjam = namaPeminjam;
        this.nohp = nohp;
        this.noid = noid;
        this.instansi = instansi;
        this.pekerjaan = pekerjaan;
        this.kdsite = kdsite;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.jmlKunci = jmlKunci;
        this.surat = surat;
    }

    public DataPeminjam(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getNoid() {
        return noid;
    }

    public void setNoid(String noid) {
        this.noid = noid;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getKdsite() {
        return kdsite;
    }

    public void setKdsite(String kdsite) {
        this.kdsite = kdsite;
    }

    public String getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

    public String getCekin() {
        return cekin;
    }

    public void setCekin(String cekin) {
        this.cekin = cekin;
    }

    public String getFotoIn() {
        return fotoIn;
    }

    public void setFotoIn(String fotoIn) {
        this.fotoIn = fotoIn;
    }

    public String getCekout() {
        return cekout;
    }

    public void setCekout(String cekout) {
        this.cekout = cekout;
    }

    public String getFotoOut() {
        return fotoOut;
    }

    public void setFotoOut(String fotoOut) {
        this.fotoOut = fotoOut;
    }

    public String getJmlKunci() {
        return jmlKunci;
    }

    public void setJmlKunci(String jmlKunci) {
        this.jmlKunci = jmlKunci;
    }

    public String getSurat() {
        return surat;
    }

    public void setSurat(String surat) {
        this.surat = surat;
    }
}
