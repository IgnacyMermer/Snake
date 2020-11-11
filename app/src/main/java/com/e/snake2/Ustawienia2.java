package com.e.snake2;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class Ustawienia2 extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "int";
    public static final String SWITCH1 = "switch1";
    SeekBar seekBar;
    int progress,wielkosc,wielk2, plansza;
    boolean zaznaczenie;
    Switch aSwitch;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia2);
        aSwitch = findViewById(R.id.switch2);
        ImageButton imageButton = findViewById(R.id.buttonZamkniecie);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                saveData();
                Intent intent = new Intent(Ustawienia2.this, GameOver.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        seekBar = findViewById(R.id.seekBar);
        loadData();
        aSwitch.setChecked(zaznaczenie);
        seekBar.setProgress(progress);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.wielkosci, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if(wielk2==8){
            spinner.setSelection(0);
        }
        else if(wielk2==9){
            spinner.setSelection(1);
        }
        else if(wielk2==10){
            spinner.setSelection(2);
        }
        else if(wielk2==11){
            spinner.setSelection(3);
        }
        else if(wielk2==12){
            spinner.setSelection(4);
        }
        else if(wielk2==13){
            spinner.setSelection(5);
        }
        else if(wielk2==14){
            spinner.setSelection(6);
        }
        else {
            spinner.setSelection(2);
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    wielkosc = 8;
                }
                else if(position==1){
                    wielkosc=9;
                }
                else if(position==2){
                    wielkosc=10;
                }
                else if(position==3){
                    wielkosc=11;
                }
                else if(position==4){
                    wielkosc=12;
                }
                else if(position==5){
                    wielkosc=13;
                }
                else if(position==6){
                    wielkosc=14;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner1 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.plansze, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        if(plansza==0){
            spinner1.setSelection(0);
        }
        else if(plansza==1){
            spinner1.setSelection(1);
        }
        else if(plansza==2){
            spinner1.setSelection(2);
        }
        else if(plansza==3){
            spinner1.setSelection(3);
        }
        else if(plansza==4){
            spinner1.setSelection(4);
        }
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    plansza=0;
                }
                else if(position==1){
                    plansza=1;
                }
                else if(position==2){
                    plansza=2;
                }
                else if(position==3){
                    plansza=3;
                }
                else if(position==4){
                    plansza=4;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    @Override
    public void onBackPressed() {
        saveData();
        Intent intent = new Intent(Ustawienia2.this, GameOver.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TEXT, seekBar.getProgress());
        editor.putInt("wielkosc", wielkosc);
        editor.putInt("plansza", plansza);
        boolean zaznaczenie2 = aSwitch.isChecked();
        editor.putBoolean("boolean", zaznaczenie2);
        editor.apply();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        progress = sharedPreferences.getInt(TEXT,0);
        wielk2 = sharedPreferences.getInt("wielkosc",0);
        zaznaczenie = sharedPreferences.getBoolean("boolean",true);
        plansza = sharedPreferences.getInt("plansza",0);
    }
    @Override
    protected void onStop() {
        super.onStop();
        saveData();
    }
}