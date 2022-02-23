package diemdanh2;

public class SinhVien {
    public String id, name, lop;

    public SinhVien(String id, String name, String lop) {
        this.id = id;
        this.name = name;
        this.lop = lop;
    }

    public String getId() {
        return id;
    }

    public String getLop() {
        return lop;
    }

    public String toString() {
        return id + " " + name + " " + lop;
    }
}