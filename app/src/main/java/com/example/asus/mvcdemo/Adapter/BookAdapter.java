package com.example.asus.mvcdemo.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.mvcdemo.Bean.Book;
import com.example.asus.mvcdemo.R;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    private List<Book> books;
    private Context context;

    public BookAdapter(Context context, List<Book> books) {
        this.books = books;
        this.context = context;
    }


    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            holder=new ViewHolder();
            holder.imageView=(ImageView)convertView.findViewById(R.id.img);
            holder.textView=(TextView)convertView.findViewById(R.id.txt);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        holder.textView.setText(books.get(position).getName());
        holder.imageView.setImageResource(books.get(position).getImage());
        return convertView;
    }
    public class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
