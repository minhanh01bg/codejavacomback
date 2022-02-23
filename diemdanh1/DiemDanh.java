package diemdanh1;

public class DiemDanh {
    private String id, dd;

    public DiemDanh(String id, String dd) {
        this.id = id;
        this.dd = dd;
    }

    public String getId() {
        return id;
    }

    public int tinhdiem() {
        int x = 10;
        char[] y = dd.toCharArray();
        int cntm = 0, cntv = 0;
        for (int i = 0; i < y.length; i++) {
            if (y[i] == 'm')
                cntm++;
            if (y[i] == 'v')
                cntv++;
        }
        x = x - 2 * cntv - cntm;
        if (x <= 0)
            return 0;
        return x;
    }
}
