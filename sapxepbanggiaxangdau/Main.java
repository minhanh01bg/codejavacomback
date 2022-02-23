package sapxepbanggiaxangdau;


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
        int t = Integer.valueOf(sc.nextLine());
        List<Xang> list = new ArrayList<Xang>();
        while (t-- != 0) {
            String s[] = sc.nextLine().split("\\s+");
            list.add(new Xang(s[0], s[1]));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            println(list.get(i).toString());
        }
    }
}
/*
3
N89BP 4500
D00BP 3500
X92SH 2600
*/
