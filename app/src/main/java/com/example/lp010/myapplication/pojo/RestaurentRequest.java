package com.example.lp010.myapplication.pojo;

public class RestaurentRequest {
    /**
     * page : 0
     * userid : 31
     * lattitude : 13.0314741
     * longtitude : 80.2715938
     * distance : 2
     * type : 2
     * area : chennai
     */

    private String page;
    private String userid;

    public RestaurentRequest(String page, String userid, String lattitude, String longtitude, String distance, String type, String area) {
        this.page = page;
        this.userid = userid;
        this.lattitude = lattitude;
        this.longtitude = longtitude;
        this.distance = distance;
        this.type = type;
        this.area = area;
    }

    private String lattitude;
    private String longtitude;
    private String distance;
    private String type;
    private String area;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
