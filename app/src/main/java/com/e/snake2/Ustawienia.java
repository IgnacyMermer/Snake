package com.e.snake2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.e.snake2.MainActivity;
import com.e.snake2.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Ustawienia extends Activity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "int";
    public static final String SWITCH1 = "switch1";
    int progress, x,y,liczba,liczba2,wynik, iloscZjedzonych, ktore;
    SeekBar seekBar;
    ArrayList<Integer> ixy;
    ArrayList<Integer> igreki;
    Switch aSwitch;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        ixy=new ArrayList<Integer>();
        igreki = new ArrayList<Integer>();
        getWindow().setLayout((int)(width*.86), (int)(height*.75));
        ImageButton imageButton = findViewById(R.id.buttonZamkniecie);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                Intent intent = new Intent(Ustawienia.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("x", x);
                intent.putExtra("y", y);
                intent.putExtra("liczba", liczba);
                intent.putExtra("liczba2", liczba2);
                intent.putExtra("wynik", wynik);
                saveData();
                startActivity(intent);
            }
        });
        Button buttonWznow = findViewById(R.id.buttonWznow);
        buttonWznow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                Intent intent = new Intent(Ustawienia.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("x", x);
                intent.putExtra("y", y);
                intent.putExtra("liczba", liczba);
                intent.putExtra("liczba2", liczba2);
                intent.putExtra("wynik", wynik);
                saveData();
                startActivity(intent);
            }
        });
        Button buttonOdNowa = findViewById(R.id.buttonOdNowa);
        buttonOdNowa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Intent intent = new Intent(Ustawienia.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        seekBar = findViewById(R.id.seekBar);
        loadData();
        seekBar.setProgress(progress);
        Intent intent = getIntent();
        x = intent.getIntExtra("x", 0);
        y = intent.getIntExtra("y", 0);
        liczba = intent.getIntExtra("liczba", 0);
        liczba2 = intent.getIntExtra("liczba2",0);
        wynik = intent.getIntExtra("wynik", 0);
        iloscZjedzonych = intent.getIntExtra("iloscZjedzonych",0);
        ixy = intent.getIntegerArrayListExtra("ixy");
        igreki = intent.getIntegerArrayListExtra("igreki");
        ktore=intent.getIntExtra("ktore",0);
    }
    @Override
    public void onBackPressed() {
        saveData();
        Intent intent = new Intent(Ustawienia.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        intent.putExtra("liczba", liczba);
        intent.putExtra("liczba2", liczba2);
        intent.putExtra("wynik", wynik);
        startActivity(intent);
    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, seekBar.getProgress());
        editor.apply();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        progress = sharedPreferences.getInt(TEXT,0);
    }
    @Override
    protected void onStop() {
        super.onStop();
        saveData();
    }
}