package com.example.clonecoding_discord.alarm;

public class AlarmDTO {
    private String tv_alarm_main,tv_alarm_time;
    private int imgv_alarm;
    private boolean togleChecked;

    public AlarmDTO(String tv_alarm_main, String tv_alarm_time, int imgv_alarm, boolean togleChecked) {
        this.tv_alarm_main = tv_alarm_main;
        this.tv_alarm_time = tv_alarm_time;
        this.imgv_alarm = imgv_alarm;
        this.togleChecked = togleChecked;
    }

    public String getTv_alarm_main() {
        return tv_alarm_main;
    }

    public void setTv_alarm_main(String tv_alarm_main) {
        this.tv_alarm_main = tv_alarm_main;
    }

    public String getTv_alarm_time() {
        return tv_alarm_time;
    }

    public void setTv_alarm_time(String tv_alarm_time) {
        this.tv_alarm_time = tv_alarm_time;
    }

    public int getImgv_alarm() {
        return imgv_alarm;
    }

    public void setImgv_alarm(int imgv_alarm) {
        this.imgv_alarm = imgv_alarm;
    }

    public boolean isTogleChecked() {
        return togleChecked;
    }

    public void setTogleChecked(boolean togleChecked) {
        this.togleChecked = togleChecked;
    }
}
