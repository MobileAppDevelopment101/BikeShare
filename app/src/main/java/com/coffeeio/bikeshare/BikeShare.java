package com.coffeeio.bikeshare;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BikeShare extends Activity {
    // GUI variables
    private Button addRide;
    private TextView lastAdded, newWhat, newWhere;
    private EditText whereInput, whatInput;

    private Ride last= new Ride("", "");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_bike_share);
        lastAdded= (TextView) findViewById(R.id.last_text);
        updateUI();
        // Button
        addRide = (Button) findViewById(R.id.add_button);
        // Texts
        newWhat= (TextView) findViewById(R.id.what_text);
        newWhere= (TextView) findViewById(R.id.where_text);

        // Input
        whatInput = (EditText) findViewById(R.id.what_input);
        whereInput = (EditText) findViewById(R.id.where_input);

        // view products click event
        addRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((whatInput.getText().length()>0) && (whereInput.getText().length()>0 )){
                    last.setMbikeName(whatInput.getText().toString().trim());
                    last.setMstartRide(whereInput.getText().toString().trim());
                    // reset text fields
                    whatInput.setText("");
                    whereInput.setText("");
                    updateUI();
                }
            }
        });
    }
    private void updateUI(){ lastAdded.setText(last.toString()); }
}
