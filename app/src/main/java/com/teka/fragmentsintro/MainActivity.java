package com.teka.fragmentsintro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.Fragment1Listener, Fragment2.Fragment2Listener {
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, fragment1)
                .replace(R.id.container2, fragment2)
                .commit();
    }

    @Override
    public void onInput1Sent(CharSequence input) {
        fragment2.updateEditText(input);
    }

    @Override
    public void onInput2Sent(CharSequence input) {
        fragment1.updateEditText(input);
    }
}