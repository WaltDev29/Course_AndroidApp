package kr.ac.waltdev29.a17_actionbar_fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabCat, tabFrog, tabGoat, tabDonkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabCat = bar.newTab();
        tabCat.setText("Cat");
        tabCat.setTabListener(this);

        tabFrog = bar.newTab();
        tabFrog.setText("Frog");
        tabFrog.setTabListener(this);

        tabGoat = bar.newTab();
        tabGoat.setText("Goat");
        tabGoat.setTabListener(this);

        tabDonkey = bar.newTab();
        tabDonkey.setText("Donkey");
        tabDonkey.setTabListener(this);

        bar.addTab(tabCat);
        bar.addTab(tabFrog);
        bar.addTab(tabGoat);
        bar.addTab(tabDonkey);
    }

    MyTabFragment[] tabFragment = new MyTabFragment[4];

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFragment;

        if (tabFragment[tab.getPosition()] == null) {
            myTabFragment = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFragment.setArguments(data);
            tabFragment[tab.getPosition()] = myTabFragment;
        } else {
            myTabFragment = tabFragment[tab.getPosition()];
        }
        ft.replace(android.R.id.content, myTabFragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}


    public static class MyTabFragment extends Fragment {
        String tabName;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            LinearLayout linear = new LinearLayout(super.getActivity());
            linear.setLayoutParams(params);
            linear.setOrientation(LinearLayout.VERTICAL);

            if (tabName.equals("Cat")) linear.setBackgroundColor(Color.YELLOW);
            else if (tabName.equals("Frog")) linear.setBackgroundColor(Color.GREEN);
            else if (tabName.equals("Goat")) linear.setBackgroundColor(Color.BLUE);
            else if (tabName.equals("Donkey")) linear.setBackgroundColor(Color.RED);


            return linear;
        }

    }
}