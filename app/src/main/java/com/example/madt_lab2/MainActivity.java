package com.example.madt_lab2;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.madt_lab2.utilities.TextCounting;

public class MainActivity extends AppCompatActivity {

    EditText userInput;
    Spinner countOption;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userInput = findViewById(R.id.userInput);
        countOption = findViewById(R.id.countOption);
        tvResult = findViewById(R.id.resultCount);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countOptions, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        countOption.setAdapter(adapter);


    }

    public void onBtnCountClick(View view) {
        String userInput = this.userInput.getText().toString();
        String[] countOptions = getResources().getStringArray(R.array.countOptions);
        int count;
        if (userInput.isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_field_error), Toast.LENGTH_LONG).show();
        } else if (countOption.getSelectedItem().toString().equals(countOptions[0])) {
            count = TextCounting.getCharsCount(userInput);
            tvResult.setText(String.valueOf(count));
        } else {
            count = TextCounting.getWordsCount(userInput);
            tvResult.setText(String.valueOf(count));
        }
    }


}