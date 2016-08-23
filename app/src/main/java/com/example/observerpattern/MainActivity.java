package com.example.observerpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.main_Edttxt);
        mTextView = (TextView) findViewById(R.id.main_TxtView);
        mTextView.setText("");


    }

    public void doMagic(View view) {

        Observer<String> observer  = ObserverHelper.createObserver(mTextView);
        Observable<String> observable = ObserverHelper.createObservable(mEditText);
        observable.subscribe(observer);
    }
}
