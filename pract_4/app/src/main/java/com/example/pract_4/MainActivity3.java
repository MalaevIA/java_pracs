package com.example.pract_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }

    public void sendMessage(View view)
    {
        EditText dayEdit, timeEdit, commentEdit;
        dayEdit = findViewById(R.id.editTextDay);
        timeEdit = findViewById(R.id.editTextTime);
        commentEdit = findViewById(R.id.editTextComment);

        String day, time, comment;
        day = dayEdit.getText().toString();
        time = timeEdit.getText().toString();
        comment = commentEdit.getText().toString();

        Intent intent = new Intent();
        if (!day.isEmpty() && !time.isEmpty() && !comment.isEmpty())
        {
            intent.putExtra(MainActivity2.ACCESS_MSG, day + " " + time + " " + comment);
            setResult(RESULT_OK, intent);
            finish();
        }
        else
        {
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }
}