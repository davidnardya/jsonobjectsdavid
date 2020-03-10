package com.example.first.jsonobjects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addNewBookBtn, showLibraryBtn;
    EditText bookNameET, bookAuthorET, bookIdET, bookYearET, bookDescriptionET;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView bookList = findViewById(R.id.container);

        bookList.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        ArrayList<Book> list = new ArrayList<Book>();
        final BookAdapter adapter = new BookAdapter(list);

        bookList.setAdapter(adapter);

        bookNameET = findViewById(R.id.book_name);
        bookAuthorET = findViewById(R.id.book_author);
        bookIdET = findViewById(R.id.book_ID);
        bookYearET = findViewById(R.id.book_date);
        bookDescriptionET = findViewById(R.id.book_description);
        addNewBookBtn = findViewById(R.id.add_new_book_btn);
        showLibraryBtn = findViewById(R.id.show_library_btn);

        addNewBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName(bookNameET.getText().toString());
                book.setAuthorName(bookAuthorET.getText().toString());
                book.setYear(bookYearET.getText().toString());
                book.setId(bookIdET.getText().toString());
                book.setDescription(bookDescriptionET.getText().toString());

                adapter.addBook(book);
                counter++;
            }
        });

        showLibraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter >= 3){
                    startActivity(new Intent(MainActivity.this,Library.class));
                } else if (counter == 0){
                    Toast.makeText(MainActivity.this,"No books added", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this,"Only " + counter + "/3 books added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*
        JSONObject object = new JSONObject();
        try {
            object.put("name", "Lord of the Rings");
            object.put("authorName", "J.R.R. Tolkien");
            object.put("id", 123);
            object.put("year", 1960);
            object.put("description", "The Lord of the Rings is an epic high-fantasy novel written by English author and scholar J. R. R. Tolkien.");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Book b = gson.fromJson(object.toString(), Book.class);

         */


    }
}
