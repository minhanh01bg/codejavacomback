package tinhthunhapgiaovien;

public class GiaoVien {
    private String id, name;
    private long money;

    public GiaoVien(String id, String name, long money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public long cal() {
        char[] x = id.toCharArray();
        String s = "" + x[0] + x[1];
        long k = 0;
        if (s.equals("GV"))
            k = 500000;
        else if (s.equals("HT"))
            k = 2000000;
        else if (s.equals("HP"))
            k = 900000;
        return k;
    }

    public long cal1() {
        char[] x = id.toCharArray();
        String s1 = "" + x[2] + x[3];
        int y = Integer.valueOf(s1);
        return y;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + cal1() + " " + cal() + " " + (money * cal1() + cal());
    }
}
