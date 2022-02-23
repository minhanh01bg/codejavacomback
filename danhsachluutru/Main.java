package danhsachluutru;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int n = Integer.parseInt(sc.nextLine());
        Customer customer[] = new Customer[n];
        for (int i = 0; i < n; i++) {
            customer[i] = new Customer(i + 1, sc.nextLine(), sc.nextLine(),
                    new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()),
                    new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
        }
        Arrays.sort(customer);
        for (Customer i : customer) {
            System.out.println(i);
        }
    }
}

class Customer implements Comparable<Customer> {
    private String id, name, idP;
    private long date;

    public Customer(int id, String name, String idP, Date b, Date l) {
        this.id = String.format("KH%02d", id);
        this.name = name;
        this.idP = idP;
        this.date = TimeUnit.DAYS.convert(l.getTime() - b.getTime(), TimeUnit.MILLISECONDS);
    }

    public String toString() {
        return id + " " + name + " " + idP + " " + date;
    }

    @Override
    public int compareTo(Customer o) {
        return Long.valueOf(this.date).compareTo(o.date) * -1;
    }
}