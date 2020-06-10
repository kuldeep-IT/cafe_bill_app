package com.example.javaviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView qty,priceView;
    Button increment,decrement,order;
    CheckBox chocolate,cream;

    EditText name;


    int quantity=2;
    String msg,q1;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qty=findViewById(R.id.qty);
        increment=findViewById(R.id.increment);
        decrement=findViewById(R.id.decrement);
        order=findViewById(R.id.order);
        priceView=findViewById(R.id.priceView);
        chocolate=(CheckBox) findViewById(R.id.chocolate);
        cream=(CheckBox) findViewById(R.id.cream);
        name=findViewById(R.id.name);


    }


    private String name1()
    {

        String n1=String.valueOf(name.getText());
        return  n1;

    }

    public void decrement(View view) {

        if(quantity>1 ) {
            quantity=quantity - 1;
            qty.setText(String.valueOf(quantity));
        }


    }

    public void increment(View view) {

        if(quantity>=1 && quantity <100) {

            quantity=quantity + 1;
            qty.setText(String.valueOf(quantity));
        }

    }

    private boolean bg1()
    {
        boolean bg=chocolate.isChecked();
        return bg;
    }

    private boolean pz1()
    {
        boolean pz=cream.isChecked();
        return pz;
    }





    private int displayPrice1()
    {


        price = (quantity *5) + 1;
        return price;

    }

    private int displayPrice2()
    {


        price = (quantity * 2);
        return price;

    }

    private int countPrice()
    {
        if (chocolate.isChecked() && cream.isChecked())
        {
            int count=  (5+2+1)*quantity;
            return count;

        }
        else if (cream.isChecked())
        {
            int count = (5+2)*quantity;
            return count;

        }
        else if (chocolate.isChecked())
        {
            int count=  (5+1)*quantity;
            return count;
        }
        else
        {

            int count= (quantity*5);
            return count;

        }


    }


    public void submit(View view) {



        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL,"rathod99244@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "order details: "+name1());
        intent.putExtra(Intent.EXTRA_TEXT, msg1());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
//

//        priceView.setText(msg1());


    }

    public String msg1()
    {

        msg="Name: " + name1();
        msg+="\nR u preferring Chocolate? " + bg1();
        msg+="\nR u preferring Cream? " + pz1();
        msg+="\nQuantity: " + quantity;


        msg=msg + "\nTotal: $" + countPrice();                                 // Integer.valueOf(displayPrice1()+ displayPrice2());

        msg+="\nThank you!";
        return msg;


    }



}
