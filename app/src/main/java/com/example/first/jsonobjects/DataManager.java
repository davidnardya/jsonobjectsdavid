package com.example.first.jsonobjects;

import java.util.ArrayList;

public class DataManager {
    private static DataManager INSTANCE = null;

    public ArrayList<Book> list = new ArrayList<Book>();


    private DataManager(){};

    public static DataManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }
}
