package com.vientamthuong.learning_10_1;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vientamthuong.learning_10_1.model.ArrayAdapterProduct;
import com.vientamthuong.learning_10_1.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // List products
    private List<Product> products;

    //  ArrayAdapter product
    private ArrayAdapterProduct arrayAdapterProduct;

    //  View
    private Button buttonRemoveFirst;
    private Button buttonRemoveAllSelect;
    private ListView listView;

    //  Menu
    public static final int ABOUt = 0;

    //  Hiện thực phương thức onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  set activity
        setContentView(R.layout.activity_main);

        //  Khởi tạo
        init();

        //   setAction cho các view
        setAction();
    }


    private void setAction() {

        // button xóa sản phẩm đầu tiên
        buttonRemoveFirst.setOnClickListener(v -> {
            if (products.size() > 0) {
                Toast.makeText(MainActivity.this, "Xóa thành công sản phẩm: " + products.get(0).getId(), Toast.LENGTH_SHORT).show();
                products.remove(0);
                arrayAdapterProduct.notifyDataSetChanged();
            } else {
                Toast.makeText(MainActivity.this, "Không còn sản phẩm nào để xóa nữa", Toast.LENGTH_SHORT).show();
            }
        });

        //  button xóa nhiều sản phẩm
        buttonRemoveAllSelect.setOnClickListener(v -> {
            int count = 0;
            int countProductRemoved = 0;
            while (count < products.size()) {
                if (products.get(count).isChecked()) {
                    products.remove(count);
                    countProductRemoved++;
                } else {
                    count++;
                }
            }
            if (countProductRemoved == 0) {
                if (products.size() == 0) {
                    Toast.makeText(MainActivity.this, "Không còn sản phẩm nào để xóa nữa", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng tích các sản phẩm cần xóa rồi mới nhấn nút này", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Xóa thành công " + countProductRemoved + " sản phẩm", Toast.LENGTH_SHORT).show();
                arrayAdapterProduct.notifyDataSetChanged();
            }
        });

    }

    private void init() {

        //   getView
        buttonRemoveFirst = findViewById(R.id.button_1);
        buttonRemoveAllSelect = findViewById(R.id.button_2);
        listView = findViewById(R.id.listView_1);

        // init listProduct
        products = new ArrayList<>();
        products.add(new Product("ID = 1", "Tên SP: SP 1", "Giá 100", false));
        products.add(new Product("ID = 2", "Tên SP: SP 2", "Giá 200", false));
        products.add(new Product("ID = 3", "Tên SP: SP 3", "Giá 300", false));
        products.add(new Product("ID = 4", "Tên SP: SP 4", "Giá 400", false));
        products.add(new Product("ID = 5", "Tên SP: SP 5", "Giá 500", false));
        products.add(new Product("ID = 6", "Tên SP: SP 6", "Giá 600", false));
        products.add(new Product("ID = 7", "Tên SP: SP 7", "Giá 700", false));
        products.add(new Product("ID = 8", "Tên SP: SP 8", "Giá 800", false));
        products.add(new Product("ID = 9", "Tên SP: SP 9", "Giá 900", false));
        products.add(new Product("ID = 10", "Tên SP: SP 10", "Giá 1000", false));
        products.add(new Product("ID = 11", "Tên SP: SP 11", "Giá 1100", false));
        products.add(new Product("ID = 12", "Tên SP: SP 12", "Giá 1200", false));
        products.add(new Product("ID = 13", "Tên SP: SP 13", "Giá 1300", false));
        products.add(new Product("ID = 14", "Tên SP: SP 14", "Giá 1400", false));
        products.add(new Product("ID = 15", "Tên SP: SP 15", "Giá 1500", false));
        products.add(new Product("ID = 16", "Tên SP: SP 16", "Giá 1600", false));
        products.add(new Product("ID = 17", "Tên SP: SP 17", "Giá 1700", false));
        products.add(new Product("ID = 18", "Tên SP: SP 18", "Giá 1800", false));
        products.add(new Product("ID = 19", "Tên SP: SP 19", "Giá 1900", false));

        //  init arrayAdapter product
        arrayAdapterProduct = new ArrayAdapterProduct(MainActivity.this, R.layout.ativity_custom_view_list_view, products);

        //  set adapter
        listView.setAdapter(arrayAdapterProduct);

    }

}
