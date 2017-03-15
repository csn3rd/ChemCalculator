package com.ryanmohta.chemcalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SigFigCalculator extends Fragment {
    Button button;
    EditText inputText;

    public SigFigCalculator() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sig_fig_calculator, container, false);
        button = (Button)view.findViewById(R.id.button);
        inputText = (EditText)view.findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), calculateSigFigs(inputText.getText().toString()) + "", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public int calculateSigFigs(String str) {
        int index = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '.') {
                index = i;
            }
        }

        boolean leftToRight = false;
        if(index != 0) {
            leftToRight = true;
        }

        int counter = 0;
        boolean significant = false;
        if(leftToRight) {
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != '0' && str.charAt(i) != '.' && !significant) {
                    significant = true;
                }
                if(str.charAt(i) != '.' && significant) {
                    counter++;
                }
            }
        } else {
            for(int i = str.length()-1; i >= 0; i--) {
                if(str.charAt(i) != '0' && str.charAt(i) != '.' && !significant) {
                    significant = true;
                }
                if(significant) {
                    counter++;
                }
            }
        }

        return counter;
    }


}
