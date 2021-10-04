
Feature: Musteri Talep Olustur
  
  Musteri stoklinke girip talep olusturur.

  Scenario: 
    Given Acilmis bir browserda musteri kullanici adi ve sifreyle sisteme giris yapar
      | kullaniciAdi        | sifre |
      | zkarsli61@gmail.com | 12345 |
    
    And Musteri talep olustur sayfasina gider
    
    When Musteri talep olusturur
      | urunKodu       | muadil | stok | urunMiktari | Aciklama |
      | 09062483202750 | true   | true |          10 | Urun 1   |
      |     1207450000 | false  | true |          10 | Urun 2   |
    
    Then Musteri olusturdugu talebi talepler sayfasinda gormelidir
