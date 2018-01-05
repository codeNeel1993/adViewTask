package com.indranil.adviewtask.controller.adapter;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.indranil.adviewtask.R;
import com.indranil.adviewtask.controller.api.Api;
import com.indranil.adviewtask.controller.api.ApiManager;
import com.indranil.adviewtask.model.constants.Constants;
import com.indranil.adviewtask.model.constants.FailureCodes;
import com.indranil.adviewtask.model.listners.GridListner;
import com.indranil.adviewtask.model.listners.ResponseProgressListner;
import com.indranil.adviewtask.model.pojo.GridResultModel;
import com.indranil.adviewtask.view.activity.MainActivity;
import com.indranil.adviewtask.view.utils.GridDiffCallback;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 1/3/2018.
 */

public class ListsAdapter extends RecyclerView.Adapter implements ResponseProgressListner,GridListner{

    List<List<String>> headerList = new ArrayList<>();
    Context context;
    List<GridResultModel> gridResultModelList ;
    GridAdapter gridAdapter ;

    public ListsAdapter(Context context, List<List<String>> datasModels) {
        this.context = context;
        headerList = datasModels;
    }

    @Override
    public ListsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_list, parent, false);
        return new ListsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        final ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        for (int i = 0; i <headerList.size() ; i++) {
            viewHolder1.header.setText(headerList.get(position).get(0));

          }
        viewHolder1.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nat_cat_id = headerList.get(position).get(8);
                String keyword = headerList.get(position).get(19);
                String url = "searchziva.php?city=Bangalore&state=&case=spcall&stype=category_list&search="+keyword+"&national_catid="+nat_cat_id+"&area=&gcity=&garea=&glat=&glon=&max=9&pg_no=1&rnd1=0.85964&rnd2=0.36009&rnd3=0.42308&wap=2&login_mobile=9036696079&sid=%252BA4tZ78EaDX6o48Z%252B5wfiFQ58rsMYRC88uVdeB%252BpIJg%253D&sver=1.0&tid=1.0&accessToken=5c0ae4fe96421c796082ad0cd06f14120fb115d7&createdOn=1514306573&expires=1545842573&refreshToken=25efc4a673b97d8ad1e16c1fc5b050badb77e5a6&scope=&refreshTokenExpires=1515516173&tokenType=Bearer&mvbksrc=ft%2Cpvr%2Ccinemax%2Cfc&jdlite=0&nextdocid=&nd=1";
                getGridItems(url);
            }
        });

    }

    private void getGridItems(String url) {
        ApiManager.getGridDetails(context, url ,this,this);
    }


    @Override
    public int getItemCount() {
        return headerList.size();
    }

    @Override
    public void onResponseInProgress() {

    }

    @Override
    public void onResponseCompleted(Object response) {
        if (response instanceof Integer) {
            int value = (int) response;
            switch (value) {
                case 2:
//                    updateGrid(gridResultModelList);
                    break;

            }
        }
    }

    public void updateGrid(List<GridResultModel> gridResultModelList) {
        final GridDiffCallback diffCallback = new GridDiffCallback(this.gridResultModelList, gridResultModelList);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.gridResultModelList.clear();
        this.gridResultModelList.addAll(gridResultModelList);
        diffResult.dispatchUpdatesTo(gridAdapter);
    }

    @Override
    public void onResponseFailed(FailureCodes code) {

    }

    @Override
    public void getGridList(List<GridResultModel> list) {
        gridAdapter = new GridAdapter(context,list);
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
