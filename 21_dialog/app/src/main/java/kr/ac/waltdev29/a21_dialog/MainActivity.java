package kr.ac.waltdev29.a21_dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button btnAlert, btnSelect, btnRadio, btnCheckbox;
    String[] itemArr = {"떡볶이", "튀김", "순대"};
    boolean[] checkArr = {false, false, false};

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

        linear = findViewById(R.id.main);
        btnAlert = findViewById(R.id.btn_alert);
        btnSelect = findViewById(R.id.btn_select);
        btnRadio = findViewById(R.id.btn_radio);
        btnCheckbox = findViewById(R.id.btn_cb);

        btnAlert.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("배경색 변경");
            dialog.setMessage("배경색을 초록색으로 변경하시겠습니까?");
            dialog.setIcon(R.drawable.ic_launcher_foreground);

            dialog.setPositiveButton("확인", (dialog2, which) -> {
                linear.setBackgroundColor(Color.GREEN);
                Toast.makeText(MainActivity.this, "배경색을 초록색으로 변경하였습니다.", Toast.LENGTH_SHORT).show();
            });
            dialog.setNegativeButton("취소", null);

            dialog.show();
        });

        btnSelect.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("버튼 라벨 변경");
            dialog.setIcon(R.drawable.ic_launcher_foreground);

            dialog.setItems(itemArr, (dialog1, which) -> btnSelect.setText(itemArr[which]));
            dialog.setPositiveButton("확인", null);

            dialog.show();
        });

        btnRadio.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("버튼 라벨 변경");
            dialog.setIcon(R.drawable.ic_launcher_foreground);

            dialog.setSingleChoiceItems(itemArr, 1, (dialog1, which) -> btnRadio.setText(itemArr[which]));
            dialog.setPositiveButton("확인", null);

            dialog.show();
        });

        btnCheckbox.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("버튼 라벨 변경");
            dialog.setIcon(R.drawable.ic_launcher_foreground);

            dialog.setMultiChoiceItems(
                    itemArr,
                    checkArr,
                    (dialog1, which, isChecked) -> {
                        if (isChecked) checkArr[which] = true;

                        String str = "";

                        for (int i = 0; i < checkArr.length; i++) {
                            if (checkArr[i]) {
                                str += itemArr[i] + " ";
                            }
                        }

                        btnCheckbox.setText(str);
                    });
            dialog.setPositiveButton("확인", null);

            dialog.show();
        });
    }
}