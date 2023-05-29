package com.example.mlt.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mlt.R;
import com.example.mlt.fragments.VolumeFrag;
import com.example.mlt.fragments.VolumeFrag;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class VolumeUnits extends BottomSheetDialogFragment {

    TextView mc, dmc, cmc, mmc, hl, l, dl, cl, ml, ftc, inc, ydc, acf;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.volume_units, container, false);

        mc = view.findViewById(R.id.mc); dmc = view.findViewById(R.id.dmc); cmc = view.findViewById(R.id.cmc);
        mmc = view.findViewById(R.id.mmc); hl = view.findViewById(R.id.hl); l = view.findViewById(R.id.l);
        dl = view.findViewById(R.id.dl); cl = view.findViewById(R.id.cl); ml = view.findViewById(R.id.ml);
        ftc = view.findViewById(R.id.ftc); inc = view.findViewById(R.id.inc); ydc = view.findViewById(R.id.ydc);
        acf = view.findViewById(R.id.acf);

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

                if(VolumeFrag.unit1clicked) {
                    VolumeFrag.unit1.setText(small);
                    VolumeFrag.ack1.setText(large);
                    updateopr();
                }
                else if(VolumeFrag.unit2clicked) {
                    VolumeFrag.unit2.setText(small);
                    VolumeFrag.ack2.setText(large);
                    updateopr();
                }
                VolumeFrag.vuDrawer.dismiss();
            }
        };

        mc.setOnClickListener(myclick); dmc.setOnClickListener(myclick); cmc.setOnClickListener(myclick); mmc.setOnClickListener(myclick);
        hl.setOnClickListener(myclick); l.setOnClickListener(myclick); dl.setOnClickListener(myclick); cl.setOnClickListener(myclick);
        ml.setOnClickListener(myclick); ftc.setOnClickListener(myclick); inc.setOnClickListener(myclick); ydc.setOnClickListener(myclick);
                                                        acf.setOnClickListener(myclick);

        return view;
    }

    double oprnd1, oprnd2;
    void updateopr() {
        String un1= VolumeFrag.unit1.getText().toString(), un2=VolumeFrag.unit2.getText().toString();
        oprnd1=VolumeFrag.oprnd1; oprnd2=VolumeFrag.oprnd2;
        if(un1.equals("dm³")) oprnd2 = oprnd1 / 1000;
        else if(un1.equals("cm³")) oprnd2 = oprnd1 / 1000000;
        else if(un1.equals("mm³")) oprnd2 = oprnd1 / 1000000000;
        else if(un1.equals("hl")) oprnd2 = oprnd1 / 10;
        else if(un1.equals("l")) oprnd2 = oprnd1 / 1000;
        else if(un1.equals("dl")) oprnd2 = oprnd1 / 10000;
        else if(un1.equals("cl")) oprnd2 = oprnd1 / 100000;
        else if(un1.equals("ml")) oprnd2 = oprnd1 / 1000000;
        else if(un1.equals("ft³")) oprnd2 = oprnd1 / 35.3146667;
        else if(un1.equals("in³")) oprnd2 = oprnd1 / 61023.7441;
        else if(un1.equals("yd³")) oprnd2 = oprnd1 / 1.30795062;
        else if(un1.equals("af³")) oprnd2 = oprnd1 * 1234;
        else oprnd2 = oprnd1;
        ifelse(un1,un2);
        VolumeFrag.output = Double.toString(oprnd2);
        String backup=VolumeFrag.output;
        int comac=3;
        for(int i=VolumeFrag.output.length()-1; i>=0; i--) {
            if(backup.charAt(i)=='.') { backup = VolumeFrag.output; comac=3; continue; }
            if(comac==0) {
                backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                comac=3;
            }
            comac--;
        }
        VolumeFrag.bycalc.setText(backup);
    }
    void ifelse(String un1, String un2) {
        if(un2.equals("dm³")) oprnd2 = oprnd1 * 1000;
        else if(un2.equals("cm³")) oprnd2 = oprnd2 * 1000000;
        else if(un2.equals("mm³")) oprnd2 = oprnd2 * 1000000000;
        else if(un2.equals("hl")) oprnd2 = oprnd2 * 10;
        else if(un2.equals("l")) oprnd2 = oprnd2 * 1000;
        else if(un2.equals("dl")) oprnd2 = oprnd2 * 10000;
        else if(un2.equals("cl")) oprnd2 = oprnd2 * 100000;
        else if(un2.equals("ml")) oprnd2 = oprnd2 * 1000000;
        else if(un2.equals("ft³")) oprnd2 = oprnd2 * 35.3146667;
        else if(un2.equals("in³")) oprnd2 = oprnd2 * 61023.7441;
        else if(un2.equals("yd³")) oprnd2 = oprnd2 * 1.30795062;
        else if(un2.equals("af³")) oprnd2 = oprnd2 / 1234;
        else oprnd2 = oprnd2;
    }
}

