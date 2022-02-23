package loaiphong;

public class LoaiPhong implements Comparable<LoaiPhong> {
    private String line;

    public LoaiPhong(String line) {
        this.line = line;
    }

    public String name() {
        String s[] = line.split("\\s+");
        return s[1];
    }

    @Override
    public int compareTo(LoaiPhong o) {
        return this.name().compareTo(o.name());
    }

    public String toString() {
        return line;
    }
}
