package kr.ac.waltdev29.a20_context_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button btn_backColor;
    Button btn_btn;

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
        btn_backColor = findViewById(R.id.btn_backColor);
        btn_btn = findViewById(R.id.btn_btn);

        registerForContextMenu(btn_backColor);
        registerForContextMenu(btn_btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();

        if (v == btn_backColor) {
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.context_menu1, menu);
        }
        else if (v == btn_btn) {
            menu.setHeaderTitle("버튼 변경");
            menuInflater.inflate(R.menu.context_menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);

        if (item.getItemId() == R.id.item_bg_red) {
            linear.setBackgroundColor(Color.RED);
            return true;
        }
        else if (item.getItemId() == R.id.item_bg_green) {
            linear.setBackgroundColor(Color.GREEN);
            return true;
        }
        else if (item.getItemId() == R.id.item_bg_blue) {
            linear.setBackgroundColor(Color.BLUE);
            return true;
        }

        if (item.getItemId() == R.id.item_btn_rotate) {
            btn_btn.setRotation(btn_btn.getRotation() + 45);
            return true;
        }
        else if (item.getItemId() == R.id.item_btn_zoom_in) {
            btn_btn.setScaleX(btn_btn.getScaleX() + 0.2f);
            btn_btn.setScaleY(btn_btn.getScaleY() + 0.2f);
            return true;
        }

        return false;
    }
}