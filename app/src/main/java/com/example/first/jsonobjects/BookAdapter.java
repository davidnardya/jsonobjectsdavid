package com.example.first.jsonobjects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    ArrayList<Book> bookArrayList;

    public BookAdapter(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public void addBook(Book book){
        bookArrayList.add(book);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_book_cell,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.tvName.setText(bookArrayList.get(position).getName());
        holder.tvAuthor.setText(bookArrayList.get(position).getAuthorName());
        holder.tvDescription.setText(bookArrayList.get(position).getDescription());
        holder.tvId.setText(bookArrayList.get(position).getId());
        holder.tvYear.setText(bookArrayList.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvAuthor, tvYear, tvId, tvDescription;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.book_name);
            tvAuthor = itemView.findViewById(R.id.book_author);
            tvYear = itemView.findViewById(R.id.book_year);
            tvId = itemView.findViewById(R.id.book_ID);
            tvDescription = itemView.findViewById((R.id.book_description));
        }
    }
}
