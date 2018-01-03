package com.indranil.adviewtask.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.indranil.adviewtask.R;
import com.indranil.adviewtask.model.constants.Constants;
import com.indranil.adviewtask.model.pojo.ResponseModel;
import com.indranil.adviewtask.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 1/3/2018.
 */

public class ListsAdapter extends RecyclerView.Adapter {

    List<List<String>> headerList = new ArrayList<>();
    Context context;

    public ListsAdapter(MainActivity mainActivity, List<List<String>> datasModels) {
        context = mainActivity;
        headerList = datasModels;
    }

    @Override
    public ListsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_list, parent, false);
        return new ListsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        final ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        for (int i = 0; i <headerList.size() ; i++) {
            viewHolder1.header.setText(headerList.get(position).get(0));
            viewHolder1.header.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String national_catId = headerList.get(position).get(8);
                }
            });
            if(i == headerList.size()){
                viewHolder1.dot.setVisibility(View.GONE);
            }

        }



    }



    @Override
    public int getItemCount() {
        return headerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.headerText)TextView header;
        @BindView(R.id.dot)TextView dot;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
