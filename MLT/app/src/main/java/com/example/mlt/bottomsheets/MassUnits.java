package com.example.mlt.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mlt.R;
import com.example.mlt.fragments.MassFrag;
import com.example.mlt.fragments.MassFrag;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MassUnits extends BottomSheetDialogFragment {

    TextView t, kg, g, mg, ug, q, lb, oz, ct, gr, lt, sht, ukcwt, uscwt, st, dr, dan, jin, qn, ln, jintw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mass_units,container,false);

        t = view.findViewById(R.id.t); kg = view.findViewById(R.id.kg); g = view.findViewById(R.id.g); mg = view.findViewById(R.id.mg);
        ug = view.findViewById(R.id.ug); q = view.findViewById(R.id.q); lb = view.findViewById(R.id.lb); oz = view.findViewById(R.id.oz);
        ct = view.findViewById(R.id.ct); gr = view.findViewById(R.id.gr); lt = view.findViewById(R.id.lt); sht = view.findViewById(R.id.sht);
        ukcwt = view.findViewById(R.id.ukcwt); uscwt = view.findViewById(R.id.uscwt); st = view.findViewById(R.id.st); dr = view.findViewById(R.id.dr);
        dan = view.findViewById(R.id.dan); jin = view.findViewById(R.id.jin); qn = view.findViewById(R.id.qn); ln = view.findViewById(R.id.ln);
        jintw = view.findViewById(R.id.jintw);

        View.OnClickListener myclick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((TextView)view).getText().toString();
                String small="", large=""; boolean sepa=false;
                for(int i=0; i<text.length(); i++) {
                    if(!sepa && text.charAt(i)==' ') { sepa=true; i+=3; }
                    if(!sepa) small+=text.charAt(i);
                    else large+=text.charAt(i);
                }
                large = (char)(large.charAt(0)-32) + large.substring(1);

                if(MassFrag.unit1clicked) {
                    MassFrag.unit1.setText(small);
                    MassFrag.ack1.setText(large);
                    updateopr();
                }
                else if(MassFrag.unit2clicked) {
                    MassFrag.unit2.setText(small);
                    MassFrag.ack2.setText(large);
                    updateopr();
                }
                MassFrag.muDrawer.dismiss();
            }
        };

        t.setOnClickListener(myclick); kg.setOnClickListener(myclick); g.setOnClickListener(myclick); mg.setOnClickListener(myclick);
        ug.setOnClickListener(myclick); q.setOnClickListener(myclick); lb.setOnClickListener(myclick); oz.setOnClickListener(myclick);
        ukcwt.setOnClickListener(myclick); uscwt.setOnClickListener(myclick); st.setOnClickListener(myclick); dr.setOnClickListener(myclick);
        ct.setOnClickListener(myclick); gr.setOnClickListener(myclick); lt.setOnClickListener(myclick); sht.setOnClickListener(myclick);
        dan.setOnClickListener(myclick); jin.setOnClickListener(myclick); qn.setOnClickListener(myclick); ln.setOnClickListener(myclick);
                                                        jintw.setOnClickListener(myclick);

        return view;
    }

    double oprnd1, oprnd2;
    void updateopr() {
        String un1= MassFrag.unit1.getText().toString(), un2=MassFrag.unit2.getText().toString();
        oprnd1=MassFrag.oprnd1; oprnd2=MassFrag.oprnd2;
        if(un1.equals("t")) oprnd2 = oprnd1 * 1000;
        else if(un1.equals("g")) oprnd2 = oprnd1 / 1000;
        else if(un1.equals("mg")) oprnd2 = oprnd1 / 1000000;
        else if(un1.equals("µg")) oprnd2 = oprnd1 / 1000000000d;
        else if(un1.equals("q")) oprnd2 = oprnd1 * 100;
        else if(un1.equals("lb")) oprnd2 = oprnd1 / 2.20462262;
        else if(un1.equals("oz")) oprnd2 = oprnd1 / 35.2739619;
        else if(un1.equals("ct")) oprnd2 = oprnd1 / 5000;
        else if(un1.equals("gr")) oprnd2 = oprnd1 / 15432.3584;
        else if(un1.equals("l.t")) oprnd2 = oprnd1 * 1016.04691;
        else if(un1.equals("sh.t")) oprnd2 = oprnd1 * 907.18474;
        else if(un1.equals("cwt(uk)")) oprnd2 = oprnd1 * 50.8023454;
        else if(un1.equals("cwt(us)")) oprnd2 = oprnd1 * 45.359237;
        else if(un1.equals("st")) oprnd2 = oprnd1 * 6.35029318;
        else if(un1.equals("dr")) oprnd2 = oprnd1 / 564.383391;
        else if(un1.equals("dan")) oprnd2 = oprnd1 * 50;
        else if(un1.equals("jin")) oprnd2 = oprnd1 / 2;
        else if(un1.equals("qn")) oprnd2 = oprnd1 / 200;
        else if(un1.equals("ln")) oprnd2 = oprnd1 / 20;
        else if(un1.equals("jin(tw)")) oprnd2 = oprnd1 * 0.6;
        else oprnd2 = oprnd1;
        ifelse(un1,un2);
        MassFrag.output = Double.toString(oprnd2);
        String backup=MassFrag.output;
        int comac=3;
        for(int i=MassFrag.output.length()-1; i>=0; i--) {
            if(backup.charAt(i)=='.') { backup = MassFrag.output; comac=3; continue; }
            if(comac==0) {
                backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                comac=3;
            }
            comac--;
        }
        MassFrag.bycalc.setText(backup);
    }
    void ifelse(String un1, String un2) {
        if(un2.equals("t")) oprnd2 = oprnd2 / 1000;
        else if(un2.equals("g")) oprnd2 = oprnd2 * 1000;
        else if(un2.equals("mg")) oprnd2 = oprnd2 * 1000000;
        else if(un2.equals("µg")) oprnd2 = oprnd2 * 1000000000d;
        else if(un2.equals("q")) oprnd2 = oprnd2 / 100;
        else if(un2.equals("lb")) oprnd2 = oprnd2 * 2.20462262;
        else if(un2.equals("oz")) oprnd2 = oprnd2 * 35.2739619;
        else if(un2.equals("ct")) oprnd2 = oprnd2 * 5000;
        else if(un2.equals("gr")) oprnd2 = oprnd2 * 15432.3584;
        else if(un2.equals("l.t")) oprnd2 = oprnd2 / 1016.04691;
        else if(un2.equals("sh.t")) oprnd2 = oprnd2 / 907.18474;
        else if(un2.equals("cwt(uk)")) oprnd2 = oprnd2 / 50.8023454;
        else if(un2.equals("cwt(us)")) oprnd2 = oprnd2 / 45.359237;
        else if(un2.equals("st")) oprnd2 = oprnd2 / 6.35029318;
        else if(un2.equals("dr")) oprnd2 = oprnd2 * 564.383391;
        else if(un2.equals("dan")) oprnd2 = oprnd2 / 50;
        else if(un2.equals("jin")) oprnd2 = oprnd2 * 2;
        else if(un2.equals("qn")) oprnd2 = oprnd2 * 200;
        else if(un2.equals("ln")) oprnd2 = oprnd2 * 20;
        else if(un2.equals("jin(tw)")) oprnd2 = oprnd2 / 0.6;
        else oprnd2 = oprnd2;
    }
}
