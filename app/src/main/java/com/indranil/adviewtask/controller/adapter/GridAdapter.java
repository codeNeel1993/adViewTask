package com.indranil.adviewtask.controller.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.indranil.adviewtask.R;
import com.indranil.adviewtask.model.pojo.GridResultModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 1/4/2018.
 */

public class GridAdapter extends RecyclerView.Adapter {

    List<GridResultModel> resultModelList = new ArrayList<>();
    Context context;

    public GridAdapter(Context mainActivity, List<GridResultModel> resultModelList) {
      this.resultModelList = resultModelList;
      context = mainActivity;
    }

    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_list, parent, false);
        return new GridAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final GridAdapter.ViewHolder viewHolder1 = (ViewHolder) viewHolder;

        viewHolder1.rating.setText(resultModelList.get(position).getCompRating());
        viewHolder1.name.setText(resultModelList.get(position).getName());
        viewHolder1.address.setText(resultModelList.get(position).getArea());
        viewHolder1.type.setText(resultModelList.get(position).getType());
        String image_url =  resultModelList.get(position).getThumbnail();
        Glide.with(context)
             .load(image_url)
              .into(viewHolder1.background);
        if(resultModelList.get(position).getOpennow().equals(1)){
            viewHolder1.openClose.setText("Open Now");
        }else{
            viewHolder1.openClose.setText("Closed");
        }


    }



    @Override
    public int getItemCount() {
        return resultModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rating)TextView rating;
        @BindView(R.id.name)TextView name;
        @BindView(R.id.address)TextView address;
        @BindView(R.id.type)TextView type;
        @BindView(R.id.openClose)TextView openClose;
        @BindView(R.id.thumbnail)ImageView background;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

    }
}
