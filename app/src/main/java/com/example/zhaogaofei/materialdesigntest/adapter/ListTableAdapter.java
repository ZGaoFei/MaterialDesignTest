package com.example.zhaogaofei.materialdesigntest.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhaogaofei.materialdesigntest.R;
import com.example.zhaogaofei.materialdesigntest.config.ConfigModel;

import java.util.ArrayList;
import java.util.List;

public class ListTableAdapter extends RecyclerView.Adapter<ListTableAdapter.TableViewHolder> {

    private List<ConfigModel> list;
    private Context context;

    public ListTableAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    public void setData(List<ConfigModel> list) {
        if (list.isEmpty()) {
            return;
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public TableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_table, null);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TableViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getImageUrl())
                .override(500, 300)
                .crossFade(1000)
                .into(holder.imageView);
        holder.textView.setText(list.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TableViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public TableViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image_view);
            textView = (TextView) itemView.findViewById(R.id.item_text_view);
        }
    }
}
