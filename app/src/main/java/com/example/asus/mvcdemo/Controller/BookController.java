package com.example.asus.mvcdemo.Controller;

import com.example.asus.mvcdemo.Bean.Book;
import com.example.asus.mvcdemo.Model.BookModel;
import com.example.asus.mvcdemo.R;

import java.util.List;

public class BookController {
    private BookModel mode;
    public BookController(){
        mode=new BookModel();
    }
    public void add(onAddBookListerer listerer){
        mode.addBook("JavaWeb从入门到精通", R.drawable.ic_javaweb);
        if(listerer!=null){
            listerer.onComplete();
        }
    }
    public void delete(onDeleteBookListener listerer){
        if(mode.query().isEmpty()){
            return;
        }else {
            mode.deleteBook();
        }
        if(listerer!=null){
            listerer.onComplete();
        }
    }
    public List<Book> query(){
        return mode.query();
    }
    public interface onAddBookListerer{
        void onComplete();
    }
    public interface onDeleteBookListener{
        void onComplete();
    }
}
