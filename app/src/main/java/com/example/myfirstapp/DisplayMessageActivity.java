package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Boiler plate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the intent link from this activity (this will be to the MainActivity
        Intent intent = getIntent();
        // Get the extra message from the MainActivity resource
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Create a new TextView
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        // Get the current layout and add the new text
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }
}
