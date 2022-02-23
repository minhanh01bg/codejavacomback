package caulacbobongda1;

public class TT {
    public String id;
    private Long soLuong;

    public TT(String id, Long soLuong) {
        this.id = id;
        this.soLuong = soLuong;
    }

    public String abc() {
        char[] x = id.toCharArray();
        String s = "" + x[1] + x[2];
        return s;
    }

    public String getId() {
        return id;
    }

    public Long getSoLuong() {
        return soLuong;
    }
}
