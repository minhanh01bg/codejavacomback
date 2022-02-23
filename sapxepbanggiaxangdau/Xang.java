package sapxepbanggiaxangdau;

public class Xang implements Comparable<Xang> {
    private String a, b;

    public Xang(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String hang() {
        char[] x = a.toCharArray();
        String s = "" + x[x.length - 2] + x[x.length - 1];
        String k = "";
        if (s.equals("BP"))
            k = "British Petro";
        else if (s.equals("ES"))
            k = "Esso";
        else if (s.equals("SH"))
            k = "Shell";
        else if (s.equals("CA"))
            k = "Castrol";
        else if (s.equals("MO"))
            k = "Mobil";
        else if (s.equals("TN"))
            k = "Trong Nuoc";
        return k;
    }

    public double Thue() {
        char[] x = a.toCharArray();
        String s = "" + x[0];
        double thue = 0;
        if (s.equals("X")) {
            thue = 0.03;
        } else if (s.equals("D")) {
            thue = 0.035;
        } else if (s.equals("N")) {
            thue = 0.02;
        }
        if (hang().equals("Trong Nuoc"))
            thue = 0;
        return thue;
    }

    public long cal() {
        char[] x = a.toCharArray();
        String s = "" + x[0];
        long y = 0;
        if (s.equals("X")) {
            y = 128000;
        } else if (s.equals("D")) {
            y = 11200;
        } else if (s.equals("N")) {
            y = 9700;
        }
        return y;
    }

    public Double Money() {
        Double x = Double.valueOf(b) * Thue() * cal() + Double.valueOf(b) * cal();
        return x;
    }

    @Override
    public String toString() {
        return a + " " + hang() + " " + cal() + " " + String.format("%.0f", Double.valueOf(b) * Thue() * cal()) + " "
                + String.format("%.0f", Money());
    }

    @Override
    public int compareTo(Xang o) {
        return this.Money().compareTo(o.Money()) * -1;
    }
}
