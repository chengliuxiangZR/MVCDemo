package com.example.asus.mvcdemo.Model;

import com.example.asus.mvcdemo.Bean.Book;
import com.example.asus.mvcdemo.R;

import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private static List<Book> list=new ArrayList<>();
    static{
        list.add(new Book("java从入门到精通", R.drawable.ic_java));
        list.add(new Book("Android从入门到精通",R.drawable.ic_android));
        list.add(new Book("java从入门到精通", R.drawable.ic_java));
        list.add(new Book("Android从入门到精通",R.drawable.ic_android));
    }
    public void addBook(String name,int image){
        list.add(new Book(name,image));
    }
    public void deleteBook(){
        list.remove(list.size()-1);
    }
    public List<Book> query(){
        return list;
    }
}
