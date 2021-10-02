package com.example.studentloancalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText loanAmount, interestRate, loanTerm, loanFees;
    private Button monthlyPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        loanAmount = (EditText) findViewById(R.id.loanAmount);
        interestRate = (EditText) findViewById(R.id.interestRate);
        loanTerm = (EditText) findViewById(R.id.loanTerm);
        loanFees = (EditText) findViewById(R.id.loanFees);
        monthlyPayment = (Button) findViewById(R.id.monthlyPayment);

        monthlyPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val1 =loanAmount.getText().toString();
                String val2 =interestRate.getText().toString();
                String val3 =loanTerm.getText().toString();
                String val4 =loanFees.getText().toString();

                int a = Integer.parseInt(val1);
                int b = Integer.parseInt(val2);
                int c = Integer.parseInt(val3);
                int loanFees = 0;
                if (val4.isEmpty()) {
                    loanFees = 500;
                }
                else {
                    loanFees = Integer.parseInt(val4);
                }
                int totalLoan = a + loanFees;
                double temp1 = 1 + (b/100.0);
                double temp2 = Math.pow(temp1, c);
                double mp = (totalLoan*temp2)/(c*12);
                double ti = totalLoan*temp2 - a;
                Toast.makeText(getApplicationContext(),"Monthly Payment: $" + String.valueOf(mp) + "\n Total Interest: $" + String.valueOf(ti), Toast.LENGTH_LONG).show();
            }
        });
    }
}