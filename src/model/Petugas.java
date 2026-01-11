package model;

public class Petugas extends User {

    public Petugas(int id, String nama) {
        super(id, nama);
    }

    @Override
    public String getRole() {
        return "PETUGAS";
    }
}
