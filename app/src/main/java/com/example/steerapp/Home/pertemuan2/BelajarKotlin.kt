package com.example.steerapp.Home.pertemuan2

fun main(){
    println("Hai Kawan Kawan.......")
    println("Selamat datang di bahasa pemograman kotlin")

    println("==========================")

    var angka = 15
    println("Hasil dari 15 + 10 = ${angka + 10}")

    var nilaiInt = 10000
    var nilaiDouble = 100.003
    var nilaiFloat = 1000.0f

    println("Nilai integer = $nilaiInt")
    println("Nilai double = $nilaiDouble")
    println("Nilai float = $nilaiFloat")

    println("==========STRING==========")

    val huruf = 'a'
    println("ini penggunaan karakter '$huruf'")

    val nilaiString = "Mawar"
    println("halo $nilaiString! \nApa kabar")

    println("==========KONDISI=========")

    val nilai = 10
    if(nilai<0)
        println("Bilangan negatif")
    else {
        if(nilai%2 == 0)
            println("Bilangan genap")
        else
            println("Bilangan ganjil")
    }

    println("========PERLUANGAN========")
    val kampusKu: Array<String> = arrayOf("kampus", "politeknik", "caltex", "riau")
    for (kampus: String in kampusKu) {
        println(kampus)
    }
}