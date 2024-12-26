import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Urun> urunler = new ArrayList<>();
    static ArrayList<Musteri> musteriler = new ArrayList<>();
    static ArrayList<Siparis> siparisler = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            // Menü
            System.out.println("\n1- Ürün Ekle");
            System.out.println("2- Müşteri Ekle");
            System.out.println("3- Sipariş Oluştur");
            System.out.println("4- Siparişleri Listele");
            System.out.println("5- Sipariş Ara");
            System.out.println("6- Sipariş Sil");
            System.out.println("7- Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    urunEkle(scanner);
                    break;
                case 2:
                    musteriEkle(scanner);
                    break;
                case 3:
                    siparisOlustur(scanner);
                    break;
                case 4:
                    siparisleriListele();
                    break;
                case 5:
                    siparisAra(scanner);
                    break;
                case 6:
                    siparisSil(scanner);
                    break;
                case 7:
                    System.out.println("Programdan çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyiniz.");
            }
        } while (secim != 7);

        scanner.close();
    }

    // Ürün ekleme
    private static void urunEkle(Scanner scanner) {
        System.out.print("Ürün ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Boşluk temizleme
        System.out.print("Ürün ismi: ");
        String isim = scanner.nextLine();
        System.out.print("Ürün fiyatı: ");
        double fiyat = scanner.nextDouble();
        urunler.add(new Urun(id, isim, fiyat));
        System.out.println("Ürün eklendi.");
    }

    // Müşteri ekleme
    private static void musteriEkle(Scanner scanner) {
        System.out.print("Müşteri ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Boşluk temizleme
        System.out.print("Müşteri ismi: ");
        String isim = scanner.nextLine();
        System.out.print("Müşteri telefonu: ");
        String telefon = scanner.nextLine();
        musteriler.add(new Musteri(id, isim, telefon));
        System.out.println("Müşteri eklendi.");
    }

    // Sipariş oluşturma
    private static void siparisOlustur(Scanner scanner) {
        System.out.println("Müşteri ID'si giriniz:");
        int musteriID = scanner.nextInt();
        Musteri musteri = musteriler.stream()
                .filter(m -> m.getID() == musteriID)
                .findFirst()
                .orElse(null);
        if (musteri == null) {
            System.out.println("Müşteri bulunamadı.");
            return;
        }

        System.out.println("Ürün ID'si giriniz:");
        int urunID = scanner.nextInt();
        Urun urun = urunler.stream()
                .filter(u -> u.getID() == urunID)
                .findFirst()
                .orElse(null);
        if (urun == null) {
            System.out.println("Ürün bulunamadı.");
            return;
        }

        System.out.print("Sipariş adedi: ");
        int adet = scanner.nextInt();
        siparisler.add(new Siparis(musteri, urun, adet));
        System.out.println("Sipariş oluşturuldu.");
    }

    // Siparişleri listeleme
    private static void siparisleriListele() {
        if (siparisler.isEmpty()) {
            System.out.println("Hiç sipariş bulunmuyor.");
        } else {
            System.out.println("Tüm Siparişler:");
            siparisler.forEach(System.out::println);
        }
    }

    // Sipariş arama
    private static void siparisAra(Scanner scanner) {
        System.out.print("Sipariş numarası giriniz: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < siparisler.size()) {
            System.out.println(siparisler.get(index));
        } else {
            System.out.println("Sipariş bulunamadı.");
        }
    }

    // Sipariş silme
    private static void siparisSil(Scanner scanner) {
        System.out.print("Silinecek sipariş numarasını giriniz: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < siparisler.size()) {
            siparisler.remove(index);
            System.out.println("Sipariş silindi.");
        } else {
            System.out.println("Sipariş bulunamadı.");
        }
    }
}
