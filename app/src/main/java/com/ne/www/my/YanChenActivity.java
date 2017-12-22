package com.ne.www.my;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 27687 on 2017/12/21.
 */

public class YanChenActivity extends Activity implements View.OnClickListener {
    private EditText editText;
    private TextView textView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonJia;
    private Button buttonJian;
    private Button buttonCheng;
    private Button buttonChu;
    private Button buttonDeng;
    private Button buttonDian;
    private Button buttonC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yanchen);
        editText = (EditText) findViewById(R.id.edit_text);
        textView = (TextView) findViewById(R.id.text_view);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        buttonJia = (Button) findViewById(R.id.buttonJia);
        buttonJian = (Button) findViewById(R.id.buttonJian);
        buttonCheng = (Button) findViewById(R.id.buttonCheng);
        buttonChu = (Button) findViewById(R.id.buttonChu);
        buttonDian = (Button) findViewById(R.id.buttonDian);
        buttonDeng = (Button) findViewById(R.id.buttonDeng);
        buttonC = (Button) findViewById(R.id.buttonC);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonJia.setOnClickListener(this);
        buttonDeng.setOnClickListener(this);

    }

    String curStr="";     //缓存首次输入信息
    String curYun="";  //运算信息
    String lstStr="0";    //

    @Override
    public void onClick(View v) {
        int curId = v.getId();
        if(curId == button1.getId()) {
            curStr+="1";
            textView.setText(curStr);
        }else if(curId == button2.getId()){
            curStr+="2";
            textView.setText(curStr);
        }else if(curId == button3.getId()){
            curStr+="3";
            textView.setText(curStr);
        }else if(curId == button4.getId()){
            curStr+="4";
            textView.setText(curStr);
        }else if(curId == button5.getId()){
            curStr+="5";
            textView.setText(curStr);
        }else if(curId == button6.getId()){
            curStr+="6";
            textView.setText(curStr);
        }else if(curId == button7.getId()){
            curStr+="7";
            textView.setText(curStr);
        }else if(curId == button8.getId()){
            curStr+="8";
            textView.setText(curStr);
        }else if(curId == button9.getId()){
            curStr+="9";
            textView.setText(curStr);
        }else if(curId == button0.getId()){
            curStr+="0";
            textView.setText(curStr);
        } else if(curId == buttonC.getId()){
            curStr="";
            lstStr = "";
            textView.setText("0");
        }else if (curId == buttonJia.getId()){
            curYun="+";
            int a = 0;
            int b = 0 ;
            try {
                b = Integer.parseInt(curStr);
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                a = Integer.parseInt(lstStr);
            }catch (Exception e){
                e.printStackTrace();
            }
//            lstStr=curStr;
            a=a+b;
            lstStr = a+"";
            curStr="";
            textView.setText(lstStr);
        }else if (curId == buttonDeng.getId()){
//            lstStr
//                    int a = (int)lstStr+(int)curStr;
            int a = 0;
            int b= 0 ;
            try {
                 b = Integer.parseInt(curStr);
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                a = Integer.parseInt(lstStr);
            }catch (Exception e){
                e.printStackTrace();
            }
            int c = a+b;
            lstStr = c+"";
            curStr = "0";
            textView.setText(lstStr);
        }
    }

}
