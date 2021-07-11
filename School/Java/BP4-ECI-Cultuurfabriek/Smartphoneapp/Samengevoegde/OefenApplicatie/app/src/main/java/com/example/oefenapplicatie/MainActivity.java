package com.example.oefenapplicatie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView filmOverzicht;

    int [] image = {R.drawable.eci2,
                    R.drawable.eci,
                    R.drawable.eci2,
                    R.drawable.eci,
                    R.drawable.eci2,
                    R.drawable.eci,
                    R.drawable.eci2,
                    R.drawable.eci};

    String[] namen = {"Locatie",
                      "Logo",
                      "Locatie",
                      "Logo",
                      "Locatie",
                      "Logo",
                      "Locatie",
                      "Logo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmOverzicht = (ListView) findViewById(R.id.mainListView);
        CustomAdapter customAdapter = new CustomAdapter();
        filmOverzicht.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
             return image.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView nImageView = (ImageView) view.findViewById(R.id.imageView);
            TextView NTextView = (TextView) view.findViewById(R.id.listviewTextView);

            nImageView.setImageResource(image[position]);
            NTextView.setText(namen[position]);

            return view;
        }
    }
}
