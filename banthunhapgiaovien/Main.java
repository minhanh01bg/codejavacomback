package banthunhapgiaovien;

import java.util.*;

public class Main {
    public static void print(String lines) {
        System.out.print(lines);
    }

    public static void println(GiaoVien giaoVien) {
        System.out.println(giaoVien);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<GiaoVien> list = new ArrayList<GiaoVien>();
        for (int i = 1; i <= t; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            long a = Long.valueOf(sc.nextLine());
            list.add(new GiaoVien(id, name, a));
        }
        // Collections.sort(list);
        boolean x = false;
        int y = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).cal() == 2000000 && x == true)
                continue;
            if (list.get(i).cal() == 2000000 && x == false)
                x = true;

            if (list.get(i).cal() == 900000 && y >= 2) {
                continue;
            }
            if (list.get(i).cal() == 900000) {
                y += 1;
            }
            println(list.get(i));
        }
        sc.close();
    }
}
