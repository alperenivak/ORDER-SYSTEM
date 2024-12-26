public class Musteri {
    private int id;
    private String isim;
    private String telefon;

    public Musteri(int id, String isim, String telefon) {
        this.id = id;
        this.isim = isim;
        this.telefon = telefon;
    }

    public int getID() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public String getTelefon() {
        return telefon;
    }

    @Override
    public String toString() {
        return "Musteri[ID=" + id + ", isim=" + isim + ", telefon=" + telefon + "]";
    }
}
