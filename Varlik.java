public abstract class Varlik {
    private int ID;

    public Varlik(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public abstract String toString(); // Sınıfın özelliklerini String olarak döndürmek için.
}
