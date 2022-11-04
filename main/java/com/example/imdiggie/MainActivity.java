package com.example.imdiggie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.imdiggie.pdf.PdfActivity;
import com.example.imdiggie.ui.classLink.ClassLinkActivity;
import com.example.imdiggie.ui.faculty.FacultyActivity;
import com.example.imdiggie.ui.notice.NoticeActivity;
import com.example.imdiggie.ui.routine.RoutineActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private CardView routinecardview ;
    private CardView classlinkcardview ;
    private CardView noticecardview ;
    private CardView videoreccardview ;
    private TextView wishmsg;
    private ImageView homeimg;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().subscribeToTopic("notification");



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        homeimg = findViewById(R.id.homeimg);
        wishmsg = findViewById(R.id.textView2);
        routinecardview = findViewById(R.id.routinecardview);
        classlinkcardview = findViewById(R.id.classlinkcardview);
        noticecardview = findViewById(R.id.noticecardview);
        videoreccardview = findViewById(R.id.videoreccardview);


        //for navigation drawer
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);


        //for music on logo click
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.music);
        homeimg.setOnClickListener(new View.OnClickListener() {
            int flag =2;
            @Override
            public void onClick(View view) {

                if(flag%2 == 0){
                    mediaPlayer.start();
                    flag++;
                }
              else if(flag%2 !=0){
                    mediaPlayer.pause();
                    flag++;
                }
            }
        });


        //for wishing according to time
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        int dateTime = Integer.parseInt(simpleDateFormat.format(calender.getTime()));

        if((dateTime) >= 00  && (dateTime) < 05) {
            wishmsg.setText("I am Sleeping!!!");
        }
        else if((dateTime) >= 05  && (dateTime) < 12) {
            wishmsg.setText("Good Morning!!!");
        }
        else if((dateTime) >= 12  && (dateTime) < 17) {
            wishmsg.setText("Good Afternoon!!!");
        }
        else if((dateTime) >= 17  && (dateTime) < 20) {
            wishmsg.setText("Good Evening!!!");
        }
        else if((dateTime) >= 20  && (dateTime) < 24) {
            wishmsg.setText("Good Night!!!");
        }
        else
            wishmsg.setText("I'm taking rest");



        routinecardview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, RoutineActivity.class);
                startActivity(intent);
            }
        });

        classlinkcardview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassLinkActivity.class);
                startActivity(intent);
            }
        });

        noticecardview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        videoreccardview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FacultyActivity.class);
                startActivity(intent);
            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nevigation_developer:
                Toast.makeText(this, "Developers", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nevigation_video:
                    gotourl("https://drive.google.com/drive/folders/1iLNE0rY0tkErrAj7Ig5mJBlT0S2c3p1r?usp=sharing");
                break;
                case R.id.nevigation_pdf:
                    startActivity(new Intent(this, PdfActivity.class));
                break;
                case R.id.nevigation_review:
                Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nevigation_share:
                Toast.makeText(this, "Share This App", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nevigation_website:
                    gotourl("https://elearn.daffodilvarsity.edu.bd/?redirect=0");
                break;

        }
        return true;
    }

    private void gotourl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }
}