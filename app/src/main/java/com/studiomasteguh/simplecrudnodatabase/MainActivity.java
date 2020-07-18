package com.studiomasteguh.simplecrudnodatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MusicItem> musicItemArrayList;

    private RecyclerView rc;
    private RecyclerView.LayoutManager lm;
    private MusicItemAdapter mAdapter;

    private Button btnHapus;
    private Button btnTambah;
    private EditText edtTambah;
    private EditText edtHapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tambah();
        hapus();

        btnHapus    = findViewById(R.id.btn_Delete);
        btnTambah   = findViewById(R.id.btn_Insert);
        edtHapus    = findViewById(R.id.edt_Delete);
        edtTambah   = findViewById(R.id.edt_Tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(edtTambah.getText().toString());
                tambahItem(position);
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(edtHapus.getText().toString());
                deleteItem(position);
            }
        });


    }

    public void tambahItem(int position){
        musicItemArrayList.add(position, new MusicItem(R.drawable.andi, "Waton Guyon" + position, "Korban Janji"));
        mAdapter.notifyItemInserted(position);
    }

    public void deleteItem(int position){
        musicItemArrayList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text){
        musicItemArrayList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }
    public void tambah(){
        musicItemArrayList= new ArrayList<>();
        musicItemArrayList.add(new MusicItem(R.drawable.andi, "Happy Asmara", "Dalan Liyane"));
        musicItemArrayList.add(new MusicItem(R.drawable.alfian, "Danny Caknan", "Sugeng Dalu"));
        musicItemArrayList.add(new MusicItem(R.drawable.evan, "Happy Asmara", "Pamit"));
    }

    public void hapus(){
        rc = findViewById(R.id.recyler);
        rc.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        mAdapter = new MusicItemAdapter(musicItemArrayList);

        // set adapter
        rc.setLayoutManager(lm);
        rc.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new MusicItemAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                changeItem(position, "You Clicked this item!!");
            }
        });
    }
}
