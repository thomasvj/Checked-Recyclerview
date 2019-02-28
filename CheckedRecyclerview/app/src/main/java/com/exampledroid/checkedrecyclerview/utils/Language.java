package com.exampledroid.checkedrecyclerview.utils;

/**
 * Created by Thomas on 5/24/2017.
 */

public class Language {

    private boolean isSelected;
    private String country;
    private int itemPos;
    public String getCountry() {
        return country;
    }

    public void setCountry(String cu) {
        this.country = cu;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public int getItemPos() {
        return itemPos;
    }

    public void setItemPos(int pos) {
        this.itemPos = pos;
    }
}