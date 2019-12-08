package com.elnino.adm.appnote1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GhiChuDao ghiChuDao;
    private ListView lv_list;
    private List<GhiChu> dsGhiChu = new ArrayList<>();
    private EditText edt_title,edt_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_title = findViewById(R.id.edt_title);
        edt_content = findViewById(R.id.edt_content);


        ghiChuDao = new GhiChuDao(this);
        dsGhiChu = ghiChuDao.getAllGhiChu();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1 ,
                dsGhiChu);
        lv_list = findViewById(R.id.lv_list);

        lv_list.setAdapter(adapter);


        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GhiChu ghiChu = dsGhiChu.get(i);
                edt_title.setText(ghiChu.getTitle());
                edt_content.setText(ghiChu.getContent());
                Intent intent = new Intent(MainActivity.this,ThemGhiChu.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent intent = new Intent(MainActivity.this, ThemGhiChu.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
