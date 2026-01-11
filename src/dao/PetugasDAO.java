package dao;

import config.Koneksi;
import java.sql.*;
import model.Petugas;

public class PetugasDAO {

    public Petugas login(String username, String password) {
        try {
            String sql = "SELECT * FROM petugas WHERE username=? AND password=?";
            PreparedStatement ps = Koneksi.getKoneksi().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Petugas(
                    rs.getInt("id"),
                    rs.getString("nama")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
