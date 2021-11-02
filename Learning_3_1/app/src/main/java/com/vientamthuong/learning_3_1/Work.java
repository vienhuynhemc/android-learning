package com.vientamthuong.learning_3_1;

public class Work {

    private String tenCongViec;
    private String thoiGianCongViec;
    private boolean isSelect;

    public Work(String tenCongViec, String thoiGianCongViec, boolean isSelect) {
        this.tenCongViec = tenCongViec;
        this.thoiGianCongViec = thoiGianCongViec;
        this.isSelect = isSelect;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public String getThoiGianCongViec() {
        return thoiGianCongViec;
    }

    public void setThoiGianCongViec(String thoiGianCongViec) {
        this.thoiGianCongViec = thoiGianCongViec;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

}
