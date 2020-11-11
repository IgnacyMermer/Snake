package com.e.snake2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Wyniki2 extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    private String pierwszy,drugi,trzeci,czwarty,piaty,szosty,siodmy,osmy,dziewiaty,dziesiaty,jedenasty,dwunastu,trzynasty,czternasty, pietnasty;
    private String szesnasty, siedemnasty, osiemnasty, dziewietnasty, dwudziesty;
    private ExpandableListView listView;
    private ExpadnableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;
    private int x,y,liczba,liczba2,wynik, iloscZjedzonych;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyniki2);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        getWindow().setLayout((int)(width*.86), (int)(height*.75));
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        pierwszy = sharedPreferences.getString("pierwszy","");
        drugi = sharedPreferences.getString("drugi","");
        trzeci = sharedPreferences.getString("trzeci","");
        czwarty = sharedPreferences.getString("czwarty","");
        piaty = sharedPreferences.getString("piaty","");
        szosty = sharedPreferences.getString("szosty","");
        siodmy = sharedPreferences.getString("siodmy","");
        osmy = sharedPreferences.getString("osmy","");
        dziewiaty = sharedPreferences.getString("dziewiaty","");
        dziesiaty = sharedPreferences.getString("dziesiaty","");
        jedenasty = sharedPreferences.getString("jedenasty","");
        dwunastu = sharedPreferences.getString("dwunasty","");
        trzynasty = sharedPreferences.getString("trzynasty","");
        czternasty = sharedPreferences.getString("czternasty","");
        pietnasty = sharedPreferences.getString("pietnasty","");
        szesnasty = sharedPreferences.getString("szesnasty","");
        siedemnasty = sharedPreferences.getString("siedemnasty","");
        osiemnasty = sharedPreferences.getString("osiemnasty", "");
        dziewietnasty = sharedPreferences.getString("dziewietnasty", "");
        dwudziesty = sharedPreferences.getString("dwudziesty", "");
        initData();
        Intent intent = getIntent();
        x = intent.getIntExtra("x", 0);
        y = intent.getIntExtra("y", 0);
        liczba = intent.getIntExtra("liczba", 0);
        liczba2 = intent.getIntExtra("liczba2",0);
        wynik = intent.getIntExtra("wynik", 0);
        iloscZjedzonych = intent.getIntExtra("iloscZjedzonych",0);
        listView = findViewById(R.id.lista);
        listAdapter = new ExpadnableListAdapter(this, listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
        ImageButton imageButton = findViewById(R.id.buttonZamkniecie);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wyniki2.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("x", x);
                intent.putExtra("y", y);
                intent.putExtra("liczba", liczba);
                intent.putExtra("liczba2", liczba2);
                intent.putExtra("wynik", wynik);
                startActivity(intent);
            }
        });
    }
    private void initData(){
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();
        listDataHeader.add("Pierwsza szybkość");
        if((!pierwszy.equals(""))&&(pierwszy!=null)){
            List<String> edmtDev = new ArrayList<>();
            edmtDev.add(pierwszy);
            listHashMap.put(listDataHeader.get(0), edmtDev);
        }
        else{
            List<String> edmtDev = new ArrayList<>();
            edmtDev.add("0");
            listHashMap.put(listDataHeader.get(0), edmtDev);
        }
        listDataHeader.add("Druga szybkość");
        if(!drugi.equals("")){
            List<String> edmtDev1 = new ArrayList<>();
            edmtDev1.add(drugi);
            listHashMap.put(listDataHeader.get(1), edmtDev1);
        }
        else{
            List<String> edmtDev1 = new ArrayList<>();
            edmtDev1.add("0");
            listHashMap.put(listDataHeader.get(1), edmtDev1);
        }
        listDataHeader.add("Trzecia szybkość");
        if(!trzeci.equals("")){
            List<String> edmtDev2 = new ArrayList<>();
            edmtDev2.add(trzeci);
            listHashMap.put(listDataHeader.get(2), edmtDev2);
        }
        else{
            List<String> edmtDev2 = new ArrayList<>();
            edmtDev2.add("0");
            listHashMap.put(listDataHeader.get(2), edmtDev2);
        }
        listDataHeader.add("Czwarta szybkość");
        if(!czwarty.equals("")){
            List<String> edmtDev3 = new ArrayList<>();
            edmtDev3.add(czwarty);
            listHashMap.put(listDataHeader.get(3), edmtDev3);
        }
        else{
            List<String> edmtDev3 = new ArrayList<>();
            edmtDev3.add("0");
            listHashMap.put(listDataHeader.get(3), edmtDev3);
        }
        listDataHeader.add("Piąta szybkość");
        if(!piaty.equals("")){
            List<String> edmtDev4 = new ArrayList<>();
            edmtDev4.add(piaty);
            listHashMap.put(listDataHeader.get(4), edmtDev4);
        }
        else{
            List<String> edmtDev4 = new ArrayList<>();
            edmtDev4.add("0");
            listHashMap.put(listDataHeader.get(4), edmtDev4);
        }
        listDataHeader.add("Szósta szybkość");
        if(!szosty.equals("")){
            List<String> edmtDev5 = new ArrayList<>();
            edmtDev5.add(szosty);
            listHashMap.put(listDataHeader.get(5), edmtDev5);
        }
        else{
            List<String> edmtDev5 = new ArrayList<>();
            edmtDev5.add("0");
            listHashMap.put(listDataHeader.get(5), edmtDev5);
        }
        listDataHeader.add("Siódma szybkość");
        if(!siodmy.equals("")){
            List<String> edmtDev6 = new ArrayList<>();
            edmtDev6.add(siodmy);
            listHashMap.put(listDataHeader.get(6), edmtDev6);
        }
        else{
            List<String> edmtDev6 = new ArrayList<>();
            edmtDev6.add("0");
            listHashMap.put(listDataHeader.get(6), edmtDev6);
        }
        listDataHeader.add("Ósma szybkość");
        if(!osmy.equals("")){
            List<String> edmtDev7 = new ArrayList<>();
            edmtDev7.add(osmy);
            listHashMap.put(listDataHeader.get(7), edmtDev7);
        }
        else{
            List<String> edmtDev7 = new ArrayList<>();
            edmtDev7.add("0");
            listHashMap.put(listDataHeader.get(7), edmtDev7);
        }
        listDataHeader.add("Dziewiąta szybkość");
        if(!dziewiaty.equals("")){
            List<String> edmtDev8 = new ArrayList<>();
            edmtDev8.add(dziewiaty);
            listHashMap.put(listDataHeader.get(8), edmtDev8);
        }
        else{
            List<String> edmtDev8 = new ArrayList<>();
            edmtDev8.add("0");
            listHashMap.put(listDataHeader.get(8), edmtDev8);
        }
        listDataHeader.add("Dziesiąta szybkość");
        if(!dziesiaty.equals("")){
            List<String> edmtDev9 = new ArrayList<>();
            edmtDev9.add(dziesiaty);
            listHashMap.put(listDataHeader.get(9), edmtDev9);
        }
        else{
            List<String> edmtDev9 = new ArrayList<>();
            edmtDev9.add("0");
            listHashMap.put(listDataHeader.get(9), edmtDev9);
        }
        listDataHeader.add("Jedenasta szybkość");
        if((!jedenasty.equals(""))&&(jedenasty!=null)){
            List<String> edmtDev10 = new ArrayList<>();
            edmtDev10.add(jedenasty);
            listHashMap.put(listDataHeader.get(10), edmtDev10);
        }
        else{
            List<String> edmtDev10 = new ArrayList<>();
            edmtDev10.add("0");
            listHashMap.put(listDataHeader.get(10), edmtDev10);
        }
        listDataHeader.add("Dwunasta szybkość");
        if(!dwunastu.equals("")){
            List<String> edmtDev11 = new ArrayList<>();
            edmtDev11.add(dwunastu);
            listHashMap.put(listDataHeader.get(11), edmtDev11);
        }
        else{
            List<String> edmtDev11 = new ArrayList<>();
            edmtDev11.add("0");
            listHashMap.put(listDataHeader.get(11), edmtDev11);
        }
        listDataHeader.add("Trzynasta szybkość");
        if(!trzynasty.equals("")){
            List<String> edmtDev12 = new ArrayList<>();
            edmtDev12.add(trzynasty);
            listHashMap.put(listDataHeader.get(12), edmtDev12);
        }
        else{
            List<String> edmtDev12 = new ArrayList<>();
            edmtDev12.add("0");
            listHashMap.put(listDataHeader.get(12), edmtDev12);
        }
        listDataHeader.add("Czternasta szybkość");
        if(!czternasty.equals("")){
            List<String> edmtDev13 = new ArrayList<>();
            edmtDev13.add(czternasty);
            listHashMap.put(listDataHeader.get(13), edmtDev13);
        }
        else{
            List<String> edmtDev13 = new ArrayList<>();
            edmtDev13.add("0");
            listHashMap.put(listDataHeader.get(13), edmtDev13);
        }
        listDataHeader.add("Pietnasta szybkość");
        if(!pietnasty.equals("")){
            List<String> edmtDev14 = new ArrayList<>();
            edmtDev14.add(pietnasty);
            listHashMap.put(listDataHeader.get(14), edmtDev14);
        }
        else{
            List<String> edmtDev14 = new ArrayList<>();
            edmtDev14.add("0");
            listHashMap.put(listDataHeader.get(14), edmtDev14);
        }
        listDataHeader.add("Szesnasta szybkość");
        if(!szesnasty.equals("")){
            List<String> edmtDev15 = new ArrayList<>();
            edmtDev15.add(szesnasty);
            listHashMap.put(listDataHeader.get(15), edmtDev15);
        }
        else{
            List<String> edmtDev15 = new ArrayList<>();
            edmtDev15.add("0");
            listHashMap.put(listDataHeader.get(15), edmtDev15);
        }
        listDataHeader.add("Siedemnasta szybkość");
        if(!siedemnasty.equals("")){
            List<String> edmtDev16 = new ArrayList<>();
            edmtDev16.add(siedemnasty);
            listHashMap.put(listDataHeader.get(16), edmtDev16);
        }
        else{
            List<String> edmtDev16 = new ArrayList<>();
            edmtDev16.add("0");
            listHashMap.put(listDataHeader.get(16), edmtDev16);
        }
        listDataHeader.add("Osiemnasta szybkość");
        if(!osiemnasty.equals("")){
            List<String> edmtDev17 = new ArrayList<>();
            edmtDev17.add(osiemnasty);
            listHashMap.put(listDataHeader.get(17), edmtDev17);
        }
        else{
            List<String> edmtDev17 = new ArrayList<>();
            edmtDev17.add("0");
            listHashMap.put(listDataHeader.get(17), edmtDev17);
        }
        listDataHeader.add("Dziewietnasta szybkość");
        if(!dziewietnasty.equals("")){
            List<String> edmtDev18 = new ArrayList<>();
            edmtDev18.add(osiemnasty);
            listHashMap.put(listDataHeader.get(18), edmtDev18);
        }
        else{
            List<String> edmtDev18 = new ArrayList<>();
            edmtDev18.add("0");
            listHashMap.put(listDataHeader.get(18), edmtDev18);
        }
        listDataHeader.add("Dwudziesta szybkość");
        if(!dwudziesty.equals("")){
            List<String> edmtDev19 = new ArrayList<>();
            edmtDev19.add(dwudziesty);
            listHashMap.put(listDataHeader.get(19), edmtDev19);
        }
        else{
            List<String> edmtDev19 = new ArrayList<>();
            edmtDev19.add("0");
            listHashMap.put(listDataHeader.get(19), edmtDev19);
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Wyniki2.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        intent.putExtra("liczba", liczba);
        intent.putExtra("liczba2", liczba2);
        intent.putExtra("wynik", wynik);
        startActivity(intent);
    }
}