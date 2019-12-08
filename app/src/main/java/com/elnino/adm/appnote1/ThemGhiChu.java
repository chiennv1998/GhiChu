package com.elnino.adm.appnote1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ThemGhiChu extends AppCompatActivity implements OnClick {
    private EditText edttitle,edtcontent;
    private Presenter presenter;
    private GhiChuDao ghiChuDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_ghi_chu);
        edttitle = findViewById(R.id.edt_title);
        edtcontent  = findViewById(R.id.edt_content);
        presenter = new Presenter(this);
        ghiChuDao =  new GhiChuDao(this);
    }


    @Override
    public void add() {

    }

    @Override
    public void onClick() {
        Intent intent = new Intent(ThemGhiChu.this,MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void errorTitle() {
        edttitle.setError("Nhap du lieu");

    }

    @Override
    public void errorContenr() {
        edtcontent.setError("Nhap du lieu");
    }

    public void add(View view) {
        String title = edttitle.getText().toString();
        String content = edtcontent.getText().toString();
        presenter.add(title,content);
        GhiChu objGhiChu = new GhiChu(title, content);
        boolean result = ghiChuDao.inserGhichu(objGhiChu);
        if (result) {
            Toast.makeText(this, "Inserted successfully!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Inserted fail!", Toast.LENGTH_LONG).show();
        }

    }
}
