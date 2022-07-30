package com.example.ders23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView kitaplariGoster;
    RatingBar ratingBar;

    public static veritabanim veritabanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        veritabanim = Room.databaseBuilder(getApplicationContext(), veritabanim.class,"kitapdb")
                .allowMainThreadQueries().build();



        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);


        // Kitaplar Burada Gösterilecek

        kitaplariGoster = findViewById(R.id.kitaplari_goster_text);
        ratingBar = findViewById(R.id.ratingBar);

        List<Kitap> kitaplar = MainActivity.veritabanim.myDao().getBenimKitap();

        String veriler = "";

        for (Kitap kitap : kitaplar){

            int id = kitap.getId();
            String kad = kitap.getKitapad();
            String kkod = kitap.getKitapkodu();

            veriler = veriler+"\n\n"+"Kitap Id: "+id+"\n"+"Kitap Adı: "+kad+"\n"+"Kitap Açıklaması: "+kkod ;

        }

        kitaplariGoster.setText(veriler);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.kitapekle_toolbar){
            Intent intent = new Intent(getApplicationContext(), yetkiKontrol.class);
            startActivity(intent);
        }
        else if (id == R.id.kitapguncelle_toolbar){
            Intent intent = new Intent(getApplicationContext(), guncelleYetkiKontrol.class);
            startActivity(intent);
        }
        else if (id == R.id.kitapsil_toolbar){
            Intent intent = new Intent(getApplicationContext(), silYetkiKontrol.class);
            startActivity(intent);
        }
        return true;
    }
}