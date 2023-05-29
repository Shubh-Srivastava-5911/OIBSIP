package com.example.mlt.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mlt.R;
import com.example.mlt.fragments.AreaFrag;
import com.example.mlt.fragments.AreaFrag;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AreaUnits extends BottomSheetDialogFragment {
    TextView kmsq, ha, a, msq, dmsq, cmsq, mmsq, umsq, ac, misq, ydsq, ftsq, insq, rdsq, qg, mu, chisq, cunsq, gngsq;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.area_units,container,false);

        kmsq = view.findViewById(R.id.kmsq); ha = view.findViewById(R.id.ha);
        a = view.findViewById(R.id.a); msq = view.findViewById(R.id.msq);
        dmsq = view.findViewById(R.id.dmsq); cmsq = view.findViewById(R.id.cmsq);
        mmsq = view.findViewById(R.id.mmsq); umsq = view.findViewById(R.id.umsq);
        ac = view.findViewById(R.id.ac); misq = view.findViewById(R.id.misq);
        ydsq = view.findViewById(R.id.ydsq); ftsq = view.findViewById(R.id.ftsq);
        insq = view.findViewById(R.id.insq); rdsq = view.findViewById(R.id.rdsq);
        qg = view.findViewById(R.id.qg); mu = view.findViewById(R.id.mu);
        chisq = view.findViewById(R.id.chisq); cunsq = view.findViewById(R.id.cunsq);
        gngsq = view.findViewById(R.id.gngsq);

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

                if(AreaFrag.unit1clicked) {
                    AreaFrag.unit1.setText(small);
                    AreaFrag.ack1.setText(large);
                    updateopr();
                }
                else if(AreaFrag.unit2clicked) {
                    AreaFrag.unit2.setText(small);
                    AreaFrag.ack2.setText(large);
                    updateopr();
                }
                AreaFrag.auDrawer.dismiss();
            }
        };

        kmsq.setOnClickListener(myclick); ha.setOnClickListener(myclick);
        a.setOnClickListener(myclick); msq.setOnClickListener(myclick);
        dmsq.setOnClickListener(myclick); cmsq.setOnClickListener(myclick);
        mmsq.setOnClickListener(myclick); umsq.setOnClickListener(myclick);
        ac.setOnClickListener(myclick); misq.setOnClickListener(myclick);
        ydsq.setOnClickListener(myclick); ftsq.setOnClickListener(myclick);
        insq.setOnClickListener(myclick); rdsq.setOnClickListener(myclick);
        qg.setOnClickListener(myclick); mu.setOnClickListener(myclick);
        chisq.setOnClickListener(myclick); cunsq.setOnClickListener(myclick);
                        gngsq.setOnClickListener(myclick);

        return view;
    }

    double oprnd1, oprnd2;
    void updateopr() {
        String un1=AreaFrag.unit1.getText().toString(), un2=AreaFrag.unit2.getText().toString();
        oprnd1=AreaFrag.oprnd1; oprnd2=AreaFrag.oprnd2;
        if(un1.equals("ha")) oprnd2 = oprnd1 / 100;
        else if(un1.equals("a")) oprnd2 = oprnd1 / 10000;
        else if(un1.equals("m²")) oprnd2 = oprnd1 / 1000000;
        else if(un1.equals("dm²")) oprnd2 = oprnd1 / 100000000;
        else if(un1.equals("cm²")) oprnd2 = oprnd1 / 10000000000d;
        else if(un1.equals("mm²")) oprnd2 = oprnd1 / 1000000000000d;
        else if(un1.equals("µm²")) oprnd2 = oprnd1 / 1000000000000000000d;
        else if(un1.equals("ac")) oprnd2 = oprnd1 / 247.105407;
        else if(un1.equals("mi²")) oprnd2 = oprnd1 * 2.58998811;
        else if(un1.equals("yd²")) oprnd2 = oprnd1 / 1195990.05;
        else if(un1.equals("ft²")) oprnd2 = oprnd1 / 10763910.4;
        else if(un1.equals("in²")) oprnd2 = oprnd1 / 1550003100.0062;
        else if(un1.equals("rd²")) oprnd2 = oprnd1 / 39536.861;
        else if(un1.equals("qg")) oprnd2 = oprnd1 / 15;
        else if(un1.equals("mu")) oprnd2 = oprnd1 / 1500;
        else if(un1.equals("chi²")) oprnd2 = oprnd1 / 9000000;
        else if(un1.equals("cun²")) oprnd2 = oprnd1 / 900000000;
        else if(un1.equals("gng²")) oprnd2 = oprnd1;
        else oprnd2 = oprnd1;
        ifelse(un1,un2);
        AreaFrag.output = Double.toString(oprnd2);
        String backup=AreaFrag.output;
        int comac=3;
        for(int i=AreaFrag.output.length()-1; i>=0; i--) {
            if(backup.charAt(i)=='.') { backup = AreaFrag.output; comac=3; continue; }
            if(comac==0) {
                backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                comac=3;
            }
            comac--;
        }
        AreaFrag.bycalc.setText(backup);
    }
    void ifelse(String un1, String un2) {
        if(un2.equals("ha")) oprnd2 = oprnd2 * 100;
        else if(un2.equals("a")) oprnd2 = oprnd2 * 10000;
        else if(un2.equals("m²")) oprnd2 = oprnd2 * 1000000;
        else if(un2.equals("dm²")) oprnd2 = oprnd2 * 100000000;
        else if(un2.equals("cm²")) oprnd2 = oprnd2 * 10000000000d;
        else if(un2.equals("mm²")) oprnd2 = oprnd2 * 1000000000000d;
        else if(un2.equals("µm²")) oprnd2 = oprnd2 * 1000000000000000000d;
        else if(un2.equals("ac")) oprnd2 = oprnd2 * 247.105407;
        else if(un2.equals("mi²")) oprnd2 = oprnd2 / 2.58998811;
        else if(un2.equals("yd²")) oprnd2 = oprnd2 * 1195990.05;
        else if(un2.equals("ft²")) oprnd2 = oprnd2 * 10763910.4;
        else if(un2.equals("in²")) oprnd2 = oprnd2 * 1550003100.0062;
        else if(un2.equals("rd²")) oprnd2 = oprnd2 * 39536.861;
        else if(un2.equals("qg")) oprnd2 = oprnd2 * 15;
        else if(un2.equals("mu")) oprnd2 = oprnd2 * 1500;
        else if(un2.equals("chi²")) oprnd2 = oprnd2 * 9000000;
        else if(un2.equals("cun²")) oprnd2 = oprnd2 * 900000000;
        else if(un2.equals("gng²")) oprnd2 = oprnd2;
        else oprnd2 = oprnd2;
    }
}
