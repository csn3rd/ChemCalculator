package com.ryanmohta.chemcalculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MolarMassCalculator extends Fragment {
    Button button;
    EditText inputText;

    public MolarMassCalculator() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_molar_mass_calculator, container, false);
        button = (Button)view.findViewById(R.id.button);
        inputText = (EditText)view.findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }




}
