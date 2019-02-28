package com.exampledroid.checkedrecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.exampledroid.checkedrecyclerview.fragments.LanguageFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment mBaseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBaseFragment = new LanguageFragment();
        openFragment(mBaseFragment);
        getSupportActionBar().setTitle("Languages");
    }

    private void openFragment(Fragment baseFragment) {
        if (baseFragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_common, baseFragment);
            fragmentTransaction.commit();
        }
    }
}
