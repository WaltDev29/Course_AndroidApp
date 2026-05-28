package kr.ac.waltdev29.a22_user_dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtEmail;
    Button btnDialog;

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

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        btnDialog = findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(v -> {
            View dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setView(dialogView);
            dialog.setTitle("정보 입력");
            dialog.setIcon(R.drawable.toast_icon);

            EditText digEdtName = dialogView.findViewById(R.id.digEdtName);
            EditText digEdtEmail = dialogView.findViewById(R.id.digEdtEmail);

            digEdtName.setText(edtName.getText().toString());
            digEdtEmail.setText(edtEmail.getText().toString());


            dialog.setPositiveButton("확인", (dialogInterface, i) -> {
                edtName.setText(digEdtName.getText().toString());
                edtEmail.setText(digEdtEmail.getText().toString());
            });

            dialog.setNegativeButton("취소", (dialogInterface, i) -> {
                View toastView = View.inflate(MainActivity.this, R.layout.toast, null);
                Toast toast = new Toast(MainActivity.this);
                toast.setView(toastView);
                toast.setDuration(Toast.LENGTH_SHORT);

                toast.show();
            });

            dialog.show();
        });
    }
}