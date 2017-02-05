package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user clicks the send button
     * @param view
     *      View page send button sits on
     */
    public void sendMessage(View view) {
        //Do something in response to button

        // Create a link between this and the DisplayMessageActivity
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // Get the EditText object/view
        EditText editText = (EditText) findViewById(R.id.edit_message);
        // Get the message from that object
        String message = editText.getText().toString();
        // Attach the key value pair between EXTRA_MESSAGE resource and the message text
        intent.putExtra(EXTRA_MESSAGE, message);
        // Create a new instance of the intent
        startActivity(intent);
    }
}
