package com.vsorokin.gridchat8;

import android.widget.RadioButton;
import android.widget.TextView;

import okhttp3.WebSocket;

class Contact {

    private String name;
    private String id;
    private int age;
    String ip;
    Boolean active;
    Boolean connected;
    WebSocket webSocket;

    public Contact(String name, String id, int age, String ip) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.ip = ip;
    }

    Contact(String name, String id, int age, Boolean active) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.active = active;
    }

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    static class ViewHolder {
        TextView nameView;
        TextView idView;
        TextView ageView;
        RadioButton active;
        RadioButton connected;

        /*public TextView getNameView() {
            return nameView;
        }

        public void setNameView(TextView nameView) {
            this.nameView = nameView;
        }

        public TextView getIdView() {
            return idView;
        }

        public void setIdView(TextView idView) {
            this.idView = idView;
        }

        public TextView getAgeView() {
            return ageView;
        }

        public void setAgeView(TextView ageView) {
            this.ageView = ageView;
        }*/

    }
}
