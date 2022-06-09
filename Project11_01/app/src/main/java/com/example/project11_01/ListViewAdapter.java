package com.example.project11_01;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> ArrayList1 = new ArrayList<ListViewItem>();

    //어댑터에 사용되는 데이터의 갯수
    @Override
    public int getCount() {
        return ArrayList1.size();
    }

    @Override
    public Object getItem(int i) {
        return ArrayList1.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (convertview == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.listview_item, viewGroup, false);
            ImageView iconImageView = convertview.findViewById(R.id.imageView);
            TextView titleTextView = convertview.findViewById(R.id.textView1);
            TextView descTextView = convertview.findViewById(R.id.textView2);

            //리스트뷰아이템에서 포지션에 위치한 데이터 참조
            ListViewItem listViewItem = ArrayList1.get(i);

            //아이템내에서 위젯에 데이터 반영
            iconImageView.setImageDrawable(listViewItem.getIconDrawable());
            titleTextView.setText(listViewItem.getTitelSTR());
            descTextView.setText(listViewItem.getDescSTR());
        }

        return convertview;
    }

    public void addItem(Drawable icon, String title,String desc) {
        ListViewItem item = new ListViewItem();
                item.setIconDrawable(icon);
                item.setTitelSTR(title);
                item.setDescSTR(desc);

                ArrayList1.add(item);
    }
}
