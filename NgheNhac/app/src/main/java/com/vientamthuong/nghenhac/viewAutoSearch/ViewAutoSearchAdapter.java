package com.vientamthuong.nghenhac.viewAutoSearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vientamthuong.nghenhac.MainActivity;
import com.vientamthuong.nghenhac.R;
import com.vientamthuong.nghenhac.model.Music;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ViewAutoSearchAdapter extends ArrayAdapter<Music> {

    private Filter filter;
    private List<Music> musicList;
    private List<Music> listACtion;
    private MainActivity mainActivity;

    public ViewAutoSearchAdapter(@NonNull Context context, int resource, @NonNull List<Music> objects, MainActivity mainActivity) {
        super(context, resource, objects);
        musicList = new ArrayList<>();
        musicList.addAll(objects);
        listACtion = new ArrayList<>();
        listACtion.addAll(objects);
        this.mainActivity = mainActivity;

        filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    List<Music> listMusic = new ArrayList<>();
                    String search = constraint.toString().trim().toLowerCase();
                    for (Music music : musicList) {
                        if (music.getName().toLowerCase().contains(search) || music.getTenCaSi().toLowerCase().contains(search)) {
                            listMusic.add(new Music(music.getIdImage(), music.getName(), music.getIdSound(), music.getTime(), music.getTenCaSi()));
                        }
                    }
                    filterResults.values = listMusic;
                    filterResults.count = listMusic.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    clear();
                    addAll((List<Music>) results.values);
                    listACtion.clear();
                    listACtion.addAll((List<Music>) results.values);
                    notifyDataSetChanged();
                }
            }

            @Override
            public CharSequence convertResultToString(Object resultValue) {
                return "";
            }
        };
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mainActivity).inflate(R.layout.custom_view_holder, parent, false);
        }
        Music music = listACtion.get(position);
        if (music != null) {
            TextView textViewTenBaiHat = convertView.findViewById(R.id.viewHolder_name);
            TextView textViewTenCaSy = convertView.findViewById(R.id.viewHolder_tenCaSy);
            TextView textViewThoiGian = convertView.findViewById(R.id.viewHolder_thoiGian);
            ImageView imageViewHinhNhac = convertView.findViewById(R.id.viewHolder_imageView);
            textViewTenBaiHat.setText(music.getName());
            textViewTenCaSy.setText(music.getTenCaSi());
            textViewThoiGian.setText(music.getTime());
            imageViewHinhNhac.setImageResource(music.getIdImage());
        }
        convertView.setOnClickListener(v -> {
            Music m = mainActivity.getDanhSachNhac().get(position);
            int postion = 0;
            for (int i = 0; i < mainActivity.getDanhSachNhac().size(); i++) {
                if (mainActivity.getDanhSachNhac().get(i).getName().equals(music.getName())) {
                    postion = i;
                    break;
                }
            }
            mainActivity.setNowPosition(postion);
            mainActivity.createAudio(postion);
            mainActivity.getAutoCompleteTextViewSearch().dismissDropDown();
            mainActivity.getAutoCompleteTextViewSearch().setText("");
        });
        return convertView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }
}
