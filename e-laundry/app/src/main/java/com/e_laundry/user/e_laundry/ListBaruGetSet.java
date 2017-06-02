package com.e_laundry.user.e_laundry;

import java.io.Serializable;

/**
 * Created by USER on 01/06/2017.
 */

class ListBaruGetSet implements Serializable {
    String tanggal_ambil,tanggal_antar,alamat,catatan;

    public String getTanggal_ambil() {
        return tanggal_ambil;
    }

    public void setTanggal_ambil(String tanggal_ambil) {
        this.tanggal_ambil = tanggal_ambil;
    }

    public String getTanggal_antar() {
        return tanggal_antar;
    }

    public void setTanggal_antar(String tanggal_antar) {
        this.tanggal_antar = tanggal_antar;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
