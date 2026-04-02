package kr.ac.kopo.a07_radio_button;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView text_result;
    RadioGroup rg;
    ImageView imgView;

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

        text_result = findViewById(R.id.text_result);
        rg = findViewById(R.id.rg);
        imgView = findViewById(R.id.imgv);

        rg.setOnCheckedChangeListener((v, ischecked) -> {
            String result = "선택한 성별 : ";
            int imgRes = 0;

            if (ischecked == R.id.rb_male) {
                result += "남성";
                imgRes = R.drawable.male;
            }
            else if (ischecked == R.id.rb_female){
                result += "여성";
                imgRes = R.drawable.female;
            }

            text_result.setText(result);
            imgView.setImageResource(imgRes);
            Toast.makeText(this, result , Toast.LENGTH_SHORT).show();
        });
    }
}