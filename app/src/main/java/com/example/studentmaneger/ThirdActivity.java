package com.example.studentmaneger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private ListView lvstudent;
    private Button btnadd;
    private CustomAdapter customAdapter;
    private List<Student> studentList;
    private DBManager dbManager;
    public static final String BUNDLE2 = "bundel2";
    public static final String studentname1 = "t11";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        dbManager = new DBManager(this);
        studentList = dbManager.getAllStudent();
        initWidge();
        setAdapter();
        deleteStudent();
        addStudent();

    }

    public void initWidge() {
        lvstudent = (ListView)findViewById(R.id.lv_danhsach);
    }
    public void setAdapter(){
        if (customAdapter == null){
            customAdapter =new CustomAdapter(this,R.layout.item_contact_listview,studentList);
            lvstudent.setAdapter(customAdapter);
        }
        else{
            customAdapter.notifyDataSetChanged();
            lvstudent.setSelection(customAdapter.getCount()-1);
        }
    }
    public void updateListstudent(){
        studentList.clear();
        studentList.addAll(dbManager.getAllStudent());
        if (customAdapter != null)
            customAdapter.notifyDataSetChanged();
    }
    public void deleteStudent(){
        lvstudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ThirdActivity.this,FourAcctivity.class);
                Bundle bundle = new Bundle();
                Student student = studentList.get(position);
                bundle.putSerializable(studentname1,student);
                intent.putExtra(BUNDLE2,bundle);
                startActivity(intent);
            }
        });
        lvstudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = studentList.get(position);
                dbManager.deleteStudent(student.getID());
                updateListstudent();
                return false;
            }
        });
    }
    public void addStudent(){
        btnadd = (Button)findViewById(R.id.btn_add);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,SecondAcctivity.class);
                startActivity(intent);
            }
        });
    }

}
