import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BangDiemTheoMonHoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("MONHOC.in"));
        Scanner sc3 = new Scanner(new File("BANGDIEM.in"));

        int t = Integer.valueOf(sc1.nextLine());
        HashMap<String, SinhVien> list1 = new HashMap<String, SinhVien>();
        while (t-- > 0) {
            String id = sc1.nextLine().trim();
            String name = sc1.nextLine().trim();
            String id_c = sc1.nextLine().trim();
            String email = sc1.nextLine().trim();
            list1.put(id, new SinhVien(id, name, id_c, email));
        }

        t = Integer.valueOf(sc2.nextLine().trim());

        HashMap<String, MonHoc> list2 = new HashMap<>();
        for (int i = 1; i <= t; i++) {
            String id = sc2.nextLine().trim();
            String name = sc2.nextLine().trim();
            String soTC = sc2.nextLine().trim();
            list2.put(id, new MonHoc(id, name, soTC));
        }

        t = Integer.valueOf(sc3.nextLine());

        List<BangDiem> list = new ArrayList<>();
        List<BangDiem> list3 = new ArrayList<>();

        while (t-- > 0) {
            String s[] = sc3.nextLine().trim().split("\\s+");
            if (!s[2].equals("null"))
                list.add(new BangDiem(s[0], list1.get(s[0]).getName(), list2.get(s[1]).getId(), s[2],
                        list1.get(s[0]).getId_c()));
            else
                list3.add(new BangDiem(s[0], list1.get(s[0]).getName(), list2.get(s[1]).getId(), s[2],
                        list1.get(s[0]).getId_c()));
        }

        Collections.sort(list);
        Collections.sort(list3);
        t = Integer.valueOf(sc3.nextLine());
        while (t-- > 0) {
            String s = sc3.nextLine().trim();
            System.out.println("BANG DIEM MON " + list2.get(s).getName() + ":");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId_MonHoc().equals(s)) {
                    System.out.println(list.get(i));
                }
            }
            for (int i = 0; i < list3.size(); i++) {
                if (list3.get(i).getId_MonHoc().equals(s)) {
                    System.out.println(list3.get(i));
                }
            }
        }
    }
}

class SinhVien {
    private String id, name, id_c, email;

    public SinhVien(String id, String name, String id_c, String email) {
        this.id = id;
        this.name = name.trim().toLowerCase();
        this.id_c = id_c;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        String s[] = name.split("\\s+");
        String x = "";
        for (int i = 0; i < s.length; i++) {
            x = x + Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }
        return x;
    }

    public String getId_c() {
        return id_c;
    }

    public String toString() {
        return id + " " + getName() + " " + email;
    }
}

class MonHoc {
    private String id, name, soTC;

    public MonHoc(String id, String name, String soTC) {
        this.id = id;
        this.name = name;
        this.soTC = soTC;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoTC() {
        return soTC;
    }

    public void setSoTC(String soTC) {
        this.soTC = soTC;
    }
}

class BangDiem implements Comparable<BangDiem> {
    private String id, name, id_MonHoc;
    private String diem, id_c;

    public BangDiem(String id, String name, String id_MonHoc, String diem, String id_c) {
        this.id = id;
        this.name = name;
        this.id_MonHoc = id_MonHoc;
        this.diem = diem;
        this.id_c = id_c;
    }

    public String getId_c() {
        return id_c;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getId_MonHoc() {
        return id_MonHoc;
    }

    public String getDiem() {
        String s = "";
        if (this.diem.equals("null"))
            return "null";
        double diem1 = Double.valueOf(this.diem);
        int diem = (int) diem1;
        if ((double) diem == diem1) {
            s = String.valueOf(diem);
        } else
            s = String.valueOf(diem1);
        return s;
    }

    public String toString() {
        return id + " " + name + id_c + " " + getDiem();
    }

    @Override
    public int compareTo(BangDiem o) {
        if (this.getDiem().equals(o.getDiem())) {
            return this.getId().compareTo(o.getId());
        }
        return this.getDiem().compareTo(o.getDiem()) * -1;
    }
}