package kr.ac.waltdev29.a25_multidirectiondata;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editNum1, editNum2;
    Button btnGen;
    TextView tvResult;
    RadioGroup radioGroup;

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

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        btnGen = findViewById(R.id.btnGen);
        tvResult = findViewById(R.id.tvResult);
        radioGroup = findViewById(R.id.rg);

        btnGen.setOnClickListener(v -> {
            int num1 = Integer.parseInt(editNum1.getText().toString());
            int num2 = Integer.parseInt(editNum2.getText().toString());

            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("num1", num1);
            intent.putExtra("num2", num2);
            intent.putExtra("oper", radioGroup.getCheckedRadioButtonId());
            startActivityForResult(intent, 0);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("hap", 0);
            tvResult.setTextColor(Color.BLUE);
            tvResult.setText("계산 결과 : " + hap);
        }
    }
}