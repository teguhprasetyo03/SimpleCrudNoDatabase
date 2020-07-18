package com.studiomasteguh.simplecrudnodatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicItemAdapter extends RecyclerView.Adapter<MusicItemAdapter.ViewHolder> {
    private ArrayList<MusicItem> musicItems;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener =  listener;
    }

    @NonNull
    @Override
    public MusicItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicItemAdapter.ViewHolder holder, int position) {
        MusicItem musicItem = musicItems.get(position);

        holder.mImg.setImageResource(musicItem.getImgItem());
        holder.tvDesc.setText(musicItem.getTvDesc());
        holder.tvTitle.setText(musicItem.getTvTitle());
    }

    public MusicItemAdapter(ArrayList<MusicItem> musicList){
        musicItems = musicList;
    }


    @Override
    public int getItemCount() {
        return musicItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImg;
        TextView tvTitle;
        TextView tvDesc;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img_item);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (listener != null){
                            int position = getAdapterPosition();
                            if  (position != RecyclerView.NO_POSITION){
                                listener.OnItemClick(position);
                            }
                        }
                }
            });
        }

    }
}
