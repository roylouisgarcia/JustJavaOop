/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjavaoop;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.justjavaoop.R.layout.activity_main);
    }

    public void increment(View view){
        quantity = quantity + 1;
        displayQuantity(quantity );
        displayPrice(calculatePrice(quantity));

    }

    public void decrement(View view){
        if (quantity > 0) {
            quantity = quantity - 1;
        }
        displayQuantity(quantity);
        displayPrice(calculatePrice(quantity));


    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        displayMessage(createOrderSummary(5));

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(com.example.android.justjavaoop.R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(com.example.android.justjavaoop.R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(com.example.android.justjavaoop.R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }


    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     * @param pricePerCoffee in the local pricePerCoffee
     */
    private int calculatePrice(int quantity, int pricePerCoffee) {
        int price = quantity * pricePerCoffee;
        return price;
    }

    /**
     * Display the order summary.
     *
     */
    private String createOrderSummary(int pricePerCoffee) {
        String message = "Name: Roy Louis L. Garcia\n";
        if (quantity <2){
            message = message + "You ordered " + quantity + " coffee.";
        }else{
            message = message + "You ordered " + quantity + " coffees.";
        }
        message = message + "\n" + "Amount due: $" + calculatePrice(quantity, pricePerCoffee) + "\nThank you!";
        return message;

    }




}