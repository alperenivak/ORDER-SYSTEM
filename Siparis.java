public class Siparis {
    private Musteri musteri;
    private Urun urun;
    private int adet;

    public Siparis(Musteri musteri, Urun urun, int adet) {
        this.musteri = musteri;
        this.urun = urun;
        this.adet = adet;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public Urun getUrun() {
        return urun;
    }

    public int getAdet() {
        return adet;
    }

    
    public String toString() {
        return "Siparis[Musteri=" + musteri + ", Urun=" + urun + ", Adet=" + adet + "]";
    }
}
