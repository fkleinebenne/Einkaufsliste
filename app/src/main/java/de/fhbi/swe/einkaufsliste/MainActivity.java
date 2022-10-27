package de.fhbi.swe.einkaufsliste;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import de.fhbi.swe.einkaufsliste.ui.main.SectionsPagerAdapter;
import de.fhbi.swe.einkaufsliste.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ArrayList<String> arrayList = new ArrayList<>();

    private ArrayAdapter<String> arad;

    public void addItem(String s){
        arrayList.add(s);
    }

    public void deleteItem(int position){
        arrayList.remove(position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        arad= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
    }
//alles funktioniert <3
    public void setAdapter(ListView listView){
        listView.setAdapter(arad);
    }
}