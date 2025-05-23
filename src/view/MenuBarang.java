package view;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;


public class MenuBarang extends javax.swing.JInternalFrame {
    

    public MenuBarang() {
        initComponents();
        loadDataKeTabel();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        getContentPane().setBackground(Color.WHITE); // ini penting
    jPanel1.setBackground(Color.WHITE); // kalau kamu pakai panel
        
    }
    
    
    
    public void loadDataKeTabel() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("NO");
    model.addColumn("Kode");
    model.addColumn("Nama");
    model.addColumn("Harga");
    model.addColumn("Stok");

    try {
        // Koneksi ke database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafetaria", "root", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM barang");

        int no = 1;
        while (rs.next()) {
            model.addRow(new Object[]{
                no++,
                rs.getString("kode"),
                rs.getString("nama"),
                rs.getInt("harga"),
                rs.getInt("stok")
            });
        }

        tabel_barang.setModel(model);

        // Center semua isi kolom di JTable
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < tabel_barang.getColumnCount(); i++) {
            tabel_barang.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal load data: " + e.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        tambah = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new Palette.JTable_Custom();
        hapus = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        edit = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 690));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Data Barang");

        search.setForeground(new java.awt.Color(204, 204, 204));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        tambah.setBackground(new java.awt.Color(114, 237, 107));
        tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahMouseClicked(evt);
            }
        });

        jLabel1.setText("Tambah");

        javax.swing.GroupLayout tambahLayout = new javax.swing.GroupLayout(tambah);
        tambah.setLayout(tambahLayout);
        tambahLayout.setHorizontalGroup(
            tambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );
        tambahLayout.setVerticalGroup(
            tambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NO", "Kode", "Nama", "Harga", "Stok"
            }
        ));
        jScrollPane1.setViewportView(tabel_barang);

        hapus.setBackground(new java.awt.Color(210, 59, 59));
        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusMouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hapus");

        javax.swing.GroupLayout hapusLayout = new javax.swing.GroupLayout(hapus);
        hapus.setLayout(hapusLayout);
        hapusLayout.setHorizontalGroup(
            hapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hapusLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(14, 14, 14))
        );
        hapusLayout.setVerticalGroup(
            hapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hapusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        edit.setBackground(new java.awt.Color(71, 109, 206));
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edit");

        javax.swing.GroupLayout editLayout = new javax.swing.GroupLayout(edit);
        edit.setLayout(editLayout);
        editLayout.setHorizontalGroup(
            editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        editLayout.setVerticalGroup(
            editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(495, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1233, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String keyword = search.getText().trim();
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("NO");
    model.addColumn("Kode");
    model.addColumn("Nama");
    model.addColumn("Harga");
    model.addColumn("Stok");

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafetaria", "root", "");
        String sql = "SELECT * FROM barang WHERE kode LIKE ? OR nama LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");
        ResultSet rs = stmt.executeQuery();

        int no = 1;
        while (rs.next()) {
            model.addRow(new Object[]{
                no++,
                rs.getString("kode"),
                rs.getString("nama"),
                rs.getInt("harga"),
                rs.getInt("stok")
            });
        }

        tabel_barang.setModel(model);

        // Center isi kolom
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tabel_barang.getColumnCount(); i++) {
            tabel_barang.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        stmt.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal mencari: " + e.getMessage());
    }
    }//GEN-LAST:event_searchActionPerformed

    private void tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahMouseClicked
        // Mengambil parent JDesktopPane
    javax.swing.JDesktopPane desktopPane = getDesktopPane();

    if (desktopPane != null) {
        // Menutup internal frame saat ini
        this.dispose();

        // Membuka internal frame baru (misalnya TambahBarang)
        Menutambahbarang tambahBarangFrame = new Menutambahbarang();
        desktopPane.add(tambahBarangFrame);
        tambahBarangFrame.setVisible(true);
    }
    }//GEN-LAST:event_tambahMouseClicked

    private void hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseClicked
        // Ambil baris yang dipilih
    int selectedRow = tabel_barang.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu.");
        return;
    }
    
    // Ambil kode barang yang akan dihapus
    String kodeBarang = tabel_barang.getValueAt(selectedRow, 1).toString();

    // Konfirmasi penghapusan
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus barang dengan kode " + kodeBarang + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // Koneksi ke database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafetaria", "root", "");
            
            // Query DELETE data
            String sql = "DELETE FROM barang WHERE kode = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kodeBarang);

            int hasil = stmt.executeUpdate();
            
            if (hasil > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                loadDataKeTabel();  // Memuat ulang data di tabel
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal dihapus.");
            }

            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_hapusMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
    int selectedRow = tabel_barang.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu");
        return;
    }

    // Ambil data dari baris yang dipilih
    String kode = tabel_barang.getValueAt(selectedRow, 1).toString();
    String nama = tabel_barang.getValueAt(selectedRow, 2).toString();
    String harga = tabel_barang.getValueAt(selectedRow, 3).toString(); // Pastikan ini sudah sesuai tipe data
    String stok  = tabel_barang.getValueAt(selectedRow, 4).toString(); // Sama halnya dengan stok

    // Buka form edit dan kirim datanya
    Menueditbarang formEdit = new Menueditbarang(this);  // Mengoper 'this' (MenuBarang) sebagai parent form
    formEdit.setKode(kode);
    formEdit.setNama(nama);
    formEdit.setHarga(harga);
    formEdit.setStok(stok);

    // Tampilkan form edit (kalau pakai JInternalFrame)
    this.getDesktopPane().add(formEdit);
    formEdit.setVisible(true);
    }//GEN-LAST:event_editMouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        searchActionPerformed(null);
    }//GEN-LAST:event_searchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel edit;
    private javax.swing.JPanel hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private Palette.JTable_Custom tabel_barang;
    private javax.swing.JPanel tambah;
    // End of variables declaration//GEN-END:variables
}
