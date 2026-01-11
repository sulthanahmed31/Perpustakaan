package ui;

import dao.BukuDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Buku;
import model.Petugas;

public class Menu extends javax.swing.JFrame {
private Petugas petugas;

    public Menu(Petugas petugas) {
    initComponents();
    this.petugas = petugas;

    loadTable();
    cekHakAkses();
}

    private Menu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


     private void loadTable() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Judul");
    model.addColumn("Penulis");
    model.addColumn("Stok");

    BukuDAO dao = new BukuDAO();
    ArrayList<Buku> list = dao.getAll();

    for (Buku b : list) {
        model.addRow(new Object[]{
            b.getId(),
            b.getJudul(),
            b.getPenulis(),
            b.getStok()
        });
    }

    tblBuku.setModel(model);
}
     private void cekHakAkses() {
    if (petugas.getId() != 1) {
        MainFrame.setEnabled(false);
        FormAnggota.setEnabled(false);
        FormPengembalian.setEnabled(false);
        FormPeminjaman.setEnabled(false);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        MainFrame = new javax.swing.JButton();
        FormAnggota = new javax.swing.JButton();
        FormPeminjaman = new javax.swing.JButton();
        FormPengembalian = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBuku = new javax.swing.JTable();
        lblUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Menu");

        MainFrame.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MainFrame.setText("CRUD Buku");
        MainFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainFrameActionPerformed(evt);
            }
        });

        FormAnggota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FormAnggota.setText("Form Anggota");
        FormAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormAnggotaActionPerformed(evt);
            }
        });

        FormPeminjaman.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FormPeminjaman.setText("Form Peminjaman");
        FormPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormPeminjamanActionPerformed(evt);
            }
        });

        FormPengembalian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FormPengembalian.setText("Form Pengembalian");
        FormPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormPengembalianActionPerformed(evt);
            }
        });

        tblBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblBuku);

        lblUser.setText("User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainFrame)
                .addGap(67, 67, 67)
                .addComponent(FormAnggota)
                .addGap(76, 76, 76)
                .addComponent(FormPeminjaman)
                .addGap(48, 48, 48)
                .addComponent(FormPengembalian)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
            .addGroup(layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MainFrame)
                    .addComponent(FormAnggota)
                    .addComponent(FormPeminjaman)
                    .addComponent(FormPengembalian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MainFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainFrameActionPerformed
        new MainFrame(petugas).setVisible(true);
    this.dispose();
    }//GEN-LAST:event_MainFrameActionPerformed

    private void FormAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormAnggotaActionPerformed
        new FormAnggota(petugas).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_FormAnggotaActionPerformed

    private void FormPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormPeminjamanActionPerformed
        new FormPeminjaman(petugas).setVisible(true);
    this.dispose();
    }//GEN-LAST:event_FormPeminjamanActionPerformed

    private void FormPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormPengembalianActionPerformed
        new FormPengembalian(petugas).setVisible(true);
    this.dispose();
    }//GEN-LAST:event_FormPengembalianActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FormAnggota;
    private javax.swing.JButton FormPeminjaman;
    private javax.swing.JButton FormPengembalian;
    private javax.swing.JButton MainFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tblBuku;
    // End of variables declaration//GEN-END:variables
}
