package com.example.recylerviewcoba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final ArrayList arrayList = new ArrayList();
    RecyclerView recyclerView;
    Button send;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        send = findViewById(R.id.send);
        editText = findViewById(R.id.editText);




        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sendTo = editText.getText().toString();
                arrayList.add(sendTo);
                setList();

            }
        });


      setList();

    }

    public void setList (){
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
//            @Override
//            public int getItemViewType(int position) {
//                return position%2==0?R.layout.reitemdua:R.layout.reitemsatu;
//            }

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reitemsatu, null);
                return new RecyclerView.ViewHolder(view) {};

            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                TextView textView = viewHolder.itemView.findViewById(R.id.txtTittle);
                textView.setText(String.valueOf(arrayList.get(i)));

            }

            @Override
            public int getItemCount() {
                return arrayList.size();
            }


        });
    }



}
