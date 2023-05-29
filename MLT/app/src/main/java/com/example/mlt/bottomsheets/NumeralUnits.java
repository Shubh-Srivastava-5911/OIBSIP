package com.example.mlt.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mlt.R;
import com.example.mlt.fragments.NumeralFrag;
import com.example.mlt.fragments.NumeralFrag;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class NumeralUnits extends BottomSheetDialogFragment {

    TextView bin, dec, oct, hex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.numeral_units, container, false);

        bin = view.findViewById(R.id.bin); dec = view.findViewById(R.id.dec); oct = view.findViewById(R.id.oct); hex = view.findViewById(R.id.hex);

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

                if(NumeralFrag.unit1clicked) {
                    NumeralFrag.unit1.setText(small);
                    NumeralFrag.ack1.setText(large);
                    if(small.equals("HEX")) {
                        NumeralFrag.one.setEnabled(true);
                        NumeralFrag.two.setEnabled(true);
                        NumeralFrag.three.setEnabled(true);
                        NumeralFrag.four.setEnabled(true);
                        NumeralFrag.five.setEnabled(true);
                        NumeralFrag.six.setEnabled(true);
                        NumeralFrag.seven.setEnabled(true);
                        NumeralFrag.eight.setEnabled(true);
                        NumeralFrag.nine.setEnabled(true);
                        NumeralFrag.zero.setEnabled(true);
                        NumeralFrag.point.setEnabled(true);
                        NumeralFrag.a.setEnabled(true);
                        NumeralFrag.b.setEnabled(true);
                        NumeralFrag.c.setEnabled(true);
                        NumeralFrag.d.setEnabled(true);
                        NumeralFrag.e.setEnabled(true);
                        NumeralFrag.f.setEnabled(true);
                    } else if(small.equals("BIN")){
                        NumeralFrag.one.setEnabled(true);
                        NumeralFrag.two.setEnabled(false);
                        NumeralFrag.three.setEnabled(false);
                        NumeralFrag.four.setEnabled(false);
                        NumeralFrag.five.setEnabled(false);
                        NumeralFrag.six.setEnabled(false);
                        NumeralFrag.seven.setEnabled(false);
                        NumeralFrag.eight.setEnabled(false);
                        NumeralFrag.nine.setEnabled(false);
                        NumeralFrag.zero.setEnabled(true);
                        NumeralFrag.point.setEnabled(true);
                        NumeralFrag.a.setEnabled(false);
                        NumeralFrag.b.setEnabled(false);
                        NumeralFrag.c.setEnabled(false);
                        NumeralFrag.d.setEnabled(false);
                        NumeralFrag.e.setEnabled(false);
                        NumeralFrag.f.setEnabled(false);
                    } else if(small.equals("OCT")) {
                        NumeralFrag.one.setEnabled(true);
                        NumeralFrag.two.setEnabled(true);
                        NumeralFrag.three.setEnabled(true);
                        NumeralFrag.four.setEnabled(true);
                        NumeralFrag.five.setEnabled(true);
                        NumeralFrag.six.setEnabled(true);
                        NumeralFrag.seven.setEnabled(true);
                        NumeralFrag.eight.setEnabled(false);
                        NumeralFrag.nine.setEnabled(false);
                        NumeralFrag.zero.setEnabled(true);
                        NumeralFrag.point.setEnabled(true);
                        NumeralFrag.a.setEnabled(false);
                        NumeralFrag.b.setEnabled(false);
                        NumeralFrag.c.setEnabled(false);
                        NumeralFrag.d.setEnabled(false);
                        NumeralFrag.e.setEnabled(false);
                        NumeralFrag.f.setEnabled(false);
                    } else {
                        NumeralFrag.one.setEnabled(true);
                        NumeralFrag.two.setEnabled(true);
                        NumeralFrag.three.setEnabled(true);
                        NumeralFrag.four.setEnabled(true);
                        NumeralFrag.five.setEnabled(true);
                        NumeralFrag.six.setEnabled(true);
                        NumeralFrag.seven.setEnabled(true);
                        NumeralFrag.eight.setEnabled(true);
                        NumeralFrag.nine.setEnabled(true);
                        NumeralFrag.zero.setEnabled(true);
                        NumeralFrag.point.setEnabled(true);
                        NumeralFrag.a.setEnabled(false);
                        NumeralFrag.b.setEnabled(false);
                        NumeralFrag.c.setEnabled(false);
                        NumeralFrag.d.setEnabled(false);
                        NumeralFrag.e.setEnabled(false);
                        NumeralFrag.f.setEnabled(false);
                    }

                }
                else if(NumeralFrag.unit2clicked) {
                    NumeralFrag.unit2.setText(small);
                    NumeralFrag.ack2.setText(large);
                }
                NumeralFrag.bycalc.setText("0");
                NumeralFrag.byuser.setText("0");
                NumeralFrag.input="0";
                NumeralFrag.output="0";
                NumeralFrag.oprnd1="0";
                NumeralFrag.oprnd2="0";
                updateopr();
                NumeralFrag.nuDrawer.dismiss();
            }
        };

        bin.setOnClickListener(myclick); dec.setOnClickListener(myclick); oct.setOnClickListener(myclick); hex.setOnClickListener(myclick);

        return view;
    }

    String oprnd1, oprnd2;
    void updateopr() {
        String un1= NumeralFrag.unit1.getText().toString(), un2=NumeralFrag.unit2.getText().toString();
        oprnd1=NumeralFrag.oprnd1; oprnd2=NumeralFrag.oprnd2;
        if(un1.equals("BIN")) oprnd2 = binaryTOdecimal(oprnd1);
        else if(un1.equals("HEX")) oprnd2 = hexadecimalTOdecimal(oprnd1);
        else if(un1.equals("OCT")) oprnd2 = octalTOdecimal(oprnd1);
        else oprnd2 = oprnd1;
        ifelse(un1,un2);
        NumeralFrag.output = (oprnd2);
        NumeralFrag.bycalc.setText(NumeralFrag.output);
    }
    void ifelse(String un1, String un2) {
        if(un2.equals("BIN")) oprnd2 = decimalTObinary(oprnd2);
        else if(un2.equals("HEX")) oprnd2 = decimalTOhexadecimal(oprnd2);
        else if(un2.equals("OCT")) oprnd2 = decimalTOoctal(oprnd2);
        else oprnd2 = oprnd2;
    }

    String binaryTOdecimal(String bin) {
        String dec="";
        double ans=0;
        String pointleft = bin, pointright = "";
        if(bin.contains(".")) {
            pointleft = bin.substring(0,bin.indexOf('.'));
            if(bin.indexOf('.')+1!=bin.length()) pointright = bin.substring(bin.indexOf('.')+1);
        }
        int p=0;
        for(int i=pointleft.length()-1; i>=0; i--) {
            ans += Double.parseDouble(pointleft.charAt(i)+"") * Math.pow(2,p);
            p++;
        }
        p=-1;
        for(int i=0; i<pointright.length(); i++) {
            ans += Double.parseDouble(pointright.charAt(i)+"") * Math.pow(2,p);
            p--;
        }
        dec = Double.toString(ans);
        return dec.isEmpty()?"0":dec;
    }
    String hexadecimalTOdecimal(String hex) {
        String dec="";
        double ans=0;
        String pointleft = hex, pointright = "";
        if(hex.contains(".")) {
            pointleft = hex.substring(0,hex.indexOf('.'));
            if(hex.indexOf('.')+1!=hex.length()) pointright = hex.substring(hex.indexOf('.')+1);
        }
        int p=0;
        for(int i=pointleft.length()-1; i>=0; i--) {
            String toparse = pointleft.charAt(i)+"";
            if(toparse.equals("A")) toparse="10";
            if(toparse.equals("B")) toparse="11";
            if(toparse.equals("C")) toparse="12";
            if(toparse.equals("D")) toparse="13";
            if(toparse.equals("E")) toparse="14";
            if(toparse.equals("F")) toparse="15";
            ans += Double.parseDouble(toparse) * Math.pow(16,p);
            p++;
        }
        p=-1;
        for(int i=0; i<pointright.length(); i++) {
            String toparse = pointright.charAt(i)+"";
            if(toparse.equals("A")) toparse="10";
            if(toparse.equals("B")) toparse="11";
            if(toparse.equals("C")) toparse="12";
            if(toparse.equals("D")) toparse="13";
            if(toparse.equals("E")) toparse="14";
            if(toparse.equals("F")) toparse="15";
            ans += Double.parseDouble(toparse) * Math.pow(16,p);
            p--;
        }
        dec = Double.toString(ans);
        return dec.isEmpty()?"0":dec;
    }
    String octalTOdecimal(String oct) {
        String dec="";
        double ans=0;
        String pointleft = oct, pointright = "";
        if(oct.contains(".")) {
            pointleft = oct.substring(0,oct.indexOf('.'));
            if(oct.indexOf('.')+1!=oct.length()) pointright = oct.substring(oct.indexOf('.')+1);
        }
        int p=0;
        for(int i=pointleft.length()-1; i>=0; i--) {
            ans += Double.parseDouble(pointleft.charAt(i)+"") * Math.pow(8,p);
            p++;
        }
        p=-1;
        for(int i=0; i<pointright.length(); i++) {
            ans += Double.parseDouble(pointright.charAt(i)+"") * Math.pow(8,p);
            p--;
        }
        dec = Double.toString(ans);
        return dec.isEmpty()?"0":dec;
    }
    String decimalTObinary(String dec) {
        String bin="";
        String pointleft = dec, pointright = "";
        if(dec.contains(".")) {
            pointleft = dec.substring(0,dec.indexOf('.'));
            if(dec.indexOf('.')+1!=dec.length()) pointright = dec.substring(dec.indexOf('.')+1);
        }
        double temp1 = Double.parseDouble(pointleft);
        while (temp1>0) {
            int rem = (int)(temp1 % 2);
            temp1 /= 2;
            temp1 = (int)temp1;
            bin = rem + bin;
        }
        if(!pointright.equals("")) {
            pointright = "0."+pointright;
            double temp2 = Double.parseDouble(pointright);
            if(temp2!=0) bin = bin+".";
            int count=5;
            while(count>0 && temp2!=0) {
                temp2 *= 2;
                bin += ""+(int)temp2;
                if(temp2>=1) temp2-=1;
                count--;
            }
        }
        return bin.isEmpty()?"0":bin;
    }
    String decimalTOhexadecimal(String dec) {
        String hex="";
        String pointleft = dec, pointright = "";
        if(dec.contains(".")) {
            pointleft = dec.substring(0,dec.indexOf('.'));
            if(dec.indexOf('.')+1!=dec.length()) pointright = dec.substring(dec.indexOf('.')+1);
        }
        double temp1 = Double.parseDouble(pointleft);
        while (temp1>0) {
            int rem = (int)(temp1 % 16);
            temp1 /= 16;
            temp1 = (int)temp1;
            String toadd = rem+"";
            if(rem==10) toadd = "A";
            if(rem==11) toadd = "B";
            if(rem==12) toadd = "C";
            if(rem==13) toadd = "D";
            if(rem==14) toadd = "E";
            if(rem==15) toadd = "F";
            hex = toadd + hex;
        }
        if(!pointright.equals("")) {
            pointright = "0."+pointright;
            double temp2 = Double.parseDouble(pointright);
            if(temp2!=0) hex = hex+".";
            int count=5;
            while(count>0 && temp2!=0) {
                temp2 *= 16;
                int t2 = (int)temp2;
                String toadd = t2+"";
                if(t2==10) toadd = "A";
                if(t2==11) toadd = "B";
                if(t2==12) toadd = "C";
                if(t2==13) toadd = "D";
                if(t2==14) toadd = "E";
                if(t2==15) toadd = "F";
                hex += toadd;
                String pointafter = Double.toString(temp2);
                pointafter = pointafter.substring(pointafter.indexOf('.')+1);
                pointafter = "0."+pointafter;
                temp2 = Double.parseDouble(pointafter);
                count--;
            }
        }
        return hex.isEmpty()?"0":hex;
    }
    String decimalTOoctal(String dec) {
        String oct="";
        String pointleft = dec, pointright = "";
        if(dec.contains(".")) {
            pointleft = dec.substring(0,dec.indexOf('.'));
            if(dec.indexOf('.')+1!=dec.length()) pointright = dec.substring(dec.indexOf('.')+1);
        }
        double temp1 = Double.parseDouble(pointleft);
        while (temp1>0) {
            int rem = (int)(temp1 % 8);
            temp1 /= 8;
            temp1 = (int)temp1;
            oct = rem + oct;
        }
        if(!pointright.equals("")) {
            pointright = "0."+pointright;
            double temp2 = Double.parseDouble(pointright);
            if(temp2!=0) oct = oct+".";
            int count=5;
            while(count>0 && temp2!=0) {
                temp2 *= 8;
                oct += ""+(int)temp2;
                String pointafter = Double.toString(temp2);
                pointafter = pointafter.substring(pointafter.indexOf('.')+1);
                pointafter = "0."+pointafter;
                temp2 = Double.parseDouble(pointafter);
                count--;
            }
        }
        return oct.isEmpty()?"0":oct;
    }
}
