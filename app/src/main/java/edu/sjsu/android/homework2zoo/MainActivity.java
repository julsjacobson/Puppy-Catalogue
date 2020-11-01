package edu.sjsu.android.homework2zoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private static final String TAG = "MainActivity";

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Log.d(TAG, "onCreated: started.");
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        images.add("https://i.ibb.co/kGmWNKZ/Screen-Shot-2020-10-04-at-1-13-33-PM.png");
        names.add("Frankie");
        desc.add("White pomeranian\nSometimes smelly\nLoves kisses\nLoud bark");

        images.add("https://i.ibb.co/KyGLC4F/Screen-Shot-2020-10-04-at-1-13-42-PM.png");
        names.add("Kuma");
        desc.add("Tan chihuaha\nAmazing catcher\nVery good boy\nCrybaby");

        images.add("https://i.ibb.co/WPxqktW/seabee.jpg");
        names.add("Seabee");
        desc.add("Tan pomeranian\nAn angel\nVery shy\nWill bite!");

        images.add("https://i.ibb.co/cQ67PWD/IMG-2733.jpg");
        names.add("Lando");
        desc.add("Giant black schnauzer\nTall boy!\nLoves pets\nForce sensitive?");

        images.add("https://i.ibb.co/vPZn81p/IMG-2734.jpg");
        names.add("Ahsoka");
        desc.add("Giant grey schnauzer\nPretty girl\nSwimming queen\nAttitude! ");

        images.add("https://i.ibb.co/ry9Phcb/IMG-2732.jpg");
        names.add("Jawa");
        desc.add("Black mini schnauzer\nSmall boy\nTiny puppy bites\nExcited to come home");

        initRecyclerView();

    }

    private void initRecyclerView() {

        androidx.recyclerview.widget.RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(names, images, desc, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.info:
                Intent info = new Intent(MainActivity.this, InfoActivity.class);
                MainActivity.this.startActivity(info);
                break;

            case R.id.home:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
                break;

            case R.id.uninstall:
                Intent uninstall = new Intent(Intent.ACTION_DELETE);
                startActivity(uninstall);
                break;
        }

        return super.onOptionsItemSelected(item);

    }

}
