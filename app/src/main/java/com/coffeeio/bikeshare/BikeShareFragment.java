package com.coffeeio.bikeshare;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by MGApcDev on 03-03-2018.
 */

public class BikeShareFragment extends Fragment {
    // GUI variables
    private Button startRide, endRide;
    private TextView lastAdded, newWhat, newWhere;
    private EditText whereInput, whatInput;
    ArrayAdapter<Ride> itemsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bikeshare, container, false);

        RidesDB ridesInstance = RidesDB.get(BikeShareFragment.this.getActivity());

        itemsAdapter = new ArrayAdapter<Ride>(BikeShareFragment.this.getActivity(), android.R.layout.simple_list_item_1, ridesInstance.getRidesDB());

        ListView listView = (ListView) v.findViewById(R.id.item_list);
        listView.setAdapter(itemsAdapter);


        startRide = (Button) v.findViewById(R.id.start_ride);
        endRide = (Button) v.findViewById(R.id.end_ride);

        // Start StartRide activity
        startRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  StartRide.newIntent(BikeShareFragment.this.getActivity());
                startActivity(intent);
            }
        });

        // Start EndRide activity
        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  EndRide.newIntent(BikeShareFragment.this.getActivity());
                startActivity(intent);
            }
        });

        return v;
    }
}
