package com.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements ContactAdapter.ItemEventListener {

    private ContactAdapter adapter;
    private int edittingItemPosition = -1;
    private EditText fullNameEt;
    private ImageView addNewContactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new ContactAdapter(this);
        recyclerView.setAdapter(adapter);


        fullNameEt = findViewById(R.id.et_main_contactFullName);
        addNewContactBtn = findViewById(R.id.iv_main_addNewContact);

        addNewContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fullNameEt.length() > 0) {
                    if(edittingItemPosition > -1){
                        adapter.updateContact(fullNameEt.getText().toString(), edittingItemPosition);
                        edittingItemPosition = -1;
                        addNewContactBtn.setImageResource(R.drawable.ic_add_white_24dp);
                    }else{
                        adapter.addNewContact(fullNameEt.getText().toString());
                        // recyclerView.smoothScrollToPosition(0); // اسکرول به نرمی انجام میشود.
                        recyclerView.scrollToPosition(0);
                    }
                    fullNameEt.setText("");
                }
            }
        });


    }

    @Override
    public void onItemClick(String fullName, int position) {
        edittingItemPosition = position;
        fullNameEt.setText(fullName);
        addNewContactBtn.setImageResource(R.drawable.ic_done_white_24dp);
    }
}