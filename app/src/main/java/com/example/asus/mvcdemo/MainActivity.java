package com.example.asus.mvcdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.asus.mvcdemo.Adapter.BookAdapter;
import com.example.asus.mvcdemo.Bean.Book;
import com.example.asus.mvcdemo.Controller.BookController;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BookController bookController;
    private ListView lv_book;
    private List<Book> list;
    private BookAdapter adapter;
    private Button bt_add,bt_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookController=new BookController();

        lv_book=(ListView)findViewById(R.id.lv);
        bt_add=(Button)findViewById(R.id.bt_add);
        bt_delete=(Button)findViewById(R.id.bt_delete);

        bt_delete.setOnClickListener(this);
        bt_add.setOnClickListener(this);

        list=bookController.query();
        adapter=new BookAdapter(this,list);
        lv_book.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_add:
                bookController.add(new BookController.onAddBookListerer() {
                    @Override
                    public void onComplete() {
                        adapter.notifyDataSetChanged();
                    }
                });
                break;
            case R.id.bt_delete:
                bookController.delete(new BookController.onDeleteBookListener() {
                    @Override
                    public void onComplete() {
                        adapter.notifyDataSetChanged();
                    }
                });
                break;
        }
    }
}
