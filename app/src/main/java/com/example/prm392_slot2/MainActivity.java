package com.example.prm392_slot2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2, etOperator;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        etOperator = findViewById(R.id.etOperator);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1Str = etNumber1.getText().toString();
                String num2Str = etNumber2.getText().toString();
                String operator = etOperator.getText().toString();

                if (num1Str.isEmpty() || num2Str.isEmpty() || operator.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("NUMBER1", num1);
                intent.putExtra("NUMBER2", num2);
                intent.putExtra("OPERATOR", operator);
                startActivity(intent);
            }
        });

    }
}