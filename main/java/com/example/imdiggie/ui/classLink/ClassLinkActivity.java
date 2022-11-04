package com.example.imdiggie.ui.classLink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.imdiggie.R;
import com.example.imdiggie.pdf.PdfActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassLinkActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    private RecyclerView saturday, sunday, monday, tuesday, wednesday, thursday, friday;
    private LinearLayout satNoData, sunNoData, monNoData, tueNoData, wedNoData, thuNoData, friNoData;
    private List<LiveClassData> list1,list2,list3,list4,list5,list6,list7;
    private LiveClassAdapter adapter;

    private DatabaseReference reference , dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_link);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Class Links ");



        //for navigation drawer
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        saturday = findViewById(R.id.saturday);
        sunday = findViewById(R.id.sunday);
        monday = findViewById(R.id.monday);
        tuesday = findViewById(R.id.tuesday);
        wednesday = findViewById(R.id.wednesday);
        thursday = findViewById(R.id.thursday);
        friday = findViewById(R.id.friday);

        satNoData = findViewById(R.id.satNoData);
        sunNoData = findViewById(R.id.sunNoData);
        monNoData = findViewById(R.id.monNoData);
        tueNoData = findViewById(R.id.tueNoData);
        wedNoData = findViewById(R.id.wedNoData);
        thuNoData = findViewById(R.id.thuNoData);
        friNoData = findViewById(R.id.friNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("ClassLink");

        saturday();
        sunday();
        monday();
        tuesday();
        wednesday();
        thursday();
        friday();

    }

    private void saturday() {
        dbRef = reference.child("Saturday");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    satNoData.setVisibility(View.VISIBLE);
                    saturday.setVisibility(View.GONE);

                }else{

                    satNoData.setVisibility(View.GONE);
                    saturday.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        LiveClassData data = snapshot.getValue(LiveClassData.class);
                        list1.add(data);
                    }
                    saturday.setHasFixedSize(true);
                    saturday.setLayoutManager(new LinearLayoutManager(ClassLinkActivity.this));
                    adapter = new LiveClassAdapter(list1, ClassLinkActivity.this,"Saturday");
                    saturday.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ClassLinkActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sunday() {
        dbRef = reference.child("Sunday");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sunNoData.setVisibility(View.VISIBLE);
                    sunday.setVisibility(View.GONE);

                }else{

                    sunNoData.setVisibility(View.GONE);
                    sunday.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        LiveClassData data = snapshot.getValue(LiveClassData.class);
                        list2.add(data);
                    }
                    sunday.setHasFixedSize(true);
                    sunday.setLayoutManager(new LinearLayoutManager(ClassLinkActivity.this));
                    adapter = new LiveClassAdapter(list2, ClassLinkActivity.this, "Sunday");
                    sunday.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ClassLinkActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void monday() {
        dbRef = reference.child("Monday");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    monNoData.setVisibility(View.VISIBLE);
                    monday.setVisibility(View.GONE);

                }else{

                    monNoData.setVisibility(View.GONE);
                    monday.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        LiveClassData data = snapshot.getValue(LiveClassData.class);
                        list3.add(data);
                    }
                    monday.setHasFixedSize(true);
                    monday.setLayoutManager(new LinearLayoutManager(ClassLinkActivity.this));
                    adapter = new LiveClassAdapter(list3, ClassLinkActivity.this,"Monday");
                    monday.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ClassLinkActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tuesday() {
        dbRef = reference.child("Tuesday");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    tueNoData.setVisibility(View.VISIBLE);
                    tuesday.setVisibility(View.GONE);

                }else{

                    tueNoData.setVisibility(View.GONE);
                    tuesday.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        LiveClassData data = snapshot.getValue(LiveClassData.class);
                        list4.add(data);
                    }
                    tuesday.setHasFixedSize(true);
                    tuesday.setLayoutManager(new LinearLayoutManager(ClassLinkActivity.this));
                    adapter = new LiveClassAdapter(list4, ClassLinkActivity.this,"Tuesday");
                    tuesday.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ClassLinkActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void wednesday() {
        dbRef = reference.child("Wednesday");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    wedNoData.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.GONE);

                }else{

                    wedNoData.setVisibility(View.GONE);
                    wednesday.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        LiveClassData data = snapshot.getValue(LiveClassData.class);
                        list5.add(data);
                    }
                    wednesday.setHasFixedSize(true);
                    wednesday.setLayoutManager(new LinearLayoutManager(ClassLinkActivity.this));
                    adapter = new LiveClassAdapter(list5, ClassLinkActivity.this,"Wednesday");
                    wednesday.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ClassLinkActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void thursday() {
        dbRef = reference.child("Thursday");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    thuNoData.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.GONE);

                }else{

                    thuNoData.setVisibility(View.GONE);
                    thursday.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        LiveClassData data = snapshot.getValue(LiveClassData.class);
                        list6.add(data);
                    }
                    thursday.setHasFixedSize(true);
                    thursday.setLayoutManager(new LinearLayoutManager(ClassLinkActivity.this));
                    adapter = new LiveClassAdapter(list6, ClassLinkActivity.this,"Thursday");
                    thursday.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ClassLinkActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void friday() {
        dbRef = reference.child("Friday");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    friNoData.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.GONE);

                }else{

                    friNoData.setVisibility(View.GONE);
                    friday.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        LiveClassData data = snapshot.getValue(LiveClassData.class);
                        list7.add(data);
                    }
                    friday.setHasFixedSize(true);
                    friday.setLayoutManager(new LinearLayoutManager(ClassLinkActivity.this));
                    adapter = new LiveClassAdapter(list7, ClassLinkActivity.this,"Friday");
                    friday.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ClassLinkActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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