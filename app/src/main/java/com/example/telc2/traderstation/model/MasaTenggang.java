package com.example.telc2.traderstation.model;

/**
 * Created by iqbal on 8/8/2017.
 */

public class MasaTenggang {

    private String id, bts, nama, inst, nohp, tglp, tglk, jmlkunci;

    public MasaTenggang(String id, String bts, String nama, String inst, String nohp, String tglp, String tglk, String jmlkunci) {
        this.id = id;
        this.bts = bts;
        this.nama = nama;
        this.inst = inst;
        this.nohp = nohp;
        this.tglp = tglp;
        this.tglk = tglk;
        this.jmlkunci = jmlkunci;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBts() {
        return bts;
    }

    public void setBts(String bts) {
        this.bts = bts;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getTglp() {
        return tglp;
    }

    public void setTglp(String tglp) {
        this.tglp = tglp;
    }

    public String getTglk() {
        return tglk;
    }

    public void setTglk(String tglk) {
        this.tglk = tglk;
    }

    public String getJmlkunci() {
        return jmlkunci;
    }

    public void setJmlkunci(String jmlkunci) {
        this.jmlkunci = jmlkunci;
    }
}
