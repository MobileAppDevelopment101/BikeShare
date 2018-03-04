package com.coffeeio.bikeshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EndRide extends AppCompatActivity {

    private RidesDB ridesInstance;

    // GUI variables
    private Button removeRide;
    private TextView lastAdded, newWhat, newWhere;
    private EditText whereInput, whatInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_ride);
        ridesInstance = RidesDB.get(EndRide.this);

        // Attach widgets.
        lastAdded= findViewById(R.id.last_text);
        removeRide = findViewById(R.id.remove_button);
        newWhat= findViewById(R.id.what_text);
        newWhere= findViewById(R.id.where_text);
        whatInput = findViewById(R.id.what_input);
        whereInput = findViewById(R.id.where_input);

        // Add ride, based on text inputs.
        removeRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((whatInput.getText().length() > 0) && (whereInput.getText().length() > 0)){
                    String what = whatInput.getText().toString().trim();
                    String where = whereInput.getText().toString().trim();

                    Ride state = ridesInstance.endRide(what, where); // Return state to get ride start location
                    if (state == null) {
                        Toast.makeText(EndRide.this, "Error: Can't end ride not in progress", Toast.LENGTH_SHORT).show();
                    } else {
                        updateUI(state);
                    }


                    // reset text fields
                    whatInput.setText("");
                    whereInput.setText("");
                }
            }
        });
    }

    private void updateUI(Ride newState){
        lastAdded.setText(newState.toString());
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, EndRide.class);
        return intent;
    }
}
