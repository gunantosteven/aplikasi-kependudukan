/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwika.model;

import java.sql.Date;

/**
 *
 * @author gunanto
 */
public class Mutasi {
    private Long id;
    private String nik;
    private String tempat;
    private Date tanggal;
    private String keterangan;

    public Mutasi() {
    }

    public Mutasi(Long id, String nik, String tempat, Date tanggal, String keterangan) {
        this.id = id;
        this.nik = nik;
        this.tempat = tempat;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }
    
}
