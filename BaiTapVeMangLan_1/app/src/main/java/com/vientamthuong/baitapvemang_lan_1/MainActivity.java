package com.vientamthuong.baitapvemang_lan_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import static com.vientamthuong.baitapvemang_lan_1.R.drawable.ic_baseline_trending_down_24;
import static com.vientamthuong.baitapvemang_lan_1.R.drawable.ic_baseline_trending_up_24;

public class MainActivity extends AppCompatActivity {

    // Tạo các biến
    private Button btCreateArray;
    private Button btSort;
    private TextView tvShowArray;
    private Random rd;
    private boolean isUp;
    private int[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các thuộc tính khác
        initVariable();
        // Lấy view từ activity
        getView();
        // set action cho các button
        setActionForButton();

    }

    private void initVariable() {
        rd = new Random();
        array = new int[10];
        // Nếu isUp là true thì sắp xếp tăng dần, ngược lại là giảm giần
        isUp = true;
    }

    private void setActionForButton() {
        // set action cho button createarray
        btCreateArray.setOnClickListener(actionCreateArray());
        // set action cho button sort
        btSort.setOnClickListener(actionSort());
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private View.OnClickListener actionSort() {
        return v -> {
            //sắp xếp theo isUP
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (isUp) {
                        if (array[j] > array[j + 1]) {
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    } else {
                        if (array[j] < array[j + 1]) {
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }
            }
            // show ra textView
            showArrayToTextView();
            // set lại drawable ở trạng thái ngược lại
            // đổi isUp thành ngược lại luôn
            if (isUp) {
                isUp = false;
                btSort.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(ic_baseline_trending_down_24), null);
            } else {
                isUp = true;
                btSort.setCompoundDrawablesWithIntrinsicBounds(null, null, getDrawable(ic_baseline_trending_up_24), null);
            }
        };
    }

    private View.OnClickListener actionCreateArray() {
        return v -> {
            // Random 10 phần tử, mỗi phần tử có giá trị từ 0-10
            for (int i = 0; i < array.length; i++) {
                array[i] = rd.nextInt(11);
            }
            // show ra textView
            showArrayToTextView();
            // VÌ ở lần đầu phải tạo mảng mới có sắp xếp
            // thế nên kiểm tra thử nút sort chưa enable thì enable
            if (!btSort.isEnabled()) {
                btSort.setEnabled(true);
            }
        };
    }

    private void showArrayToTextView() {
        tvShowArray.setText(coverArrayToString());
    }

    private String coverArrayToString() {
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value).append(" ");
        }
        return result.toString().trim();
    }

    private void getView() {
        btCreateArray = findViewById(R.id.button_1);
        btSort = findViewById(R.id.button_2);
        tvShowArray = findViewById(R.id.textView_1);
    }
}