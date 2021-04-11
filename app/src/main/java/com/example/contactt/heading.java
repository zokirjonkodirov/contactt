package com.example.contactt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class heading extends AppCompatActivity {

    TextView creatorSadulla, creatorZokir;
    ImageView emoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heading);

        creatorSadulla = (TextView) findViewById(R.id.creatorsSadulla);
        creatorZokir = (TextView) findViewById(R.id.creatorsZokir);

        emoji = (ImageView) findViewById(R.id.emoji);

        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, .5f, RotateAnimation.RELATIVE_TO_SELF, .5f);
                rotateAnimation.setDuration(1000);
                emoji.startAnimation(rotateAnimation);
            }
        });

    }
}