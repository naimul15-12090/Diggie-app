package com.example.imdiggie.ui.routine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.imdiggie.R;
import com.example.imdiggie.pdf.PdfActivity;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoutineActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    RecyclerView classRecycler,examRecycler,courseRecycler,othersRecycler;
    RoutineAdapter adapter;
    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Routine ");




        //for navigation drawer
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);


        classRecycler = findViewById(R.id.classRecycler);
        examRecycler = findViewById(R.id.examRecycler);
        courseRecycler = findViewById(R.id.courseRecycler);
        othersRecycler = findViewById(R.id.othersRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getClassRoutineImage();
        getExamRoutineImage();
        getCourseListImage();
        getOthersImage();



    }

    private void getOthersImage() {
        reference.child("Others").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for(DataSnapshot snapshot: datasnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new RoutineAdapter(RoutineActivity.this,imageList);
                othersRecycler.setLayoutManager(new GridLayoutManager(RoutineActivity.this, 2));
                othersRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(RoutineActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void getCourseListImage() {
        reference.child("Course List").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for(DataSnapshot snapshot: datasnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new RoutineAdapter(RoutineActivity.this,imageList);
                courseRecycler.setLayoutManager(new GridLayoutManager(RoutineActivity.this, 2));
                courseRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(RoutineActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getExamRoutineImage() {
        reference.child("Exam Routine").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for(DataSnapshot snapshot: datasnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new RoutineAdapter(RoutineActivity.this,imageList);
                examRecycler.setLayoutManager(new GridLayoutManager(RoutineActivity.this, 2));
                examRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(RoutineActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getClassRoutineImage() {
        reference.child("Class Routine").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for(DataSnapshot snapshot: datasnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new RoutineAdapter(RoutineActivity.this,imageList);
                classRecycler.setLayoutManager(new GridLayoutManager(RoutineActivity.this, 2));
                classRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(RoutineActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

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
//                try {
//                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
//                    Intent i = new Intent(Intent.ACTION_VIEW,uri);
//                    startActivity(i);
//                } catch (Exception e) {
//                    Toast.makeText(this, "Unable to Open", Toast.LENGTH_SHORT).show();
//                }
                Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nevigation_share:
//                try{
//                    Intent i = new Intent(Intent.ACTION_SEND);
//                    i.setType("text/plain");
//                    i.putExtra(Intent.EXTRA_SUBJECT,"Diggie");
//                    i.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
//                    startActivity(Intent.createChooser(i,"Share With"));
//                }catch (Exception e){
//                    Toast.makeText(this, "Unable to share this App", Toast.LENGTH_SHORT).show();
//                }
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