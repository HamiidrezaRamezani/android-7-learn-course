package com.test.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private static final String TAG = "ContactAdapter";
    private String[] contacts = new String[20];

    public ContactAdapter() {
        contacts[0] = "Ruthann Trustrie";
        contacts[1] = "Peadar Dawtrey";
        contacts[2] = "Felipe Bradtke";
        contacts[3] = "Claude Crissil";
        contacts[4] = "Jacky Girardeau";
        contacts[5] = "Rubia Dominguez";
        contacts[6] = "Michaela Churchley";
        contacts[7] = "Harvey Pentelow";
        contacts[8] = "Neilla Langton";
        contacts[9] = "Marco Greaves";
        contacts[11] = "Lamond Littlepage";
        contacts[10] = "Liz Batchley";
        contacts[12] = "Malina Weir";
        contacts[13] = "Tomlin Lenchenko";
        contacts[14] = "Hy Pavelin";
        contacts[15] = "Jenelle Palin";
        contacts[16] = "Damon Knewstubb";
        contacts[17] = "Alex Ivanusyev";
        contacts[18] = "Hamil Callery";
        contacts[19] = "Karol Syer";
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: position=> " + position);
        holder.bindContact(contacts[position]);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView firstCharacterTv;
        private TextView fullNameTv;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            firstCharacterTv = itemView.findViewById(R.id.tv_contact_firstCharacter);
            fullNameTv = itemView.findViewById(R.id.tv_contact_fullName);
        }

        public void bindContact(String fullName) {
            fullNameTv.setText(fullName);
            firstCharacterTv.setText(fullName.substring(0, 1));
        }
    }

}
