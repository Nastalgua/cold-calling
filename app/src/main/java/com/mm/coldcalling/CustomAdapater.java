package com.mm.coldcalling;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapater implements ListAdapter {
  private ArrayList<Student> mStuds;
  private Context mContext;

  public CustomAdapater(Context context, ArrayList<Student> studs) {
    this.mContext = context;
    this.mStuds = studs;
  }

  @Override
  public boolean areAllItemsEnabled() {
    return false;
  }
  @Override
  public boolean isEnabled(int position) {
    return true;
  }

  @Override
  public void registerDataSetObserver(DataSetObserver observer) { }

  @Override
  public void unregisterDataSetObserver(DataSetObserver observer) { }

  @Override
  public int getCount() { return this.mStuds.size(); }

  @Override
  public Object getItem(int position) { return position; }

  @Override
  public long getItemId(int position) { return position; }

  @Override
  public boolean hasStableIds() { return false; }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    Student studentData = this.mStuds.get(position);

    if (convertView == null) {
      LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
      convertView = layoutInflater.inflate(R.layout.listview_layout, null);

      convertView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) { }
      });

      TextView title = convertView.findViewById(R.id.student_name);
      ImageView imag = convertView.findViewById(R.id.list_image);
      title.setText(studentData.getFullName());

      Picasso.with(this.mContext)
          .load(studentData.getImage())
          .into(imag);
    }

    return convertView;
  }

  @Override
  public int getItemViewType(int position) { return position; }

  @Override
  public int getViewTypeCount() { return this.mStuds.size(); }

  @Override
  public boolean isEmpty() { return false; }
}
