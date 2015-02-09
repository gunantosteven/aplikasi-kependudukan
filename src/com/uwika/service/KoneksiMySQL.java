/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwika.service;

/**
 *
 * @author gunanto
 */
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class KoneksiMySQL {
    public static Connection connection;
    public static Statement stat;
    public static String ip;
    static String lokasKoneksi;

    public static void koneksi(){
        lokasKoneksi="jdbc:mysql://" + ip + "/desasugeng";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(lokasKoneksi, "root", "");
            stat=connection.createStatement();
        }
        catch(Exception z){
            z.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
    
    
}
