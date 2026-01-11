package dao;

import config.Koneksi;
import java.sql.*;
import java.time.LocalDate;

public class PeminjamanDAO {

    public void pinjam(int idBuku, int idAnggota) {
    try {
        LocalDate tglPinjam = LocalDate.now();
        LocalDate tglKembali = tglPinjam.plusDays(7);

        Connection c = Koneksi.getKoneksi();

        // 1️⃣ INSERT PEMINJAMAN
        String sql = "INSERT INTO peminjaman " +
                     "(id_buku, id_anggota, tgl_pinjam, tgl_kembali) " +
                     "VALUES (?, ?, ?, ?)";

        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, idBuku);
        ps.setInt(2, idAnggota);
        ps.setDate(3, Date.valueOf(tglPinjam));
        ps.setDate(4, Date.valueOf(tglKembali));
        ps.executeUpdate();

        // 2️⃣ KURANGI STOK BUKU
        String sql2 = "UPDATE buku SET stok = stok - 1 WHERE id = ?";
        PreparedStatement ps2 = c.prepareStatement(sql2);
        ps2.setInt(1, idBuku);
        ps2.executeUpdate();

    } catch (Exception e) {
        System.out.println(e);
    }
}

    public void kembalikan(int idPeminjaman, int idBuku) {
    try {
        Connection c = Koneksi.getKoneksi();

        String sql = "DELETE FROM peminjaman WHERE id=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, idPeminjaman);
        ps.execute();

        String sql2 = "UPDATE buku SET stok = stok + 1 WHERE id=?";
        PreparedStatement ps2 = c.prepareStatement(sql2);
        ps2.setInt(1, idBuku);
        ps2.execute();

    } catch (Exception e) {
        System.out.println(e);
    }
}


}
