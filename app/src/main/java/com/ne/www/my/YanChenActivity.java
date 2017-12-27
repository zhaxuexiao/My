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
    Operation curOperation;
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
        buttonJian.setOnClickListener(this);
        buttonCheng.setOnClickListener(this);
        buttonChu.setOnClickListener(this);

    }

    String curStr="";     //缓存首次输入信息
//    String curYun="";  //运算信息
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
            lstStr = equalResult(curOperation,lstStr,curStr)+"";
            curOperation = Operation.addition;
            curStr="";
            textView.setText(lstStr);
        }else if (curId == buttonDeng.getId()){
            lstStr = equalResult(curOperation,lstStr,curStr)+"";
            curStr = "";
            textView.setText(lstStr);
            curOperation = Operation.equalResult;
        }else if (curId == buttonJian.getId()){
            //点击运算按钮的时候；需要先完成上一次的运算
            lstStr = equalResult(curOperation,lstStr,curStr)+"";
            curOperation = Operation.subtraction;
            curStr="";
            textView.setText(lstStr);
        }else if (curId == buttonCheng.getId()){
            lstStr = equalResult(curOperation,lstStr,curStr)+"";
            curOperation = Operation.multiplication;
            curStr="";
            textView.setText(lstStr);
        }else if (curId == buttonChu.getId()){
            lstStr = equalResult(curOperation,lstStr,curStr)+"";
            curOperation = Operation.division;
            curStr="";
            textView.setText(lstStr);
        }
    }

    /**
     * 加法运算
     */
    private int addition(int a,int b){
        return a+b;
    }

    /**
     * 减法运算
     */
    private int subtraction(int a,int b){

        return a-b;
    }

    /**
     * 乘法运算
     */
    private int multiplication(int a,int b){

        return a*b;
    }

    /**
     * 除法运算
     */
    private int division(int a,int b){

        return a/b;
    }

    /**
     * 等于的结果
     */
    private int equalResult(Operation operation,String aStr,String bStr){

        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(aStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            b = Integer.parseInt(bStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(operation == null || operation == Operation.equalResult){
            if(a == 0) {
                return b;
            }
            return a;
        }
        int result = 0;
        switch (operation){
            case addition:{
                result = addition(a,b);
                break;
            }
            case subtraction:{
                result =  subtraction(a,b);
                break;
            }
            case multiplication:{
                result = multiplication(a,b);
                break;
            }
            case division:{
                result = division(a,b);
                break;
            }
        }
        return result;
    }

    /**
     * 枚举的运算类型
     */
    enum Operation{
        addition,
        subtraction,
        multiplication,
        division,
        equalResult
    }
}
