package dao;

import config.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import model.Buku;

public class BukuDAO implements OperasiCRUD {

    public void insert(String judul, String penulis, int stok) {
        try {
            String sql = "INSERT INTO buku VALUES (null, ?, ?, ?)";
            PreparedStatement ps = Koneksi.getKoneksi().prepareStatement(sql);
            ps.setString(1, judul);
            ps.setString(2, penulis);
            ps.setInt(3, stok);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Buku> getAll() {
        ArrayList<Buku> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM buku";
            Statement st = Koneksi.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                list.add(new Buku(
                    rs.getInt("id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getInt("stok")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
         @Override
    public void insert() {
        // implement insert buku
    }

    @Override
    public void update() {
        // implement update buku
    }

    @Override
    public void delete() {
        // implement delete buku
    }
}
