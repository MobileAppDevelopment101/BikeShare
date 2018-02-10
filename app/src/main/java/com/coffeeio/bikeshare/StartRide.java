package com.coffeeio.bikeshare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartRide extends AppCompatActivity {

    private Ride last = new Ride("", "");

    // GUI variables
    private Button addRide;
    private TextView lastAdded, newWhat, newWhere;
    private EditText whereInput, whatInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_start_ride);

        // Attach widgets.
        lastAdded= (TextView) findViewById(R.id.last_text);
        addRide = (Button) findViewById(R.id.add_button);
        newWhat= (TextView) findViewById(R.id.what_text);
        newWhere= (TextView) findViewById(R.id.where_text);
        whatInput = (EditText) findViewById(R.id.what_input);
        whereInput = (EditText) findViewById(R.id.where_input);

        updateUI();

        // Add ride, based on text inputs.
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

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, StartRide.class);
        return intent;
    }
}
