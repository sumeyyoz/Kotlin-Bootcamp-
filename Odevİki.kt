package com.example.kotlindersleri.odevİki

class Odevİki {

    //1-Parametre olarak girilen dereceyi fahrenhiet'a dönüştürdükten sonra geri döndüren bir metod yazınız. F= C*(1.8)+32
    fun donusturme(derece : Double )  : Double {
        return (derece * 1.8) + 32
    }

    //2-Kenarları parametre olarak girilen ve dikdörtgenin çevresini hesaplayan bir metod yazınız.
    fun dikdortgenCH(kenar1 : Int,kenar2 : Int) : Int {
        return kenar1 + kenar2
    }

    //3-Parametre olarak girilen sayinin faktoriyel değerini hesaplayıp geri döndüren metodu yazınız
    fun fakt(sayi: Int): Int {
        if (sayi == 0 || sayi == 1) {
            return 1
        } else {
            return sayi * fakt(sayi - 1)
        }
    }

    //4-Parametre olarak girilen kelime içinde kaç adet a harfi olduğunu gösteren bir metod yazınız.
    fun karakterSayisi(kelime: String, karakter: Char): Int {
        return kelime.count { it == karakter }     // String in içindeki belirli bir karakterin sayısını bulan metod.
    }

    //5-Parametre olarak girilen kenar sayisina göre iç açılar toplamını hesaplayıp sonucu geri gönderen bir metod yazın. İAÇ = (kenar sayisi-2)*180
    fun icAciTop(kenarSayisi : Int) :Int {
        return (kenarSayisi - 2) * 180
    }

    //6-Parametre olarak girilen gün sayisina göre maaş hesabı yapan ve elde edilen değeri döndüren metod yazınız.
    //1 günde 8 saat çalışabilir. Çalışam saat ücreti : 10 tl . Mesai ücreti : 20 tl . 160 saat üzeri mesai sayılır.
    fun maasHesabi(gun : Int) : Int{
        val toplamSaat = 8*gun
        if(toplamSaat > 160) {
            var mesai = toplamSaat - 160
            var maas = toplamSaat * 10 + mesai * 20
            return maas
        }else{
            var maas = toplamSaat * 10
            return maas
        }
    }

    //7-Parametre olarak girilen kota miktarına göre ücreti hesaplayarak geri döndüren metodu yazınız.
    //50GB = 100 tl . Kota aşımından sonra her 1GB , 4 tl.
    fun kotaHesabı(kotaMiktari:Int) : Int{
        if ( kotaMiktari <= 50){
            return 100

        }else{
            val asimMik = (kotaMiktari - 50) * 4
            val sonuc = 100 + asimMik
            return sonuc
        }

    }

}