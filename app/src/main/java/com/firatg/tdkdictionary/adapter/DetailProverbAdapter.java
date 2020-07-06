package com.firatg.tdkdictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.databinding.ItemProverbBinding;
import com.firatg.tdkdictionary.model.detail.AtasozuItem;
import com.firatg.tdkdictionary.utils.WordClickDetail;

import java.util.List;

public class DetailProverbAdapter extends RecyclerView.Adapter<DetailProverbAdapter.DetailProverbViewHolder> {
    private List<AtasozuItem> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private WordClickDetail clickListener;

    public DetailProverbAdapter(List<AtasozuItem> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public DetailProverbAdapter.DetailProverbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemProverbBinding proverbBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_proverb, parent, false);
        return new DetailProverbAdapter.DetailProverbViewHolder(proverbBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailProverbAdapter.DetailProverbViewHolder holder, int position) {
        AtasozuItem item = list.get(position);
        holder.setSearchList(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DetailProverbViewHolder extends RecyclerView.ViewHolder {
        ItemProverbBinding proverbBinding;

        public DetailProverbViewHolder(@NonNull final ItemProverbBinding proverbBinding) {
            super(proverbBinding.getRoot());
            this.proverbBinding = proverbBinding;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (clickListener != null && position != RecyclerView.NO_POSITION) {
                        clickListener.openDetail(list.get(position).getMadde());
                    }
                }
            });
        }

        public void setSearchList(AtasozuItem item) {
            this.proverbBinding.setProverb(item);
            proverbBinding.executePendingBindings();
        }
    }

    public void setOnItemClickListener(WordClickDetail clickListener) {
        this.clickListener = clickListener;
    }

}
