package com.example.and09_fragmentadapter.melon;

public class MelonDTO {
    private int imgChartRes , rank;
    private String title , singer ;


    public MelonDTO(int imgChartRes, int rank, String title, String singer) {
        this.imgChartRes = imgChartRes;
        this.rank = rank;
        this.title = title;
        this.singer = singer;
    }

    public int getImgChartRes() {
        return imgChartRes;
    }

    public void setImgChartRes(int imgChartRes) {
        this.imgChartRes = imgChartRes;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
