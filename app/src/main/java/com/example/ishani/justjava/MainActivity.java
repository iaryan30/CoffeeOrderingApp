package com.example.ishani.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method for + button
    public void increment(View view){
        quantity=quantity+1;
        displayQuantity(quantity);
    }
//mrthod for - button
    public void decrement(View view){
        quantity=quantity-1;
        displayQuantity(quantity);
    }

    // method for order button
    public void submitOrder( View view){
        EditText username= (EditText) findViewById(R.id.name_ed);
        //String customername= String.valueOf(username.getText()); //does the same as below
        String customername=username.getText().toString();

        CheckBox WippedCream= (CheckBox) findViewById(R.id.wc_checkbox);
        boolean haswippedcream= WippedCream.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price=CalculatePrice(haswippedcream , hasChocolate);
        String message=CreateOrderSummary( price,haswippedcream, hasChocolate,customername);
        displayMessage(message);
    }
//calculate priceof the order
    private int CalculatePrice( boolean addWhhippedCream, boolean addChocolate)
    {
        int baseprice= 5;
        if(addWhhippedCream)
        {
            baseprice= baseprice+1;
        }
        if (addChocolate)
        {
            baseprice=baseprice+2;
        }

        return quantity*baseprice;
    }

    private void displayQuantity(int numberofCoffees) {
        TextView quantityTextView= (TextView) findViewById(R.id.quantity_tv);
        quantityTextView.setText(""+numberofCoffees);
        //quantityTextView.setText(String.format("%d", number));

    }

    private String CreateOrderSummary(int price, boolean addwippedcream, boolean addChocolate ,String username)
    {
        String priceMessage= "Name of the customer: "+username;
        priceMessage +="\nAdded wipped cream: "+addwippedcream;
        priceMessage +="\nAdded Chocolate: "+addChocolate;
        priceMessage +="\nQuantity: "+ quantity;
        priceMessage +="\nToatal: "+ price;
        priceMessage +="\nThank you!";
        return priceMessage;

    }
/*
    private void displayPrice(int number){
        TextView priceTextView= (TextView) findViewById(R.id.price_tv);
        priceTextView.setText(java.text.NumberFormat.getCurrencyInstance().format(number));
    }*/
    private void displayMessage(String messages){
        TextView ordersummaryTextView= (TextView) findViewById(R.id.order_summary_tv);
        ordersummaryTextView.setText(messages);
    }
}
