package com.example.provapraticanavita;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void openMovieDetails(View view){
        Intent intent = new Intent (this, Details.class);
        /*pick the movie Id from the button on the main_activity and send it to Details to present
        more information about it.*/
        Integer movieId = new Integer("");
    }

}