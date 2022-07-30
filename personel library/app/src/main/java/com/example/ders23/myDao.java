package com.example.ders23;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface myDao {

    @Insert
    public void kitapEkle(Kitap kitap);

    @Query("select * from kitaplar")
    public List<Kitap> getBenimKitap();

    @Delete
    public void kitapSil(Kitap kitap);

    @Update
    public void kitapGuncelle(Kitap kitap);

}
