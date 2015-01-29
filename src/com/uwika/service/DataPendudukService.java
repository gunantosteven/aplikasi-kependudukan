/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwika.service;

import com.uwika.model.DataPenduduk;
import com.uwika.model.JenisKelamin;
import com.uwika.model.StatusKawin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gunanto
 */
public class DataPendudukService {
    
    public boolean insert(DataPenduduk da){
		PreparedStatement preparedStatement = null;
	        boolean cek=true;
	        try{
	          preparedStatement = KoneksiMySQL.getConnection().prepareStatement
		        	      ("insert into data_penduduk values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
	      preparedStatement.setString(1,da.getNik());
      	      preparedStatement.setString(2,da.getNamaLengkap());
      	      preparedStatement.setString(3,da.getJenisKelamin().toString());
              preparedStatement.setString(4, da.getStatusKawin().toString());
              preparedStatement.setString(5, da.getTempatLahir());
              preparedStatement.setDate(6, da.getTanggalLahir());
              preparedStatement.setString(7, da.getAgama());
              preparedStatement.setString(8, da.getPendidikanTerakhir());
              preparedStatement.setString(9, da.getPekerjaan());
              preparedStatement.setString(10, da.getKewarganegaraan());
              preparedStatement.setString(11, da.getAlamatLengkap());
              preparedStatement.setString(12, da.getKedudukanDalamKeluarga());
              preparedStatement.setString(13, da.getKk());
              preparedStatement.setString(14, da.getKeterangan());
              preparedStatement.setString(15, da.getStatus());
              
      	      preparedStatement.executeUpdate();
	        }
	        catch(Exception z){
	            JOptionPane.showMessageDialog(null,"Pengisian Data Gagal ??? \n"+ z.getMessage());
	            cek=false;
	        }
	        finally
	        {
	        	try { preparedStatement.close(); } catch (SQLException logOrIgnore) {}
	        }
	        return cek;
    }
    
    public boolean update(String nik, DataPenduduk dataPenduduk)
    {
            PreparedStatement preparedStatement = null;
            boolean cek=true;
           try{
             preparedStatement = KoneksiMySQL.getConnection().prepareStatement
                                 ("UPDATE data_penduduk SET namaLengkap = ?, jenisKelamin = ?, statusKawin = ?, tempatLahir = ?, tanggalLahir = ?, agama = ?, pendidikanTerakhir = ?, pekerjaan = ?, kewarganegaraan = ?, alamatLengkap = ?, kedudukanDalamKeluarga = ?, kk = ?, keterangan = ?, status = ? WHERE nik = ?");
             preparedStatement.setString(1,dataPenduduk.getNamaLengkap());
               preparedStatement.setString(2,dataPenduduk.getJenisKelamin().toString());
               preparedStatement.setString(3, dataPenduduk.getStatusKawin().toString());
               preparedStatement.setString(4,dataPenduduk.getTempatLahir());
               preparedStatement.setDate(5,dataPenduduk.getTanggalLahir());
               preparedStatement.setString(6,dataPenduduk.getAgama());
               preparedStatement.setString(7,dataPenduduk.getPendidikanTerakhir());
               preparedStatement.setString(8,dataPenduduk.getPekerjaan());
               preparedStatement.setString(9, dataPenduduk.getKewarganegaraan());
               preparedStatement.setString(10, dataPenduduk.getAlamatLengkap());
               preparedStatement.setString(11, dataPenduduk.getKedudukanDalamKeluarga());
               preparedStatement.setString(12, dataPenduduk.getKk());
               preparedStatement.setString(13, dataPenduduk.getKeterangan());
               preparedStatement.setString(14, dataPenduduk.getStatus());
               preparedStatement.setString(15, nik);
               
               preparedStatement.executeUpdate();
           }
           catch(Exception z){
               JOptionPane.showMessageDialog(null,"Update Data Gagal ??? \n"+ z.getMessage());
               cek=false;
           }
           finally
           {
                   try { preparedStatement.close(); } catch (SQLException logOrIgnore) {}
           }
           return cek;
    }
    
    public boolean delete(String nik){
	    	PreparedStatement preparedStatement = null;
	        boolean cek=true;
	        try{
                    preparedStatement = KoneksiMySQL.getConnection().prepareStatement("delete from data_penduduk  where nik = ?");
                    preparedStatement.setString(1, nik);
	            preparedStatement.executeUpdate();
	        }
	        catch(Exception z){
                    z.printStackTrace();
	            JOptionPane.showMessageDialog(null, z.getMessage());
	            cek=false;
	        }
	        finally
	        {
	        	try { preparedStatement.close(); } catch (SQLException logOrIgnore) {}
	        }
	        return cek;
    }
    
    public ArrayList<DataPenduduk> getAll()
    {
        PreparedStatement preparedStatement = null;
        ArrayList<DataPenduduk> listDataPenduduk = new ArrayList<DataPenduduk>();
        try
        {
            
            preparedStatement = KoneksiMySQL.getConnection().prepareStatement("select * from data_penduduk");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                DataPenduduk dataPendudukan = new DataPenduduk();
                dataPendudukan.setNik(resultSet.getString("nik"));
                dataPendudukan.setNamaLengkap(resultSet.getString("namaLengkap"));
                dataPendudukan.setJenisKelamin(resultSet.getString("jenisKelamin").equals("PRIA") ? JenisKelamin.PRIA : JenisKelamin.WANITA);
                dataPendudukan.setStatusKawin(resultSet.getString("statusKawin").equals("KAWIN") ? StatusKawin.KAWIN : StatusKawin.TIDAKKAWIN);
                dataPendudukan.setTempatLahir(resultSet.getString("tempatLahir"));
                dataPendudukan.setTanggalLahir(resultSet.getDate("tanggalLahir"));
                dataPendudukan.setAgama(resultSet.getString("agama"));
                dataPendudukan.setPendidikanTerakhir(resultSet.getString("pendidikanTerakhir"));
                dataPendudukan.setPekerjaan(resultSet.getString("pekerjaan"));
                dataPendudukan.setKewarganegaraan(resultSet.getString("kewarganegaraan"));
                dataPendudukan.setAlamatLengkap(resultSet.getString("alamatLengkap"));
                dataPendudukan.setKedudukanDalamKeluarga(resultSet.getString("kedudukanDalamKeluarga"));
                dataPendudukan.setKk(resultSet.getString("kk"));
                dataPendudukan.setKeterangan(resultSet.getString("keterangan"));
                dataPendudukan.setStatus(resultSet.getString("status"));
                
                listDataPenduduk.add(dataPendudukan);
            }
        }
        catch(Exception z){
            z.printStackTrace();
            JOptionPane.showMessageDialog(null, z.getMessage());
        }
        finally
        {
                try { preparedStatement.close(); } catch (SQLException logOrIgnore) {}
        }
        
        return listDataPenduduk;
    }
    
    public DataPenduduk getByNik(String nik)
    {
        PreparedStatement preparedStatement = null;
        DataPenduduk dataPenduduk = new DataPenduduk();
        
        try
        {
            
            preparedStatement = KoneksiMySQL.getConnection().prepareStatement("select * from data_penduduk where nik = ?");
            preparedStatement.setString(1, nik);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                dataPenduduk.setNik(resultSet.getString("nik"));
                dataPenduduk.setNamaLengkap(resultSet.getString("namaLengkap"));
                dataPenduduk.setJenisKelamin(resultSet.getString("jenisKelamin").equals("PRIA") ? JenisKelamin.PRIA : JenisKelamin.WANITA);
                dataPenduduk.setStatusKawin(resultSet.getString("statusKawin").equals("KAWIN") ? StatusKawin.KAWIN : StatusKawin.TIDAKKAWIN);
                dataPenduduk.setTempatLahir(resultSet.getString("tempatLahir"));
                dataPenduduk.setTanggalLahir(resultSet.getDate("tanggalLahir"));
                dataPenduduk.setAgama(resultSet.getString("agama"));
                dataPenduduk.setPendidikanTerakhir(resultSet.getString("pendidikanTerakhir"));
                dataPenduduk.setPekerjaan(resultSet.getString("pekerjaan"));
                dataPenduduk.setKewarganegaraan(resultSet.getString("kewarganegaraan"));
                dataPenduduk.setAlamatLengkap(resultSet.getString("alamatLengkap"));
                dataPenduduk.setKedudukanDalamKeluarga(resultSet.getString("kedudukanDalamKeluarga"));
                dataPenduduk.setKk(resultSet.getString("kk"));
                dataPenduduk.setKeterangan(resultSet.getString("keterangan"));
                dataPenduduk.setStatus(resultSet.getString("status"));
            }
            else
                dataPenduduk = null;
        }
        catch(Exception z){
            z.printStackTrace();
            JOptionPane.showMessageDialog(null, z.getMessage());
        }
        finally
        {
                try { preparedStatement.close(); } catch (SQLException logOrIgnore) {}
        }
        
        
        return dataPenduduk;
    }
}
