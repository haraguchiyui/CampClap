package com.lifeistech.android.campclap;

import android.app.Activity;
import android.drm.DrmStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends Activity implements View.OnClickListener,AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    ImageButton button;

    Clap clapInstance;

    Spinner spinner;

    int repeat=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(ImageButton)findViewById(R.id.imageButton);
        button.setOnClickListener(this);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        String[] strArray=new String[5];
        strArray[0]="パンッ！";
        strArray[1]="パンパンッ！";
        strArray[2]="パンパンパンッ！";
        strArray[3]="４回";
        strArray[4]="５回";

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String >(
                this,android.R.layout.simple_spinner_item,strArray
        );
        arrayAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinner.setAdapter(arrayAdapter);



        clapInstance=new Clap(this.getApplicationContext());
    }

    @Override
    public void onClick(View v) {

        //clapInstance.play();
        clapInstance.repeatPlay(repeat);

    }

    @Override
    public void onItemSelected(AdapterView<?>parent,View v,int pos,long id){
        repeat =pos+1;



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
