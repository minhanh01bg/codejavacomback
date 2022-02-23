import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BangDiemTheoLop {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("MONHOC.in"));
        Scanner sc3 = new Scanner(new File("BANGDIEM.in"));
        // Scanner sc1 = new Scanner(new File("C:/Users/vuanh/OneDrive/Desktop/codejavacomback/SINHVIEN.in"));
        // Scanner sc2 = new Scanner(new File("C:/Users/vuanh/OneDrive/Desktop/codejavacomback/MONHOC.in"));
        // Scanner sc3 = new Scanner(new File("C:/Users/vuanh/OneDrive/Desktop/codejavacomback/BANGDIEM.in"));
        // Scanner sc1 = new Scanner(System.in);
        

        int t = Integer.valueOf(sc1.nextLine());
        HashMap<String, SV> list1 = new HashMap<String, SV>();
        while (t-- > 0) {
            String id = sc1.nextLine();
            String name = sc1.nextLine();
            String id_c = sc1.nextLine();
            String email = sc1.nextLine();
            list1.put(id, new SV(id, name, id_c, email));
        }

        // t = Integer.valueOf(sc1.nextLine());

        t = Integer.valueOf(sc2.nextLine());

        HashMap<String, MH> list2 = new HashMap<>();
        for (int i = 1; i <= t; i++) {
            String id = sc2.nextLine();
            String name = sc2.nextLine();
            String soTC = sc2.nextLine();

            // String id = sc1.nextLine();
            // String name = sc1.nextLine();
            // String soTC = sc1.nextLine();
            // String.format("%03d", i) + 
            list2.put(id, new MH(id, name, soTC));
        }

        t = Integer.valueOf(sc3.nextLine());

        // t = Integer.valueOf(sc1.nextLine());

        List<BD> list = new ArrayList<>();
        while (t-- > 0) {
            String s[] = sc3.nextLine().split("\\s+");

            // String s[] = sc1.nextLine().split("\\s+");

            list.add(new BD(s[0], list1.get(s[0]).getName(), list2.get(s[1]).getId(), list2.get(s[1]).getName(), s[2],
                    list1.get(s[0]).getId_c()));
        }
        Collections.sort(list);

        t = Integer.valueOf(sc3.nextLine());
        // t = Integer.valueOf(sc1.nextLine());
        while (t-- > 0) {
            String s = sc3.nextLine();
            // String s = sc1.nextLine();
            System.out.println("BANG DIEM lop " + s + ":");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId_c().equals(s)) {
                    System.out.println(list.get(i));
                }
            }
        }
    }
}

class SV {
    private String id, name, id_c, email;

    public SV(String id, String name, String id_c, String email) {
        this.id = id;
        this.name = name.trim().toLowerCase();
        this.id_c = id_c;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        String s[] = name.split("\\s+");
        String x = "";
        for (int i = 0; i < s.length; i++) {
            x = x + Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1) + " ";
        }
        return x;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_c() {
        return id_c;
    }

    public void setId_c(String id_c) {
        this.id_c = id_c;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return id + " " + getName() + " " + email;
    }
}

class MH {
    private String id, name, soTC;

    public MH(String id, String name, String soTC) {
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

class BD implements Comparable<BD> {
    private String id, name, id_mh, name_mh;
    private String diem, id_c;

    public BD(String id, String name, String id_mh, String name_mh, String diem, String id_c) {
        this.id = id;
        this.name = name;
        this.name_mh = name_mh;
        this.id_mh = id_mh;
        this.diem = diem;
        this.id_c = id_c;
    }

    public String getId_c() {
        return id_c;
    }

    public void setId_c(String id_c) {
        this.id_c = id_c;
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

    public String getId_mh() {
        return id_mh;
    }

    public void setId_mh(String id_mh) {
        this.id_mh = id_mh;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public String toString() {
        return id + " " + name + id_mh + " " + name_mh + " " + diem;
    }

    @Override
    public int compareTo(BD o) {
        if (this.getId_mh().equals(o.getId_mh())) {
            return this.getId().compareTo(o.getId());
        }
        return this.getId_mh().compareTo(o.getId_mh());
    }
}