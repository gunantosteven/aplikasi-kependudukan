/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwika.main;

import com.uwika.model.DataPenduduk;
import com.uwika.model.JenisKelamin;
import com.uwika.model.Mutasi;
import com.uwika.model.StatusKawin;
import com.uwika.service.DataPendudukService;
import com.uwika.service.KoneksiMySQL;
import com.uwika.service.MutasiService;
import com.uwika.view.Menu;
import java.sql.Date;

/**
 *
 * @author gunanto
 */
public class Main {
    public static void main(String[] args)
    {
        KoneksiMySQL.koneksi();
        MutasiService mutasiService = new MutasiService();
        mutasiService.insert(new Mutasi(null, "zxc", "zxvzxvzxv", new Date(0),"LAHIR"));
        new Menu().setVisible(true);
    }
}
