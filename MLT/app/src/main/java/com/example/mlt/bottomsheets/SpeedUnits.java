package com.example.mlt.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mlt.R;
import com.example.mlt.fragments.SpeedFrag;
import com.example.mlt.fragments.SpeedFrag;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SpeedUnits extends BottomSheetDialogFragment {

    TextView c, ma, mps, kmph, kmps, kn, mph, fps, ips;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.speed_units, container, false);

        c = view.findViewById(R.id.c); ma = view.findViewById(R.id.ma); mps = view.findViewById(R.id.mps); kmph = view.findViewById(R.id.kmph);
        kmps = view.findViewById(R.id.kmps); kn = view.findViewById(R.id.kn); mph = view.findViewById(R.id.mph); fps = view.findViewById(R.id.fps);
        ips = view.findViewById(R.id.ips);

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

                if(SpeedFrag.unit1clicked) {
                    SpeedFrag.unit1.setText(small);
                    SpeedFrag.ack1.setText(large);
                    updateopr();
                }
                else if(SpeedFrag.unit2clicked) {
                    SpeedFrag.unit2.setText(small);
                    SpeedFrag.ack2.setText(large);
                    updateopr();
                }
                SpeedFrag.suDrawer.dismiss();
            }
        };

        c.setOnClickListener(myclick); ma.setOnClickListener(myclick); mps.setOnClickListener(myclick); kmph.setOnClickListener(myclick);
        kmps.setOnClickListener(myclick); kn.setOnClickListener(myclick); mph.setOnClickListener(myclick); fps.setOnClickListener(myclick);
                                                        ips.setOnClickListener(myclick);

        return view;
    }

    double oprnd1, oprnd2;
    void updateopr() {
        String un1= SpeedFrag.unit1.getText().toString(), un2=SpeedFrag.unit2.getText().toString();
        oprnd1=SpeedFrag.oprnd1; oprnd2=SpeedFrag.oprnd2;
        if(un1.equals("c")) oprnd2 = oprnd1 * 1079252848.8;
        else if(un1.equals("ma")) oprnd2 = oprnd1 * 1225.08;
        else if(un1.equals("m/s")) oprnd2 = oprnd1 * 3.6;
        else if(un1.equals("km/s")) oprnd2 = oprnd1 * 3600;
        else if(un1.equals("kn")) oprnd2 = oprnd1 * 1.852;
        else if(un1.equals("mph")) oprnd2 = oprnd1 * 1.609344;
        else if(un1.equals("fps")) oprnd2 = oprnd1 * 1.09728;
        else if(un1.equals("ips")) oprnd2 = oprnd1 / 10.936133;
        else oprnd2 = oprnd1;
        ifelse(un1,un2);
        SpeedFrag.output = Double.toString(oprnd2);
        String backup=SpeedFrag.output;
        int comac=3;
        for(int i=SpeedFrag.output.length()-1; i>=0; i--) {
            if(backup.charAt(i)=='.') { backup = SpeedFrag.output; comac=3; continue; }
            if(comac==0) {
                backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                comac=3;
            }
            comac--;
        }
        SpeedFrag.bycalc.setText(backup);
    }
    void ifelse(String un1, String un2) {
        if(un2.equals("c")) oprnd2 = oprnd2 / 1079252848.8;
        else if(un2.equals("ma")) oprnd2 = oprnd2 / 1225.08;
        else if(un2.equals("m/s")) oprnd2 = oprnd2 / 3.6;
        else if(un2.equals("km/s")) oprnd2 = oprnd2 / 3600;
        else if(un2.equals("kn")) oprnd2 = oprnd2 / 1.852;
        else if(un2.equals("mph")) oprnd2 = oprnd2 / 1.609344;
        else if(un2.equals("fps")) oprnd2 = oprnd2 / 1.09728;
        else if(un2.equals("ips")) oprnd2 = oprnd2 * 10.936133;
        else oprnd2 = oprnd2;
    }
}
