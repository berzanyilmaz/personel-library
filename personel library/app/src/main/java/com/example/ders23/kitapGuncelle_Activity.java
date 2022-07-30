package com.example.ders23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kitapGuncelle_Activity extends AppCompatActivity {

    private EditText kitapguncelleid, kitapguncellead, kitapguncellekod;
    private Button GuncelleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_guncelle);

        kitapguncelleid = findViewById(R.id.txt_kitap_guncelle_id);
        kitapguncellead = findViewById(R.id.txt_kitap_guncelle_ad);
        kitapguncellekod = findViewById(R.id.txt_kitap_guncelle_kod);

        GuncelleBtn = findViewById(R.id.btn_kitap_guncelle);
    
        Animation anima= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sagdangel);
        Animation anima2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.soldangel);

        kitapguncelleid.startAnimation(anima);
        kitapguncellead.startAnimation(anima);
        kitapguncellekod.startAnimation(anima);
        GuncelleBtn.startAnimation(anima2);

        GuncelleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(kitapguncelleid.getText().toString());

                String kitapad = kitapguncellead.getText().toString();
                String kitapkod = kitapguncellekod.getText().toString();

                Kitap kitap = new Kitap();
                kitap.setId(id);
                kitap.setKitapad(kitapad);
                kitap.setKitapkodu(kitapkod);


                MainActivity.veritabanim.myDao().kitapGuncelle(kitap);
                Toast.makeText(kitapGuncelle_Activity.this, "Kitap Güncellendi...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(kitapGuncelle_Activity.this,MainActivity.class);
                startActivity(intent);



            }
        });

    }
}