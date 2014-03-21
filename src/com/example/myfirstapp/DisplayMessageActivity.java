package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;

import android.view.MenuItem;
import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v4.app.NavUtils;

import android.widget.TextView;
import android.content.Intent;


public class DisplayMessageActivity extends Activity
{

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      // Get the message from the intent
      Intent intent = getIntent();
      String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

      // Create the text view
      TextView textView = new TextView(this);
      textView.setTextSize(40);
      textView.setText(message);

      // Set the text view as the activity layout
      setContentView(textView);

      // Enable the up button to go to parent activity
      getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
