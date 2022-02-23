package caulacbobongda2;

public class SORT implements Comparable<SORT> {
    private String id, name;
    private Long soLuong;

    public SORT(String id, String name, Long soLuong) {
        this.id = id;
        this.name = name;
        this.soLuong = soLuong;
    }

    public String toString() {
        return id + " " + name + " " + soLuong;
    }

    @Override
    public int compareTo(SORT o) {
        return this.soLuong.compareTo(o.soLuong) * -1;
    }
}
