package com.example.alpervural.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activities_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

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

    public void showStats(View view) {
        EditText et  = (EditText)findViewById(R.id.amount);
        String text = et.getText().toString();
        double amountEntered = Double.parseDouble(text);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        text = spinner.getSelectedItem().toString();
        double caloriesBurned = 0.0;
        String rest = "";
        if(text.substring(0,1).equals("P")) {
            caloriesBurned = amountEntered / 3.5;
            int one = (int) (amountEntered * 200.0 / 350.0);
            int two = (int) (amountEntered * 10.0 / 350.0);
            int three = (int) (amountEntered * 12.0 / 350.0);
            rest += Integer.toString(one) + " situp reps\n";
            rest += Integer.toString(two) + " jumping jack minutes\n";
            rest += Integer.toString(three) + " jogging minutes";
        }
        else if(text.substring(0,1).equals("S")){
            caloriesBurned = amountEntered / 2;
            int one = (int) (amountEntered * 350.0 / 200.0);
            int two = (int) (amountEntered * 10.0 / 200.0);
            int three = (int) (amountEntered * 12.0 / 200.0);
            rest += Integer.toString(one) + " pushup reps\n";
            rest += Integer.toString(two) + " jumping jack minutes\n";
            rest += Integer.toString(three) + " jogging minutes";
        }

        else if(text.substring(0,2).equals("Ju")){
            caloriesBurned = amountEntered * 10;
            int one = (int) (amountEntered * 350.0 / 10.0);
            int two = (int) (amountEntered * 200.0 / 10.0);
            int three = (int) (amountEntered * 12.0 / 10.0);
            rest += Integer.toString(one) + " pushup reps\n";
            rest += Integer.toString(two) + " situp reps\n";
            rest += Integer.toString(three) + " jogging minutes";
        }

        else if(text.substring(0,2).equals("Jo")){
            caloriesBurned = amountEntered * 8.5;
            int one = (int) (amountEntered * 350.0 / 12.0);
            int two = (int) (amountEntered * 200.0 / 12.0);
            int three = (int) (amountEntered * 10.0 / 12.0);
            rest += Integer.toString(one) + " pushup reps\n";
            rest += Integer.toString(two) + " situp reps\n";
            rest += Integer.toString(three) + " jumping jack minutes";
        }
        String newText = "Congratulations! You burned " + Integer.toString((int) caloriesBurned)
                + " calories.\n This is equivalent to:\n" + rest;
        TextView tv  = (TextView)findViewById(R.id.congrats1);
        tv.setText(newText);
        tv.setVisibility(TextView.VISIBLE);
    }
}
