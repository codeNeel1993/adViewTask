package com.indranil.adviewtask.model.pojo;

/**
 * Created by pc on 1/3/2018.
 */

public class ResponseModel {

    ResultsModel results;
    private String msg;
    private String errorcode;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public ResultsModel getResults() {
        return results;
    }

    public void setResults(ResultsModel results) {
        this.results = results;
    }
}
