package xacdinhdanhsachtrungtuyen;

public class SinhVien implements Comparable<SinhVien> {
    private String id, name;
    private double a, b, c;
    private double diem;
    public SinhVien(String id, String name, double a, double b, double c) {
        this.id = id;
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void setDiem(double diem) {
        this.diem = diem;
    }
    public double ut() {
        double x = 0;
        if (id.charAt(2) == '1') {
            x = 0.5;
        } else if (id.charAt(2) == '2') {
            x = 1;
        } else if (id.charAt(2) == '3') {
            x = 2.5;
        }
        return x;
    }

    public double cal() {
        double x = 0;
        x = x + a * 2 + b + c;
        return x;
    }

    public String check() {
        double x = cal() + ut();
        if (x < diem)
            return "TRUOT";
        else
            return "TRUNG TUYEN";
    }

    public String toString() {
        double x = cal() + ut();
        int y = Integer.valueOf(String.format("%.0f", x));
        if (x == y)
            return id + " " + name + " " + ((ut() == 1) ? "1" : ut()) + " " + y + " " + check();
        else
            return id + " " + name + " " + ((ut() == 1) ? "1" : ut()) + " " + String.format("%.1f", x) + " " + check();
    }

    @Override
    public int compareTo(SinhVien o) {
        double x = cal() + ut();
        double y = o.cal() + o.ut();
        if (x == y)
            return id.compareTo(o.id);
        else
            return Double.valueOf(x).compareTo(y) * -1;
    }

}
