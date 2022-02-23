import java.util.*;

public class BangLuongTheoPhongBan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<String> lines = new ArrayList<String>();
        String s;

        for (int i = 0; i < t; i++) {
            s = sc.nextLine();
            lines.add(s);
        }

        t = Integer.parseInt(sc.nextLine());
        List<NV> list = new ArrayList<NV>();
        for (int i = 0; i < t; i++) {
            list.add(new NV(sc.nextLine(), sc.nextLine(), Long.valueOf(sc.nextLine()), Long.valueOf(sc.nextLine())));
        }
        String str = sc.nextLine();
        for (int j = 0; j < lines.size(); j++) {
            String s1[] = lines.get(j).trim().split("\\s+");
            if (s1[0].equals(str)) {
                System.out.print("Bang luong phong ");
                for (int k = 1; k < s1.length - 1; k++) {

                    System.out.print(s1[k] + " ");
                }
                System.out.println(s1[s1.length - 1] + ":");
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < lines.size(); j++) {
                String s1[] = lines.get(j).trim().split("\\s+");
                if (list.get(i).St().equals(s1[0]) && list.get(i).St().equals(str)) {
                    System.out.print(list.get(i));
                    System.out.println(list.get(i).money() + "000");
                    break;
                }
            }
        }
        sc.close();
    }
}

/*
 * 2 HC Hanh chinh KH Ke hoach Dau tu 2 C06HC Tran Binh Minh 65 25 D03KH Le Hoa
 * Binh 59 24 KH
 */
class NV {
    private String id, name;
    private Long mn, p;

    public NV(String id, String name, Long p, Long mn) {
        this.id = id;
        this.name = name;
        this.p = p;
        this.mn = mn;
    }

    public int mid() {
        char[] x = id.toCharArray();
        int X = 0;
        String s = "" + x[1] + x[2];
        int y = Integer.valueOf(s);
        if (x[0] == 'A' && y <= 3 && y >= 1) {
            X = 10;
        } else if (x[0] == 'A' && y > 3 && y <= 8) {
            X = 12;
        } else if (x[0] == 'A' && y > 8 && y <= 15) {
            X = 14;
        } else if (x[0] == 'A' && y > 15) {
            X = 20;
        }
        if (x[0] == 'B' && y <= 3 && y >= 1) {
            X = 10;
        } else if (x[0] == 'B' && y > 3 && y <= 8) {
            X = 11;
        } else if (x[0] == 'B' && y > 8 && y <= 15) {
            X = 13;
        } else if (x[0] == 'B' && y > 15) {
            X = 16;
        }
        if (x[0] == 'C' && y <= 3 && y >= 1) {
            X = 9;
        } else if (x[0] == 'C' && y > 3 && y <= 8) {
            X = 10;
        } else if (x[0] == 'C' && y > 8 && y <= 15) {
            X = 12;
        } else if (x[0] == 'C' && y > 15) {
            X = 14;
        }
        if (x[0] == 'D' && y <= 3 && y >= 1) {
            X = 8;
        } else if (x[0] == 'D' && y > 3 && y <= 8) {
            X = 9;
        } else if (x[0] == 'D' && y > 8 && y <= 15) {
            X = 11;
        } else if (x[0] == 'D' && y > 15) {
            X = 13;
        }
        return X;
    }

    public String St() {
        char[] x = id.toCharArray();
        return "" + x[3] + x[4];
    }

    public Long money() {
        return Long.valueOf(mid() * p * mn);
    }

    public String toString() {
        return id + " " + name + " ";
    }
}