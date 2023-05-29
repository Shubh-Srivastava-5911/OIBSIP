package com.example.mlt.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mlt.R;
import com.example.mlt.fragments.TimeFrag;
import com.example.mlt.fragments.TimeFrag;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class TimeUnits extends BottomSheetDialogFragment {

    TextView yr, wk, dy, hr, min, sec, ms, us, ps;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.time_units, container, false);

        yr = view.findViewById(R.id.yr); wk = view.findViewById(R.id.wk); dy = view.findViewById(R.id.dy); hr = view.findViewById(R.id.hr);
        min = view.findViewById(R.id.min); sec = view.findViewById(R.id.sec); ms = view.findViewById(R.id.ms); us = view.findViewById(R.id.us);
        ps = view.findViewById(R.id.ps);

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

                if(TimeFrag.unit1clicked) {
                    TimeFrag.unit1.setText(small);
                    TimeFrag.ack1.setText(large);
                    updateopr();
                }
                else if(TimeFrag.unit2clicked) {
                    TimeFrag.unit2.setText(small);
                    TimeFrag.ack2.setText(large);
                    updateopr();
                }
                TimeFrag.tuDrawer.dismiss();
            }
        };

        yr.setOnClickListener(myclick); wk.setOnClickListener(myclick); dy.setOnClickListener(myclick); hr.setOnClickListener(myclick);
        min.setOnClickListener(myclick); sec.setOnClickListener(myclick); ms.setOnClickListener(myclick); us.setOnClickListener(myclick);
                                                        ps.setOnClickListener(myclick);

        return view;
    }

    double oprnd1, oprnd2;
    void updateopr() {
        String un1= TimeFrag.unit1.getText().toString(), un2=TimeFrag.unit2.getText().toString();
        oprnd1=TimeFrag.oprnd1; oprnd2=TimeFrag.oprnd2;
        if(un1.equals("yr")) oprnd2 = oprnd1 * 8760;
        else if(un1.equals("wk")) oprnd2 = oprnd1 * 168;
        else if(un1.equals("dy")) oprnd2 = oprnd1 * 24;
        else if(un1.equals("min")) oprnd2 = oprnd1 / 60;
        else if(un1.equals("sec")) oprnd2 = oprnd1 / 3600;
        else if(un1.equals("ms")) oprnd2 = oprnd1 / 3600000;
        else if(un1.equals("µs")) oprnd2 = oprnd1 / 3600000000d;
        else if(un1.equals("ps")) oprnd2 = oprnd1 / 3600000000000000d;
        else oprnd2 = oprnd1;
        ifelse(un1,un2);
        TimeFrag.output = Double.toString(oprnd2);
        String backup=TimeFrag.output;
        int comac=3;
        for(int i=TimeFrag.output.length()-1; i>=0; i--) {
            if(backup.charAt(i)=='.') { backup = TimeFrag.output; comac=3; continue; }
            if(comac==0) {
                backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                comac=3;
            }
            comac--;
        }
        TimeFrag.bycalc.setText(backup);
    }
    void ifelse(String un1, String un2) {
        if(un2.equals("yr")) oprnd2 = oprnd2 / 8760;
        else if(un2.equals("wk")) oprnd2 = oprnd2 / 168;
        else if(un2.equals("dy")) oprnd2 = oprnd2 / 24;
        else if(un2.equals("min")) oprnd2 = oprnd2 * 60;
        else if(un2.equals("sec")) oprnd2 = oprnd2 * 3600;
        else if(un2.equals("ms")) oprnd2 = oprnd2 * 3600000;
        else if(un2.equals("µs")) oprnd2 = oprnd2 * 3600000000d;
        else if(un2.equals("ps")) oprnd2 = oprnd2 * 3600000000000000d;
        else oprnd2 = oprnd2;
    }
}
