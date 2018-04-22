package com.example.user.searchablerecyclerview.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.searchablerecyclerview.NetCalls.MakeNetCalls;
import com.example.user.searchablerecyclerview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static butterknife.ButterKnife.findById;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.searchAutoCompleteText)
    AutoCompleteTextView mSearchAutoCompleteText;
    @BindView(R.id.searchButton)
    Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        mSearchButton.setOnClickListener(this);
        ArrayAdapter<Object> searchAdapter = new ArrayAdapter<Object>(this, R.layout.support_simple_spinner_dropdown_item, sAppliance);
        mSearchAutoCompleteText.setAdapter(searchAdapter);
    }

    public static Object[] sAppliance = new Object[]{"Galaxy s9 SM-G965FZPD", "Smart TV", "Inspire LGH930DS",
            "LG JS-Q18CUXA", "Split AC", "Samsung AR12NC1UDMC", "Samsung UA49M5000ARLXL", "Sony KD-55A1",
            "LG 55LJ550T", "Sony KLV-32W672E", "Sony KD-55X9500E", "Sony KD-65Z9D", "Sony X9400E/X9300E",
            "XPERIA G3416 XA1 PLUS", "Sony TV", "Samsung TV", "Sony Mobiles", "LG TV", "Samsung Galaxy Mobiles",
            "LG AC", "Samsung AC", "LG Mobiles", "Panasonic AC"};

    @Override
    public void onClick(View v) {
        String searchInput = mSearchAutoCompleteText.getText().toString();

        if (searchInput.isEmpty()) {
            Toast.makeText(this, "You're searching without entering", Toast.LENGTH_SHORT).show();
        } else if (Arrays.toString(sAppliance).contains(searchInput) || Arrays.toString(sAppliance).toLowerCase().contains(searchInput)) {
            startActivity(new Intent(SearchActivity.this, ApplianceActivity.class)
                    .putExtra("search input", searchInput.toLowerCase()));
        } else {
            Toast.makeText(this, "No such element there", Toast.LENGTH_SHORT).show();
        }


    }
}
