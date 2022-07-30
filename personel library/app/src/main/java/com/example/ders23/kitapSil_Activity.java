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

public class kitapSil_Activity extends AppCompatActivity {

    private EditText Kitapsilid;
    private Button KitapSilBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_sil);

        Kitapsilid = findViewById(R.id.sil_id);

        KitapSilBtn = findViewById(R.id.kitap_sil_btn);

        Animation anima= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sagdangel);
        Animation anima2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.soldangel);

        Kitapsilid.startAnimation(anima);
        KitapSilBtn.startAnimation(anima2);


        KitapSilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(Kitapsilid.getText().toString());

                Kitap kitap = new Kitap();

                kitap.setId(id);

                MainActivity.veritabanim.myDao().kitapSil(kitap);

                Toast.makeText(kitapSil_Activity.this, "Kitap Silindi...", Toast.LENGTH_SHORT).show();
                Kitapsilid.setText("");

                Intent intent = new Intent(kitapSil_Activity.this,MainActivity.class);
                startActivity(intent);



            }
        });

    }
}