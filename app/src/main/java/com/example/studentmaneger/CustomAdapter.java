package com.example.studentmaneger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {
    private Context context;
    private int resource;
    private List<Student> listStudent;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listStudent = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_student,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imgavatar = (ImageView)convertView.findViewById(R.id.imgv_avatar);
            viewHolder.tvname = (TextView)convertView.findViewById(R.id.tv_name);
            viewHolder.tvsex = (TextView)convertView.findViewById(R.id.tv_sex);
            viewHolder.tvnumber = (TextView)convertView.findViewById(R.id.tv_number);
            viewHolder.tvaddress = (TextView)convertView.findViewById(R.id.tv_address);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Student student = listStudent.get(position);
        if (student.isMale()){
        viewHolder.imgavatar.setBackgroundResource(R.mipmap.nam);
        }else{
        viewHolder.imgavatar.setBackgroundResource(R.mipmap.nu);
        }
        viewHolder.tvname.setText(String.valueOf(student.getName()));
        viewHolder.tvsex.setText(String.valueOf(student.getSex()));
        viewHolder.tvnumber.setText(String.valueOf(student.getNumber()));
        viewHolder.tvaddress.setText(String.valueOf(student.getAddress()));

        return convertView;
    }
    public class ViewHolder{
        private TextView tvsex;
        private TextView tvname;
        private TextView tvnumber;
        private TextView tvaddress;
        private ImageView imgavatar;
    }
}
