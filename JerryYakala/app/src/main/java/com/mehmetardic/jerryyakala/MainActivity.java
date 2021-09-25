package com.mehmetardic.jerryyakala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView [] resimler= new ImageView[9];
    Integer sayi,onceki=0,skorTablosu=0;
    Random r;
    Button basla;
    TextView skor,timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resimler[0]= findViewById(R.id.imageView);
        resimler[1]= findViewById(R.id.imageView2);
        resimler[2]= findViewById(R.id.imageView3);
        resimler[3]= findViewById(R.id.imageView4);
        resimler[4]= findViewById(R.id.imageView5);
        resimler[5]= findViewById(R.id.imageView6);
        resimler[6]= findViewById(R.id.imageView7);
        resimler[7]= findViewById(R.id.imageView8);
        resimler[8]= findViewById(R.id.imageView9);
        basla=findViewById(R.id.baslaButton);
        skor=findViewById(R.id.skorTextView);
        timer=findViewById(R.id.timerTextView);

        for(int i=0;i<9;i++){
            resimler[i].setVisibility(View.INVISIBLE);
        }
        r= new Random();
    }
    public void basla(View view){
        basla.setEnabled(false);
        skorTablosu=0;
        skor.setText("Skor : "+skorTablosu);
        new CountDownTimer(10000,250){

            @Override
            public void onTick(long millisUntilFinished) {

                resimler[onceki].setVisibility(View.INVISIBLE);
                resimler[onceki].setEnabled(true);
                sayi=r.nextInt(9);

                    while(sayi==onceki){
                        sayi=r.nextInt(9);
                    }

                    resimler[sayi].setVisibility(View.VISIBLE);
                    onceki=sayi;

                    timer.setText("Kalan Sure : "+millisUntilFinished/1000);


            }

            @Override
            public void onFinish() {
                resimler[onceki].setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this,"Süre Bitti",Toast.LENGTH_LONG).show();
                basla.setEnabled(true);
            }
        }.start();

    }

    public void arttir(View view){

            resimler[sayi].setEnabled(false);
            skorTablosu++;
            skor.setText("Skor : "+skorTablosu);


    }

}