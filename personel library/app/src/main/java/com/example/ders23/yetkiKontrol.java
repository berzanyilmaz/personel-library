package com.example.ders23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class yetkiKontrol extends AppCompatActivity {
    Button button;
    private EditText sifre;
    private String kSifre, dogruSifre= "1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yetki_kontrol);
        button=findViewById(R.id.button);
        sifre=findViewById(R.id.editTextTextPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kSifre=sifre.getText().toString();
            //yetki kontrol ediliyor
                if (!TextUtils.isEmpty(kSifre)) {
                    if(kSifre.equals(dogruSifre)) {
                        Intent gec=new Intent(getApplicationContext(),kitapEkle_Activity.class);
                        startActivity(gec);
                        Toast.makeText(yetkiKontrol.this, "Şifre doğru, yönlendiriliyorsunuz...", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(yetkiKontrol.this, "Yanlış şifre, yetki reddedildi...", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}