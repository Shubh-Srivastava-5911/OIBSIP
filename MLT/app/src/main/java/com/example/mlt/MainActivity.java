package com.example.mlt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mlt.fragments.AreaFrag;
import com.example.mlt.fragments.DataFrag;
import com.example.mlt.fragments.LengthFrag;
import com.example.mlt.fragments.MassFrag;
import com.example.mlt.fragments.NumeralFrag;
import com.example.mlt.fragments.SpeedFrag;
import com.example.mlt.fragments.TemperatureFrag;
import com.example.mlt.fragments.TimeFrag;
import com.example.mlt.fragments.VolumeFrag;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SlidingRootNav myslider;
    Toolbar tb;

    TextView data, length, area, volume, mass, time, temperature, speed, numeral;
    TextView toolText;
    ImageView toolImg;

    public static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        tb = findViewById(R.id.my_toolbar);
        toolText = findViewById(R.id.toolbarIndicator);
        toolImg = findViewById(R.id.toolbarImg);

        myslider = new SlidingRootNavBuilder(this)
                .withMenuOpened(false) //Initial menu opened/closed state. Default == false
                .withMenuLocked(false) //If true, a user can't open or close the menu. Default == false.
                .withToolbarMenuToggle(tb)
                .withContentClickableWhenMenuOpened(true)
                .withMenuLayout(R.layout.drawer_layout)
                .withGravity(SlideGravity.LEFT) //If LEFT you can swipe a menu from left to right, if RIGHT - the direction is opposite.
                .withSavedState(savedInstanceState) //If you call the method, layout will restore its opened/closed state
                .inject();

        fm = getSupportFragmentManager();

        ArrayList<TextView> options = new ArrayList<>();

        data = findViewById(R.id.data); options.add(data);
        length = findViewById(R.id.length); options.add(length);
        area = findViewById(R.id.area); options.add(area);
        volume = findViewById(R.id.volume); options.add(volume);
        mass = findViewById(R.id.mass); options.add(mass);
        time = findViewById(R.id.time); options.add(time);
        temperature = findViewById(R.id.temperature); options.add(temperature);
        speed = findViewById(R.id.speed); options.add(speed);
        numeral = findViewById(R.id.numeral); options.add(numeral);

        for(TextView ele : options) {
            Drawable db = ele.getCompoundDrawables()[0];
            db.setTint(Color.parseColor("#5F7678"));
            ele.setCompoundDrawables(db,null,null,null);
            ele.setTextColor(Color.parseColor("#5F7678"));
        }
        Drawable db = data.getCompoundDrawables()[0];
        db.setTint(Color.parseColor("#1DC8FC"));
        data.setCompoundDrawables(db,null,null,null);
        data.setTextColor(Color.parseColor("#1DC8FC"));
        toolText.setText("Data"); toolImg.setImageResource(R.drawable.world);

        FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
        ftFromData.replace(R.id.my_framelayout, new DataFrag());
        ftFromData.addToBackStack(null);
        ftFromData.commit();

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for(TextView ele : options) {
                    Drawable db = ele.getCompoundDrawables()[0];
                    db.setTint(Color.parseColor("#5F7678"));
                    ele.setCompoundDrawables(db,null,null,null);
                    ele.setTextColor(Color.parseColor("#5F7678"));
                }
                Drawable db = data.getCompoundDrawables()[0];
                db.setTint(Color.parseColor("#1DC8FC"));
                data.setCompoundDrawables(db,null,null,null);
                data.setTextColor(Color.parseColor("#1DC8FC"));
                toolText.setText("Data"); toolImg.setImageResource(R.drawable.world);

                FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
                ftFromData.replace(R.id.my_framelayout, new DataFrag());
                ftFromData.addToBackStack(null);
                ftFromData.commit();

                myslider.closeMenu();
            }
        });

        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for(TextView ele : options) {
                    Drawable db = ele.getCompoundDrawables()[0];
                    db.setTint(Color.parseColor("#5F7678"));
                    ele.setCompoundDrawables(db,null,null,null);
                    ele.setTextColor(Color.parseColor("#5F7678"));
                }
                Drawable db = length.getCompoundDrawables()[0];
                db.setTint(Color.parseColor("#1DC8FC"));
                length.setCompoundDrawables(db,null,null,null);
                length.setTextColor(Color.parseColor("#1DC8FC"));
                toolText.setText("Length"); toolImg.setImageResource(R.drawable.arrows);

                FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
                ftFromData.replace(R.id.my_framelayout, new LengthFrag());
                ftFromData.addToBackStack(null);
                ftFromData.commit();

                myslider.closeMenu();
            }
        });

        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for(TextView ele : options) {
                    Drawable db = ele.getCompoundDrawables()[0];
                    db.setTint(Color.parseColor("#5F7678"));
                    ele.setCompoundDrawables(db,null,null,null);
                    ele.setTextColor(Color.parseColor("#5F7678"));
                }
                Drawable db = area.getCompoundDrawables()[0];
                db.setTint(Color.parseColor("#1DC8FC"));
                area.setCompoundDrawables(db,null,null,null);
                area.setTextColor(Color.parseColor("#1DC8FC"));
                toolText.setText("Area"); toolImg.setImageResource(R.drawable.scale);

                FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
                ftFromData.replace(R.id.my_framelayout, new AreaFrag());
                ftFromData.addToBackStack(null);
                ftFromData.commit();

                myslider.closeMenu();
            }
        });

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for(TextView ele : options) {
                    Drawable db = ele.getCompoundDrawables()[0];
                    db.setTint(Color.parseColor("#5F7678"));
                    ele.setCompoundDrawables(db,null,null,null);
                    ele.setTextColor(Color.parseColor("#5F7678"));
                }
                Drawable db = volume.getCompoundDrawables()[0];
                db.setTint(Color.parseColor("#1DC8FC"));
                volume.setCompoundDrawables(db,null,null,null);
                volume.setTextColor(Color.parseColor("#1DC8FC"));
                toolText.setText("Volume"); toolImg.setImageResource(R.drawable.volume);

                FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
                ftFromData.replace(R.id.my_framelayout, new VolumeFrag());
                ftFromData.addToBackStack(null);
                ftFromData.commit();

                myslider.closeMenu();
            }
        });

        mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for(TextView ele : options) {
                    Drawable db = ele.getCompoundDrawables()[0];
                    db.setTint(Color.parseColor("#5F7678"));
                    ele.setCompoundDrawables(db,null,null,null);
                    ele.setTextColor(Color.parseColor("#5F7678"));
                }
                Drawable db = mass.getCompoundDrawables()[0];
                db.setTint(Color.parseColor("#1DC8FC"));
                mass.setCompoundDrawables(db,null,null,null);
                mass.setTextColor(Color.parseColor("#1DC8FC"));
                toolText.setText("Mass"); toolImg.setImageResource(R.drawable.load);

                FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
                ftFromData.replace(R.id.my_framelayout, new MassFrag());
                ftFromData.addToBackStack(null);
                ftFromData.commit();

                myslider.closeMenu();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for(TextView ele : options) {
                    Drawable db = ele.getCompoundDrawables()[0];
                    db.setTint(Color.parseColor("#5F7678"));
                    ele.setCompoundDrawables(db,null,null,null);
                    ele.setTextColor(Color.parseColor("#5F7678"));
                }
                Drawable db = time.getCompoundDrawables()[0];
                db.setTint(Color.parseColor("#1DC8FC"));
                time.setCompoundDrawables(db,null,null,null);
                time.setTextColor(Color.parseColor("#1DC8FC"));
                toolText.setText("Time"); toolImg.setImageResource(R.drawable.times);

                FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
                ftFromData.replace(R.id.my_framelayout, new TimeFrag());
                ftFromData.addToBackStack(null);
                ftFromData.commit();

                myslider.closeMenu();
            }
        });

        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for(TextView ele : options) {
                    Drawable db = ele.getCompoundDrawables()[0];
                    db.setTint(Color.parseColor("#5F7678"));
                    ele.setCompoundDrawables(db,null,null,null);
                    ele.setTextColor(Color.parseColor("#5F7678"));
                }
                Drawable db = temperature.getCompoundDrawables()[0];
                db.setTint(Color.parseColor("#1DC8FC"));
                temperature.setCompoundDrawables(db,null,null,null);
                temperature.setTextColor(Color.parseColor("#1DC8FC"));
                toolText.setText("Temperature"); toolImg.setImageResource(R.drawable.thermometer);

                FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
                ftFromData.replace(R.id.my_framelayout, new TemperatureFrag());
                ftFromData.addToBackStack(null);
                ftFromData.commit();

                myslider.closeMenu();
            }
        });

        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for(TextView ele : options) {
                    Drawable db = ele.getCompoundDrawables()[0];
                    db.setTint(Color.parseColor("#5F7678"));
                    ele.setCompoundDrawables(db,null,null,null);
                    ele.setTextColor(Color.parseColor("#5F7678"));
                }
                Drawable db = speed.getCompoundDrawables()[0];
                db.setTint(Color.parseColor("#1DC8FC"));
                speed.setCompoundDrawables(db,null,null,null);
                speed.setTextColor(Color.parseColor("#1DC8FC"));
                toolText.setText("Speed"); toolImg.setImageResource(R.drawable.speedometer);

                FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
                ftFromData.replace(R.id.my_framelayout, new SpeedFrag());
                ftFromData.addToBackStack(null);
                ftFromData.commit();

                myslider.closeMenu();
            }
        });

        numeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                for(TextView ele : options) {
                    Drawable db = ele.getCompoundDrawables()[0];
                    db.setTint(Color.parseColor("#5F7678"));
                    ele.setCompoundDrawables(db,null,null,null);
                    ele.setTextColor(Color.parseColor("#5F7678"));
                }
                Drawable db = numeral.getCompoundDrawables()[0];
                db.setTint(Color.parseColor("#1DC8FC"));
                numeral.setCompoundDrawables(db,null,null,null);
                numeral.setTextColor(Color.parseColor("#1DC8FC"));
                toolText.setText("Numeral"); toolImg.setImageResource(R.drawable.binary);

                FragmentTransaction ftFromData = MainActivity.fm.beginTransaction();
                ftFromData.replace(R.id.my_framelayout, new NumeralFrag());
                ftFromData.addToBackStack(null);
                ftFromData.commit();

                myslider.closeMenu();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(myslider.isMenuOpened()) myslider.closeMenu();
        else finish();
    }
}