package com.loicngou.alcchallenge1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    MaterialButton about_acl_btn ;
    MaterialButton my_profile_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar toolbar = getSupportActionBar();
        assert toolbar != null;
        toolbar.setElevation(0.2f);
        about_acl_btn =findViewById(R.id.about_acl_btn);
        about_acl_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("btn clicked");
                Intent i = new Intent(MainActivity.this,AboutACL.class);
                startActivity(i);
            }
        });

        my_profile_btn = findViewById(R.id.my_profile_btn) ;
        my_profile_btn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("btn clicked");
                Intent i1 = new Intent(MainActivity.this,My_Profile.class);
                startActivity(i1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater  = getMenuInflater();
        inflater.inflate(R.menu.menu_home_1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                startActivity(new Intent(MainActivity.this,About.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
