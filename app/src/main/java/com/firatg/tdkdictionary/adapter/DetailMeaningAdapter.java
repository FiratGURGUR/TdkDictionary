package com.firatg.tdkdictionary.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.databinding.ItemMeaningBinding;
import com.firatg.tdkdictionary.model.detail.AnlamlarListeItem;

import java.util.List;

public class DetailMeaningAdapter extends RecyclerView.Adapter<DetailMeaningAdapter.DetailMeaningViewHolder> {
    private List<AnlamlarListeItem> list;
    private Context context;
    private LayoutInflater layoutInflater;
    ExampleAdapter exampleAdapter;

    public DetailMeaningAdapter(List<AnlamlarListeItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailMeaningAdapter.DetailMeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemMeaningBinding meaningBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_meaning, parent, false);
        return new DetailMeaningAdapter.DetailMeaningViewHolder(meaningBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailMeaningAdapter.DetailMeaningViewHolder holder, int position) {
        AnlamlarListeItem anlamlarListeItem = list.get(position);
        holder.setSearchList(anlamlarListeItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DetailMeaningViewHolder extends RecyclerView.ViewHolder {
        ItemMeaningBinding meaningBinding;

        public DetailMeaningViewHolder(@NonNull final ItemMeaningBinding meaningBinding) {
            super(meaningBinding.getRoot());
            this.meaningBinding = meaningBinding;
        }

        public void setSearchList(AnlamlarListeItem item) {
            this.meaningBinding.setAnlam(item);
            if (item.getOrneklerListe()!=null){
                exampleAdapter = new ExampleAdapter(item.getOrneklerListe(),context);
                meaningBinding.recyclerOrnek.setAdapter(exampleAdapter);

            }
            meaningBinding.executePendingBindings();
        }
    }


}
