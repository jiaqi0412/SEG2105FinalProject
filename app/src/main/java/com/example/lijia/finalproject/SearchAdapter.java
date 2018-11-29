package com.example.lijia.finalproject;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    Context context;
    ArrayList<String> serviceNameList;

    class SearchViewHolder extends RecyclerView.ViewHolder{
        TextView serviceName;

        public SearchViewHolder(View itemView){
            super(itemView);
            serviceName = itemView.findViewById(R.id.serviceName);
        }
    }

    public SearchAdapter(Context contex, ArrayList<String> serviceNameList) {
        this.context = contex;
        this.serviceNameList = serviceNameList;
    }





    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view =LayoutInflater.from(context).inflate(R.layout.activity_home_owner_search_page, parent, false);
        return new SearchAdapter.SearchViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position){
        holder.serviceName.setText(serviceNameList.get(position));


    }

    @Override
    public int getItemCount(){
        return serviceNameList.size();
    }

}
