// 2026.03.26
// Java 코드로 TextView 속성 설정
package kr.ac.kopo.a04_textview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2, text3;
    EditText edit_text;

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

        TextView text1, text2;

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);

        text1.setText("SetText & SetTextColor");
        text1.setTextColor(Color.BLUE);

        text2.setText("SetTextSize & SetTypeface");
        text2.setTextSize(20);
        text2.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC);

        text3.setText("setSingleLine setSingleLine setSingleLine setSingleLine setSingleLine setSingleLine setSingleLine setSingleLine");
        text3.setSingleLine();

        edit_text = findViewById(R.id.edit_text);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            String text = edit_text.getText().toString();
            text1.setText(text);
            text2.setText(text);
            text3.setText(text);
        });
    }
}