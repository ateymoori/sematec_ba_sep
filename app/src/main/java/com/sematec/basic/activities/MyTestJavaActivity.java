package com.sematec.basic.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.sematec.basic.R;

public class MyTestJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test_java);
    }

    private String getMyName(){
        return "Amirhossein" ;
    }
}