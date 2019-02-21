package org.pursuit.fragmentinterfacecallbacksappfromscratch;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.pursuit.fragmentinterfacecallbacksappfromscratch.fragments.DisplayFragment;
import org.pursuit.fragmentinterfacecallbacksappfromscratch.fragments.InputFragment;

public class MainActivity extends AppCompatActivity implements InputFragment.FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputFragment inputFragment = InputFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, inputFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String text1, String text2, String text3) {
        DisplayFragment displayFragment = DisplayFragment.newInstance(text1, text2, text3);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, displayFragment)
                .addToBackStack(null)
                .commit();
    }
}
