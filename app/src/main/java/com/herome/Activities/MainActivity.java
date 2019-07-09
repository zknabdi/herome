package com.herome.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.herome.Fragments.MainFragment;
import com.herome.Fragments.PickPowerFragment;
import com.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragementInteractionListener, PickPowerFragment.PIckPowerInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fragment manager to get support fragment manager, then load Fragment
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new MainFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

            // fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


    public void loadPickPowerScreen() {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container, pickPowerFragment)
                .addToBackStack(null).commit();

//        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, pickPowerFragment).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }
}
