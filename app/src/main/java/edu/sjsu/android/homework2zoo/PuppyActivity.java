package edu.sjsu.android.homework2zoo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class PuppyActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puppy);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("name")
            && getIntent().hasExtra("desc")) {
            String url = getIntent().getStringExtra("image_url");
            String name = getIntent().getStringExtra("name");
            String desc = getIntent().getStringExtra("desc");

            setImage(url, name, desc);
        }
    }

    private void setImage(String url, String name, String desc) {
        TextView puppy_name = findViewById(R.id.name);
        ImageView image = findViewById(R.id.icon);
        TextView description = findViewById(R.id.description);

        puppy_name.setText(name);
        description.setText(desc);

        Glide.with(this)
                .asBitmap()
                .load(url)
                .into(image);



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
                Intent info = new Intent(PuppyActivity.this, InfoActivity.class);
                PuppyActivity.this.startActivity(info);
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
