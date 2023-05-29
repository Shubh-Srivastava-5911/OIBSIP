package com.example.mlt.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mlt.R;
import com.example.mlt.fragments.DataFrag;
import com.example.mlt.fragments.LengthFrag;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class LengthUnits extends BottomSheetDialogFragment {

    TextView km, m, dm, cm, mm, um, nm, pm, nmi, mi, fur, ftm, yd, ft, in, gng, li, zh, chi, cun, fen, lii, hao, pc, ld, au, ly;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.length_units, container, false);

        km = view.findViewById(R.id.km); m = view.findViewById(R.id.m); dm = view.findViewById(R.id.dm);
        cm = view.findViewById(R.id.cm); mm = view.findViewById(R.id.mm); um = view.findViewById(R.id.um);
        nm = view.findViewById(R.id.nm); pm = view.findViewById(R.id.pm); nmi = view.findViewById(R.id.nmi);
        mi = view.findViewById(R.id.mi); fur = view.findViewById(R.id.fur); ftm = view.findViewById(R.id.ftm);
        yd = view.findViewById(R.id.yd); ft = view.findViewById(R.id.ft); in = view.findViewById(R.id.in);
        gng = view.findViewById(R.id.gng); li = view.findViewById(R.id.li); zh = view.findViewById(R.id.zh);
        chi = view.findViewById(R.id.chi); cun = view.findViewById(R.id.cun); fen = view.findViewById(R.id.fen);
        lii = view.findViewById(R.id.lii); hao = view.findViewById(R.id.hao); pc = view.findViewById(R.id.pc);
        ld = view.findViewById(R.id.ld); au = view.findViewById(R.id.au); ly = view.findViewById(R.id.ly);

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

                if(LengthFrag.unit1clicked) {
                    LengthFrag.unit1.setText(small);
                    LengthFrag.ack1.setText(large);
                    updateopr();
                }
                else if(LengthFrag.unit2clicked) {
                    LengthFrag.unit2.setText(small);
                    LengthFrag.ack2.setText(large);
                    updateopr();
                }
                LengthFrag.luDrawer.dismiss();
            }
        };

        km.setOnClickListener(myclick); m.setOnClickListener(myclick); dm.setOnClickListener(myclick);
        cm.setOnClickListener(myclick); mm.setOnClickListener(myclick); um.setOnClickListener(myclick);
        nm.setOnClickListener(myclick); pm.setOnClickListener(myclick); nmi.setOnClickListener(myclick);
        mi.setOnClickListener(myclick); fur.setOnClickListener(myclick); ftm.setOnClickListener(myclick);
        yd.setOnClickListener(myclick); ft.setOnClickListener(myclick); in.setOnClickListener(myclick);
        gng.setOnClickListener(myclick); li.setOnClickListener(myclick); zh.setOnClickListener(myclick);
        chi.setOnClickListener(myclick); cun.setOnClickListener(myclick); fen.setOnClickListener(myclick);
        lii.setOnClickListener(myclick); hao.setOnClickListener(myclick); pc.setOnClickListener(myclick);
        ld.setOnClickListener(myclick); au.setOnClickListener(myclick); ly.setOnClickListener(myclick);

        return view;
    }

    double oprnd1, oprnd2;
    void updateopr() {
        String un1=LengthFrag.unit1.getText().toString(), un2=LengthFrag.unit2.getText().toString();
        oprnd1=LengthFrag.oprnd1; oprnd2=LengthFrag.oprnd2;
        if(un1.equals("m")) oprnd2 = oprnd1 / 1000;
        else if(un1.equals("dm")) oprnd2 = oprnd1 / 10000;
        else if(un1.equals("cm")) oprnd2 = oprnd1 / 100000;
        else if(un1.equals("mm")) oprnd2 = oprnd1 / 1000000;
        else if(un1.equals("um")) oprnd2 = oprnd1 / 1000000000;
        else if(un1.equals("nm")) oprnd2 = oprnd1 / 1000000000000d;
        else if(un1.equals("pm")) oprnd2 = oprnd1 / 1000000000000000d;
        else if(un1.equals("nmi")) oprnd2 = oprnd1 * 1.852;
        else if(un1.equals("mi")) oprnd2 = oprnd1 * 1.609344;
        else if(un1.equals("fur")) oprnd2 = oprnd1 / 4.97096954;
        else if(un1.equals("ftm")) oprnd2 = oprnd1 / 546.806649;
        else if(un1.equals("yd")) oprnd2 = oprnd1 / 1093.6133;
        else if(un1.equals("ft")) oprnd2 = oprnd1 / 3280.8399;
        else if(un1.equals("in")) oprnd2 = oprnd1 / 39370.0787;
        else if(un1.equals("gng")) oprnd2 = oprnd1;
        else if(un1.equals("li")) oprnd2 = oprnd1 / 2;
        else if(un1.equals("zh")) oprnd2 = oprnd1 / 300;
        else if(un1.equals("chi")) oprnd2 = oprnd1 / 3000;
        else if(un1.equals("cun")) oprnd2 = oprnd1 / 30000;
        else if(un1.equals("fen")) oprnd2 = oprnd1 / 300000;
        else if(un1.equals("lii")) oprnd2 = oprnd1 / 3000000;
        else if(un1.equals("hao")) oprnd2 = oprnd1 / 30000000;
        else if(un1.equals("pc")) oprnd2 = oprnd1 * 30856775812800d;
        else if(un1.equals("ld")) oprnd2 = oprnd1 * 384401;
        else if(un1.equals("au")) oprnd2 = oprnd1 * 149597871;
        else if(un1.equals("ly")) oprnd2 = oprnd1 * 9460730472580d;
        else oprnd2 = oprnd1;
        ifelse(un1,un2);
        LengthFrag.output = Double.toString(oprnd2);
        String backup=LengthFrag.output;
        int comac=3;
        for(int i=LengthFrag.output.length()-1; i>=0; i--) {
            if(backup.charAt(i)=='.') { backup = LengthFrag.output; comac=3; continue; }
            if(comac==0) {
                backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                comac=3;
            }
            comac--;
        }
        LengthFrag.bycalc.setText(backup);
    }
    void ifelse(String un1, String un2) {
        if(un2.equals("m")) oprnd2 = oprnd2 * 1000;
        else if(un2.equals("dm")) oprnd2 = oprnd2 * 10000;
        else if(un2.equals("cm")) oprnd2 = oprnd2 * 100000;
        else if(un2.equals("mm")) oprnd2 = oprnd2 * 1000000;
        else if(un2.equals("um")) oprnd2 = oprnd2 * 1000000000;
        else if(un2.equals("nm")) oprnd2 = oprnd2 * 1000000000000d;
        else if(un2.equals("pm")) oprnd2 = oprnd2 * 1000000000000000d;
        else if(un2.equals("nmi")) oprnd2 = oprnd2 / 1.852;
        else if(un2.equals("mi")) oprnd2 = oprnd2 / 1.609344;
        else if(un2.equals("fur")) oprnd2 = oprnd2 * 4.97096954;
        else if(un2.equals("ftm")) oprnd2 = oprnd2 * 546.806649;
        else if(un2.equals("yd")) oprnd2 = oprnd2 * 1093.6133;
        else if(un2.equals("ft")) oprnd2 = oprnd2 * 3280.8399;
        else if(un2.equals("in")) oprnd2 = oprnd2 * 39370.0787;
        else if(un2.equals("gng")) oprnd2 = oprnd2;
        else if(un2.equals("li")) oprnd2 = oprnd2 * 2;
        else if(un2.equals("zh")) oprnd2 = oprnd2 * 300;
        else if(un2.equals("chi")) oprnd2 = oprnd2 * 3000;
        else if(un2.equals("cun")) oprnd2 = oprnd2 * 30000;
        else if(un2.equals("fen")) oprnd2 = oprnd2 * 300000;
        else if(un2.equals("lii")) oprnd2 = oprnd2 * 3000000;
        else if(un2.equals("hao")) oprnd2 = oprnd2 * 30000000;
        else if(un2.equals("pc")) oprnd2 = oprnd2 / 30856775812800d;
        else if(un2.equals("ld")) oprnd2 = oprnd2 / 384401;
        else if(un2.equals("au")) oprnd2 = oprnd2 / 149597871;
        else if(un2.equals("ly")) oprnd2 = oprnd2 / 9460730472580d;
        else { oprnd2 = oprnd2; }
    }
}
