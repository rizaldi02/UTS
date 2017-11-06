package com.rizaldi.uts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cipowela on 06/11/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private List<ContactModel> contactModels;
    private Context c;

    public ContactAdapter(Context c, List<ContactModel> contactModels) {
        this.c = c;
        this.contactModels = contactModels;
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        final ContactModel model = contactModels.get(position);
        holder.nama.setText(model.getNama());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, Detail.class);
                intent.putExtra("nama.kontak",model.getNama());
                intent.putExtra("email.kontak",model.getEmail());
                intent.putExtra("telp.kontak",model.getNomor());

                c.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return contactModels.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder {
        TextView nama;
        LinearLayout layout;
        public ContactHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.list_nama);
            layout = (LinearLayout) itemView.findViewById(R.id.bisa_diklik);
        }
    }
}
