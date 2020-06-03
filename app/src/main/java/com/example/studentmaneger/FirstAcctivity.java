package com.example.studentmaneger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class FirstAcctivity extends Activity {
    private Button btnnew;
    private Button btnlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_first_acctivity);
        widget();
        Buttonclick();


    }
    public void widget(){
        btnnew = (Button)findViewById(R.id.btn_new);
        btnlist = (Button)findViewById(R.id.btn_list);
    }
    public void Buttonclick(){
        btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstAcctivity.this,SecondAcctivity.class);
                startActivity(intent);
            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstAcctivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
