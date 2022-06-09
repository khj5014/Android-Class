package com.example.project11_01;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private String titelSTR;
    private String descSTR;

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getTitelSTR() {
        return titelSTR;
    }

    public void setTitelSTR(String titelSTR) {
        this.titelSTR = titelSTR;
    }

    public String getDescSTR() {
        return descSTR;
    }

    public void setDescSTR(String descSTR) {
        this.descSTR = descSTR;
    }
}
