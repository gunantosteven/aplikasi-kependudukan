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
public class DataPenduduk {
    private String nik;
    private String kk;
    private String namaLengkap;
    private JenisKelamin jenisKelamin;
    private StatusKawin statusKawin;
    private String tempatLahir;
    private Date tanggalLahir;
    private String agama;
    private String pendidikanTerakhir;
    private String pekerjaan;
    private String kewarganegaraan;
    private String alamatLengkap;
    private String kedudukanDalamKeluarga;
    private String keterangan;

    public DataPenduduk() {
    }

    public DataPenduduk(String nik, String kk, String namaLengkap, JenisKelamin jenisKelamin, StatusKawin statusKawin, String tempatLahir, Date tanggalLahir, String agama, String pendidikanTerakhir, String pekerjaan, String kewarganegaraan, String alamatLengkap, String kedudukanDalamKeluarga, String keterangan) {
        this.nik = nik;
        this.kk = kk;
        this.namaLengkap = namaLengkap;
        this.jenisKelamin = jenisKelamin;
        this.statusKawin = statusKawin;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.agama = agama;
        this.pendidikanTerakhir = pendidikanTerakhir;
        this.pekerjaan = pekerjaan;
        this.kewarganegaraan = kewarganegaraan;
        this.alamatLengkap = alamatLengkap;
        this.kedudukanDalamKeluarga = kedudukanDalamKeluarga;
        this.keterangan = keterangan;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getKedudukanDalamKeluarga() {
        return kedudukanDalamKeluarga;
    }

    public void setKedudukanDalamKeluarga(String kedudukanDalamKeluarga) {
        this.kedudukanDalamKeluarga = kedudukanDalamKeluarga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(String pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public StatusKawin getStatusKawin() {
        return statusKawin;
    }

    public void setStatusKawin(StatusKawin statusKawin) {
        this.statusKawin = statusKawin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }
}
