package kr.ac.kopo.a08_album;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    ImageView imgv;
    SwitchCompat switch_start;
    Button btn_restart;
    Button btn_close;

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

        switch_start = findViewById(R.id.switch_album);
        rg = findViewById(R.id.rg);
        imgv = findViewById(R.id.imgv);
        btn_restart = findViewById(R.id.btn_restart);
        btn_close = findViewById(R.id.btn_close);

        switch_start.setOnCheckedChangeListener((v, ischecked) -> {
            if (ischecked) imgv.setVisibility(ImageView.VISIBLE);
            else imgv.setVisibility(ImageView.INVISIBLE);
        });

        rg.setOnCheckedChangeListener((group, checkedID) -> {
            int imgRes;
            if (checkedID == R.id.rb_dog) imgRes = R.drawable.dog;
            else if (checkedID == R.id.rb_bird) imgRes = R.drawable.bird;
            else if (checkedID == R.id.rb_fish) imgRes = R.drawable.fish;
            else imgRes = R.drawable.img_placeholder;

            imgv.setImageResource(imgRes);
        });

        btn_restart.setOnClickListener(btnListener);

        btn_close.setOnClickListener(btnListener);

    }

    View.OnClickListener btnListener = v -> {
        int clickedID = v.getId();
        if (clickedID == R.id.btn_restart) {
            switch_start.setChecked(false);
            imgv.setImageResource(R.drawable.img_placeholder);
            rg.clearCheck();
        }
        else if (clickedID == R.id.btn_close) {
            finish();
        }
    };
}