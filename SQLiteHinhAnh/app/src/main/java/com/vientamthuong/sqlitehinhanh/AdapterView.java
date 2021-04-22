package com.vientamthuong.sqlitehinhanh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterView extends ArrayAdapter<DoVat> {

    private Context context;
    private int resoucre;
    private List<DoVat> obDoVats;

    public AdapterView(@NonNull Context context, int resource, @NonNull List<DoVat> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resoucre = resource;
        this.obDoVats = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resoucre, parent, false);
        }
        DoVat doVat = obDoVats.get(position);
        TextView textView1 = convertView.findViewById(R.id.textView_1);
        TextView textView2 = convertView.findViewById(R.id.textView_2);
        ImageView imageView = convertView.findViewById(R.id.imageView_1);
        textView1.setText(doVat.getName());
        textView2.setText(doVat.getMota());
//        Bitmap bitmap = BitmapFactory.decodeByteArray(doVat.getHinh(), 0, doVat.getHinh().length);
//        imageView.setImageBitmap(bitmap);
        return convertView;
    }
}
