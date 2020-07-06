package com.firatg.tdkdictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.databinding.KaristirmaBinding;
import com.firatg.tdkdictionary.model.homepage.KaristirmaItem;
import com.firatg.tdkdictionary.utils.WordClickDetail;

import java.util.List;

public class shuffleAdapter extends RecyclerView.Adapter<shuffleAdapter.ShuffleViewHolder> {
    private List<KaristirmaItem> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private WordClickDetail clickListener;

    public shuffleAdapter(List<KaristirmaItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ShuffleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        KaristirmaBinding karistirmaBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_karistirma,parent,false);
        return new ShuffleViewHolder(karistirmaBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShuffleViewHolder holder, int position) {
       KaristirmaItem karistirmaItem = list.get(position);
       holder.setKaristirma(karistirmaItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShuffleViewHolder extends RecyclerView.ViewHolder {
        KaristirmaBinding karistirmaBinding;
        public ShuffleViewHolder(@NonNull KaristirmaBinding karistirmaBinding) {
            super(karistirmaBinding.getRoot());
            this.karistirmaBinding = karistirmaBinding;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (clickListener != null && position != RecyclerView.NO_POSITION) {
                        clickListener.openDetail(list.get(position).getDogru());
                    }
                }
            });
        }

        public void setKaristirma(KaristirmaItem karistirmaItem){
            this.karistirmaBinding.setContent(karistirmaItem);
            karistirmaBinding.executePendingBindings();
        }
    }
    public void setOnItemClickListener(WordClickDetail clickListener) {
        this.clickListener = clickListener;
    }
}
