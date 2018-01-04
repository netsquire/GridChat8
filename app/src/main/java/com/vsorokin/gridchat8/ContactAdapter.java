package com.vsorokin.gridchat8;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    private ArrayList<Contact> contactList;
    private LayoutInflater layoutInflater;

    public ContactAdapter(Context aContext, ArrayList<Contact> contactList) {
        this.contactList = contactList;
        this.layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.contact_row, null);
            holder = new Contact.ViewHolder();
            holder.nameView = convertView.findViewById(R.id.name);
            holder.idView = convertView.findViewById(R.id.id);
            holder.ageView = convertView.findViewById(R.id.age);
            holder.active = convertView.findViewById(R.id.active);
            convertView.setTag(holder);
        } else {
            holder = (Contact.ViewHolder) convertView.getTag();
        }
        Contact contact = contactList.get(position);
        holder.nameView.setText(contact.getName());
        holder.idView.setText(String.format("By %s", contact.getId()));
        holder.ageView.setText(String.format(" %d ", contact.getAge()));
        holder.active.setChecked(contact.isActive());

        View.OnClickListener contactListener = v -> {
            Context context = v.getContext();
            //
            Log.i(" >>> Item: ", String.valueOf(v.getId()));
            Contact chosenContact = contactList.get(3);
            Intent intent = new Intent(context, ChatActivity.class);
            intent.putExtra(contact.getId(), chosenContact.getId());
            intent.putExtra("name", "Netsquire");
            context.startActivity(intent);
            };
        holder.nameView.setOnClickListener(contactListener);
        holder.idView.setOnClickListener(contactListener);
        holder.ageView.setOnClickListener(contactListener);

        return convertView;
        };
}
