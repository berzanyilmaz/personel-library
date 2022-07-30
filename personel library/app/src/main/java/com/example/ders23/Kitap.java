package com.example.ders23;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kitaplar")
public class Kitap {
//verileri çekiyoruz
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "kitap_adi")
    public String kitapad;

    @ColumnInfo(name = "kitap_kodu")
    public String kitapkodu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitapad() {
        return kitapad;
    }

    public void setKitapad(String kitapad) {
        this.kitapad = kitapad;
    }

    public String getKitapkodu() {
        return kitapkodu;
    }

    public void setKitapkodu(String kitapkodu) {
        this.kitapkodu = kitapkodu;
    }
}
