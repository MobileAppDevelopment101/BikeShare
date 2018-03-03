package com.coffeeio.bikeshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EndRide extends AppCompatActivity {

    // GUI variables
    private Button removeRide;
    private TextView lastAdded, newWhat, newWhere;
    private EditText whereInput, whatInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_ride);

        // Attach widgets.
        lastAdded= findViewById(R.id.last_text);
        removeRide = findViewById(R.id.remove_button);
        newWhat= findViewById(R.id.what_text);
        newWhere= findViewById(R.id.where_text);
        whatInput = findViewById(R.id.what_input);
        whereInput = findViewById(R.id.where_input);

    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, EndRide.class);
        return intent;
    }
}
