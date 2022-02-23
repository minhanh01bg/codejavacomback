import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class QuanLyKhachSan {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("DATA.in"));
        // Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        HashMap<String, ABC> map = new HashMap<String, ABC>();
        while (t-- != 0) {
            String s[] = sc.nextLine().split("\\s+");
            map.put(s[0], new ABC(s[0], s[1], Double.valueOf(s[2]), Double.valueOf(s[3])));
        }
        t = Integer.valueOf(sc.nextLine());
        List<User> users = new ArrayList<User>();

        for (int i = 1; i <= t; i++) {
            String name = sc.nextLine();
            String id = sc.nextLine();
            // date
            String date_b = sc.nextLine();
            String date_a = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fi = sdf.parse(date_b);
            Date se = sdf.parse(date_a);
            long date = TimeUnit.DAYS.convert(se.getTime() - fi.getTime(), TimeUnit.MILLISECONDS);

            char x[] = id.toCharArray();
            String id_p = "" + x[2];
            ABC k = map.get(id_p);
            users.add(new User(i, name, id, date, k.getMoney(), k.getPhi()));
        }
        Collections.sort(users, new SortByDate());
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }
}

class SortByDate implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getDate().compareTo(o2.getDate()) * -1;
    }
}

class ABC {
    private String id, name;
    private double money, phi;

    public ABC(String id, String name, double money, double phi) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.phi = phi;
    }

    public String getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public double getPhi() {
        return phi;
    }

    public String toString() {
        return id + " " + name + " " + money + " " + phi;
    }
}

class User {
    private String name, id, stt;
    private double money, phi;
    private long date;

    public User(int stt, String name, String id, long date, double money, double phi) {
        this.stt = String.format("KH%02d", stt);
        this.name = name;
        this.id = id;
        this.date = date;
        this.money = money;
        this.phi = phi;
    }

    public Long getDate() {
        return date;
    }

    public double cal() {
        if (date == 0) {
            return money * phi + money;
        }
        double x = date * money * phi + date * money;
        if (date >= 10 && date < 20) {
            x = x - x * 0.02;
        } else if (date >= 20 && date < 30)
            x = x - x * 0.04;
        else if (date >= 30)
            x = x - x * 0.06;
        return x;
    }

    public String toString() {
        return stt + " " + name + " " + id + " " + date + " " + String.format("%.2f", cal());
    }
}
