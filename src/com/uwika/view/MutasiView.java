/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwika.view;


import com.uwika.model.DataPenduduk;
import com.uwika.model.Mutasi;
import com.uwika.service.DataPendudukService;
import com.uwika.service.MutasiService;
import com.uwika.util.LineNumberTableRowHeader;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andrean
 */
public class MutasiView extends javax.swing.JPanel {

    private Mutasi mutasi;
    private ArrayList<Mutasi> listMutasi;
    private MutasiService ms = new MutasiService();
    private DataPendudukService ds = new DataPendudukService();
    private ArrayList<DataPenduduk> listDataPenduduk;
    
    public MutasiView() {
        initComponents();
        
        // kolom nomer urut
        LineNumberTableRowHeader tableLineNumber = new LineNumberTableRowHeader(jScrollPane1, jTable1);
        tableLineNumber.setBackground(Color.LIGHT_GRAY);
        jScrollPane1.setRowHeaderView(tableLineNumber);
        
        jTable1.setAutoCreateColumnsFromModel(false);
        jTable1.getSelectionModel().addListSelectionListener(new MutasiSelectionListener());
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50); // ID column width
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250); 
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150); 
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150); 
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(250); 
        
        refreshTable();
    }

    private boolean validateForm()
    {
        if(txtNik.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong !!!");
            return false;
        }
        listDataPenduduk = ds.getAll();
        boolean check = false;
        for (int i = 0; i<listDataPenduduk.size(); i++)
        {
            if(txtNik.getText().equalsIgnoreCase(listDataPenduduk.get(i).getNik()))
            {
                check = true;
                break;
            }
        }
        if(!check)
        {
            JOptionPane.showMessageDialog(null, "NIK tidak terdaftar dalam Data Penduduk!");
            return false;
        }
        
        if(ds.getByNik(txtNik.getText()).getStatus().equals("MATI"))
        {
            JOptionPane.showMessageDialog(null, "Orang ini sudah tidak ada / meninggal");
            return false;
        }
        
        return true;
    }
    
    private class MutasiSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            if(jTable1.getSelectedRow()>=0)
            {
                mutasi = listMutasi.get(jTable1.getSelectedRow());
                mutasi = ms.getByNik(mutasi.getNik());
                ModelToForm();
                txtNik.setEditable(false);
                btnSimpan.setEnabled(false);
                btnUbah.setEnabled(true);
                btnHapus.setEnabled(true);
            }
            else
            {
                txtNik.setEditable(true);
                btnSimpan.setEnabled(true);
                btnUbah.setEnabled(false);
                btnHapus.setEnabled(false);
            }
        }
    }
    
    public void FormToModel()
    {
        mutasi.setNik(txtNik.getText());
        mutasi.setTempat(txtTempat.getText());
        mutasi.setTanggal(new java.sql.Date(calendarTanggal.getDate().getTime()));
        mutasi.setKeterangan(comboKeterangan.getSelectedItem().toString());
    }
    
    public void ModelToForm()
    {
        txtNik.setText(mutasi.getNik());
        txtTempat.setText(mutasi.getTempat());
        calendarTanggal.setDate(new Date(mutasi.getTanggal().getTime()));
        comboKeterangan.setSelectedItem(mutasi.getKeterangan());
    }
    
    private class MutasiTableModel extends AbstractTableModel
    {
        private List<Mutasi> listMutasi;
        
        public MutasiTableModel(List<Mutasi> listMutasi)
        {
            this.listMutasi = listMutasi;
        }
        
        public int getRowCount()
        {
            return listMutasi.size();
        }
        
        public int getColumnCount()
        {
            return 4;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            Mutasi mutasi = listMutasi.get(rowIndex);
            switch(columnIndex)
            {
                case 0:
                    return mutasi.getId();
                case 1:
                    return mutasi.getNik();
                case 2:
                    return mutasi.getTempat();
                case 3:
                    return mutasi.getTanggal();
                case 4:
                    return mutasi.getKeterangan();
                    
                default:
                    return "";
                        
            }
        }
    }
    
    private void refreshTable()
    {
        listMutasi = ms.getAll();
        jTable1.setModel(new MutasiView.MutasiTableModel(listMutasi));
    }
    
    private void refresh()
    {
        txtNik.setText("");
        txtTempat.setText("");
        
        txtNik.setEditable(true);
    }
    
    private void refreshTanpaNik()
    {
        txtTempat.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        txtTempat = new javax.swing.JTextField();
        comboKeterangan = new javax.swing.JComboBox();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        calendarTanggal = new de.wannawork.jcalendar.JCalendarComboBox();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBaru = new javax.swing.JButton();

        jLabel1.setText("NIK");

        jLabel2.setText("Tempat");

        jLabel3.setText("Tanggal");

        jLabel4.setText("Keterangan");

        comboKeterangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DATANG", "PINDAH", "LAHIR", "MATI" }));

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "NIK", "Tempat", "Tanggal", "Keterangan"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel5.setText("Pencarian");

        btnUbah.setText("UBAH");
        btnUbah.setEnabled(false);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.setEnabled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnBaru.setText("BARU");
        btnBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNik, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                .addComponent(txtTempat)
                                .addComponent(calendarTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                            .addComponent(comboKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBaru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(calendarTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnUbah)
                            .addComponent(btnHapus)
                            .addComponent(btnClear)
                            .addComponent(btnBaru))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(mutasi == null)
            {
                mutasi = new Mutasi();
            }
            FormToModel();
            if(comboKeterangan.getSelectedItem().toString().equals("MATI"))
            {
                ds.updateStatusKematian(mutasi.getNik(), "MATI");
            }
            if(ms.insert(mutasi))
            {
                refreshTable();
                refresh();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
            
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(mutasi == null)
            {
                mutasi = new Mutasi();
            }
            FormToModel();
            if(comboKeterangan.getSelectedItem().toString().equals("MATI"))
            {
                ds.updateStatusKematian(mutasi.getNik(), "MATI");
            }
            if(ms.update(Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()),mutasi))
            {
                refreshTable();
                refresh();
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            }
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() >= 0)
        {
            int i = JOptionPane.showConfirmDialog(null, "Apakah anda yakin untuk menghapus data ini ?");
            if(i == JOptionPane.YES_OPTION)
            {
                ms.delete(Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
                refreshTable();
                refresh();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } 
        }
        else
            JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        listMutasi = ms.GetListByNik(search.getText());
        jTable1.setModel(new MutasiView.MutasiTableModel(listMutasi));
    }//GEN-LAST:event_searchKeyReleased

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        
        refreshTanpaNik();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        // TODO add your handling code here:
        refreshTable();
        refresh();
        btnSimpan.setEnabled(true);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
    }//GEN-LAST:event_btnBaruActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private de.wannawork.jcalendar.JCalendarComboBox calendarTanggal;
    private javax.swing.JComboBox comboKeterangan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtTempat;
    // End of variables declaration//GEN-END:variables
}
