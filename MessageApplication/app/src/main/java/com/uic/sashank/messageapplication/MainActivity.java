package com.uic.sashank.messageapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //public final static String NUMBER = "com.uic.sashank.messageapplication.NUMBER";
    protected static boolean resumeFlag = false;
    public void sendMessage(View view){
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        String number = parseUserMessage(message);
        if(number!= ""){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //startActivity(intent);
            //intent.putExtra(NUMBER,number);
            intent.setData(Uri.parse("sms:"+number));
            resumeFlag = true;
            startActivity(intent);
        }
    }
    protected String parseNumber(String number){
        for(int i = 0;i<number.length();i++)
        {
            if(!Character.isDigit(number.charAt(i)))
                return "";
        }
        return number;
    }
    protected String parseUserMessage(String message){
        String result = "";
        char[] charArray = message.toCharArray();
        for(int i = 0;i<message.length()-12;i++){
            if(charArray[i] == '(') {
                if(charArray[i+5] !=' ')
                    result = parseNumber(message.substring(i+1,i+4)+message.substring(i+5,i+8)+message.substring(i+9,i+13));
                else
                    result = parseNumber(message.substring(i+1,i+4)+message.substring(i+6,i+9)+message.substring(i+10,i+14));
                if(result != "")
                    return result;
                else
                    result = "";
            }
        }
        return "";
    }
    protected void onStop(){
        super.onStop();
        //EditText datafield = (EditText) findViewById(R.id.edit_message);
        //datafield.setText("Returning from Messaging activity.... ");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void onStart(){
        super.onStart();
        if(resumeFlag){
            EditText textfield = (EditText) findViewById(R.id.edit_message);
            textfield.setText("Returning from Compose Message...");
            resumeFlag = false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
