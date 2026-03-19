// 2026.03.19
// Layout 속성 실습

package kr.ac.kopo.buttontest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text_view;
    EditText name_input;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        text_view = findViewById(R.id.text_view);
        name_input = findViewById(R.id.name_input);
        btn = findViewById(R.id.btn_submit);

        btn.setOnClickListener(btnListener);
    }



    View.OnClickListener btnListener = v -> {
        String name = name_input.getText().toString();
        String text = name + "'s App";
        text_view.setText(text);
        Toast.makeText(this, name + "님 안녕하세요!", Toast.LENGTH_SHORT).show();
    };
}