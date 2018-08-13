package com.example.annascott.buttondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    int desertNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of Dessert objects
        final ArrayList<Dessert> desserts = new ArrayList<Dessert>();

        desserts.add(new Dessert("Donut", 0, R.drawable.doughnut));
        desserts.add(new Dessert("Cookie", 0, R.drawable.cookie));
        desserts.add(new Dessert("PieceOfCake", 0, R.drawable.piece_of_cake));
        desserts.add(new Dessert("Pastry", 0, R.drawable.pastry));

        // Create an {@link DessertAdapter}, whose data source is a list of
        // {@link Dessert}s. The adapter knows how to create list item views for each item
        // in the list.
        DesertAdapter flavorAdapter = new DesertAdapter(this, desserts);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_dessert);
        listView.setAdapter(flavorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Dessert dessert = desserts.get(i);
                switch(i) {
                    case 0:
                        Intent donut = new Intent(MainActivity.this, Donut.class);
                        startActivity(donut);
                        break;
                    case 1:
                        Intent cookie = new Intent(MainActivity.this, Cookie.class);
                        startActivity(cookie);
                        break;
                    case 2:
                        Intent pieceOfCake = new Intent(MainActivity.this, PieceOfCake.class);
                        startActivity(pieceOfCake);
                        break;
                    case 3:
                        Intent pastry = new Intent(MainActivity.this, Pastry.class);
                        startActivity(pastry);
                        break;
                }
    }
});
    }
    public void Decrement(View view) {

        LinearLayout parentRow = (LinearLayout) view.getParent();

        TextView quantityView = (TextView) parentRow.findViewById(R.id.dessert_number);
        String quantityString = quantityView.getText().toString();
        desertNumber = Integer.parseInt(quantityString);
        desertNumber -= 1;

        if (desertNumber < 0) {
            desertNumber = 0;
            Toast.makeText(MainActivity.this, "Can not be less than 0",
                    Toast.LENGTH_SHORT).show();}
        quantityView.setText(String.valueOf(desertNumber));
    }
    public void Increment(View view) {

        LinearLayout parentRow = (LinearLayout) view.getParent();

        TextView quantityView = (TextView) parentRow.findViewById(R.id.dessert_number);
        String quantityString = quantityView.getText().toString();
        desertNumber = Integer.parseInt(quantityString);
        desertNumber += 1;
        quantityView.setText(String.valueOf(desertNumber));
    }
}