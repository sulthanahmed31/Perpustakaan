package model;

public class Buku {
    private int id;
    private String judul;
    private String penulis;
    private int stok;

    // constructor 4 parameter
    public Buku(int id, String judul, String penulis, int stok) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.stok = stok;
    }

    // ===== GETTER (WAJIB ADA SEMUA) =====
    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getStok() {
        return stok;
    }

    @Override
    public String toString() {
        return judul;
    }
}
