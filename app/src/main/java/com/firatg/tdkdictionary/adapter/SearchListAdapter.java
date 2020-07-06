package com.firatg.tdkdictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.databinding.SearchItemBinding;
import com.firatg.tdkdictionary.model.search.Suggestion;
import com.firatg.tdkdictionary.utils.WordClickDetail;

import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchListViewHolder> {
    private List<Suggestion> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private WordClickDetail clickListener;

    public SearchListAdapter(List<Suggestion> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public SearchListAdapter.SearchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        SearchItemBinding searchItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_search, parent, false);
        return new SearchListAdapter.SearchListViewHolder(searchItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListAdapter.SearchListViewHolder holder, int position) {
        Suggestion suggestion = list.get(position);
        holder.setSearchList(suggestion);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SearchListViewHolder extends RecyclerView.ViewHolder {
        SearchItemBinding searchItemBinding;

        public SearchListViewHolder(@NonNull final SearchItemBinding searchItemBinding) {
            super(searchItemBinding.getRoot());
            this.searchItemBinding = searchItemBinding;

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

        public void setSearchList(Suggestion suggestion) {
            this.searchItemBinding.setAutocomp(suggestion);
            searchItemBinding.executePendingBindings();
        }
    }


    public void setOnItemClickListener(WordClickDetail clickListener) {
        this.clickListener = clickListener;
    }

}
