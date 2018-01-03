package com.indranil.adviewtask.model.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 1/3/2018.
 */

public class ResultsModel {

    List<String> columns ;
    List<Object>  banner ;
    List<List<String>>  data ;
    private String vid;
    private String vn;
    private String icon_path;
    private String banner_path;
    private String img;
    private String vmsg;
    private Integer totalnoofresult;


    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<Object> getBanner() {
        return banner;
    }

    public void setBanner(List<Object> banner) {
        this.banner = banner;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getIcon_path() {
        return icon_path;
    }

    public void setIcon_path(String icon_path) {
        this.icon_path = icon_path;
    }

    public String getBanner_path() {
        return banner_path;
    }

    public void setBanner_path(String banner_path) {
        this.banner_path = banner_path;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVmsg() {
        return vmsg;
    }

    public void setVmsg(String vmsg) {
        this.vmsg = vmsg;
    }

    public Integer getTotalnoofresult() {
        return totalnoofresult;
    }

    public void setTotalnoofresult(Integer totalnoofresult) {
        this.totalnoofresult = totalnoofresult;
    }
}
