package com.ne.www.my;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

/**
 * Created by 27687 on 2017/12/21.
 */

public class YanChenActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "YanChenActivity";
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
        button1.setOnClickListener(this);  //监听
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
        buttonDian.setOnClickListener(this);
    }

    String curStr="";     //缓存首次输入信息
    String lstStr="0";    //显示结果

    @Override
    public void onClick(View v) {  //点击事件回调方法
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
        }else if(curId == buttonDian.getId()){
            if(curStr.contains(".")){
                Log.e(TAG,"已经存在小数点了；不能再添加了");
                Toast.makeText(this, "无效的小数点", Toast.LENGTH_SHORT).show();
            }else {
                if(TextUtils.isEmpty(curStr)){
                    curStr += "0.";
                }else {
                    curStr += ".";
                }
            }
            textView.setText(curStr);
        }
        else if(curId == buttonC.getId()){
            curStr="";
            lstStr = "";
            textView.setText("0");
            curOperation = null;
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
    private double addition(double a,double b){
        BigDecimal bigDecimalA = new BigDecimal(Double.toString(a));
        BigDecimal bigDecimalB = new BigDecimal(Double.toString(b));
        double c = bigDecimalA.add(bigDecimalB).doubleValue();
        return c;
    }

    /**
     * 减法运算
     */
    private double subtraction(double a,double b){
        BigDecimal bigDecimalA = new BigDecimal(Double.toString(a));
        BigDecimal bigDecimalB = new BigDecimal(Double.toString(b));
        double c = bigDecimalA.subtract(bigDecimalB).doubleValue();
        return c;
    }

    /**
     * 乘法运算
     */
    private double multiplication(double a,double b){
        BigDecimal bigDecimalA = new BigDecimal(Double.toString(a));
        BigDecimal bigDecimalB = new BigDecimal(Double.toString(b));
        double c = bigDecimalA.multiply(bigDecimalB).doubleValue();
        return c;
    }

    /**
     * 除法运算
     */
    private double division(double a,double b){

        if(b==0){
            return 0;
        }
        BigDecimal bigDecimalA = new BigDecimal(Double.toString(a));
        BigDecimal bigDecimalB = new BigDecimal(Double.toString(b));
        double c = bigDecimalA.divide(bigDecimalB).doubleValue();
        return c;
    }

    /**
     * 等于的结果
     */
    private String equalResult(Operation operation,String aStr,String bStr){

        double a = 0;
        double b = 0;
        if(!TextUtils.isEmpty(aStr)) {
            try {
                a = Double.parseDouble(aStr); //Double对象 调用方法
            } catch (Exception e) { //转换失败，异常捕获
                e.printStackTrace();//打印异常信息
            }
        }
        if(!TextUtils.isEmpty(bStr)) {
            try {
                b = Double.parseDouble(bStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int resultInt;//转换判断结果是否为整数类型用的；
        if(operation == null || operation == Operation.equalResult){
            if(a == 0) {
                resultInt = (int)b;
                if((b - resultInt)==0){
                    return resultInt+"";//结果为整数；
                }
                return b+"";
            }
            resultInt = (int)a;
            if((a - resultInt)==0){
                return resultInt+"";//结果为整数；
            }
            return a+"";
        }
        double result = 0;
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
        resultInt = (int)result;
        if((result - resultInt)==0){
            return resultInt+"";//结果为整数；
        }
        return result+"";//结果有小数点
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
