package danhsachsanpham2;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = Integer.parseInt(sc.nextLine());
        Iteam iteam[] = new Iteam[n];
        for (int i = 0; i < n; i++) {
            iteam[i] = new Iteam(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(iteam);
        for (Iteam i : iteam) {
            System.out.println(i);
        }
    }
}

class Iteam implements Comparable<Iteam> {
    private String id, name, time;
    private Long money;

    public Iteam(String id, String name, String b, String l) {
        this.name = name;
        this.id = id;
        this.money = Long.valueOf(b);
        this.time = l;
    }

    public String toString() {
        return id + " " + name + " " + money + " " + time;
    }

    @Override
    public int compareTo(Iteam o) {
        if (this.money == o.money)
            return this.id.compareTo(o.id);
        return this.money.compareTo(o.money) * -1;
    }
}