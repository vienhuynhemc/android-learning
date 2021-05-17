package com.vientamthuong.hello_flutter;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends FlutterActivity {
    // Không new vẫn oke
    var sinhVien1 = SinhVien("Nguyễn Văn A", 19);
    // Có new vẫn oke
    var sinhVien2 = new SinhVien("Nguyễn Văn B", 20);

}

    double dienTichHinhTron(double banKinh) {
        // Phương thức này có thể chứa phương thức khác
        double binhPhuong ( double banKinh){
            return banKinh * banKinh;
        }
        return 3.14 * binhPhuong(banKinh);
    }

    void main() {
        double banKinh = 5;
        dienTichHinhTron(banKinh);
    }



