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
import com.example.mlt.bottomsheets.TemperatureUnits;

public class TemperatureFrag extends Fragment {

    public static TextView unit1, unit2, ack1, ack2, byuser, bycalc;
    public static boolean unit1clicked, unit2clicked;
    TextView point, zero, one, two, three, four, five, six, seven, eight, nine;
    TextView ac, x, sign;

    public static TemperatureUnits tuDrawer = new TemperatureUnits();

    public static String input="1", output="33.8";
    public static double oprnd1=1, oprnd2=33.8;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.temperature_frag, container, false);

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
        sign = view.findViewById(R.id.sign);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()>15) return;
                if(input.equals("0")) input = "1";
                else input += "1";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "2";
                else input += "2";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "3";
                else input += "3";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "4";
                else input += "4";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "5";
                else input += "5";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "6";
                else input += "6";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "7";
                else input += "7";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "8";
                else input += "8";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) input = "9";
                else input += "9";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.equals("0")) return;
                input += "0";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.length()==15) return;
                if(input.contains(".")) return;
                input += ".";
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = input.substring(0,input.length()-1);
                if(input.isEmpty() || input.equals("-")) input="0";
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input="0";
                oprnd1 = Double.parseDouble(input);
                byuser.setText("0");
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.equals("0")) return;
                if(input.charAt(0)=='-') input = input.substring(1);
                else input = '-'+input;
                oprnd1 = Double.parseDouble(input);
                String backup=input;
                int comac=3;
                for(int i=input.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = input; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                byuser.setText(backup);
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
                if(un1.equals("°F")) oprnd2 = (oprnd1-32) * (5.0/9.0);
                else if(un1.equals("K")) oprnd2 = oprnd1 - 273.15;
                else if(un1.equals("°R")) oprnd2 = (oprnd1-491.67) * (5.0/9.0);
                else if(un1.equals("°Re")) oprnd2 = oprnd1 * 1.25;
                else oprnd2 = oprnd1;
                ifelse(un1,un2);
                output = Double.toString(oprnd2);
                String backup=output;
                int comac=3;
                for(int i=output.length()-1; i>=0; i--) {
                    if(backup.charAt(i)=='.') { backup = output; comac=3; continue; }
                    if(backup.charAt(i)=='-') { comac=3; continue; }
                    if(comac==0) {
                        backup = backup.substring(0,i+1) + "," + backup.substring(i+1);
                        comac=3;
                    }
                    comac--;
                }
                bycalc.setText(backup);
            }
        });

        unit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tuDrawer.show(getActivity().getSupportFragmentManager(), tuDrawer.getTag());
                unit1clicked=true; unit2clicked=false;
            }
        });
        unit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tuDrawer.show(getActivity().getSupportFragmentManager(), tuDrawer.getTag());
                unit2clicked=true; unit1clicked=false;
            }
        });

        return view;
    }

    void ifelse(String un1, String un2) {
        if(un2.equals("°F")) oprnd2 = (oprnd2 * (9.0/5.0)) + 32;
        else if(un2.equals("K")) oprnd2 = oprnd2 + 273.15;
        else if(un2.equals("°R")) oprnd2 = (oprnd2 * (9.0/5.0)) + 491.67;
        else if(un2.equals("°Re")) oprnd2 = oprnd2 / 1.25;
        else oprnd2 = oprnd2;
    }

    @Override
    public void onResume() {
        super.onResume();
        input = byuser.getText().toString().replace(",","");
        output = bycalc.getText().toString().replace(",","");
    }
}
