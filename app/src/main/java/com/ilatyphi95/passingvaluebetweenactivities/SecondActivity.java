package com.ilatyphi95.passingvaluebetweenactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String RANDOM_NUMBER = "randon_number";

    private TextView mTextView;
    private Button mSendButton;
    private int mNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTextView = findViewById(R.id.tvDisplay);
        mSendButton = findViewById(R.id.button);
        Intent intent = getIntent();
        if (intent != null){
            mNumber = intent.getIntExtra(RANDOM_NUMBER,0);
            mTextView.setText(String.valueOf(mNumber));
        }

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra(MainActivity.RANDOM_NUMBER, (int) Math.round(Math.random() * 10000));
                startActivity(intent);
            }
        });
    }
}
