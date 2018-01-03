package com.indranil.adviewtask.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.indranil.adviewtask.R;
import com.indranil.adviewtask.controller.adapter.GridAdapter;
import com.indranil.adviewtask.controller.adapter.ListsAdapter;
import com.indranil.adviewtask.controller.api.ApiManager;
import com.indranil.adviewtask.model.constants.FailureCodes;
import com.indranil.adviewtask.model.listners.ListListner;
import com.indranil.adviewtask.model.listners.ResponseProgressListner;
import com.indranil.adviewtask.model.pojo.GridResultModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ResponseProgressListner, ListListner {

    @BindView(R.id.recyclerViewList)RecyclerView recyclerView;
    @BindView(R.id.recyclerViewGrid)RecyclerView gridRecyclerView;

    List<List<String>> list1 = new ArrayList<>();
    List<GridResultModel> resultModelList = new ArrayList<>();

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mGridLayoutManager;

    private ListsAdapter listsAdapter;
    private GridAdapter gridAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);

        ApiManager.getListDetails(this,this,this);

        mGridLayoutManager = new GridLayoutManager(this,2);
        gridRecyclerView.setLayoutManager(mGridLayoutManager);
        gridAdapter = new GridAdapter(this, resultModelList);
        gridRecyclerView.setAdapter(gridAdapter);

    }

    @Override
    public void onResponseInProgress() {

    }

    @Override
    public void onResponseCompleted(Object response) {
        if (response instanceof Integer) {
            int value = (int) response;
            switch (value) {
                case 1:
                    listsAdapter = new ListsAdapter(this, list1);
                    recyclerView.setAdapter(listsAdapter);
                    break;
                case 2:

                    break;
                case 0:
                    break;
            }
        }
    }

    @Override
    public void onResponseFailed(FailureCodes code) {
        switch (code) {
            case API_ERROR:
                Toast.makeText(this, "Api Error", Toast.LENGTH_SHORT).show();
                break;
            case NO_INTERNET:
                Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
                break;
            case RESPONSE_NULL:
                Toast.makeText(this, "Null Response", Toast.LENGTH_SHORT).show();
                break;
            case STATUS_0:
                break;
        }
    }

    @Override
    public void getHeaderList(List<List<String>> list) {
       list1 = list;
    }
}
