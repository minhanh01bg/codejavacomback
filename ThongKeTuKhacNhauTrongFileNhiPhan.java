import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class ThongKeTuKhacNhauTrongFileNhiPhan {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> ar = (ArrayList<String>) ois.readObject();
        String line = "";
        for (String i : ar) {
            line = line + " " + i;
        }
        String s[] = line.trim().toLowerCase().split("\\W+");
        HashMap<String, Pair> map = new HashMap<String, Pair>();

        for (String i : s) {
            if (map.get(i) == null) {
                map.put(i, new Pair(i, 1));
            } else {
                Pair x = map.get(i);
                x.update();
                map.replace(i, x);
            }
        }
        List<Pair> list = new ArrayList<Pair>(map.values());
        Collections.sort(list);
        for (Pair x : list) {
            System.out.println(x);
        }
    }
}

class Pair implements Comparable<Pair> {
    private String key;
    private Integer value;

    public Pair(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void update() {
        this.value += 1;
    }

    public String toString() {
        return key + " " + value;
    }

    @Override
    public int compareTo(Pair o) {
        if (value == o.value)
            return this.key.compareTo(o.key);
        return value.compareTo(o.value) * -1;
    }
}
