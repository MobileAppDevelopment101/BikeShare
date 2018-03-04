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

public class StartRide extends AppCompatActivity {
    private RidesDB ridesInstance;

    // GUI variables
    private Button addRide;
    private TextView lastAdded, newWhat, newWhere;
    private EditText whereInput, whatInput;

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, StartRide.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_start_ride);
        ridesInstance = RidesDB.get(StartRide.this);

        // Attach widgets.
        lastAdded= findViewById(R.id.last_text);
        addRide = findViewById(R.id.add_button);
        newWhat= findViewById(R.id.what_text);
        newWhere= findViewById(R.id.where_text);
        whatInput = findViewById(R.id.what_input);
        whereInput = findViewById(R.id.where_input);

        // Add ride, based on text inputs.
        addRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((whatInput.getText().length() > 0) && (whereInput.getText().length() > 0)){
                    String what = whatInput.getText().toString().trim();
                    String where = whereInput.getText().toString().trim();
                    Ride state = ridesInstance.addRide(what, where);

                    if (state == null) {
                        Toast.makeText(StartRide.this, "Error: Ride is still in progress", Toast.LENGTH_SHORT).show();
                    } else {
                        updateUI(state);
                    }

                    // Reset text fields
                    whatInput.setText("");
                    whereInput.setText("");
                }
            }
        });
    }

    private void updateUI(Ride newState){
        lastAdded.setText(newState.toString());
    }
}
