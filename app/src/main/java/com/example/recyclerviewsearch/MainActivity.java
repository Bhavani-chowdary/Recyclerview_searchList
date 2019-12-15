package com.example.recyclerviewsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.recyclerviewsearch.adapter.SearchListAdapter;
import com.example.recyclerviewsearch.model.SearchListModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv_search_list;
    EditText ed_search;
    ArrayList<SearchListModel> searchListModelArrayList;
    SearchListAdapter searchListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_search_list = findViewById(R.id.rcv_search_list);
        ed_search = findViewById(R.id.ed_search);
        searchListModelArrayList = new ArrayList<>();
        initAdapter();

        ed_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filter(editable.toString());
            }
        });
    }

    public void initAdapter(){

        searchListModelArrayList.add(new SearchListModel(1,"Bhavani"));
        searchListModelArrayList.add(new SearchListModel(2,"Roja"));
        searchListModelArrayList.add(new SearchListModel(3,"Sreelakshmi"));
        searchListModelArrayList.add(new SearchListModel(4,"Sukanys"));
        searchListModelArrayList.add(new SearchListModel(5,"Ramnajulu"));
        searchListModelArrayList.add(new SearchListModel(6,"Rahul"));
        searchListModelArrayList.add(new SearchListModel(7,"Muneswara"));
        searchListModelArrayList.add(new SearchListModel(8,"Bhavani"));

        rcv_search_list.setHasFixedSize(true);
        rcv_search_list.setLayoutManager(new LinearLayoutManager(this));
         searchListAdapter = new SearchListAdapter(searchListModelArrayList,this);
        rcv_search_list.setAdapter(searchListAdapter);
        searchListAdapter.notifyDataSetChanged();
    }


    public void filter(String text){
        ArrayList<SearchListModel> searchListModelList =new ArrayList<>() ;

        for (SearchListModel s :searchListModelArrayList){

            if (s.getName().toLowerCase().contains(text.toLowerCase())){
                searchListModelList.add(s);
            }

        }
        searchListAdapter.filterLIst(searchListModelList);
    }
}
