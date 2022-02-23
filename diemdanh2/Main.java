package diemdanh2;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void print(String lines) {
        System.out.print(lines);
    }

    public static void println(String lines) {
        System.out.println(lines);
    }

    public static void main(String[] args) {
        int t = Integer.parseInt(sc.nextLine());
        List<SinhVien> list1 = new ArrayList<SinhVien>();

        for (int i = 1; i <= t; i++) {
            SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine());
            list1.add(x);
        }

        List<DiemDanh> list2 = new ArrayList<DiemDanh>();
        for (int i = 1; i <= t; i++) {
            String s[] = sc.nextLine().split("\\s+");
            DiemDanh x = new DiemDanh(s[0], s[1]);
            list2.add(x);
        }
        String loptest = sc.nextLine();
        
        for (int j = 0; j < list1.size(); j++) {
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).getId().equals(list1.get(j).getId()) && list1.get(j).getLop().equals(loptest)) {
                    print(list1.get(j).toString() + " " + list2.get(i).tinhdiem());
                    if (list2.get(i).tinhdiem() == 0)
                        println(" KDDK");
                    else println("");
                }
            }
        }
    }
}
/**
3
B19DCCN999
Le Cong Minh
D19CQAT02-B
B19DCCN998
Tran Truong Giang
D19CQAT02-B
B19DCCN997
Nguyen Tuan Anh
D19CQCN04-B
B19DCCN998 xxxmxmmvmx
B19DCCN997 xmxmxxxvxx
B19DCCN999 xvxmxmmvvm
D19CQAT02-B
 */