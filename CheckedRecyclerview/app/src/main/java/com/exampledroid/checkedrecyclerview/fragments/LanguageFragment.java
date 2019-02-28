package com.exampledroid.checkedrecyclerview.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.exampledroid.checkedrecyclerview.R;
import com.exampledroid.checkedrecyclerview.adapters.SearchLanguageAdapter;
import com.exampledroid.checkedrecyclerview.utils.Language;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;


public class LanguageFragment extends Fragment {

    private RecyclerView mRecycler;
    SearchLanguageAdapter adapter;
    public LanguageFragment() {
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_languages, container, false);
        mRecycler = rootView.findViewById(R.id.mRecyclerview);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        MaterialSearchBar searchBar = (MaterialSearchBar) rootView.findViewById(R.id.searchBar);
        searchBar.setHint("Search..");
        searchBar.setTextColor(R.color.colorPrimary);
        searchBar.setTextHintColor(R.color.gray);
        searchBar.setSpeechMode(false);

        //ADAPTER
        adapter=new SearchLanguageAdapter(getLanguages(), getActivity());
        mRecycler.setAdapter(adapter);

        //SEARCHBAR TEXT CHANGE LISTENER
        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //SEARCH FILTER
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private Language addHMap(String val, int pos){
        Language map = new Language();
        map.setCountry( val);
        map.setSelected(false);
        map.setItemPos(pos);
        return map;
    }
    private ArrayList<Language> getLanguages()
    {
        String[] arrLanguages = {"Afrikaans", "Albanian","Arabic", "Aramaic", "Balochi", "Bengali", "Cherokee", "Croatian", "Czech", "Dakota", "Danish", "Dutch", "English", "French", "Georgian", "German", "Greek", "Gujarati", "Hebrew", "Hindi", "Hungarian", "Irish Gaelic", "Italian", "Japanese", "Kazakh", "Korean", "Latin", "Macedonian", "Malayalam", "Marathi", "Mongolian", "Nepali", "Oriya", "Polish", "Russian", "Serbian", "Tajiki", "Turkish","Urdu", "Zulu"};
        ArrayList<Language> languagesList=new ArrayList<>();
        for(int i=0;i<arrLanguages.length;i++){
            languagesList.add(addHMap(arrLanguages[i], i));
        }
        return languagesList;
    }

}