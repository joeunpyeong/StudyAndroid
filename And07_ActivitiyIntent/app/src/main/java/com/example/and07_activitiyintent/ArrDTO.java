package com.example.and07_activitiyintent;

import java.io.Serializable;

public class ArrDTO implements Serializable {
    private int num;
    private String str;

    public ArrDTO(int num, String str) {
        this.num = num;
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
