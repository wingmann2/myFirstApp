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

        // Check if installed android version is sufficient
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB) {
            // Notify the user via text box incompatible
            ((EditText) findViewById(R.id.edit_message)).setText("Version not supported");
        }

        // Lesson 1 - adding text send and recieve activity
        setContentView(R.layout.activity_main);

        // Lesson 2 - Fragment static add
        //setContentView(R.layout.news_articles);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
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
