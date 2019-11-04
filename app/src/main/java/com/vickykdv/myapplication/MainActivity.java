package com.vickykdv.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.vickykdv.waintent.WhatsappIntent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edthp = findViewById(R.id.edtnohp);
        final EditText edtpesan = findViewById(R.id.edtpesan);


        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            new WhatsappIntent(MainActivity.this,edthp.getText().toString(),edtpesan.getText().toString());


            }

        });



    }


}
