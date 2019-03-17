package com.zzy.cs.sicnu.layoutpractice;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview_menu);
        registerForContextMenu(textView);   //为textview注册上下文菜单

        //

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);//解析XML文件，恢复为所需类型
        menu.add("other");//增加一个选项
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "you choose " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.main,menu);//解析XML文件，恢复为所需类型
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, "you choose " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

    public void showPop(View v){
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.inflate(R.menu.main);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "you choose " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public void showDialog1(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录");
        builder.setMessage("是否要登录?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "you choose 确定", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "you choose 取消", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    //Marked:Mutichoice
    public void showDialog2(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录");
        final String[] strings = {"1","2","3","4"};
        final boolean[] chooses = {false,false,false,false};
        builder.setMultiChoiceItems(strings, chooses, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String context = "";
                for(int i=0;i<chooses.length;i++){
                    if(chooses[i]){
                        context += strings[i];
                    }
                }
                Toast.makeText(MainActivity.this, "you choose"+context, Toast.LENGTH_SHORT).show();
            }
        });




        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "you choose 确定", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "you choose 取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
