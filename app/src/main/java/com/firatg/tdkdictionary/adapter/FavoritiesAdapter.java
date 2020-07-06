package com.firatg.tdkdictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.databinding.ItemFavoriBinding;
import com.firatg.tdkdictionary.model.search.Favori;
import com.firatg.tdkdictionary.utils.WordClickDetail;

import java.util.List;

public class FavoritiesAdapter extends RecyclerView.Adapter<FavoritiesAdapter.FavoriListViewHolder> {
    private List<Favori> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private WordClickDetail clickListener;

    public FavoritiesAdapter(List<Favori> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public FavoritiesAdapter.FavoriListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemFavoriBinding itemFavoriBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_favori, parent, false);
        return new FavoritiesAdapter.FavoriListViewHolder(itemFavoriBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritiesAdapter.FavoriListViewHolder holder, int position) {
        Favori favori = list.get(position);
        holder.setSearchList(favori);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FavoriListViewHolder extends RecyclerView.ViewHolder {
        ItemFavoriBinding itemFavoriBinding;

        public FavoriListViewHolder(@NonNull final ItemFavoriBinding itemFavoriBinding) {
            super(itemFavoriBinding.getRoot());
            this.itemFavoriBinding = itemFavoriBinding;

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

        public void setSearchList(Favori favori) {
            this.itemFavoriBinding.setItemFavori(favori);
            itemFavoriBinding.executePendingBindings();
        }
    }


    public void setOnItemClickListener(WordClickDetail clickListener) {
        this.clickListener = clickListener;
    }

}
