package dao;

import config.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import model.Anggota;

public class AnggotaDAO {

    public void insert(String nama) {
        try {
            String sql = "INSERT INTO anggota VALUES (null, ?)";
            PreparedStatement ps = Koneksi.getKoneksi().prepareStatement(sql);
            ps.setString(1, nama);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Anggota> getAll() {
        ArrayList<Anggota> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM anggota";
            Statement st = Koneksi.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                list.add(new Anggota(
                    rs.getInt("id"),
                    rs.getString("nama")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
