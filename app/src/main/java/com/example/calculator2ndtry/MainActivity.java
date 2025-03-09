package com.example.calculator2ndtry;
// I Watched https://www.youtube.com/watch?v=4DGLcL4v6Qo tutorial for help with this project and better understanding of the code
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
    EditText editTextN1, editTextN2;
    TextView textView;
    int n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.button_add);
        buttonSubtract = findViewById(R.id.button_sub);
        buttonMultiply = findViewById(R.id.button_mul);
        buttonDivide = findViewById(R.id.button_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);


    }

    private Integer getInteger(EditText editText) {
        String input = editText.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show();
            return null;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input. Enter an integer.", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    @Override
    public void onClick(View view) {
        n1 = getInteger(editTextN1);
        n2 = getInteger(editTextN2);

        if (view.getId() == R.id.button_add) {
            textView.setText("Answer = " + (n1 + n2));
        } else if (view.getId() == R.id.button_sub) {
            textView.setText("Answer = " + (n1 - n2));
        } else if (view.getId() == R.id.button_mul) {
            textView.setText("Answer = " + (n1 * n2));
        } else if (view.getId() == R.id.button_div) {
            if (n2 == 0) { // Prevent division by zero
                textView.setText("Error: Cannot divide by zero");
            } else {
                textView.setText("Answer = " + ((float) n1 / (float) n2));
            }

        }
    }
}