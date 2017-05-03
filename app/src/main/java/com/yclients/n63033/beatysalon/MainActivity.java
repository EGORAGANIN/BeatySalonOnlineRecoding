package com.yclients.n63033.beatysalon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yclients.n63033.beatysalon.Fragments.StaffBookingFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addStaffBookingFragment();
    }

    private void addStaffBookingFragment(){
        StaffBookingFragment staffBookingFragment = new StaffBookingFragment();

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout,staffBookingFragment);
        transaction.commit();
    }
}
