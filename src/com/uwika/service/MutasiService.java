/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwika.service;



import com.uwika.model.DataPenduduk;
import com.uwika.model.enums.JenisKelamin;
import com.uwika.model.Mutasi;
import com.uwika.model.enums.StatusKawin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gunanto
 */
public class MutasiService {
    
        public boolean insert(Mutasi mutasi){
		PreparedStatement updateemp = null;
	        boolean cek=true;
	        try{
	          updateemp = KoneksiMySQL.getConnection().prepareStatement
		        	      ("insert into mutasi (nik, tempat, tanggal, keterangan)  values(?,?,?,?)"); 
                  updateemp.setString(1,mutasi.getNik());
                  updateemp.setString(2,mutasi.getTempat());
                  updateemp.setDate(3, mutasi.getTanggal());
                  updateemp.setString(4, mutasi.getKeterangan());
                  
                  updateemp.executeUpdate();
                }
                catch(Exception z){
	            JOptionPane.showMessageDialog(null,"Pengisian Data Gagal ??? \n"+ z.getMessage());
	            cek=false;
	        }
                finally
	        {
	        	try { updateemp.close(); } catch (SQLException logOrIgnore) {}
	        }
	        return cek;
        }
        
        public boolean update(Long id, Mutasi mutasi)
        {
            PreparedStatement updateemp = null;
            boolean cek=true;
            try{
              updateemp = KoneksiMySQL.getConnection().prepareStatement
                                  ("UPDATE mutasi SET nik = ?, tempat = ?, tanggal = ?, keterangan = ? WHERE id = ?");
              updateemp.setString(1, mutasi.getNik());
              updateemp.setString(2, mutasi.getTempat());
              updateemp.setDate(3, mutasi.getTanggal());
              updateemp.setString(4, mutasi.getKeterangan());
              updateemp.setLong(5, id);
              
              updateemp.executeUpdate();
            }
            catch(Exception z){
	            JOptionPane.showMessageDialog(null,"Pengisian Data Gagal ??? \n"+ z.getMessage());
	            cek=false;
                    z.printStackTrace();
            }
            finally
            {
                    try { updateemp.close(); } catch (SQLException logOrIgnore) {}
            }
            return cek;
           
        }
        
        public boolean delete(Long id){
	    	PreparedStatement updateemp = null;
	        boolean cek=true;
	        try{
                    updateemp = KoneksiMySQL.getConnection().prepareStatement("delete from mutasi where id = ?");
                    updateemp.setLong(1, id);
	            updateemp.executeUpdate();
	        }
	        catch(Exception z){
	            JOptionPane.showMessageDialog(null, z.getMessage());
	            cek=false;
	        }
	        finally
	        {
	        	try { updateemp.close(); } catch (SQLException logOrIgnore) {}
	        }
	        return cek;
	    }
        
        public ArrayList<Mutasi> getAll()
    {
        PreparedStatement preparedStatement = null;
        ArrayList<Mutasi> listMutasi = new ArrayList<Mutasi>();
        try
        {
            
            preparedStatement = KoneksiMySQL.getConnection().prepareStatement("select * from mutasi");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Mutasi mutasi = new Mutasi();
                mutasi.setId(Long.parseLong(resultSet.getString("id")));
                mutasi.setNik(resultSet.getString("nik"));
                mutasi.setTempat(resultSet.getString("tempat"));
                mutasi.setTanggal(resultSet.getDate("tanggal"));
                mutasi.setKeterangan(resultSet.getString("keterangan"));
                
                listMutasi.add(mutasi);
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
        
        return listMutasi;
    }
        
        public ArrayList<Mutasi> GetListByNik(String nik)
        {
            PreparedStatement preparedStatement = null;
            ArrayList<Mutasi> listMutasi = new ArrayList<Mutasi>();
            try
            {

                preparedStatement = KoneksiMySQL.getConnection().prepareStatement("select * from mutasi where nik like '%"+ nik +"%'");
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next())
                {
                    Mutasi mutasi = new Mutasi();
                    mutasi.setId(Long.parseLong(resultSet.getString("id")));
                    mutasi.setNik(resultSet.getString("nik"));
                    mutasi.setTempat(resultSet.getString("tempat"));
                    mutasi.setTanggal(resultSet.getDate("tanggal"));
                    mutasi.setKeterangan(resultSet.getString("keterangan"));

                    listMutasi.add(mutasi);
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

            return listMutasi;
        }
        
        public Mutasi getByNik(String nik)
    {
        PreparedStatement preparedStatement = null;
        Mutasi mutasi = new Mutasi();
        
        try
        {
            
            preparedStatement = KoneksiMySQL.getConnection().prepareStatement("select * from mutasi where nik = ?");
            preparedStatement.setString(1, nik);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                mutasi.setNik(resultSet.getString("nik"));
                mutasi.setTempat(resultSet.getString("tempat"));
                mutasi.setTanggal(resultSet.getDate("tanggal"));
                mutasi.setKeterangan(resultSet.getString("keterangan"));
                
            }
            else
                mutasi = null;
        }
        catch(Exception z){
            z.printStackTrace();
            JOptionPane.showMessageDialog(null, z.getMessage());
        }
        finally
        {
                try { preparedStatement.close(); } catch (SQLException logOrIgnore) {}
        }
        
        
        return mutasi;
    }
}
