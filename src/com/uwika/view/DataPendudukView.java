/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uwika.view;

import com.uwika.model.DataPenduduk;
import com.uwika.model.JenisKelamin;
import com.uwika.model.StatusKawin;
import com.uwika.service.DataPendudukService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gunanto
 */
public class DataPendudukView extends javax.swing.JPanel {

    private DataPenduduk dataPenduduk;
    private ArrayList<DataPenduduk> listDataPenduduk;
    private DataPendudukService dataPendudukService = new DataPendudukService();
    
    /**
     * Creates new form DataPendudukView
     */
    public DataPendudukView() {
        initComponents();
        
        jTable1.setAutoCreateColumnsFromModel(false);
        jTable1.getSelectionModel().addListSelectionListener(new PendudukSelectionListener());
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250); // NIK column width
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(250);
        refreshTable();
    }
    
    private void FormToModel()
    {
        dataPenduduk.setNik(txtNIK.getText());
        dataPenduduk.setKk(txtKK.getText());
        dataPenduduk.setNamaLengkap(txtNamaLengkap.getText());
        dataPenduduk.setJenisKelamin(comboJenisKelamin.getSelectedItem().toString().equals("PRIA") ? JenisKelamin.PRIA : JenisKelamin.WANITA);
        dataPenduduk.setStatusKawin(comboStatusKawin.getSelectedItem().toString().equals("Kawin") ? StatusKawin.KAWIN : StatusKawin.TIDAKKAWIN );
        dataPenduduk.setTempatLahir(txtTempatLahir.getText());
        dataPenduduk.setTanggalLahir(new Date(calendarTanggalLahir.getDate().getTime()));
        dataPenduduk.setAgama(txtAgama.getText());
        dataPenduduk.setPendidikanTerakhir(txtPendidikan.getText());
        dataPenduduk.setPekerjaan(comboBoxPekerjaan.getSelectedItem().toString());
        dataPenduduk.setKewarganegaraan(txtKewarganegaraan.getText());
        dataPenduduk.setAlamatLengkap(txtAlamat.getText());
        dataPenduduk.setKedudukanDalamKeluarga(comboBoxKedudukanDalamKeluarga.getSelectedItem().toString());
        dataPenduduk.setKeterangan(txtKeteranngan.getText());
        dataPenduduk.setStatus(comboBoxStatus.getSelectedItem().toString());
    }
    
    private void ModelToForm()
    {
        txtNIK.setText(dataPenduduk.getNik());
        txtKK.setText(dataPenduduk.getKk());
        txtNamaLengkap.setText(dataPenduduk.getNamaLengkap());
        comboJenisKelamin.setSelectedItem(dataPenduduk.getJenisKelamin().toString());
        comboStatusKawin.setSelectedItem(dataPenduduk.getStatusKawin().toString());
        txtTempatLahir.setText(dataPenduduk.getTempatLahir());
        calendarTanggalLahir.setDate(new java.util.Date(dataPenduduk.getTanggalLahir().getTime()));
        txtAgama.setText(dataPenduduk.getAgama());
        txtPendidikan.setText(dataPenduduk.getPendidikanTerakhir());
        comboBoxPekerjaan.setSelectedItem(dataPenduduk.getPekerjaan());
        txtKewarganegaraan.setText(dataPenduduk.getKewarganegaraan());
        txtAlamat.setText(dataPenduduk.getAlamatLengkap());
        comboBoxKedudukanDalamKeluarga.setSelectedItem(dataPenduduk.getKedudukanDalamKeluarga());
        txtKeteranngan.setText(dataPenduduk.getKeterangan());
        comboBoxStatus.setSelectedItem(dataPenduduk.getStatus());
    }
    
    private void refreshTable()
    {
        listDataPenduduk = dataPendudukService.getAll();
        jTable1.setModel(new PendudukTableModel(listDataPenduduk));
    }
    
    private void refresh()
    {
        txtAgama.setText("");
        txtAlamat.setText("");
        txtKK.setText("");
        txtKeteranngan.setText("");
        txtKewarganegaraan.setText("");
        txtNIK.setText("");
        txtNamaLengkap.setText("");
        txtPendidikan.setText("");
        txtTempatLahir.setText("");
        txtNIK.setEditable(true);
    }
    
    private class PendudukSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            if(jTable1.getSelectedRow()>=0)
            {
                dataPenduduk = listDataPenduduk.get(jTable1.getSelectedRow());
                dataPenduduk = dataPendudukService.getByNik(dataPenduduk.getNik());
                ModelToForm();
                txtNIK.setEditable(false);
                btnSave.setEnabled(false);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
            }
            else
            {
                txtNIK.setEditable(true);
                btnSave.setEnabled(true);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
            }
        }
    }
    
    
     private class PendudukTableModel extends AbstractTableModel
    {
        private List<DataPenduduk> listDataPenduduk;
        
        public PendudukTableModel(List<DataPenduduk> listDataPenduduk)
        {
            this.listDataPenduduk = listDataPenduduk;
        }
        
        public int getRowCount()
        {
            return listDataPenduduk.size();
        }
        
        public int getColumnCount()
        {
            return 14;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            DataPenduduk dataPenduduk = listDataPenduduk.get(rowIndex);
            switch(columnIndex)
            {
                case 0:
                    return dataPenduduk.getNik();
                case 1:
                    return dataPenduduk.getKk();
                case 2:
                    return dataPenduduk.getNamaLengkap();
                case 3:
                    return dataPenduduk.getJenisKelamin();
                case 4:
                    return dataPenduduk.getStatusKawin();
                case 5:
                    return dataPenduduk.getTempatLahir();
                case 6:
                    return dataPenduduk.getTanggalLahir();
                case 7:
                    return dataPenduduk.getAgama();
                case 8:
                    return dataPenduduk.getPendidikanTerakhir();
                case 9:
                    return dataPenduduk.getPekerjaan();
                case 10:
                    return dataPenduduk.getKewarganegaraan();
                case 11:
                    return dataPenduduk.getAlamatLengkap();
                case 12:
                    return dataPenduduk.getKedudukanDalamKeluarga();
                case 13:
                    return dataPenduduk.getStatus();
                    
                default:
                    return "";
                        
            }
        }
    }
    
    private boolean validateForm()
    {
        if(txtNIK.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong !!!");
            return false;
        }
        return true;
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
        txtNIK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtKK = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNamaLengkap = new javax.swing.JTextField();
        comboJenisKelamin = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTempatLahir = new javax.swing.JTextField();
        txtAgama = new javax.swing.JTextField();
        txtPendidikan = new javax.swing.JTextField();
        txtKewarganegaraan = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        comboStatusKawin = new javax.swing.JComboBox();
        txtKeteranngan = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        calendarTanggalLahir = new de.wannawork.jcalendar.JCalendarComboBox();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        comboBoxPekerjaan = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox();
        comboBoxKedudukanDalamKeluarga = new javax.swing.JComboBox();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("NIK");

        jLabel2.setText("KK");

        jLabel3.setText("Nama Lengkap");

        jLabel4.setText("Jenis Kelamin");

        comboJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PRIA", "WANITA" }));

        jLabel5.setText("Tempat Lahir");

        jLabel6.setText("Tanggal Lahir");

        jLabel7.setText("Agama");

        jLabel8.setText("Pendidikan Terakhir");

        jLabel9.setText("Pekerjaan");

        jLabel10.setText("Kewarganegaraan");

        jLabel11.setText("Alamat");

        jLabel12.setText("Kedudukan Dalam Keluarga");

        jLabel13.setText("Keterangan");

        jLabel15.setText("Status Kawin");

        comboStatusKawin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kawin", "Tidak Kawin" }));

        txtKeteranngan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeterannganActionPerformed(evt);
            }
        });

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIK", "KK", "Nama Lengkap", "Jenis Kelamin", "Status Kawin", "Tempat Lahir", "Tanggal Lahir", "Agama", "Pendidikan Terakhir", "Pekerjaan", "Kewarganegaraan", "Alamat", "Kedudukan Dalam Keluarga", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jLabel14.setText("Pencarian");

        btnUpdate.setText("UPDATE");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        comboBoxPekerjaan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABRI", "PEGAWAI NEGERI", "KARYAWAN", "TANI", "PEDAGANG", "BURUH TANI", "PERTUKANGAN", "PENSIUNAN", "LAIN-LAIN" }));

        jLabel16.setText("Status");

        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hidup", "Mati" }));

        comboBoxKedudukanDalamKeluarga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BAPAK", "IBU", "ANAK" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboStatusKawin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNIK)
                    .addComponent(txtKK)
                    .addComponent(txtNamaLengkap)
                    .addComponent(txtTempatLahir, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(txtAgama)
                    .addComponent(txtPendidikan)
                    .addComponent(txtKewarganegaraan)
                    .addComponent(txtAlamat)
                    .addComponent(txtKeteranngan)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear))
                    .addComponent(calendarTanggalLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxKedudukanDalamKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(373, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNamaLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(comboStatusKawin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(calendarTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(comboBoxPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtKewarganegaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(comboBoxKedudukanDalamKeluarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtKeteranngan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate)
                            .addComponent(btnClear))
                        .addGap(24, 24, 24))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtKeterannganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeterannganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeterannganActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(dataPenduduk == null)
            {
                dataPenduduk = new DataPenduduk();
            }
            FormToModel();
            dataPendudukService.insert(dataPenduduk);
            refreshTable();
            refresh();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(dataPenduduk == null)
            {
                dataPenduduk = new DataPenduduk();
            }
            FormToModel();
            dataPendudukService.update(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString(),dataPenduduk);
            refreshTable();
            refresh();
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() >= 0)
        {
            int i = JOptionPane.showConfirmDialog(null, "Apakah anda yakin untuk menghapus data ini ?");
            if(i == JOptionPane.YES_OPTION)
            {
                dataPendudukService.delete(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                refreshTable();
                refresh();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } 
        }
        else
            JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        refreshTable();
        refresh();
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private de.wannawork.jcalendar.JCalendarComboBox calendarTanggalLahir;
    private javax.swing.JComboBox comboBoxKedudukanDalamKeluarga;
    private javax.swing.JComboBox comboBoxPekerjaan;
    private javax.swing.JComboBox comboBoxStatus;
    private javax.swing.JComboBox comboJenisKelamin;
    private javax.swing.JComboBox comboStatusKawin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search;
    private javax.swing.JTextField txtAgama;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtKK;
    private javax.swing.JTextField txtKeteranngan;
    private javax.swing.JTextField txtKewarganegaraan;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtNamaLengkap;
    private javax.swing.JTextField txtPendidikan;
    private javax.swing.JTextField txtTempatLahir;
    // End of variables declaration//GEN-END:variables
}
