package com.firatg.tdkdictionary.ui.search;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.adapter.HistoryAdapter;
import com.firatg.tdkdictionary.adapter.SearchListAdapter;
import com.firatg.tdkdictionary.databinding.FragmentSearchBinding;
import com.firatg.tdkdictionary.model.search.History;
import com.firatg.tdkdictionary.model.search.Suggestion;
import com.firatg.tdkdictionary.ui.MainActivity;
import com.firatg.tdkdictionary.ui.search.FragmentDetail;
import com.firatg.tdkdictionary.utils.SimpleDividerItemDecoration;
import com.firatg.tdkdictionary.utils.Statics;
import com.firatg.tdkdictionary.utils.WordClickDetail;
import com.firatg.tdkdictionary.viewmodel.SearchViewModel;
import com.firatg.tdkdictionary.viewmodel.ShareViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;
import static com.firatg.tdkdictionary.utils.Statics.passOtherFragment;

public class FragmentSearch extends Fragment {
    SearchViewModel searchViewModel;
    SearchListAdapter searchListAdapter;
    HistoryAdapter historyAdapter;
    private ShareViewModel model;
  //  private ArrayList<History> articleArrayList = new ArrayList<>();
    FragmentSearchBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = DataBindingUtil.inflate(
                inflater, R.layout.fragment_search, container, false);
        View view = binding.getRoot();

        Log.i("sira","onCreateView");

        searchViewModel =  new ViewModelProvider(requireActivity()).get(SearchViewModel.class);
        model = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);



        init();
        observerHistory();



        return view;
    }

    public void loadRecycler(FragmentSearchBinding binding) {
       binding.rcyclerSearch.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
    }


    public void loadHistoryRecycler(FragmentSearchBinding binding) {
        binding.recyclerHistory.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("sira","onActivityCreated");


    }

    public void init(){
        Log.i("sira","init");
        loadRecycler(binding);
        loadHistoryRecycler(binding);
        binding.searchArea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.linearHistory.setVisibility(View.GONE);
                binding.rcyclerSearch.setVisibility(View.VISIBLE);
                if(s.length() > 0){
                    binding.ivClearSearchText.setVisibility(View.VISIBLE);
                }else{
                    binding.ivClearSearchText.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


                searchViewModel.getAllNotes(s.toString()).observe(requireActivity(), new Observer<List<Suggestion>>() {
                    @Override
                    public void onChanged(List<Suggestion> suggestions) {
                        searchListAdapter = new SearchListAdapter(suggestions, requireActivity());
                        binding.rcyclerSearch.setAdapter(searchListAdapter);
                        searchListAdapter.setOnItemClickListener(new WordClickDetail() {
                            @Override
                            public void openDetail(String word) {
                                if (Statics.getConnectionStatus(getActivity())){
                                    model.setName(word);
                                    passOtherFragment(((MainActivity) requireActivity()), new FragmentDetail(), "detail",R.id.homeFrameLayout);
                                }else {
                                    Statics.showError(getActivity(),"İnternet bağlantısı yok!");
                                }

                            }
                        });
                    }
                });
            }
        });

        binding.ivClearSearchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.searchArea.setText("");
                binding.ivClearSearchText.setVisibility(View.INVISIBLE);
            }
        });

        binding.deleteHistoryTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchViewModel.deleteHistory();
            }
        });

        binding.cappedOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.searchArea.append(getString(R.string.search_append_1));
            }
        });
        binding.cappedTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.searchArea.append(getString(R.string.search_append_2));
            }
        });
        binding.cappedThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.searchArea.append(getString(R.string.search_append_3));
            }
        });

        binding.voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }




    public void observerHistory(){

        searchViewModel.getHistorylist().observe(getActivity(), new Observer<List<History>>() {
            @Override
            public void onChanged(List<History> histories) {
                if (histories!=null){
                    List<History> newsArticles = histories;
                    historyAdapter = new HistoryAdapter(newsArticles,getActivity());
                    binding.recyclerHistory.setAdapter(historyAdapter);
                    historyAdapter.setOnItemClickListener(new WordClickDetail() {
                        @Override
                        public void openDetail(String word) {
                            if (Statics.getConnectionStatus(getActivity())){
                                model.setName(word);
                                passOtherFragment(((MainActivity) requireActivity()), new FragmentDetail(), "detail",R.id.homeFrameLayout);
                            }else {
                                Statics.showError(getActivity(),"İnternet bağlantısı yok!");
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getActivity(), "Liste boş", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private final int REQ_CODE = 100;
    public void speak(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Need to speak");
        try {
            startActivityForResult(intent, REQ_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getActivity(),
                    "Sorry your device not supported",
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    binding.searchArea.setText(result.get(0).toString());
                }
                break;
            }
        }
    }
}
