package com.tahmid.l2t2allpdf;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class activity_dashboard extends AppCompatActivity {

    GridView gridView;
    TextView text;
    ImageView image;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        gridView = findViewById(R.id.gridview);
        /////////////////////////////////////////////////////////////////////////
        hashmap = new HashMap<>();
        hashmap.put("text", "DBMS");
        hashmap.put("image", "database");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Vector Calculus");
        hashmap.put("image", "vector_calculus");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Complex Number");
        hashmap.put("image", "complex_number");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Algorithm");
        hashmap.put("image", "algorithm");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Digital Signal Processing");
        hashmap.put("image", "dsp");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Electrical Drives and Instrumentation");
        hashmap.put("image", "electrical");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Term question(21 batch)");
        hashmap.put("image", "question_21");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Term question(20 batch)");
        hashmap.put("image", "question_20");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Term question(19 batch)");
        hashmap.put("image", "question_19");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Term question(18 batch)");
        hashmap.put("image", "question_18");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "CT questions(21)");
        hashmap.put("image", "ct_question_21");
        arrayList.add(hashmap);

        hashmap = new HashMap<>();
        hashmap.put("text", "Routine");
        hashmap.put("image", "routine");
        arrayList.add(hashmap);

        //////////////////////////////////////////////////////////

        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item, parent, false);

            text = myView.findViewById(R.id.text);
            image = myView.findViewById(R.id.image);

            HashMap<String, String> currentItem = arrayList.get(position);

            text.setText(currentItem.get("text"));
            image.setImageResource(getResources().getIdentifier(currentItem.get("image"), "drawable", getPackageName()));

            image.setOnClickListener(v -> {
                MainActivity.assetName = currentItem.get("text") + ".pdf";
                Intent intent = new Intent(activity_dashboard.this, MainActivity.class);
                startActivity(intent);
            });
            return myView;
        }
    }
}
