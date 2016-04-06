package in.debbit.realmtestapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import in.debbit.secondactivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //initialize the button
        setupbutton();
     //initialize textview for current time
        displaycurrenttime();
        displaylasttime();

        setsharedpref();
    }




    //create a toast when the button is clicked and generate a log message
        private void setupbutton() {

        Button msgbutton = (Button) findViewById(R.id.button);

        msgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Buttonmsg", "You just clicked my creation.");
                Toast.makeText(MainActivity.this, "You clicked my button", Toast.LENGTH_LONG)
                        .show();

                startActivity(new Intent(MainActivity.this, secondactivity.class));
            }
        });
    }

    //sharedpreferences


    private void displaycurrenttime() {
        Date current = new Date();
        String showtxt = "The current time is: " + current.toString();

        TextView currt = (TextView) findViewById(R.id.currenttimetxt);
        currt.setText(showtxt);
    }

    private void displaylasttime() {

        String showtxt = "You last opened this App at: " + fetchfromshpref();

        TextView currt = (TextView) findViewById(R.id.lasttimetxt);
        currt.setText(showtxt);
    }

    private String fetchfromshpref() {
        SharedPreferences sharedPreferences = getSharedPreferences("App-Time", MODE_PRIVATE);
        return sharedPreferences.getString("LastStart", "No recorded time yet.");
    }

    //function definition to set shared preferences when app is run
    private void setsharedpref() {
        String currtime = new Date().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("App-Time", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("LastStart", currtime);
        editor.commit();
    }
}
