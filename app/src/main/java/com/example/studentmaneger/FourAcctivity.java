package com.example.studentmaneger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.studentmaneger.ThirdActivity.studentname1;

public class FourAcctivity extends AppCompatActivity {
    private TextView tvHoten;
    private TextView tvNgaysinh;
    private TextView tvMSSV;
    private TextView tvSdt;
    private TextView tvGioitinh;
    private TextView tvNoio;
    private TextView tvVaodoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_infor);
        initWidge();
        byBundle();
    }
    public void byBundle()
    {
        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getBundleExtra(ThirdActivity.BUNDLE2);
            Student t1 = (Student)bundle.getSerializable(studentname1);
            tvHoten.setText(t1.getName());
            tvMSSV.setText(t1.getID());
            tvNgaysinh.setText(t1.getBirth());
            tvSdt.setText(t1.getNumber());
            tvGioitinh.setText(t1.getSex());
            tvNoio.setText(t1.getAddress());
            tvVaodoan.setText(t1.getVaoDoan());

        }
    }
    public void initWidge() {
        tvHoten = (TextView) findViewById(R.id.tv_Hoten);
        tvNgaysinh = (TextView) findViewById(R.id.tv_ngaysinh);
        tvMSSV= (TextView) findViewById(R.id.tv_MSSV);
        tvSdt = (TextView) findViewById(R.id.tv_sdt);
        tvGioitinh = (TextView) findViewById(R.id.tv_gioitinh);
        tvNoio = (TextView) findViewById(R.id.tv_noio);
        tvVaodoan = (TextView)findViewById(R.id.tv_vaodoan);
    }
}
