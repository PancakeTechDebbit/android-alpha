package in.debbit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import in.debbit.realmtestapp.R;
import in.debbit.realmtestapp.transactions;

public class secondactivity extends AppCompatActivity {
    //instantiate listview
    private List<transactions> transac = new ArrayList<transactions>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //runfunctions
        createbutton();
        populatetranslist();
        populatelistview();
        registerclickcall();

        //default code for floating button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    //to populate class
    private void populatetranslist() {
        transac.add(new transactions("Starbucks", "Coffee", "Rs. 350", R.drawable.cafe, "April 1, 2016", "Ram"));
        transac.add(new transactions("Big Basket", "Groceries", "Rs. 995", R.drawable.grocery, "March 31, 2016", ""));
        transac.add(new transactions("Airtel", "Phone Bill", "Rs. 678", R.drawable.phone, "March 31, 2016", ""));
    }

    //button to finish activity
    private void createbutton() {

        Button msgbutton = (Button) findViewById(R.id.backbutton);

        msgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Buttonmsg", "You just clicked my second creation.");
                Toast.makeText(secondactivity.this, "You clicked my second button", Toast.LENGTH_SHORT)
                        .show();
                finish();
            }
        });
    }

    //register callback on click
    private void registerclickcall() {
        ListView listView = (ListView) findViewById(R.id.transactionview);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        transactions clickedtrans = transac.get(position);
                        String message = "You clicked on Position "+position+" corresponding to "+clickedtrans.getMerchant();
                        Toast.makeText(secondactivity.this,message,Toast.LENGTH_LONG).show();
                    }
                });
    }


    //populate listview with all class elements
    private void populatelistview() {
        ArrayAdapter<transactions> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.transactionview);
        list.setAdapter(adapter);
    }

    //new class for adapter
    private class MyListAdapter extends ArrayAdapter<transactions> {
        public MyListAdapter() {
            super(secondactivity.this, R.layout.itemview, transac);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView==null) {
                itemView = getLayoutInflater().inflate(R.layout.itemview, parent, false);
            }

            transactions currenttrans = transac.get(position);

            ImageView imageView = (ImageView)itemView.findViewById(R.id.merchanticon);
            imageView.setImageResource(currenttrans.getIconid());

            TextView textView = (TextView)itemView.findViewById(R.id.merchantname);
            textView.setText(currenttrans.getMerchant());

            TextView textView1 = (TextView)itemView.findViewById(R.id.category);
            textView1.setText(currenttrans.getCategory());

            TextView textView2 = (TextView)itemView.findViewById(R.id.amount);
            textView2.setText(currenttrans.getAmount());

            if(currenttrans.getSharedwith()!=""){
                TextView textView3 = (TextView)itemView.findViewById(R.id.sharedwithname);
                String temp = " with #"+currenttrans.getSharedwith();
                textView3.setText(temp);
            }

            return itemView;
        }
    }



}
