package io.github.smu.part;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kug00 on 2017-10-17.
 */

public class TravelCourseListViewAdapter extends BaseAdapter{
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<LocalListViewItem> listViewItemList = new ArrayList<LocalListViewItem>() ;

    // ListViewAdapter의 생성자
    public TravelCourseListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.travelcourse_listview, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.travelcourseimg) ;
        ImageView imagebg = (ImageView) convertView.findViewById(R.id.bg) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.travelcoursetitle) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.travelcourseaddress) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        LocalListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영, 피카소 이용해 url 주소 이미지 넣기
        Picasso.with(context).load(listViewItem.getIcon()).into(iconImageView);
        Picasso.with(context).load(listViewItem.getIcon()).into(imagebg);
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());
        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String icon, String title) {
        LocalListViewItem item = new LocalListViewItem();
        item.setIcon(icon);
        item.setTitle(title);
        listViewItemList.add(item);
    }

    //리스트뷰 데이터 모두 제거
    public void removeall() {
        listViewItemList.clear();
    }
}