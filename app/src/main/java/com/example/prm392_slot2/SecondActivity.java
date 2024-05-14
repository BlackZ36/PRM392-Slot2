package com.example.prm392_slot2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        tvResult = findViewById(R.id.tvResult);
        Intent intent = getIntent();
        double num1 = intent.getDoubleExtra("NUMBER1", 0);
        double num2 = intent.getDoubleExtra("NUMBER2", 0);
        String operator = intent.getStringExtra("OPERATOR");

        double result = 0;
        boolean validOperation = true;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    validOperation = false;
                    tvResult.setText("Lỗi: Không thể chia cho 0");
                }
                break;
            default:
                validOperation = false;
                tvResult.setText("Lỗi: Phép toán không hợp lệ");
                break;
        }

        if (validOperation) {
            tvResult.setText("Kết quả: " + result);
        }

    }
}