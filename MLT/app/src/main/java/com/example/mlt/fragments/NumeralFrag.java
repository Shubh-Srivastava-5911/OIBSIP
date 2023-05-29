package com.example.mlt.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mlt.R;
import com.example.mlt.bottomsheets.NumeralUnits;

public class NumeralFrag extends Fragment {

    public static TextView unit1, unit2, ack1, ack2, byuser, bycalc;
    public static boolean unit1clicked, unit2clicked;
    public static TextView point, zero, one, two, three, four, five, six, seven, eight, nine;
    TextView ac, x;
    public static TextView a, b, c, d, e, f;

    public static NumeralUnits nuDrawer = new NumeralUnits();

    public static String input="5", output="101";
    public static String oprnd1="5", oprnd2="101";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.numeral_frag, container, false);

        unit1 = view.findViewById(R.id.unit1);
        unit2 = view.findViewById(R.id.unit2);
        ack1 = view.findViewById(R.id.ack1);
        ack2 = view.findViewById(R.id.ack2);
        byuser = view.findViewById(R.id.byuser);
        bycalc = view.findViewById(R.id.bycalc);
        point = view.findViewById(R.id.point);
        zero = view.findViewById(R.id.zero);
        one = view.findViewById(R.id.one);
        two = view.findViewById(R.id.two);
        three = view.findViewById(R.id.three);
        four = view.findViewById(R.id.four);
        five = view.findViewById(R.id.five);
        six = view.findViewById(R.id.six);
        seven = view.findViewById(R.id.seven);
        eight = view.findViewById(R.id.eight);
        nine = view.findViewById(R.id.nine);
        ac = view.findViewById(R.id.ac);
        x = view.findViewById(R.id.x);
        a = view.findViewById(R.id.a);
        b = view.findViewById(R.id.b);
        c = view.findViewById(R.id.c);
        d = view.findViewById(R.id.d);
        e = view.findViewById(R.id.e);
        f = view.findViewById(R.id.f);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()>15) return;
                if(input.equals("0")) input = "1";
                else input += "1";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "2";
                else input += "2";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "3";
                else input += "3";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "4";
                else input += "4";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "5";
                else input += "5";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "6";
                else input += "6";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "7";
                else input += "7";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "8";
                else input += "8";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "9";
                else input += "9";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) return;
                input += "0";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.contains(".")) return;
                input += ".";
                byuser.setText(input);
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = input.substring(0,input.length()-1);
                if(input.isEmpty()) input="0";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byuser.setText("0");
                bycalc.setText("0");
                input="0";
                oprnd1 = (input);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "A";
                else input += "A";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "B";
                else input += "B";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "C";
                else input += "C";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "D";
                else input += "D";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "E";
                else input += "E";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "F";
                else input += "F";
                oprnd1 = (input);
                byuser.setText(input);
            }
        });

        byuser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                String un1=unit1.getText().toString(), un2=unit2.getText().toString();
                if(un1.equals("BIN")) oprnd2 = binaryTOdecimal(oprnd1);
                else if(un1.equals("HEX")) oprnd2 = hexadecimalTOdecimal(oprnd1);
                else if(un1.equals("OCT")) oprnd2 = octalTOdecimal(oprnd1);
                else oprnd2 = oprnd1;
                ifelse(un1,un2);
                output = (oprnd2);
                bycalc.setText(output);
            }
        });

        unit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuDrawer.show(getActivity().getSupportFragmentManager(), nuDrawer.getTag());
                unit1clicked=true; unit2clicked=false;
            }
        });
        unit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuDrawer.show(getActivity().getSupportFragmentManager(), nuDrawer.getTag());
                unit2clicked=true; unit1clicked=false;
            }
        });

        return view;
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

    @Override
    public void onResume() {
        super.onResume();
        input = byuser.getText().toString().replace(",","");
        output = bycalc.getText().toString().replace(",","");
    }

    @Override
    public void onStart() {
        super.onStart();
        unit1.setText("DEC");
        unit2.setText("BIN");
        ack1.setText("Decimal");
        ack2.setText("Binary");
        byuser.setText("5");
        bycalc.setText("101");
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
