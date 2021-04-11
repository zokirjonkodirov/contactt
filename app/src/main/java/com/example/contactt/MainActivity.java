package com.example.contactt;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView sadulla,
            tursunboy,
            bosit,
            kamoliddin,
            abdurashid,
            zokir,
            allo,
            heading;
    private EditText editTextPhone;
    private ImageView callButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sadulla = (TextView) findViewById(R.id.sadulla);
        tursunboy = (TextView) findViewById(R.id.tursunboy);
        bosit =(TextView) findViewById(R.id.bosit);
        kamoliddin = (TextView) findViewById(R.id.Kamoliddin);
        abdurashid = (TextView) findViewById(R.id.abdurashid);
        zokir = (TextView) findViewById(R.id.zokir);
        heading = (TextView) findViewById(R.id.heading);
        allo = (TextView) findViewById(R.id.allo);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        callButton = (ImageView) findViewById(R.id.callButton);


        heading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent headingIntent = new Intent(getApplicationContext(), heading.class);
                startActivity(headingIntent);
            }
        });

        sadulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+998935345452"));
                startActivity(intent);
            }
        });

        tursunboy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+998946441771"));
                startActivity(intent);
            }
        });

        bosit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+998901232249"));
                startActivity(intent);
            }
        });
            zokir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+998946020920"));
                    startActivity(intent);
                }
            });


            abdurashid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+998946031915"));
                    startActivity(intent);
                }
            });
            kamoliddin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+998330096660"));
                    startActivity(intent);
                }
            });

            allo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+998999255353"));
                    startActivity(intent);
                }
            });

        String phoneNumber = editTextPhone.getText().toString();
        if (phoneNumber != null) {
            callButton.setVisibility(View.VISIBLE);
        }

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, .5f, RotateAnimation.RELATIVE_TO_SELF, .5f);
                rotateAnimation.setDuration(1000);
                callButton.startAnimation(rotateAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String phoneNumber = editTextPhone.getText().toString();
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                        if (phoneNumber == null) {
                            Toast.makeText(getApplicationContext(), "Enter phone number", Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(intent);
                        }
                    }
                }, 1000);
            }
        });
    }

    public void getPermission(View view) {

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        };

        TedPermission.with(MainActivity.this)
                .setPermissionListener(permissionListener)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check();
    }
}