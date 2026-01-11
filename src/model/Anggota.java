package model;

public class Anggota extends User {

    public Anggota(int id, String nama) {
        super(id, nama);
    }

    @Override
    public String getRole() {
        return "ANGGOTA";
    }

    @Override
    public String toString() {
        return nama;
    }
}
