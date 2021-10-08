package com.example.listapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.viewHolder> {

    private ArrayList<ItemModel> dataItem;
    private Context context;

    AdapterRecyclerView(Context context, ArrayList<ItemModel> dataItem) {
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.viewHolder holder, int position) {
        TextView textTittle = holder.textTittle;
        TextView textSubTittle = holder.textSubTittle;
        ImageView imageIcon = holder.imageIcon;

        textTittle.setText(dataItem.get(position).getName());
        textSubTittle.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());

        holder.parentLayout.setOnClickListener(view -> {
            Toast.makeText(context, "Musik yang dipilih: "+dataItem.get(position).getName(), Toast.LENGTH_SHORT).show();

            if (dataItem.get(position).getName().equals("Maroon 5")) {
                Intent i = new Intent(context, DetailMusikActivity.class);
                i.putExtra("TEXT", "Maroon 5");
                i.putExtra("SUBTEXT", "20 Lagu");
                context.startActivity(i);
            } else if (dataItem.get(position).getName().equals("Bruno Mars")) {
                Intent i = new Intent(context, DetailMusikActivity.class);
                i.putExtra("TEXT", "Bruno Mars");
                i.putExtra("SUBTEXT", "5 Lagu");
                context.startActivity(i);
            } else if (dataItem.get(position).getName().equals("Rizky Febian")) {
                Intent i = new Intent(context, DetailMusikActivity.class);
                i.putExtra("TEXT", "Rizky Febian");
                i.putExtra("SUBTEXT", "10 Lagu");
                context.startActivity(i);
            } else if (dataItem.get(position).getName().equals("Tiara Andini")) {
                Intent i = new Intent(context, DetailMusikActivity.class);
                i.putExtra("TEXT", "Tiara Andini");
                i.putExtra("SUBTEXT", "7 Lagu");
                context.startActivity(i);
            } else if (dataItem.get(position).getName().equals("Avenged Sevenfold")) {
                Intent i = new Intent(context, DetailMusikActivity.class);
                i.putExtra("TEXT", "Avenged Sevenfold");
                i.putExtra("SUBTEXT", "13 Lagu");
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textTittle, textSubTittle;
        ImageView imageIcon;
        LinearLayoutCompat parentLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textTittle = itemView.findViewById(R.id.textTittle);
            textSubTittle = itemView.findViewById(R.id.textSubTitle);
            imageIcon = itemView.findViewById(R.id.imageList);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
