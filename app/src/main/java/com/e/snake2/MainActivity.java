package com.e.snake2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int temp,widthGlowne, heightGlowne, width, height, ktore=0, pomoc=0;
    ImageButton wGore, wPrawo, wLewo, wDol;
    int we=0,x,y, x2,y2, liczba, liczba2,czas=80, wynik=0, tempor, iloscZjedzonych=1, re=0, liczba5, liczba6, liczba3=0;
    boolean gameOver=false, jedzenie=false;
    String kierunek="", powod="";
    ArrayList<Integer> ixy;
    ArrayList<Integer> igreki;
    TextView wynikPole;
    int wielkosc, plansza;
    boolean zaznaczenie;
    ImageButton ustawieniaButton, wynikiButton;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "int";
    ArrayList<Integer> punkty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<TextView> lista = new ArrayList<>();
        for(int i=0;i<196;i++){
            String x = "textView"+i;
            temp = getResources().getIdentifier(x, "id", getPackageName());
            lista.add((TextView) findViewById(temp));
        }
        wynikPole = findViewById(R.id.wynik);
        ustawieniaButton = findViewById(R.id.ustawienia);
        wynikiButton = findViewById(R.id.wynikZnaczek);
        Intent incomingIntent = getIntent();
        ixy = new ArrayList<>();
        igreki = new ArrayList<>();
        punkty = new ArrayList<>();
        try {
            loadData();
            x = incomingIntent.getIntExtra("x",0);
            y = incomingIntent.getIntExtra("y", 0);
            if((x!=0)&&(y!=0)){
                kierunek="lala";
                zaznaczenie = incomingIntent.getBooleanExtra("zaznaczenie", true);
            }
            else{
                loadData2();
            }
            liczba = incomingIntent.getIntExtra("liczba",0);
            liczba2 = incomingIntent.getIntExtra("liczba2",0);
            if((liczba!=0)&&(liczba2!=0)){
                liczba3 = 1;
            }
            else{
                liczba3=0;
            }
            wynik = incomingIntent.getIntExtra("wynik", 0);
            if(wynik!=0){
                wynikPole.setText(""+wynik);
            }
            if(plansza==1){
                if(wielkosc==8){
                    for(int i=27;i<29;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else if(wielkosc==9){
                    for(int i=30;i<33;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else{
                    int rt = 3*wielkosc+3;
                    int rte = 4*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
            }
            else if(plansza==2) {
                if(wielkosc==8){
                    for(int i=19;i<21;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=43;i<45;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else if(wielkosc==9){
                    for(int i=21;i<24;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=57;i<60;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else if(wielkosc==10||wielkosc==11){
                    int rt = 2*wielkosc+3;
                    int rte = 3*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt = 5*wielkosc+3;
                    rte=6*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else{
                    int rt = 4*wielkosc+3;
                    int rte = 5*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt = 8*wielkosc+3;
                    rte=9*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }

            }
            else if(plansza==3){
                if(wielkosc==8){
                    for(int i=19;i<21;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=35;i<37;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=51;i<53;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else if(wielkosc==9){
                    for(int i=3;i<6;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=30;i<33;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=66;i<69;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else if(wielkosc==10||wielkosc==1){
                    int rt = 2*wielkosc+3;
                    int rte = 3*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt = 5*wielkosc+3;
                    rte=6*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt=8*wielkosc+3;
                    rte=9*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else{
                    int rt = 3*wielkosc+3;
                    int rte = 4*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt = 6*wielkosc+3;
                    rte=7*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt=9*wielkosc+3;
                    rte=10*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
            }
            else if(plansza==4){
                if(wielkosc==8){
                    for(int i=3;i<5;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=19;i<21;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=35;i<37;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=51;i<53;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else if(wielkosc==9){
                    for(int i=3;i<6;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=30;i<33;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=48;i<51;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    for(int i=66;i<69;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else if(wielkosc==10||wielkosc==11||wielkosc==12){
                    int rt = 2*wielkosc+3;
                    int rte = 3*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt = 4*wielkosc+3;
                    rte=5*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt=6*wielkosc+3;
                    rte=7*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt=8*wielkosc+3;
                    rte=9*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
                else{
                    int rt = 2*wielkosc+3;
                    int rte = 3*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt = 5*wielkosc+3;
                    rte=6*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt=7*wielkosc+3;
                    rte=8*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                    rt=10*wielkosc+3;
                    rte=11*wielkosc;
                    rte-=3;
                    for(int i=rt;i<rte;i++){
                        lista.get(i).setBackgroundColor(Color.parseColor("#000000"));
                        punkty.add(i);
                    }
                }
            }
        }
        catch (Exception ex){
            Log.i("wynik", ex.getMessage().toString());
        }
        final android.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);
        gridLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                gridLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                widthGlowne = gridLayout.getWidth();
                heightGlowne=gridLayout.getHeight();
                width = widthGlowne/wielkosc;
                height = heightGlowne/wielkosc;
                for(int i=0;i<196;i++){
                    TextView textView = lista.get(i);
                    android.widget.GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                    layoutParams.width = width;
                    layoutParams.height = height;
                    layoutParams.rowSpec = GridLayout.spec(i/wielkosc);
                    layoutParams.columnSpec = GridLayout.spec(i%wielkosc);
                    textView.setLayoutParams(layoutParams);
                }
            }
        });
        wGore = findViewById(R.id.strzlka_w_gore);
        wDol = findViewById(R.id.strzalka_dolna);
        wPrawo = findViewById(R.id.strzalka_prawa);
        wLewo = findViewById(R.id.strzalka_lewo);
        gameOver=false;
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                synchronized (this){
                    try {
                        while (!gameOver) {
                            final long t = System.currentTimeMillis() + czas;
                            while (t > System.currentTimeMillis()) {
                            }
                            if (kierunek.equals("")) {
                                y = 1;
                                x = 5;
                                kierunek = "lala";
                            }
                            if (kierunek.equals("dol")) {
                                y += 1;
                            }
                            else if (kierunek.equals("gora")) {
                                y -= 1;
                            }
                            else if (kierunek.equals("prawo")) {
                                x += 1;
                            }
                            else if (kierunek.equals("lewo")) {
                                x-=1;
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (x<0){
                                        gameOver = true;
                                        powod = " zderzenie ze ścianą lewą";
                                    }
                                    if (y<0){
                                        gameOver = true;
                                        powod = " zderzenie ze ścianą górną";
                                    }
                                    if (x>wielkosc-1){
                                        gameOver=true;
                                        powod= " zderzenie ze ścianą prawą";
                                    }
                                    if (y>wielkosc-1){
                                        gameOver = true;
                                        powod = " zderzenie ze ścianą dolną";
                                    }
                                    if ((x==x2)&&(y==y2)) {
                                        jedzenie = true;
                                        int tempor3 = y2*wielkosc+x2;
                                        lista.get(tempor3).setBackgroundResource(0);
                                    }
                                    if(ktore>0){
                                        if(!zaznaczenie){
                                            iloscZjedzonych=1;
                                        }
                                        liczba6 = igreki.get(ktore-iloscZjedzonych);
                                        liczba5 = ixy.get(ktore-iloscZjedzonych);
                                    }
                                    try {
                                        if(gameOver){
                                            throw new Exception("Błąd");
                                        }
                                        int tempor2 = liczba6*wielkosc+liczba5;
                                        lista.get(tempor2).setText("");
                                        tempor = y*wielkosc+x;
                                        for(int i=0;i<punkty.size();i++){
                                            if(tempor==punkty.get(i)){
                                                gameOver=true;
                                                powod = " zderzenie z wewnętrzną ścianą";
                                                throw new Exception("Bladd");
                                            }
                                        }
                                        if(lista.get(tempor).getText().toString().equals("o")){
                                            gameOver=true;
                                            powod = " wejście we własny ogon";
                                            throw new Exception("błąd");
                                        }
                                        lista.get(tempor).setText("o");
                                        ixy.add(x);
                                        igreki.add(y);
                                        ktore++;
                                    }
                                    catch (Exception ex){
                                        Log.i("wynik2", ex.getMessage().toString());
                                    }
                                }
                            });
                            if (we==1){
                                break;
                            }
                            wDol.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    kierunek = "dol";
                                }
                            });
                            wGore.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    kierunek = "gora";
                                }
                            });
                            wLewo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    kierunek = "lewo";
                                }
                            });
                            wPrawo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    kierunek = "prawo";
                                }
                            });
                            ustawieniaButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    gameOver=true;
                                    Intent intent = new Intent(MainActivity.this, Ustawienia.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    intent.putExtra("x", x);
                                    intent.putExtra("y", y);
                                    intent.putExtra("liczba", liczba);
                                    intent.putExtra("liczba2", liczba2);
                                    intent.putExtra("wynik", wynik);
                                    intent.putExtra("iloscZjedzonych", iloscZjedzonych);
                                    startActivity(intent);
                                    we=1;
                                }
                            });
                            wynikiButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    gameOver=true;
                                    Intent intent = new Intent(MainActivity.this, Wyniki2.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    we=2;
                                }
                            });
                        }
                        if(we==1){
                            Intent intent = new Intent(MainActivity.this, Ustawienia.class);
                            intent.putExtra("x", x);
                            intent.putExtra("y", y);
                            intent.putExtra("liczba", liczba);
                            intent.putExtra("liczba2", liczba2);
                            intent.putExtra("wynik", wynik);
                            intent.putExtra("iloscZjedzonych", iloscZjedzonych);
                            intent.putExtra("ixy", ixy);
                            intent.putExtra("igreki",igreki);
                            intent.putExtra("ktore", ktore);
                            startActivity(intent);
                        }
                        else if(we==2){
                            Intent intent = new Intent(MainActivity.this, Wyniki2.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            intent.putExtra("x",x);
                            intent.putExtra("y", y);
                            intent.putExtra("wynik", wynik);
                            intent.putExtra("iloscZjedzonych", iloscZjedzonych);
                            startActivity(intent);
                        }
                        else{
                            Intent intent = new Intent(MainActivity.this, GameOver.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            intent.putExtra("wynik", ""+wynik);
                            intent.putExtra("powod", powod);
                            intent.putExtra("czas",czas);
                            intent.putExtra("iloscZjedzonych", iloscZjedzonych);
                            startActivity(intent);
                        }
                    }
                    catch (Exception ex){
                        Log.i("wynik", ex.getMessage().toString());
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        while (!gameOver) {
                            jedzenie = false;
                            if(liczba3==1){
                                liczba3=0;
                            }
                            else{
                                liczba = losowanie(x);
                                liczba2 = losowanie2(y);
                            }
                            x2 = liczba;
                            y2 = liczba2;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tempor=y2*wielkosc+x2;
                                    lista.get(tempor).setBackgroundResource(R.drawable.jablko);
                                }
                            });
                            long t2;
                            if (re != 1) {
                                t2 = System.currentTimeMillis() + 100000;
                            }
                            else {
                                t2 = System.currentTimeMillis() + 100;
                                re++;
                            }
                            while ((System.currentTimeMillis() < t2) && (!jedzenie)) {
                            }
                            if (jedzenie) {
                                wynik += 10;
                                wynikPole.setText(""+wynik);
                                iloscZjedzonych++;
                                pomoc++;
                            }
                        }
                    } catch (Exception ex) {
                        Log.i("wynik", ex.getMessage().toString());
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        int d=sharedPreferences.getInt(TEXT, 0);
        d=d*10;
        czas+=d;
        plansza = sharedPreferences.getInt("plansza", 0);
        wielkosc = sharedPreferences.getInt("wielkosc",10);
    }
    public void loadData2(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        zaznaczenie = sharedPreferences.getBoolean("boolean", true);
    }
    public int losowanie(int x11){
        int liczba11 = (int) (Math.random() * (wielkosc-1));
        if(liczba11==x11){
            losowanie(x11);
        }
        return liczba11;
    }
    public int losowanie2(int x11){
        int liczba11 = (int)(Math.random()*(wielkosc-1));
        int pomo=0;
        if(liczba11==x11){
            losowanie2(x11);
        }
        for(int i=0;i<punkty.size();i++){
            if((liczba11*wielkosc+liczba)==punkty.get(i)){
                int uy = liczba11*wielkosc+liczba;
                Log.i("wynik2", ""+uy+"   "+punkty.get(i));
                pomo=1;
                liczba11=1;
            }
        }
        return liczba11;
    }
    @Override
    public void onBackPressed() {}
}
