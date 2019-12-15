package com.example.recyclerviewsearch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewsearch.R;
import com.example.recyclerviewsearch.model.SearchListModel;

import java.util.ArrayList;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    ArrayList<SearchListModel> stringArrayList;
    Context context;

    public SearchListAdapter(ArrayList<SearchListModel> stringArrayList, Context context) {
        this.stringArrayList = stringArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SearchListModel searchListModel = stringArrayList.get(position);
        holder.textViewSearchList.setText(searchListModel.getName());
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSearchList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSearchList = itemView.findViewById(R.id.tv_list);
        }
    }

    public void filterLIst(ArrayList<SearchListModel> searchListModelArrayList){
        this.stringArrayList = searchListModelArrayList;
        notifyDataSetChanged();
    }
}
