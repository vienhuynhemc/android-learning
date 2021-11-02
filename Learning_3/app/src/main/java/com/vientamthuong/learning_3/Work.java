package com.vientamthuong.learning_3;

public class Work {

    //  Đối tượng work có nội dung, thời gian công việc và 1 boolean xem thử có đang check
    private String noiDungCongViec;
    private String thoiGianCongViec;
    private boolean isCheck;

    public Work(String noiDungCongViec, String thoiGianCongViec) {
        this.noiDungCongViec = noiDungCongViec;
        this.thoiGianCongViec = thoiGianCongViec;
        this.isCheck = false;
    }

    // Getter and setter
    public String getNoiDungCongViec() {
        return noiDungCongViec;
    }

    public void setNoiDungCongViec(String noiDungCongViec) {
        this.noiDungCongViec = noiDungCongViec;
    }

    public String getThoiGianCongViec() {
        return thoiGianCongViec;
    }

    public void setThoiGianCongViec(String thoiGianCongViec) {
        this.thoiGianCongViec = thoiGianCongViec;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

}
