package com.example.zoomapp.welcomepak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zoomapp.JoinMeetingActivity;
import com.example.zoomapp.Loginpage;
import com.example.zoomapp.R;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private TextView textViewSignup, textViewSignin;
    private AppCompatButton buttonJoinMeeting;
    private SpringDotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initViews();
        clickListener();
        setPagerAdapter();
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        textViewSignin = findViewById(R.id.textViewSignIn);
        textViewSignup = findViewById(R.id.textViewSignup);
        dotsIndicator = findViewById(R.id.dots_indicator);
        buttonJoinMeeting = findViewById(R.id.btnJoinMeeting);
    }

    private void clickListener() {
        textViewSignin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
        buttonJoinMeeting.setOnClickListener(this);
    }

    private void setPagerAdapter() {
        viewPager.setAdapter(new WelcomePagerAdapter(this,getSupportFragmentManager()));
        dotsIndicator.setViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.textViewSignIn:
                navigateToSignIn(true);
                break;
            case R.id.textViewSignup:
                navigateToSignIn(false);
                break;

            case R.id.btnJoinMeeting:
                navigateToJoinMeeting();
                break;

        }
    }

    private void navigateToJoinMeeting() {
        Intent intent = new Intent(this, JoinMeetingActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    private void navigateToSignIn(boolean isSignIn) {
        Intent intent = new Intent(this, Loginpage.class);
        intent.putExtra("isSignIn",isSignIn);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}