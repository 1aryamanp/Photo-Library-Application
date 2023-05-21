package com.example.photosapp21.model;
/*
@author Deep Shah
@author Aryaman Patel
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class Photo implements Serializable {

    static final long serialVersionUID = 1L;

    private String path;
    private ArrayList<String> people;
    private String location;

    public Photo(Uri path){
        this.path = path.toString();
        people = new ArrayList<String>();
        location = "";
    }
    public Uri getPath(){
        return Uri.parse(path);
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<String> getPeople(){
        return people;
    }

    public boolean hasTag(String s){
        s = s.toLowerCase();
        if(location.toLowerCase().contains(s)){
            return true;
        }
        for(String p : people){
            if(p.toLowerCase().contains(s)){
                return true;
            }
        }
        return false;
    }
    public void setLocation(String s){
        location = s;
    }
    public void addPerson(String s){
        people.add(s);
    }
    public void containsPerson(String s){
        people.contains(s);
    }
    public void deletePerson(String s){
        people.remove(s);
    }

    public String toString(){
        return path;
    }

    public boolean equals(Object o){
        if(o == null || !(o instanceof Photo)){
            return false;
        }
        Photo p = (Photo) o;
        return p.path.equals(path);
    }

    public Bitmap getBitMap(Context c){
        ImageView iv = getImageView(c);
        BitmapDrawable bd = (BitmapDrawable) iv.getDrawable();
        return bd.getBitmap();

    }
    public ImageView getImageView(Context c){
        ImageView iv =  new ImageView(c);
        iv.setImageURI(Uri.parse(path));
        return iv;


    }


}
