package caulacbobongda2;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void println(String lines) {
        System.out.println(lines);
    }

    public static void main(String[] args) {
        int t = Integer.valueOf(sc.nextLine());
        List<CLB> list1 = new ArrayList<CLB>();
        while (t-- != 0) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            long x = Long.valueOf(sc.nextLine());
            list1.add(new CLB(id, name, x));
        }
        List<TT> list2 = new ArrayList<TT>();
        int t2 = Integer.valueOf(sc.nextLine());
        while (t2-- != 0) {
            String s[] = sc.nextLine().split("\\s+");
            String id = s[0];
            long x = Long.valueOf(s[1]);
            list2.add(new TT(id, x));
        }
        List<SORT> list = new ArrayList<SORT>();
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                if (list2.get(i).abc().equals(list1.get(j).getId())) {
                    // println(list2.get(i).getId() + " " + list1.get(j).getName() + " "
                    // + String.valueOf((list1.get(j).getGiave() * list2.get(i).getSoLuong())));
                    list.add(new SORT(list2.get(i).getId(), list1.get(j).getName(),
                            list1.get(j).getGiave() * list2.get(i).getSoLuong()));
                }
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
/**
2
AC
AC Milan
12
MU
Manchester United
10
2
IAC1 80000
EMU2 60000
 */