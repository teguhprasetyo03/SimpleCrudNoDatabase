package com.studiomasteguh.simplecrudnodatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rc;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MusicItem> musicList = new ArrayList<>();
        musicList.add(new MusicItem(R.drawable.andi, "Happy Asmara", "Dalan Liyane"));
        musicList.add(new MusicItem(R.drawable.alfian, "Danny Caknan", "Sugeng Dalu"));
        musicList.add(new MusicItem(R.drawable.evan, "Happy Asmara", "Pamit"));

        rc = findViewById(R.id.recyler);
        rc.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        adapter = new MusicItemAdapter(musicList);

        // set adapter
        rc.setLayoutManager(lm);
        rc.setAdapter(adapter);
    }
}
