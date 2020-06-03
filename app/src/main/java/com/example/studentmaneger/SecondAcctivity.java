package com.example.studentmaneger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SecondAcctivity extends Activity {
    private EditText edHoten;
    private EditText edNgaysinh;
    private EditText edMSSV;
    private EditText edSdt;
    private RadioButton rbtnNam;
    private RadioButton rbtnNu;
    private Spinner spnCategory;
    private CheckBox cbVaodoan;
    private Button btnHoanthanh;
    private Student student ;

    private DBManager dbManager;
    public final String TAG =  "DBManager";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second_acctivity);
        student = new Student();
        dbManager = new DBManager(this);
        initWidget();
        SpinnerChoose();
        ButtonClick();

    }
    public void ButtonClick()
    {
        Button button = (Button)findViewById(R.id.btn_Hoanthanh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondAcctivity.this,ThirdActivity.class);
                startActivity(intent);
                ByBundle();
                dbManager.addStudent(student);
            }
        });
    }
    public void ByBundle(){
        student.setName(edHoten.getText().toString());
        student.setBirth(edNgaysinh.getText().toString());
        student.setID(edMSSV.getText().toString());
        student.setNumber(edSdt.getText().toString());
        if (rbtnNam.isChecked()){
            student.setSex(rbtnNam.getText().toString());
        }
        else
        {
            student.setSex(rbtnNu.getText().toString());
        }
        if (cbVaodoan.isChecked())
            student.setVaoDoan(cbVaodoan.getText().toString());
        else
            student.setVaoDoan("Chưa vào đoàn ");

        Log.d(TAG,"Thanh cong");
    }



    public void SpinnerChoose()
    {
        List<String> list = new ArrayList<>();
        list.add("An Giang");
        list.add("Hậu Giang");
        list.add("Cần Thơ");
        list.add("Đồng Tháp");
        list.add("Bạc Liêu");
        list.add("Cà Mau");
        list.add("Sóc Trăng");
        list.add("Kiên Giang");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnCategory.setAdapter(adapter);
        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                student.setAddress(spnCategory.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void initWidget()
    {
        edHoten = (EditText)findViewById(R.id.ed_Hoten);
        edNgaysinh = (EditText)findViewById(R.id.ed_ngaysinh);
        edMSSV = (EditText)findViewById(R.id.ed_MSSV);
        edSdt = (EditText)findViewById(R.id.ed_sdt);
        rbtnNam = (RadioButton)findViewById(R.id.rbtn_nam);
        rbtnNu = (RadioButton)findViewById(R.id.rbtn_nu);
        spnCategory = (Spinner)findViewById(R.id.spn_Category);
        cbVaodoan = (CheckBox)findViewById(R.id.cb_da_vao_doan);
        btnHoanthanh = (Button)findViewById(R.id.btn_Hoanthanh);

    }
}
