package com.vsorokin.gridchat8;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.vsorokin.gridchat8.model.Contact;
import com.vsorokin.gridchat8.model.ContactHolder;

import java.io.Serializable;
import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private List<Contact> contactList;
    private LayoutInflater layoutInflater;

    ContactAdapter(Context aContext, List<Contact> contactList) {
        this.contactList = contactList;
        this.layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return contactList==null ? 0 : contactList.size();
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
        ContactHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.contact_row, null);
            holder = new ContactHolder();
            holder.nameView = convertView.findViewById(R.id.name);
            holder.idView = convertView.findViewById(R.id.id);
            holder.ageView = convertView.findViewById(R.id.age);
            holder.active = convertView.findViewById(R.id.active);
            convertView.setTag(holder);
        } else {
            holder = (ContactHolder) convertView.getTag();
        }
        Contact contact = contactList.get(position);
        holder.nameView.setText(contact.getName());
        holder.idView.setText(String.format("By %s", contact.getId()));
        holder.ageView.setText("HZ");
        holder.active.setChecked(contact.isActive());

        View.OnClickListener contactListener = v -> {
            Context context = v.getContext();
            Log.i(" >>> Item: ", String.valueOf(v.getId()));
            Contact chosenContact = contactList.get(position);
            Intent intent = new Intent(context, ChatActivity.class);
            intent.putExtra(contact.getId(), chosenContact.getId());
            intent.putExtra("name", chosenContact.getName());
            intent.putExtra("contact", chosenContact);
            context.startActivity(intent);
            };
        holder.nameView.setOnClickListener(contactListener);
        holder.idView.setOnClickListener(contactListener);
        holder.ageView.setOnClickListener(contactListener);

        return convertView;
        }
}
