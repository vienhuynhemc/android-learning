package com.vientamthuong.uicomponentexampleadvance_lan_1;

import android.content.Context;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RegisterViewHolder extends RecyclerView.ViewHolder {

    // Khai báo biến
    // textview
    private TextView tvHoVaTen;
    private TextView tvDienThoai;
    private TextView tvEmail;
    private TextView tvDiaChi;
    // autocompleteTextView
    private AutoCompleteTextView autoCompleteTextView;
    // button
    private Button btNgaySinh;
    private Button btOke;
    // RadioButton
    private RadioButton rbNam;
    private RadioButton rbNu;
    // checkbox
    private CheckBox cbAndroid;
    private CheckBox cbWeb;
    private CheckBox cbIC3;
    // context
    private Context context;
    // registerObject
    private RegisterObject registerObject;

    public RegisterViewHolder(@NonNull View itemView, RegisterObject registerObject, Context context) {
        super(itemView);
        this.registerObject = registerObject;
        this.context = context;

        // findView from parent view
        getView(itemView);
        // Khởi tạo
        init();
    }

    private void init() {
        // Khởi tạo autocompleteTextVIew;
        initAutoCompleteTextView();
    }

    private void initAutoCompleteTextView() {
        // Tạo danh sách học viên
        List<Student> dsHocVien = new ArrayList<>();
        dsHocVien.add(new Student("Nguyễn Văn A", "0971122209", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        dsHocVien.add(new Student("Nguyễn Đại C", "0971323232", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        dsHocVien.add(new Student("Nguyễn Công Phú", "0932323155", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        dsHocVien.add(new Student("Huỳnh Văn Viên", "0934534534", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        dsHocVien.add(new Student("Super Plance", "0123456789", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        dsHocVien.add(new Student("Bitch", "54645645645", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        dsHocVien.add(new Student("Normal", "21354654", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        dsHocVien.add(new Student("La Văn E", "0789798754", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        dsHocVien.add(new Student("Trương Văn D", "1545151515", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        dsHocVien.add(new Student("Nguyễn Đại A", "16456167489", R.drawable.ic_baseline_person_24, R.drawable.ic_baseline_phone_android_24));
        // tạo adapter và set cho autoCompleteTextView
        ArrayAdapterAutoCompleteTextView arrayAdapterAutoCompleteTextView = new ArrayAdapterAutoCompleteTextView(context, R.layout.activity_auto_complete_text_view, dsHocVien);
        autoCompleteTextView.setAdapter(arrayAdapterAutoCompleteTextView);
    }

    private void getView(View itemView) {
        // textview
        tvHoVaTen = itemView.findViewById(R.id.editText_1);
        tvDienThoai = itemView.findViewById(R.id.editText_2);
        tvEmail = itemView.findViewById(R.id.editText_3);
        tvDiaChi = itemView.findViewById(R.id.editText_4);
        // autocompleteTextView
        autoCompleteTextView = itemView.findViewById(R.id.editText_5);
        // button
        btNgaySinh = itemView.findViewById(R.id.button_1);
        btOke = itemView.findViewById(R.id.button_2);
        // checbox
        cbAndroid = itemView.findViewById(R.id.checkBox_1);
        cbWeb = itemView.findViewById(R.id.checkBox_2);
        cbIC3 = itemView.findViewById(R.id.checkBox_3);
        // radiobutton
        rbNam = itemView.findViewById(R.id.radioButton_1);
        rbNu = itemView.findViewById(R.id.radioButton_2);
    }

    // getter and setter
    public TextView getTvHoVaTen() {
        return tvHoVaTen;
    }

    public void setTvHoVaTen(TextView tvHoVaTen) {
        this.tvHoVaTen = tvHoVaTen;
    }

    public TextView getTvDienThoai() {
        return tvDienThoai;
    }

    public void setTvDienThoai(TextView tvDienThoai) {
        this.tvDienThoai = tvDienThoai;
    }

    public TextView getTvEmail() {
        return tvEmail;
    }

    public void setTvEmail(TextView tvEmail) {
        this.tvEmail = tvEmail;
    }

    public TextView getTvDiaChi() {
        return tvDiaChi;
    }

    public void setTvDiaChi(TextView tvDiaChi) {
        this.tvDiaChi = tvDiaChi;
    }

    public AutoCompleteTextView getAutoCompleteTextView() {
        return autoCompleteTextView;
    }

    public void setAutoCompleteTextView(AutoCompleteTextView autoCompleteTextView) {
        this.autoCompleteTextView = autoCompleteTextView;
    }

    public Button getBtNgaySinh() {
        return btNgaySinh;
    }

    public void setBtNgaySinh(Button btNgaySinh) {
        this.btNgaySinh = btNgaySinh;
    }

    public Button getBtOke() {
        return btOke;
    }

    public void setBtOke(Button btOke) {
        this.btOke = btOke;
    }

    public RadioButton getRbNam() {
        return rbNam;
    }

    public void setRbNam(RadioButton rbNam) {
        this.rbNam = rbNam;
    }

    public RadioButton getRbNu() {
        return rbNu;
    }

    public void setRbNu(RadioButton rbNu) {
        this.rbNu = rbNu;
    }

    public CheckBox getCbAndroid() {
        return cbAndroid;
    }

    public void setCbAndroid(CheckBox cbAndroid) {
        this.cbAndroid = cbAndroid;
    }

    public CheckBox getCbWeb() {
        return cbWeb;
    }

    public void setCbWeb(CheckBox cbWeb) {
        this.cbWeb = cbWeb;
    }

    public CheckBox getCbIC3() {
        return cbIC3;
    }

    public void setCbIC3(CheckBox cbIC3) {
        this.cbIC3 = cbIC3;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RegisterObject getRegisterObject() {
        return registerObject;
    }

    public void setRegisterObject(RegisterObject registerObject) {
        this.registerObject = registerObject;
    }

}
