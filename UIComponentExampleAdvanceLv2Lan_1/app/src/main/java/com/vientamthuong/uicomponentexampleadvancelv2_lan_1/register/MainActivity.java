package com.vientamthuong.uicomponentexampleadvancelv2_lan_1.register;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.R;
import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.autoCompleteStudent.ArrayAdapterAutoCompleteStudent;
import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.recyclerViewStudent.StudentRecyclerViewAdapter;
import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.selectBirthDay.BirthDay;
import com.vientamthuong.uicomponentexampleadvancelv2_lan_1.student.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //  Khai báo các biến
    // EditText
    private EditText etHoVaTen;
    private EditText etDienThoai;
    private EditText etEmail;
    private EditText etDiaChi;
    // button
    private Button btChonNgaySinh;
    private Button btThemVaoNhom;
    // textView
    private TextView tvHienThiNgaySinh;
    // radiobutton
    private RadioButton rbNam;
    private RadioButton rbNu;
    // RecycvlerViewStudent
    private RecyclerView ryRecyclerViewStudent;
    // autoCompleteTextView
    private AutoCompleteTextView autoCompleteStudent;

    // Liên quan đén danh sách nhóm học sinh
    private List<Student> dsSinhVien;
    private List<Student> dsSinhVienDuocChon;
    private ArrayAdapterAutoCompleteStudent arrayAdapterAutoCompleteStudent;
    private Student nowStudent;

    // Liên quan đến chọn ngày sinh
    // datePickedDialog
    private DatePickerDialog datePickerDialog;
    // birthDay
    private BirthDay birthDay;

    // Liên quan đến danh sách nhóm
    private StudentRecyclerViewAdapter studentRecyclerViewAdapter;

    // Biến để nhận dữ liệu từ intent
    public static int FROM_MAIN_ACTIVITY = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy view từ activity
        getViewFromActivity();
        // Khởi tạo các phần tử
        init();
        // set action cho các phần tử
        setActionForComponent();

    }

    private void init() {
        // tạo các thứ liên quan đến ngày sinh
        initSelectDay();
        // tạo các thứ liên quan đến học viên
        initStudent();
        // Tạo các thứ liên quan đến danh sách nhóm
        initGroupStudent();
    }

    private void getViewFromActivity() {
        // EditText
        etHoVaTen = findViewById(R.id.register_editText_1);
        etDienThoai = findViewById(R.id.register_editText_2);
        etEmail = findViewById(R.id.register_editText_3);
        etDiaChi = findViewById(R.id.register_editText_4);
        // button
        btChonNgaySinh = findViewById(R.id.register_button_1);
        btThemVaoNhom = findViewById(R.id.register_button_2);
        // textView
        tvHienThiNgaySinh = findViewById(R.id.register_textView_1);
        // radiobutton
        rbNam = findViewById(R.id.register_radioButton_1);
        rbNu = findViewById(R.id.register_radioButton_2);
        // autoCompleteTextView
        autoCompleteStudent = findViewById(R.id.register_autoCompleteTextView_1);
        //  recyclerView
        ryRecyclerViewStudent = findViewById(R.id.register_recyclerView_1);
    }

    private void setActionForComponent() {
        // button chọn ngày sinh
        setActionForButtonChonNgaySinh();
        // button cho thêm vào nhóm
        setActionForButtonThemVaoNhom();
    }

    private void initGroupStudent() {
        // set layoutmanager
        ryRecyclerViewStudent.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        // Tao adapter cho recyclerView
        studentRecyclerViewAdapter = new StudentRecyclerViewAdapter(MainActivity.this, dsSinhVienDuocChon);
        ryRecyclerViewStudent.setAdapter(studentRecyclerViewAdapter);
    }

    private void initStudent() {
        // tạo danh sách học viên ban đầu
        dsSinhVien = new ArrayList<>();
        dsSinhVien.add(new Student("1", "Lê Xuân Tuấn", "0988585568"));
        dsSinhVien.add(new Student("2", "Hoàng Đình Hương", "0916175566"));
        dsSinhVien.add(new Student("3", "Trần Minh Nguyệt", "0987898882"));
        dsSinhVien.add(new Student("4", "Nguyễn Khắc Thành", "0912040325"));
        dsSinhVien.add(new Student("5", "Nguyễn Thị Hồng Hạnh", "0989965118"));
        dsSinhVien.add(new Student("6", "Lê Thị Thùy Dung", "0904352749"));
        dsSinhVien.add(new Student("7", "Trần Lệ Thu", "0902210733"));
        dsSinhVien.add(new Student("8", "Nguyễn Thị Hồng Hạnh", "0934447788"));
        dsSinhVien.add(new Student("9", "Nguyễn Thị Hải Yến", "0968686291"));
        dsSinhVien.add(new Student("10", "Nguyễn Ngọc Khải", "0983266986"));
        dsSinhVien.add(new Student("11", "Lê Lan Anh", "0912177345"));
        dsSinhVien.add(new Student("12", "Trần Cảnh Dương", "0903220098"));
        dsSinhVien.add(new Student("13", "Bùi Thị Hồng Thắm", "0976785816"));
        dsSinhVien.add(new Student("14", "Lê Việt Hưng", "0983109724"));
        dsSinhVien.add(new Student("15", "Phạm Minh Tiến", "0983899956"));
        dsSinhVien.add(new Student("16", "Phạm Kiên Cường", "0984652666"));
        dsSinhVien.add(new Student("17", "Lê Thị Hương", "0942554498"));
        dsSinhVien.add(new Student("18", "Phạm Văn Sáu", "0388403008"));
        dsSinhVien.add(new Student("19", "Đinh Hữu Thịnh", "0985861886"));
        dsSinhVien.add(new Student("20", "Nguyễn Thị Đoan Hiền", "0904629579"));
        dsSinhVien.add(new Student("21", "Phạm Đức Quán", "0983054815"));
        dsSinhVien.add(new Student("22", "Nguyễn Thị Lý", "0902207799"));
        dsSinhVien.add(new Student("23", "Nguyễn Thị Thanh Tâm", "0988464946"));
        dsSinhVien.add(new Student("24", "Bùi Thu Phương", "0983463800"));
        // tạo danh sách học viên được chọn
        dsSinhVienDuocChon = new ArrayList<>();
        // tạo adpater cho autoCompleteTextView
        arrayAdapterAutoCompleteStudent = new ArrayAdapterAutoCompleteStudent(MainActivity.this, R.layout.activity_custom_auto_complete_student, dsSinhVien, dsSinhVienDuocChon);
        autoCompleteStudent.setAdapter(arrayAdapterAutoCompleteStudent);
        autoCompleteStudent.setOnItemClickListener((parent, view, position, id) -> {
            Student student = arrayAdapterAutoCompleteStudent.getSuggestionnn().get(position);
            nowStudent = new Student(student.getId(), student.getName(), student.getPhone());
        });
        // set mỗi khi chọn vô chưa nhập thì nó show all student
        autoCompleteStudent.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                autoCompleteStudent.showDropDown();
            }
        });

    }

    private void setActionForButtonChonNgaySinh() {
        btChonNgaySinh.setOnClickListener(v -> {
            // Mỗi lần click thì show bảng chọn ngày
            datePickerDialog.show();
        });
    }

    private void setActionForButtonThemVaoNhom() {
        btThemVaoNhom.setOnClickListener(v -> {
            // Kiểm tra nếu now student !=null thì
            if (nowStudent != null) {
                // add student mới vào list
                dsSinhVienDuocChon.add(new Student(nowStudent.getId(), nowStudent.getName(), nowStudent.getPhone()));
                // add xong thì cho now student thành null
                nowStudent = null;
                // Làm rỗng autocompleteTextView
                autoCompleteStudent.setText("");
                // cho recyclerview thông báo
                studentRecyclerViewAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Thêm thành công một học viên vào nhóm", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Hãy chọn sinh viên", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initSelectDay() {
        // tạo birthDay , mặc định là 1 - 1 -2000
        birthDay = new BirthDay(1, 1, 2000);
        // tạo datePickedDialog
        datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year, month, dayOfMonth) -> {
            // set lại cho birth day mỗi khi có sự chon lựa ngày mới, và tvHienThiNgaySinh
            birthDay.setDay(dayOfMonth);
            birthDay.setMonth(month + 1);
            birthDay.setYear(year);
            tvHienThiNgaySinh.setText(birthDay.toString());
        }, 2000, 0, 1);
    }


}