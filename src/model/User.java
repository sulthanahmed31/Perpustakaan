package model;

public abstract class User {
    protected int id;
    protected String nama;

    public User(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public abstract String getRole();

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}
