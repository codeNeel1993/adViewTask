package com.indranil.adviewtask.model.pojo;

import java.util.List;

/**
 * Created by pc on 1/4/2018.
 */

public class GridResponseModel {

    private List<GridResultModel> results = null;
    private String nearmeDetails;
    private String catid;
    private Integer trendingFlag;
    private String trendingNid;
    private String keyword;
    private Integer ishotel;
    private List<Object> keywordResults = null;
    private String moreKeywords;
    private String totalNumberofResults;
    private String ratingsTab;
    private Integer pncdbd;
    private String ismovie;
    private Integer sortPriceTag;
    private List<Object> sortPrice = null;
    private String viewFlag;
    private Integer filterFlag;
    private String imagePath;
    private Integer view;
    private String nationalCatid;
    private String medianLatitude;
    private String medianLongitude;
   /* private String vpfs;
    private String msgpos;
    private String areadocids;
    private String areaDocidsCnt;
    private String nofriends;
    private String nextdocid;
    private String nextdocidcount;
    private String scity;
    private String spincode;
    private Integer amp;
    private Integer numberMask;
    private String moviesnf;
    private Integer other;
    private Error error;*/

    public List<GridResultModel> getResults() {
        return results;
    }

    public void setResults(List<GridResultModel> results) {
        this.results = results;
    }

    public String getNearmeDetails() {
        return nearmeDetails;
    }

    public void setNearmeDetails(String nearmeDetails) {
        this.nearmeDetails = nearmeDetails;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public Integer getTrendingFlag() {
        return trendingFlag;
    }

    public void setTrendingFlag(Integer trendingFlag) {
        this.trendingFlag = trendingFlag;
    }

    public String getTrendingNid() {
        return trendingNid;
    }

    public void setTrendingNid(String trendingNid) {
        this.trendingNid = trendingNid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getIshotel() {
        return ishotel;
    }

    public void setIshotel(Integer ishotel) {
        this.ishotel = ishotel;
    }

    public List<Object> getKeywordResults() {
        return keywordResults;
    }

    public void setKeywordResults(List<Object> keywordResults) {
        this.keywordResults = keywordResults;
    }

    public String getMoreKeywords() {
        return moreKeywords;
    }

    public void setMoreKeywords(String moreKeywords) {
        this.moreKeywords = moreKeywords;
    }

    public String getTotalNumberofResults() {
        return totalNumberofResults;
    }

    public void setTotalNumberofResults(String totalNumberofResults) {
        this.totalNumberofResults = totalNumberofResults;
    }

    public String getRatingsTab() {
        return ratingsTab;
    }

    public void setRatingsTab(String ratingsTab) {
        this.ratingsTab = ratingsTab;
    }

    public Integer getPncdbd() {
        return pncdbd;
    }

    public void setPncdbd(Integer pncdbd) {
        this.pncdbd = pncdbd;
    }

    public String getIsmovie() {
        return ismovie;
    }

    public void setIsmovie(String ismovie) {
        this.ismovie = ismovie;
    }

    public Integer getSortPriceTag() {
        return sortPriceTag;
    }

    public void setSortPriceTag(Integer sortPriceTag) {
        this.sortPriceTag = sortPriceTag;
    }

    public List<Object> getSortPrice() {
        return sortPrice;
    }

    public void setSortPrice(List<Object> sortPrice) {
        this.sortPrice = sortPrice;
    }

    public String getViewFlag() {
        return viewFlag;
    }

    public void setViewFlag(String viewFlag) {
        this.viewFlag = viewFlag;
    }

    public Integer getFilterFlag() {
        return filterFlag;
    }

    public void setFilterFlag(Integer filterFlag) {
        this.filterFlag = filterFlag;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public String getNationalCatid() {
        return nationalCatid;
    }

    public void setNationalCatid(String nationalCatid) {
        this.nationalCatid = nationalCatid;
    }

    public String getMedianLatitude() {
        return medianLatitude;
    }

    public void setMedianLatitude(String medianLatitude) {
        this.medianLatitude = medianLatitude;
    }

    public String getMedianLongitude() {
        return medianLongitude;
    }

    public void setMedianLongitude(String medianLongitude) {
        this.medianLongitude = medianLongitude;
    }
}
