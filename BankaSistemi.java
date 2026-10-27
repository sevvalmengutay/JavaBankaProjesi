import java.util.Scanner;

public class BankaSistemi {
    public static void main(String[] args) {
        // Kullanıcı giriş işlemleri için Scanner nesnesi (C++'taki cin gibi)
        Scanner input = new Scanner(System.util.System.in);
        
        // 1. Sınıf Seviyesi: Sabit boyutlu diziler (Array) kullanımı
        // Metotlardan sonrasını kullanmadığımız için bilgileri paralel dizilerde tutuyoruz
        int[] hesapNolari = {1001, 1002, 1003};
        String[] musteriIsimleri = {"Ahmet", "Ayse", "Mehmet"};
        double[] bakiyeler = {5000.0, 7500.50, 1200.0};
        
        System.out.println("=== JAVA BANKACILIK SİSTEMİNE HOŞ GELDİNİZ ===");
        
        int secim;
        // do-while döngüsü: Kullanıcı çıkış yapana kadar menüyü döndürür
        do {
            System.out.println("\n--- İŞLEM MENÜSÜ ---");
            System.out.println("1. Tüm Hesapları Listele");
            System.out.println("2. Hesaba Para Yatır");
            System.out.println("3. Hesaptan Para Çek");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = input.nextInt();
            
            // switch-case yapısı ile menü kontrolü
            switch (secim) {
                case 1:
                    System.out.println("\n--- MÜŞTERİ HESAP LİSTESİ ---");
                    // for döngüsü ile dizilerdeki elemanları ekrana yazdırıyoruz
                    for (int i = 0; i < hesapNolari.length; i++) {
                        System.out.println("Hesap No: " + hesapNolari[i] + 
                                           " | İsim: " + musteriIsimleri[i] + 
                                           " | Bakiye: " + bakiyeler[i] + " TL");
                    }
                    break;
                    
                case 2:
                    System.out.print("\nPara yatırmak istediğiniz Hesap No girin: ");
                    int yatirilacakNo = input.nextInt();
                    
                    // Hesap numarasını dizide aratıyoruz
                    int bulunanYatirmaIndeksi = -1;
                    for (int i = 0; i < hesapNolari.length; i++) {
                        if (hesapNolari[i] == yatirilacakNo) {
                            bulunanYatirmaIndeksi = i;
                            break;
                        }
                    }
                    
                    // Eğer hesap bulunduysa para yatırma işlemini yapıyoruz
                    if (bulunanYatirmaIndeksi != -1) {
                        System.out.print("Yatırılacak Miktar: ");
                        double miktar = input.nextDouble();
                        if (miktar > 0) {
                            bakiyeler[bulunanYatirmaIndeksi] += miktar; // Bakiyeyi artır
                            System.out.println("İşlem Başarılı! Yeni Bakiye: " + bakiyeler[bulunanYatirmaIndeksi] + " TL");
                        } else {
                            System.out.println("Geçersiz miktar girdiniz!");
                        }
                    } else {
                        System.out.println("Hata: Hesap bulunamadı!");
                    }
                    break;
                    
                case 3:
                    System.out.print("\nPara çekmek istediğiniz Hesap No girin: ");
                    int cekilecekNo = input.nextInt();
                    
                    int bulunanCekmeIndeksi = -1;
                    for (int i = 0; i < hesapNolari.length; i++) {
                        if (hesapNolari[i] == cekilecekNo) {
                            bulunanCekmeIndeksi = i;
                            break;
                        }
                    }
                    
                    if (bulunanCekmeIndeksi != -1) {
                        System.out.print("Çekilecek Miktar: ");
                        double miktar = input.nextDouble();
                        // Bakiye kontrolü (Yetersiz bakiye engellemesi)
                        if (miktar > 0 && miktar <= bakiyeler[bulunanCekmeIndeksi]) {
                            bakiyeler[bulunanCekmeIndeksi] -= miktar; // Bakiyeyi azalt
                            System.out.println("İşlem Başarılı! Kalan Bakiye: " + bakiyeler[bulunanCekmeIndeksi] + " TL");
                        } else {
                            System.out.println("Hata: Yetersiz bakiye veya geçersiz miktar!");
                        }
                    } else {
                        System.out.println("Hata: Hesap bulunamadı!");
                    }
                    break;
                    
                case 4:
                    System.out.println("Sistemden çıkış yapılıyor. İyi günler dileriz!");
                    break;
                    
                default:
                    System.out.println("Hata: Geçersiz bir seçim yaptınız, tekrar deneyin.");
            }
        } while (secim != 4);
        
        input.close(); // Scanner hafızasını temizleme
    }
}