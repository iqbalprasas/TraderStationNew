package com.example.telc2.traderstation.model;

/**
 * Created by TELC2 on 6/16/2017.
 */

public class StatusSurat {

    private String signId, tglPinjam, tglKembali, jmlKunci, statusSurat;

    public StatusSurat(String signId, String tglPinjam, String tglKembali, String jmlKunci, String statusSurat) {
        this.signId = signId;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.jmlKunci = jmlKunci;
        this.statusSurat = statusSurat;
    }

    public StatusSurat() {
    }

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId;
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

    public String getJmlKunci() {
        return jmlKunci;
    }

    public void setJmlKunci(String jmlKunci) {
        this.jmlKunci = jmlKunci;
    }

    public String getStatusSurat() {
        return statusSurat;
    }

    public void setStatusSurat(String statusSurat) {
        this.statusSurat = statusSurat;
    }
}
