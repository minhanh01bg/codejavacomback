import java.util.*;

public class HocBongSinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().trim().split("\\s+");
        int t = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        List<SV> list = new ArrayList<SV>();

        for (int i = 0; i < t; i++) {
            SV x = new SV(i, sc.nextLine(), sc.nextLine());
            list.add(x);
        }
        if (m > t)
            m = t;
        Collections.sort(list, new SortPoint());
        double diem = list.get(m - 1).diem();
        // System.out.println(diem);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).cal(diem);
        }
        Collections.sort(list, new SortSTT());
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}

/*
 * 3 2 Nguyen Van Nam 3.59 75 Tran Hong Ngoc 3.61 90 Do Van An 3.22 90
 */
class SortPoint implements Comparator<SV> {
    @Override
    public int compare(SV x, SV y) {
        return x.diem().compareTo(y.diem()) * -1;
    }
}

class SortSTT implements Comparator<SV> {
    @Override
    public int compare(SV o1, SV o2) {
        return o1.getSTT().compareTo(o2.getSTT());
    }
}

class SV {
    private String name, abs, xeploai;
    private Integer STT;

    public SV(int stt, String name, String abs) {
        this.STT = stt;
        this.name = name;
        this.abs = abs;
    }

    public Integer getSTT() {
        return STT;
    }

    public Double diem() {
        String s[] = abs.split("\\s+");
        return Double.parseDouble(s[0]);
    }

    public Double diem1() {
        String s[] = abs.split("\\s+");
        return Double.parseDouble(s[1]);
    }

    public void cal(double diem) {
        String s[] = abs.split("\\s+");
        double a = Double.parseDouble(s[0]);
        if (a < diem) {
            xeploai = "KHONG";
            return;
        }
        double b = Double.parseDouble(s[1]);
        if (a >= 3.6 && b >= 90)
            xeploai = "XUATSAC";
        else if (a >= 3.2 && b >= 80)
            xeploai = "GIOI";
        else if (a >= 2.5 && b >= 70)
            xeploai = "KHA";
        else
            xeploai = "KHONG";
    }

    public String toString() {
        return name + ": " + xeploai;
    }
}