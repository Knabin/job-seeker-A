package com.android.kimnabin;

public class MyIcon {
    private int iconImage;
    private String iconName;
    private String iconTag;

    public MyIcon(int iconImage, String iconName, String iconTag) {
        this.iconImage = iconImage;
        this.iconName = iconName;
        this.iconTag = iconTag;
    }

    public int getIconImage() {
        return iconImage;
    }

    public void setIconImage(int iconImage) {
        this.iconImage = iconImage;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getIconTag() {
        return iconTag;
    }

    public void setIconTag(String iconTag) {
        this.iconTag = iconTag;
    }
}
