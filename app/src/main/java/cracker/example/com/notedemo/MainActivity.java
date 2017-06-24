package cracker.example.com.notedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton imgbtn_add;
    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private List<Note> list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null){
        }actionbar.hide();

        initViews();
        initData();
    }

    private void initData() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        list = new ArrayList<Note>();
        List<Note> notes = ContentDao.queryAll();
        list = notes;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NoteAdapter(MainActivity.this,list);
        recyclerView.setAdapter(adapter);

    }


    private void initViews() {
        imgbtn_add = (ImageButton) findViewById(R.id.imgbtn_add);
        imgbtn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,AddActivity.class);
                    startActivity(intent);

            }
        });

    }
}
