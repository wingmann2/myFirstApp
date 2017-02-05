package com.example.myfirstapp;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if installed android version is sufficient
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB) {
            // Notify the user via text box incompatible
            ((EditText) findViewById(R.id.edit_message)).setText("Version not supported");
        }
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
