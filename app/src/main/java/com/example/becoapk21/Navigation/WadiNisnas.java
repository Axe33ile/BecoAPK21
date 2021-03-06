package com.example.becoapk21.Navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.becoapk21.R;
/*
                       WadiNisnas.java ---> INFORMATION
            ------------------------------------------------------------
            this intent will show information regarding bike Track
            and if the user want it will redirect to the WadiNisnas Track
            -------------------------------------------------------------
 */
public class WadiNisnas extends AppCompatActivity {

    TextView yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //status bar color
        getWindow().setStatusBarColor(ContextCompat.getColor(WadiNisnas.this, R.color.beco));
        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wadi_nisnas);
        getSupportActionBar().hide();
        yellow = (TextView) findViewById(R.id.goToYellowRoad);
        String yellowMap = "https://www.google.com/maps/dir/32.818798,34.9884174/32.8192272,34.984453/32.8165778,34.9907084/32.8078856,35.0006353/32.8046628,34.9994404/32.7991925,35.0025543/@32.8094017,34.9758895,14z/data=!3m1!4b1!4m2!4m1!3e1";

        yellow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(yellowMap));
                startActivity(i);
            }
        });
    }
}