package com.ryanmohta.chemcalculator;

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

    final double H = 1.01;
    final double He = 4.00;
    final double Li = 6.94;
    final double Be = 9.01;
    final double B = 10.81;
    final double C = 12.01;
    final double N = 14.01;
    final double O = 16.00;
    final double F = 19.00;
    final double Ne = 20.18;
    final double Na = 22.99;
    final double Mg = 24.31;
    final double Al = 26.98;
    final double Si = 28.09;
    final double P = 30.97;
    final double S = 32.07;
    final double Cl = 35.45;
    final double Ar = 39.95;
    final double K = 39.10;
    final double Ca = 40.08;
    final double Sc = 44.96;
    final double Ti = 47.87;
    final double V = 50.94;
    final double Cr = 52.00;
    final double Mn = 54.94;
    final double Fe = 55.85;
    final double Co = 58.93;
    final double Ni = 58.69;
    final double Cu = 63.55;
    final double Zn = 65.39;
    final double Ga = 69.72;
    final double Ge = 72.61;
    final double As = 74.92;
    final double Se = 78.96;
    final double Br = 79.90;
    final double Kr = 83.80;
    final double Rb = 85.47;
    final double Sr = 87.62;
    final double Y = 88.91;
    final double Zr = 91.22;
    final double Nb = 92.91;
    final double Mo = 95.95;
    final double Tc = 98.00;
    final double Ru = 101.07;
    final double Rh = 102.91;
    final double Pd = 106.42;
    final double Ag = 107.87;
    final double Cd = 112.41;
    final double In = 114.82;
    final double Sn = 118.71;
    final double Sb = 121.76;
    final double Te = 127.60;
    final double I = 126.90;
    final double Xe = 131.29;
    final double Cs = 132.91;
    final double Ba = 137.33;
    final double La = 138.91;
    final double Ce = 140.12;
    final double Pr = 140.91;
    final double Nd = 144.24;
    final double Pm = 145.00;
    final double Sm = 150.36;
    final double Eu = 151.96;
    final double Gd = 157.25;
    final double Tb = 158.93;
    final double Dy = 162.50;
    final double Ho = 164.93;
    final double Er = 167.26;
    final double Tm = 168.93;
    final double Yb = 173.04;
    final double Lu = 174.97;
    final double Hf = 178.49;
    final double Ta = 180.95;
    final double W = 183.84;
    final double Re = 186.21;
    final double Os = 190.23;
    final double Ir = 192.22;
    final double Pt = 195.08;
    final double Au = 196.97;
    final double Hg = 200.59;
    final double Tl = 204.38;
    final double Pb = 207.20;
    final double Bi = 208.98;
    final double Po = 209.00;
    final double At = 210.00;
    final double Rn = 222.00;
    final double Fr = 223.00;
    final double Ra = 226.00;
    final double Ac = 227.00;
    final double Th = 232.04;
    final double Pa = 231.04;
    final double U = 238.03;

    double[] elements = {H, He,
            Li, Be, B, C, N, O, F, Ne,
            Na, Mg, Al, Si, P, S, Cl, Ar,
            K, Ca, Sc, Ti, V, Cr, Mn, Fe, Co, Ni, Cu, Zn, Ga, Ge, As, Se, Br, Kr,
            Rb, Sr, Y, Zr, Nb, Mo, Tc, Ru, Rh, Pd, Ag, Cd, In, Sn, Sb, Te, I, Xe,
            Cs, Ba, La,
            Ce, Pr, Nd, Pm, Sm, Eu, Gd, Tb, Dy, Ho, Er, Tm, Yb, Lu,
            Hf, Ta, W, Re, Os, Ir, Pt, Au, Hg, Tl, Pb, Bi, Po, At, Rn,
            Fr, Ra, Ac, Th, Pa, U
    };

    String[] symbols = {"H", "He",
            "Li", "Be", "B", "C", "N", "O", "F", "Ne",
            "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar",
            "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr",
            "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe",
            "Cs", "Ba", "La",
            "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu",
            "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn",
            "Fr", "Ra", "Ac", "Th", "Pa", "U"
    };

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
                Toast.makeText(getContext(), calculateMolarMass(inputText.getText().toString()) + "", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

        public  double calculateMolarMass(String compound) {
            String currentElement = "";
            boolean elem = false;
            int coefficient = 0;
            int num= 0;
            double molarMass = 0;
            for(int i = 0; i < compound.length(); i++) {
                char current = compound.charAt(i);
                if(Character.isLowerCase(current)) {
                    currentElement += current;
                    elem = true;
                    num = 0;
                } else if(Character.isUpperCase(current)) {
                    if(i != 0) {
                        int index = 0;
                        for(int j = 0; j < symbols.length; j++) {
                            if(symbols[j].equals(currentElement)) {
                                index = j;
                                j = symbols.length;
                            }
                        }
                        if(num == 0) {
                            num = 1;
                        }
                        molarMass += num * elements[index];
                    }
                    currentElement = Character.toString(current);
                    elem = true;
                    num = 0;
                }
                else{
                    if(i == 0) {
                        for(int j = 0; j < compound.length(); j++) {
                            if(Character.isUpperCase(compound.charAt(j))) {
                                coefficient = Integer.parseInt(compound.substring(0,j));
                                i=j;
                                j = compound.length();
                            }
                        }
                    } else {
                        if(elem) {
                            num += Integer.parseInt(Character.toString(current));
                        } else {
                            num *= 10;
                            num += Integer.parseInt(Character.toString(current));
                        }
                    }
                    elem = false;
                }
            }

            int index = 0;
            for(int i = 0; i < symbols.length; i++) {
                if(symbols[i].equals(currentElement)) {
                    index = i;
                    i = symbols.length;
                }
            }
            if(num == 0) {
                num = 1;
            }
            molarMass += num * elements[index];
            if(coefficient == 0) {
                return molarMass;
            } else {
                return molarMass * coefficient;
            }
        }
    }
