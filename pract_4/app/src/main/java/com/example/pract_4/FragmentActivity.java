package com.example.pract_4;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //second fragment
        getSupportFragmentManager().beginTransaction().add(R.id.dynamicFragment, SecondFragment.class, null).commit();
    }
    public void onFirstFragment1(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.staticFragment,
                FirstFragment.class, null).commit();
    }
    public void onSecondFragment1(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.staticFragment,
                SecondFragment.class, null).commit();
    }
    public void onThirdFragment1(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.staticFragment,
                ThirdFragment.class, null).commit();
    }
    public void onFirstFragment2(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.dynamicFragment,
                FirstFragment.class, null).commit();
    }
    public void onSecondFragment2(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.dynamicFragment,
                SecondFragment.class, null).commit();
    }
    public void onThirdFragment2(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.dynamicFragment,
                ThirdFragment.class, null).commit();
    }
    public void onFirstFragment3(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.containerView,
                FirstFragment.class, null).commit();
    }
    public void onSecondFragment3(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.containerView,
                SecondFragment.class, null).commit();
    }
    public void onThirdFragment3(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.containerView,
                ThirdFragment.class, null).commit();
    }
}