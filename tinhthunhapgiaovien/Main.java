package tinhthunhapgiaovien;

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
        String id = sc.nextLine();
        String name = sc.nextLine();
        long a = Long.valueOf(sc.nextLine());
        GiaoVien x = new GiaoVien(id, name, a);
        println(x);
        sc.close();
    }
}
/**
HP04
Tran Quoc Huy
1578000
 */