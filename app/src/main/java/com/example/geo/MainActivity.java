package com.example.geo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button searchBtn = findViewById(R.id.button);
        final EditText dataEdTxt = findViewById(R.id.editText);
        final Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri;
                String getTextOfEditText = dataEdTxt.getText().toString();
                char chX = getTextOfEditText.charAt(0);
                int indexSpace = getTextOfEditText.indexOf(' ');
                char chY = getTextOfEditText.charAt(indexSpace+1);
                if (Character.isDigit(chX) & Character.isDigit(chY) ) {
                    String searchXY = "geo:"+getTextOfEditText;
                    uri = Uri.parse(searchXY);
                } else {
                    String searchText ="geo:?q="+getTextOfEditText;
                    uri = Uri.parse(searchText);
                }
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}
