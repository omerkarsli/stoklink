
Feature: Musteri Talep Olustur
  
  Musteri stoklinke girip talep olusturur.

  Scenario: 
    Given Acilmis bir browserda musteri kullanici adi ve sifreyle sisteme giris yapar
      | kullaniciAdi        | sifre |
      | zkarsli61@gmail.com | 12345 |
    
    When Musteri talep olustur sayfasina gider
    And Musteri urun satirini doldurur
      | urunKodu       | muadil | stok | urunMiktari | Aciklama |
      | 09062483202750 | true   | true |          10 | Urun 1   |
    And Musteri urun satirini doldurur
      | urunKodu       | muadil | stok | urunMiktari | Aciklama |
      |     1207450000 | false  | true |          10 | Urun 2   |
    And Musteri teklif iste butonuna tiklar
    Then Musteri olusturdugu talebi talepler sayfasinda gormelidir
