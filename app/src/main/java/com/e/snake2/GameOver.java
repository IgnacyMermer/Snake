package com.e.snake2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {
    String wynik;
    String powod;
    int czas, wynikInt;
    public static final String SHARED_PREFS = "sharedPrefs";
    private String pierwszy,drugi,trzeci,czwarty,piaty,szosty,siodmy,osmy,dziewiaty,dziesiaty,jedenasty,dwunastu,trzynasty,czternasty, pietnasty;
    private String szesnasty, siedemnasty, osiemnasty, dziewietnasty, dwudziesty;
    private int pierwszyInt,drugiInt,trzeciInt,czwartyInt,piatyInt,szostyInt,siodmyInt,osmyInt,dziewiatyInt,dziesiatyInt,jedenastyInt,dwunastuInt,trzynastyInt,czternastyInt, pietnastyInt;
    private int szesnastyInt, siedemnastyInt, osiemnastyInt, dziewietnastyInt, dwudziestyInt, iloscZjedzonych;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        TextView wynikTekst = findViewById(R.id.wynikTekst);
        TextView wynikPole = findViewById(R.id.wynikPole);
        TextView powodPrzegranej = findViewById(R.id.powodPrzegranej);
        Button buttonRozpocznij = findViewById(R.id.buttonRozpocznijPonownie);
        try {
            Intent incomingIntent = getIntent();
            wynik = incomingIntent.getStringExtra("wynik");
            powod = incomingIntent.getStringExtra("powod");
            czas = incomingIntent.getIntExtra("czas", 0);
            iloscZjedzonych = incomingIntent.getIntExtra("iloscZjedzonych",0);
        }
        catch (Exception ex){
            Log.i("wynik2", ex.getMessage().toString());
        }
        if(wynik!=null){
            wynikInt = Integer.parseInt(wynik);
            if(!wynik.equals("")){
                wynikPole.setText(wynik);
            }
        }
        if(powod!=null){
            if(!powod.equals("")){
                String x = powodPrzegranej.getText().toString();
                powodPrzegranej.setText(x+powod);
            }
            else{
                powodPrzegranej.setText("");
            }
        }
        czas=czas-80;
        czas=czas/10;
        czas+=1;
        buttonRozpocznij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        ImageButton imageButton = findViewById(R.id.wynikZnaczek);
        ImageButton imageButton1 = findViewById(R.id.ustawienia);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this, Ustawienia2.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this, Wyniki.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        pierwszy = sharedPreferences.getString("pierwszy","0");
        pierwszyInt = Integer.parseInt(pierwszy);
        drugi = sharedPreferences.getString("drugi","0");
        drugiInt = Integer.parseInt(drugi);
        trzeci = sharedPreferences.getString("trzeci","0");
        trzeciInt = Integer.parseInt(trzeci);
        czwarty = sharedPreferences.getString("czwarty","0");
        czwartyInt = Integer.parseInt(czwarty);
        piaty = sharedPreferences.getString("piaty","0");
        piatyInt = Integer.parseInt(piaty);
        szosty = sharedPreferences.getString("szosty","0");
        szostyInt = Integer.parseInt(szosty);
        siodmy = sharedPreferences.getString("siodmy","0");
        siodmyInt = Integer.parseInt(siodmy);
        osmy = sharedPreferences.getString("osmy","0");
        osmyInt = Integer.parseInt(osmy);
        dziewiaty = sharedPreferences.getString("dziewiaty","0");
        dziewiatyInt = Integer.parseInt(dziewiaty);
        dziesiaty = sharedPreferences.getString("dziesiaty","0");
        dziesiatyInt = Integer.parseInt(dziesiaty);
        jedenasty = sharedPreferences.getString("jedenasty","0");
        jedenastyInt = Integer.parseInt(jedenasty);
        dwunastu = sharedPreferences.getString("dwunasty","0");
        dwunastuInt = Integer.parseInt(dwunastu);
        trzynasty = sharedPreferences.getString("trzynasty","0");
        trzynastyInt = Integer.parseInt(trzynasty);
        czternasty = sharedPreferences.getString("czternasty","0");
        czternastyInt = Integer.parseInt(czternasty);
        pietnasty = sharedPreferences.getString("pietnasty","0");
        pietnastyInt = Integer.parseInt(pietnasty);
        szesnasty = sharedPreferences.getString("szesnasty","0");
        szesnastyInt = Integer.parseInt(szesnasty);
        siedemnasty = sharedPreferences.getString("siedemnasty","0");
        siedemnastyInt = Integer.parseInt(siedemnasty);
        osiemnasty = sharedPreferences.getString("osiemnasty","0");
        osiemnastyInt = Integer.parseInt(osiemnasty);
        dziewietnasty = sharedPreferences.getString("dziewietnasty","0");
        dziewietnastyInt = Integer.parseInt(dziewietnasty);
        dwudziesty = sharedPreferences.getString("dwudziesty","0");
        dwudziestyInt = Integer.parseInt(dwudziesty);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(czas==1){
            if(wynikInt>pierwszyInt){
                editor.putString("pierwszy", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==2){
            if(wynikInt>drugiInt){
                editor.putString("drugi", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==3){
            if(wynikInt>trzeciInt){
                editor.putString("trzeci", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==4){
            if(wynikInt>czwartyInt){
                editor.putString("czwarty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==5){
            if(wynikInt>piatyInt){
                editor.putString("piaty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==6){
            if(wynikInt>szostyInt){
                editor.putString("szosty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==7){
            if(wynikInt>siodmyInt){
                editor.putString("siodmy", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==8){
            if(wynikInt>osmyInt){
                editor.putString("osmy", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==9){
            if(wynikInt>dziewiatyInt){
                editor.putString("dziewiaty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==10){
            if(wynikInt>dziesiatyInt){
                editor.putString("dziesiaty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==11){
            if(wynikInt>jedenastyInt){
                editor.putString("jedenasty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==12){
            if(wynikInt>dwunastuInt){
                editor.putString("dwunasty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==13){
            if(wynikInt>trzynastyInt){
                editor.putString("trzynasty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==14){
            if(wynikInt>czternastyInt){
                editor.putString("czternasty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==15){
            if(wynikInt>pietnastyInt){
                editor.putString("pietnasty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==16){
            if(wynikInt>szesnastyInt){
                editor.putString("szesnasty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==17){
            if(wynikInt>siedemnastyInt){
                editor.putString("siedemnasty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==18){
            if(wynikInt>osiemnastyInt){
                editor.putString("osiemnasty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==19){
            if(wynikInt>dziewietnastyInt){
                editor.putString("dziewietnasty", ""+wynikInt);
                editor.apply();
            }
        }
        else if(czas==20){
            if(wynikInt>dwudziestyInt){
                editor.putString("dwudziesty", ""+wynikInt);
                editor.apply();
            }
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameOver.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}