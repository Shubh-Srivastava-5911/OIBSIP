package com.example.mlt.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mlt.R;
import com.example.mlt.fragments.TemperatureFrag;
import com.example.mlt.fragments.TemperatureFrag;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class TemperatureUnits extends BottomSheetDialogFragment {

    TextView c, f, k, r, re;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.temperature_units, container, false);

        c = view.findViewById(R.id.c); f = view.findViewById(R.id.f);
        k = view.findViewById(R.id.k); r = view.findViewById(R.id.r);
        re = view.findViewById(R.id.re);

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

                if(TemperatureFrag.unit1clicked) {
                    TemperatureFrag.unit1.setText(small);
                    TemperatureFrag.ack1.setText(large);
                    updateopr();
                }
                else if(TemperatureFrag.unit2clicked) {
                    TemperatureFrag.unit2.setText(small);
                    TemperatureFrag.ack2.setText(large);
                    updateopr();
                }
                TemperatureFrag.tuDrawer.dismiss();
            }
        };

        c.setOnClickListener(myclick); f.setOnClickListener(myclick); k.setOnClickListener(myclick); r.setOnClickListener(myclick); re.setOnClickListener(myclick);

        return view;
    }

    double oprnd1, oprnd2;
    void updateopr() {
        String un1= TemperatureFrag.unit1.getText().toString(), un2=TemperatureFrag.unit2.getText().toString();
        oprnd1=TemperatureFrag.oprnd1; oprnd2=TemperatureFrag.oprnd2;
        if(un1.equals("°F")) oprnd2 = (oprnd1-32) * (5.0/9.0);
        else if(un1.equals("K")) oprnd2 = oprnd1 - 273.15;
        else if(un1.equals("°R")) oprnd2 = (oprnd1-491.67) * (5.0/9.0);
        else if(un1.equals("°Re")) oprnd2 = oprnd1 * 1.25;
        else oprnd2 = oprnd1;
        ifelse(un1,un2);
        TemperatureFrag.output = Double.toString(oprnd2);
        String backup=TemperatureFrag.output;
        int comac=3;
        for(int i=TemperatureFrag.output.length()-1; i>=0; i--) {
            if(backup.charAt(i)=='.') { backup = TemperatureFrag.output; comac=3; continue; }
            if(backup.charAt(i)=='-') { comac=3; continue; }
            if(comac==0) {
                backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                comac=3;
            }
            comac--;
        }
        TemperatureFrag.bycalc.setText(backup);
    }
    void ifelse(String un1, String un2) {
        if(un2.equals("°F")) oprnd2 = (oprnd2 * (9.0/5.0)) + 32;
        else if(un2.equals("K")) oprnd2 = oprnd2 + 273.15;
        else if(un2.equals("°R")) oprnd2 = (oprnd2 * (9.0/5.0)) + 491.67;
        else if(un2.equals("°Re")) oprnd2 = oprnd2 / 1.25;
        else oprnd2 = oprnd2;
    }
}
