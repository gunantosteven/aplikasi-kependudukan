/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwika.main;

import com.uwika.model.DataPenduduk;
import com.uwika.model.enums.JenisKelamin;
import com.uwika.model.Mutasi;
import com.uwika.model.enums.StatusKawin;
import com.uwika.service.DataPendudukService;
import com.uwika.service.KoneksiMySQL;
import com.uwika.service.MutasiService;
import com.uwika.view.Menu;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author gunanto
 */
public class Main {
    public static void main(String[] args)
    {
        //KoneksiMySQL.ip = JOptionPane.showInputDialog(null, "masukan ip server !");
        KoneksiMySQL.ip = "localhost";
        KoneksiMySQL.koneksi();
        new Menu().setVisible(true);
    }
}
