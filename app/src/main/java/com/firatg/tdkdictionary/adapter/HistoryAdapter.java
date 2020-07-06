package com.firatg.tdkdictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.databinding.HistoryItemBinding;
import com.firatg.tdkdictionary.model.search.History;
import com.firatg.tdkdictionary.utils.WordClickDetail;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryListViewHolder> {
    private List<History> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private WordClickDetail clickListener;

    public HistoryAdapter(List<History> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public HistoryAdapter.HistoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        HistoryItemBinding historyItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_history, parent, false);
        return new HistoryAdapter.HistoryListViewHolder(historyItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryListViewHolder holder, int position) {
        History history = list.get(position);
        holder.setSearchList(history);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HistoryListViewHolder extends RecyclerView.ViewHolder {
        HistoryItemBinding historyItemBinding;

        public HistoryListViewHolder(@NonNull final HistoryItemBinding historyItemBinding) {
            super(historyItemBinding.getRoot());
            this.historyItemBinding = historyItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (clickListener != null && position != RecyclerView.NO_POSITION) {
                        clickListener.openDetail(list.get(position).getWord());
                    }
                }
            });

        }

        public void setSearchList(History history) {
            this.historyItemBinding.setHistory(history);
            historyItemBinding.executePendingBindings();
        }
    }


    public void setOnItemClickListener(WordClickDetail clickListener) {
        this.clickListener = clickListener;
    }

}
