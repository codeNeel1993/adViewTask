package com.indranil.adviewtask.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.indranil.adviewtask.R;
import com.indranil.adviewtask.model.pojo.GridResultModel;
import com.indranil.adviewtask.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by pc on 1/4/2018.
 */

public class GridAdapter extends RecyclerView.Adapter {

    List<GridResultModel> resultModelList = new ArrayList<>();
    Context context;

    public GridAdapter(MainActivity mainActivity, List<GridResultModel> resultModelList) {
      this.resultModelList = resultModelList;
      context = mainActivity;
    }

    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_list, parent, false);
        return new GridAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final GridAdapter.ViewHolder viewHolder1 = (ViewHolder) viewHolder;
    }



    @Override
    public int getItemCount() {
        return resultModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
