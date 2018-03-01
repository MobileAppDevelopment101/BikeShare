package com.coffeeio.bikeshare;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BikeShare extends Activity {
    private static final String TAG = "BikeShare";

    // GUI variables
    private Button startRide, endRide;
    private TextView lastAdded, newWhat, newWhere;
    private EditText whereInput, whatInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_bike_share);

        RidesDB rides = new RidesDB(BikeShare.this);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.list_element, rides.getRidesDB());


        startRide = (Button) findViewById(R.id.start_ride);
        endRide = (Button) findViewById(R.id.end_ride);

        // Start StartRide activity
        startRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  StartRide.newIntent(BikeShare.this);
                startActivity(intent);
            }
        });

        // Start EndRide activity
        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  EndRide.newIntent(BikeShare.this);
                startActivity(intent);
            }
        });

    }
}
