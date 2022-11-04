package com.example.imdiggie.ui.faculty;

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

public class FacultyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    private RecyclerView cseDepartment,othersDepartment,DepartmentHead,Advisor;
    private LinearLayout cseNoData,othersDepartmentNoData,DepartmentHeadNoData,AdvisorNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference , dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Faculty ");

        //for navigation drawer
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        cseDepartment = findViewById(R.id.cseDepartment);
        othersDepartment = findViewById(R.id.othersDepartment);
        DepartmentHead = findViewById(R.id.DepartmentHead);
        Advisor = findViewById(R.id.Advisor);

        cseNoData = findViewById(R.id.cseNoData);
        othersDepartmentNoData = findViewById(R.id.othersDepartmentNoData);
        DepartmentHeadNoData = findViewById(R.id.DepartmentHeadNoData);
        AdvisorNoData = findViewById(R.id.AdvisorNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Faculty");

        cseDepartment();
        othersDepartment();
        DepartmentHead();
        Advisor();

    }

    private void cseDepartment() {
        dbRef = reference.child("Department of CSE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cseNoData.setVisibility(View.VISIBLE);
                    cseDepartment.setVisibility(View.GONE);

                }else{

                    cseNoData.setVisibility(View.GONE);
                    cseDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    cseDepartment.setHasFixedSize(true);
                    cseDepartment.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list1,FacultyActivity.this,"Department of CSE");
                    cseDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FacultyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void othersDepartment() {
        dbRef = reference.child("others Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    othersDepartmentNoData.setVisibility(View.VISIBLE);
                    othersDepartment.setVisibility(View.GONE);

                }else{

                    othersDepartmentNoData.setVisibility(View.GONE);
                    othersDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    othersDepartment.setHasFixedSize(true);
                    othersDepartment.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list2,FacultyActivity.this, "others Department");
                    othersDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FacultyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void DepartmentHead() {
        dbRef = reference.child("Department Head");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    DepartmentHeadNoData.setVisibility(View.VISIBLE);
                    DepartmentHead.setVisibility(View.GONE);

                }else{

                    DepartmentHeadNoData.setVisibility(View.GONE);
                    DepartmentHead.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    DepartmentHead.setHasFixedSize(true);
                    DepartmentHead.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list3,FacultyActivity.this,"Department Head");
                    DepartmentHead.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FacultyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Advisor() {
        dbRef = reference.child("Advisor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    AdvisorNoData.setVisibility(View.VISIBLE);
                    Advisor.setVisibility(View.GONE);

                }else{

                    AdvisorNoData.setVisibility(View.GONE);
                    Advisor.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    Advisor.setHasFixedSize(true);
                    Advisor.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list4,FacultyActivity.this,"Advisor");
                    Advisor.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FacultyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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