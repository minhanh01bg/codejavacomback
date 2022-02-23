import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        HashMap<String, Sv> ms = new HashMap<>();
        HashMap<String, MonHo> mo = new HashMap<>();

        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            Sv sv = new Sv(ma, sc.nextLine(), sc.nextLine(), sc.nextLine());
            ms.put(ma, sv);
        }

        sc = new Scanner(new File("MONHOC.in"));
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            MonHo mh = new MonHo(ma, sc.nextLine(), Integer.parseInt(sc.nextLine()));
            mo.put(ma, mh);
        }

        sc = new Scanner(new File("BANGDIEM.in"));
        n = Integer.parseInt(sc.nextLine());
        BangDiem[] bd = new BangDiem[n];
        for (int i = 0; i < n; i++) {
            Sv s = ms.get(sc.next());
            MonHo m = mo.get(sc.next());
            bd[i] = new BangDiem(s, m, sc.next());
        }

        Arrays.sort(bd);
        sc.nextLine();
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String id_mh = sc.nextLine();
            System.out.println("BANG DIEM MON " + id_mh + ":\n");
            for (BangDiem j : bd) {
                if (id_mh.equals(j.mh.getMa()))
                    System.out.println(j);
            }
        }
    }
}

class BangDiem implements Comparable<BangDiem> {
    private Sv sv;
    public MonHo mh;
    private String diem;

    public BangDiem(Sv sv, MonHo mh, String diem) {
        this.sv = sv;
        this.mh = mh;
        this.diem = diem;
    }

    public Sv getSv() {
        return sv;
    }

    public int compareTo(BangDiem b) {
        if (diem.equals(b.diem))
            return sv.compareTo(b.sv);
        return diem.compareTo(b.diem) * -1;
    }

    public String toString() {
        return sv.toString() + " " + diem;
    }
}

class MonHo implements Comparable<MonHo> {
    private String ten, ma;
    private int tin;

    public MonHo(String ma, String ten, int tin) {
        this.ten = ten;
        this.ma = ma;
        this.tin = tin;
    }

    public String getMa() {
        return ma;
    }

    public int compareTo(MonHo m) {
        return ten.compareTo(m.ten);
    }

    public String toString() {
        return ma + " " + ten;
    }
}

class Sv implements Comparable<Sv> {
    private String ma, ten, lop, email;

    public Sv(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = "";
        String[] name = ten.trim().toLowerCase().split("\\s+");
        for (String i : name) {
            this.ten += Character.toUpperCase(i.charAt(0)) + i.substring(1) + " ";
        }
        this.setLop(lop);
        this.email = email;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String toString() {
        return ma + " " + ten + lop;
    }

    public int compareTo(Sv s) {
        return ma.compareTo(s.ma);
    }
}
