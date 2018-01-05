package com.indranil.adviewtask.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.indranil.adviewtask.R;
import com.indranil.adviewtask.controller.adapter.GridAdapter;
import com.indranil.adviewtask.controller.adapter.ListsAdapter;
import com.indranil.adviewtask.controller.api.ApiManager;
import com.indranil.adviewtask.model.constants.FailureCodes;
import com.indranil.adviewtask.model.listners.GridListner;
import com.indranil.adviewtask.model.listners.ListListner;
import com.indranil.adviewtask.model.listners.ResponseProgressListner;
import com.indranil.adviewtask.model.pojo.GridResultModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements ResponseProgressListner, ListListner ,GridListner{

    @BindView(R.id.recyclerViewList)RecyclerView recyclerView;
    @BindView(R.id.recyclerViewGrid)RecyclerView gridRecyclerView;

    List<List<String>> list1 = new ArrayList<>();
    List<GridResultModel> resultModelList = new ArrayList<>();

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mGridLayoutManager;
    public String url = "searchziva.php?city=Bangalore&state=&case=spcall&stype=category_list&search=Restaurants&national_catid=10408936&area=&gcity=&garea=&glat=&glon=&max=9&pg_no=1&rnd1=0.85964&rnd2=0.36009&rnd3=0.42308&wap=2&login_mobile=9036696079&sid=%252BA4tZ78EaDX6o48Z%252B5wfiFQ58rsMYRC88uVdeB%252BpIJg%253D&sver=1.0&tid=1.0&accessToken=5c0ae4fe96421c796082ad0cd06f14120fb115d7&createdOn=1514306573&expires=1545842573&refreshToken=25efc4a673b97d8ad1e16c1fc5b050badb77e5a6&scope=&refreshTokenExpires=1515516173&tokenType=Bearer&mvbksrc=ft%2Cpvr%2Ccinemax%2Cfc&jdlite=0&nextdocid=&nd=1";

    private ListsAdapter listsAdapter;
    private GridAdapter gridAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);

        if(listsAdapter == null){
            ApiManager.getListDetails(this,this,this);
        }

        mGridLayoutManager = new GridLayoutManager(this,2);
        gridRecyclerView.setLayoutManager(mGridLayoutManager);

        if(gridAdapter == null){
            ApiManager.getGridDetails(this,url,this,this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

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
                    gridAdapter = new GridAdapter(this, resultModelList);
                    gridRecyclerView.setAdapter(gridAdapter);
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

    @Override
    public void getGridList(List<GridResultModel> list) {
        resultModelList = list;
    }
}
