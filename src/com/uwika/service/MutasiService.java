/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwika.service;

import com.uwika.model.DataPenduduk;
import com.uwika.model.Mutasi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
              updateemp.setDate(2, mutasi.getTanggal());
              updateemp.setString(3, mutasi.getKeterangan());
              updateemp.setLong(4, mutasi.getId());
              
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
        
        public boolean delete(Long id){
	    	PreparedStatement updateemp = null;
	        boolean cek=true;
	        try{
                    updateemp = KoneksiMySQL.getConnection().prepareStatement("delete from mutas m where m.id = ?");
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
}
