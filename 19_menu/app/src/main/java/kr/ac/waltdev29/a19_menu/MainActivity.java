package kr.ac.waltdev29.a19_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ImageView imageView;

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

        editText = findViewById(R.id.editText_rotate);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.item_rotate) {
            int rotate = editText.getText().toString().isEmpty() ? 0 : Integer.parseInt(editText.getText().toString());
            imageView.setRotation(rotate);
            return true;
        }

        else if (item.getItemId() == R.id.item_bird) {
            imageView.setImageResource(R.drawable.bird);
            item.setChecked(true);
            return true;
        }
        else if (item.getItemId() == R.id.item_bee) {
            imageView.setImageResource(R.drawable.bee);
            item.setChecked(true);
            return true;
        }
        else if (item.getItemId() == R.id.item_fish) {
            imageView.setImageResource(R.drawable.fish);
            item.setChecked(true);
            return true;
        }

        return false;
    }
}