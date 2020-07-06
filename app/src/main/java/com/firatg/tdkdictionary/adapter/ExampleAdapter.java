package com.firatg.tdkdictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.databinding.ItemExampleBinding;
import com.firatg.tdkdictionary.model.detail.OrneklerListeItem;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private List<OrneklerListeItem> list;
    private Context context;
    private LayoutInflater layoutInflater;


    public ExampleAdapter(List<OrneklerListeItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ExampleAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemExampleBinding item_example = DataBindingUtil.inflate(layoutInflater, R.layout.item_example, parent, false);
        return new ExampleAdapter.ExampleViewHolder(item_example);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapter.ExampleViewHolder holder, int position) {
        OrneklerListeItem item = list.get(position);
        holder.setSearchList(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        ItemExampleBinding example;

        public ExampleViewHolder(@NonNull final ItemExampleBinding example) {
            super(example.getRoot());
            this.example = example;
        }

        public void setSearchList(OrneklerListeItem item) {
            this.example.setExample(item);
            example.executePendingBindings();
        }
    }


}

