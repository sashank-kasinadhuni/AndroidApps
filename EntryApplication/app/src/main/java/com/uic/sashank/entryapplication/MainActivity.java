package com.uic.sashank.entryapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout chicagoLayout = (LinearLayout) findViewById(R.id.ChicagoLayout);
        LinearLayout indianaLayout = (LinearLayout) findViewById(R.id.IndianapolisLayout);

        TextView chicagoTextView = (TextView) findViewById(R.id.chicagoTextView);
        TextView indianapolisTextView = (TextView) findViewById(R.id.indianapolisTextView);

        Button chicagoButton = (Button) findViewById(R.id.chicagoButton);
        Button indianapolisButton = (Button) findViewById(R.id.indianapolisButton);

        chicagoTextView.setText(R.string.chicagoText);
        indianapolisTextView.setText(R.string.indianapolisText);

        Drawable chicagoFlagContent = getResources().getDrawable(R.drawable.chicagoflag);
        Drawable indianapolisFlagContent = getResources().getDrawable(R.drawable.indanapolisflag);

        chicagoFlagContent.setAlpha(50);
        indianapolisFlagContent.setAlpha(50);

        chicagoTextView.setBackground(chicagoFlagContent);
        indianapolisTextView.setBackground(indianapolisFlagContent);
        chicagoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"You have Selected to view attractions of Chicago", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        indianapolisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"You have Selected to view The attractions of Indianapolis",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        //chicagoLayout.setBackground(chicagoFlagContent);
        //indianaLayout.setBackground(indianapolisFlagContent);


    }
}
