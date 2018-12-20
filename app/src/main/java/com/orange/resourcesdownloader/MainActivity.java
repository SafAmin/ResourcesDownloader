package com.orange.resourcesdownloader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.orange.resourcesdownloader.pinboard.PinBoardFragment;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.layout_placeholder)
    FrameLayout layoutPlaceHolder;
    @BindString(R.string.pin_board_screen_title)
    String pinBoardScreenTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setScreenTitle(pinBoardScreenTitle);

        invalidateView(PinBoardFragment.getInstance());
    }

    public void setScreenTitle(String title) {
        toolbar.setTitle(title);
    }

    public void invalidateView(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_placeholder, fragment);
        fragmentTransaction.commit();
    }
}
