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
        final Button search = findViewById(R.id.button);
        final EditText data = findViewById(R.id.editText);
        final Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri;
                String str = data.getText().toString();
                char ch = str.charAt(0);
                if (Character.isLetter(ch)) {
                    String searchText = "geo:?q="+str;
                    uri = Uri.parse(searchText);
                } else {
                    String searchXY = "geo:"+str;
                    uri = Uri.parse(searchXY);
                }
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}