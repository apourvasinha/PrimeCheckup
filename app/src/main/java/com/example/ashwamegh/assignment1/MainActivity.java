package com.example.ashwamegh.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;

    private TextView  mNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTrueButton=(Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rand=mNumber.getText().toString();
                int random =Integer.parseInt(rand);
                boolean checkPrime=isPrime(random);

                if(checkPrime){
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                }


            }
        });


        mFalseButton=(Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String rand=mNumber.getText().toString();
                int random =Integer.parseInt(rand);
                boolean checkPrime=isPrime(random);

                if(checkPrime){
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                }


            }
        });


        mNextButton=(Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mNumber.setText(Integer.toString(generateRandomNumber()));

            }
        });


        mNumber=(TextView) findViewById(R.id.random_number);
        mNumber.setText(Integer.toString(generateRandomNumber()));

    }



    private int generateRandomNumber(){

        Random r = new Random();
        int question = r.nextInt(1000);
        return question;
    }




    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }



}