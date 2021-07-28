package com.example.becoapk21.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.becoapk21.Admin.ManagerControl;
import com.example.becoapk21.Navigation.RoadMap;
import com.example.becoapk21.Parking.FixBike;
import com.example.becoapk21.Parking.Parking;
import com.example.becoapk21.R;
import com.example.becoapk21.Admin.Help;
import com.google.firebase.auth.FirebaseAuth;

/*
                        WelcomeSession.java ---> INFORMATION
            ---------------------------------------------------------------
            this intent will present all the functions after the user LOGIN
            it will show their name, the function they can use.
            if the user is a manager i will show another that only showing up
            for the manager.
            -----------------------------------------------------------------
 */

public class WelcomeSession<first_name> extends AppCompatActivity {
static Random rnd = new Random();

    private ImageView parking;//park Bicycle
    FirebaseAuth fAuth;
    TextView fullName;
    ImageView map;
    ImageView fix;
    ImageView man;
    ImageView chatSu;
    TextView didYouKnowText;
    int random_number;
    boolean isAdmin = false;
    String user_phone;
    String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //status bar color
        getWindow().setStatusBarColor(ContextCompat.getColor(WelcomeSession.this, R.color.beco));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_session);
        getSupportActionBar().hide();

        //Get data from calling intent
        Intent intent = getIntent();
         user_phone = intent.getStringExtra("user_phone");
         user_name = intent.getStringExtra("user_name");
//        Toast.makeText(WelcomeSession.this, user_phone, Toast.LENGTH_SHORT).show();
        //Get data from calling intent
        chatSu = (ImageView) findViewById(R.id.chatSupport);
        fix = (ImageView) findViewById(R.id.fix1);
        map = (ImageView) findViewById(R.id.map);
        didYouKnowText = (TextView) findViewById(R.id.didYouKnowNote);

        fullName = (TextView) findViewById(R.id.fullName2);

        fAuth = FirebaseAuth.getInstance();
        random_number=rnd.nextInt(2);
        man = (ImageView) findViewById(R.id.man);
        parking = (ImageView) findViewById(R.id.parking);

        //Random Message display into the screen.
        String[] arr = {
                "רכיבה על אופניים מגבירה את הריכוז וממריצה את המוח.","הרכיבה מעודדת ירידה במשקל וטובה ללב"
                ,"לאכול שווארמה טעים אבל לא בהכרח בריא"};
        didYouKnowText.setText(arr[random_number]);


        fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), FixBike.class);
                startActivity(i);
            }
        });

        fullName.setText(user_name);
        parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parking();
            }
        });

        //user who manage the application
        if (user_phone.equals("0526333")) {
            isAdmin = true;

        } else {
            isAdmin = false;
            //if you are not manager you cant go to admin session.
            man.setVisibility(ImageView.GONE);
        }

        chatSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Help.class);
                startActivity(i);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), RoadMap.class);
                startActivity(i);

            }
        });

        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAdmin) {
                    Intent i = new Intent(getApplication(), ManagerControl.class);
                    startActivity(i);
                } else {
                    Toast.makeText(WelcomeSession.this, "אתה לא מנהל", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void parking() {
        Intent intent = new Intent(this, Parking.class);
        intent.putExtra("user_name",user_name);
        intent.putExtra("user_phone",user_phone);
        startActivity(intent);
    }


}
