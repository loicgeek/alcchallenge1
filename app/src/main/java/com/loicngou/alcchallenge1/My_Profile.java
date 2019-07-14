package com.loicngou.alcchallenge1;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class My_Profile extends AppCompatActivity {
    ImageView profile_img_view;
    TextView my_phone_number;
    TextView my_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__profile);

        profile_img_view = findViewById(R.id.profile_img_view);
        my_phone_number = findViewById(R.id.my_phone_number);
        my_email = findViewById(R.id.my_email);

        Drawable d = new Drawable() {
            @Override
            public void draw(@NonNull Canvas canvas) {
                canvas.clipRect(4,25,8,4);
            }

            @Override
            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(@Nullable ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return PixelFormat.OPAQUE;
            }
        };
        Picasso.get().load("https://avatars2.githubusercontent.com/u/33604660?s=400&v=4").placeholder(d).into(profile_img_view);

        my_phone_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("number clicked");
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+my_phone_number.getText().toString()));
                if(intent.resolveActivity(getPackageManager())!= null){
                    startActivity(intent);
                }
            }
        });

        my_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto",my_email.getText().toString(),null));
                if(intent.resolveActivity(getPackageManager())!= null){
                    startActivity(Intent.createChooser(intent,"Send Mail"));
                }
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("MY PROFILE");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setElevation(1.2f);
        }


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
