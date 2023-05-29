package com.example.mlt.bottomsheets;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mlt.MainActivity;
import com.example.mlt.R;
import com.example.mlt.fragments.DataFrag;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class DataUnits extends BottomSheetDialogFragment {
    TextView b, kb, mb, gb, tb, pb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.data_units, container, false);

        b = view.findViewById(R.id.b);
        kb = view.findViewById(R.id.kb);
        mb = view.findViewById(R.id.mb);
        gb = view.findViewById(R.id.gb);
        tb = view.findViewById(R.id.tb);
        pb = view.findViewById(R.id.pb);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DataFrag.unit1clicked) {
                    DataFrag.unit1.setText("B");
                    DataFrag.ack1.setText("Byte");
                    updateopr();
                }
                else if(DataFrag.unit2clicked) {
                    DataFrag.unit2.setText("B");
                    DataFrag.ack2.setText("Byte");
                    updateopr();
                }
                DataFrag.duDrawer.dismiss();
            }
        });
        kb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DataFrag.unit1clicked) {
                    DataFrag.unit1.setText("KB");
                    DataFrag.ack1.setText("Kilobyte");
                    updateopr();
                }
                else if(DataFrag.unit2clicked) {
                    DataFrag.unit2.setText("KB");
                    DataFrag.ack2.setText("Kilobyte");
                    updateopr();
                }
                DataFrag.duDrawer.dismiss();
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DataFrag.unit1clicked) {
                    DataFrag.unit1.setText("MB");
                    DataFrag.ack1.setText("Megabyte");
                    updateopr();
                }
                else if(DataFrag.unit2clicked) {
                    DataFrag.unit2.setText("MB");
                    DataFrag.ack2.setText("Megabyte");
                    updateopr();
                }
                DataFrag.duDrawer.dismiss();
            }
        });
        gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DataFrag.unit1clicked) {
                    DataFrag.unit1.setText("GB");
                    DataFrag.ack1.setText("Gigabyte");
                    updateopr();
                }
                else if(DataFrag.unit2clicked) {
                    DataFrag.unit2.setText("GB");
                    DataFrag.ack2.setText("Gigabyte");
                    updateopr();
                }
                DataFrag.duDrawer.dismiss();
            }
        });
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DataFrag.unit1clicked) {
                    DataFrag.unit1.setText("TB");
                    DataFrag.ack1.setText("Terabyte");
                    updateopr();
                }
                else if(DataFrag.unit2clicked) {
                    DataFrag.unit2.setText("TB");
                    DataFrag.ack2.setText("Terabyte");
                    updateopr();
                }
                DataFrag.duDrawer.dismiss();
            }
        });
        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DataFrag.unit1clicked) {
                    DataFrag.unit1.setText("PB");
                    DataFrag.ack1.setText("Petabyte");
                    updateopr();
                }
                else if(DataFrag.unit2clicked) {
                    DataFrag.unit2.setText("PB");
                    DataFrag.ack2.setText("Petabyte");
                    updateopr();
                }
                DataFrag.duDrawer.dismiss();
            }
        });

        return view;
    }

    void updateopr()
    {
        String un1=DataFrag.unit1.getText().toString(), un2=DataFrag.unit2.getText().toString();
        double oprnd1=DataFrag.oprnd1, oprnd2=DataFrag.oprnd2;

        if(un1.equals("B")) {
            if(un2.equals("KB")) { oprnd2 = oprnd1 / 1024; }
            else if(un2.equals("MB")) { oprnd2 = oprnd1 / 1024 / 1024; }
            else if(un2.equals("GB")) { oprnd2 = oprnd1 / 1024 / 1024 / 1024; }
            else if(un2.equals("TB")) { oprnd2 = oprnd1 / 1024 / 1024 / 1024 / 1024; }
            else if(un2.equals("PB")) { oprnd2 = oprnd1 / 1024 / 1024 / 1024 / 1024 / 1024; }
            else { oprnd2 = oprnd1; }
        }
        if(un1.equals("KB")) {
            if(un2.equals("B")) { oprnd2 = oprnd1 * 1024; }
            else if(un2.equals("MB")) { oprnd2 = oprnd1 / 1024; }
            else if(un2.equals("GB")) { oprnd2 = oprnd1 / 1024 / 1024; }
            else if(un2.equals("TB")) { oprnd2 = oprnd1 / 1024 / 1024 / 1024; }
            else if(un2.equals("PB")) { oprnd2 = oprnd1 / 1024 / 1024 / 1024 / 1024; }
            else { oprnd2 = oprnd1; }
        }
        if(un1.equals("MB")) {
            if(un2.equals("B")) { oprnd2 = oprnd1 * 1024 * 1024; }
            else if(un2.equals("KB")) { oprnd2 = oprnd1 * 1024; }
            else if(un2.equals("GB")) { oprnd2 = oprnd1 / 1024; }
            else if(un2.equals("TB")) { oprnd2 = oprnd1 / 1024 / 1024; }
            else if(un2.equals("PB")) { oprnd2 = oprnd1 / 1024 / 1024 / 1024; }
            else { oprnd2 = oprnd1; }
        }
        if(un1.equals("GB")) {
            if(un2.equals("B")) { oprnd2 = oprnd1 * 1024 * 1024 * 1024; }
            else if(un2.equals("KB")) { oprnd2 = oprnd1 * 1024 * 1024; }
            else if(un2.equals("MB")) { oprnd2 = oprnd1 * 1024; }
            else if(un2.equals("TB")) { oprnd2 = oprnd1 / 1024; }
            else if(un2.equals("PB")) { oprnd2 = oprnd1 / 1024 / 1024; }
            else { oprnd2 = oprnd1; }
        }
        if(un1.equals("TB")) {
            if(un2.equals("B")) { oprnd2 = oprnd1 * 1024 * 1024 * 1024 * 1024; }
            else if(un2.equals("KB")) { oprnd2 = oprnd1 * 1024 * 1024 * 1024; }
            else if(un2.equals("MB")) { oprnd2 = oprnd1 * 1024 * 1024; }
            else if(un2.equals("GB")) { oprnd2 = oprnd1 * 1024; }
            else if(un2.equals("PB")) { oprnd2 = oprnd1 / 1024; }
            else { oprnd2 = oprnd1; }
        }
        if(un1.equals("PB")) {
            if(un2.equals("B")) { oprnd2 = oprnd1 * 1024 * 1024 * 1024 * 1024 * 1024; }
            else if(un2.equals("KB")) { oprnd2 = oprnd1 * 1024 * 1024 * 1024 * 1024; }
            else if(un2.equals("MB")) { oprnd2 = oprnd1 * 1024 * 1024 * 1024; }
            else if(un2.equals("GB")) { oprnd2 = oprnd1 * 1024 * 1024; }
            else if(un2.equals("TB")) { oprnd2 = oprnd1 * 1024; }
            else { oprnd2 = oprnd1; }
        }

        DataFrag.oprnd2=oprnd2;
        DataFrag.output = Double.toString(oprnd2);
        String backup=DataFrag.output;
        int comac=3;
        for(int i=DataFrag.output.length()-1; i>=0; i--) {
            if(backup.charAt(i)=='.') { backup = DataFrag.output; comac=3; continue; }
            if(comac==0) {
                backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                comac=3;
            }
            comac--;
        }
        DataFrag.bycalc.setText(backup);
    }
}
