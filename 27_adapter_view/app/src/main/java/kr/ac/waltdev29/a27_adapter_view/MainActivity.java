package kr.ac.waltdev29.a27_adapter_view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    String[] items = {"피카츄", "라이츄", "파이리", "꼬부기", "버터플", "야도란", "피죤투", "또가스"};

    ArrayList<String> items = new ArrayList<String>();
    EditText editText;
    Button btnAdd;

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

        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListView list1 = findViewById(R.id.listView);

        list1.setAdapter(adapter);

        list1.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(), items.get(position), Toast.LENGTH_SHORT).show();
        });

        list1.setOnItemLongClickListener((parent, view, position, id) -> {
            items.remove(position);
            adapter.notifyDataSetChanged();
            return false;
        });

        btnAdd.setOnClickListener(v -> {
            items.add(editText.getText().toString());
            adapter.notifyDataSetChanged();
        });
    }
}