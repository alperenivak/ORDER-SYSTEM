public class Urun {
    private int id;
    private String isim;
    private double fiyat;

    public Urun(int id, String isim, double fiyat) {
        this.id = id;
        this.isim = isim;
        this.fiyat = fiyat;
    }

    public int getID() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public double getFiyat() {
        return fiyat;
    }

    @Override
    public String toString() {
        return "Urun[ID=" + id + ", isim=" + isim + ", fiyat=" + fiyat + "]";
    }
}

