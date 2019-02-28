package com.exampledroid.checkedrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;


import com.exampledroid.checkedrecyclerview.R;
import com.exampledroid.checkedrecyclerview.utils.FilterHelper;
import com.exampledroid.checkedrecyclerview.utils.Language;

import java.util.ArrayList;

public class SearchLanguageAdapter extends RecyclerView.Adapter<SearchLanguageAdapter.MyViewHolder> implements Filterable {
     ArrayList<Language> languages;
     ArrayList<Language> currentList;
    private LayoutInflater inflater;

    public SearchLanguageAdapter(ArrayList<Language> galaxies, Context mcxt) {
        inflater = LayoutInflater.from(mcxt);
        this.languages = galaxies;
        this.currentList=galaxies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= inflater.inflate(R.layout.row_languages,parent,false);
        MyViewHolder mv = new MyViewHolder(v);
        return mv;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.chkLanguage.setText(languages.get(position).getCountry());
        holder.chkLanguage.setChecked(languages.get(position).getSelected());

        holder.chkLanguage.setTag(position);
        holder.chkLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer) holder.chkLanguage.getTag();
                if (languages.get(pos).getSelected()) {
                    languages.get(pos).setSelected(false);
                    currentList.get(languages.get(pos).getItemPos()).setSelected(false);
                } else {
                    languages.get(pos).setSelected(true);
                    currentList.get(languages.get(pos).getItemPos()).setSelected(true);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return languages.size();
    }

    public void setLanguages(ArrayList<Language> filteredLanguages)
    {
        this.languages=filteredLanguages;
    }

    @Override
    public Filter getFilter() {
        return FilterHelper.newInstance(currentList,this);
    }

    /*
    - Our MyViewHolder class
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox chkLanguage;
        public MyViewHolder(View itemView) {
            super(itemView);
            chkLanguage= itemView.findViewById(R.id.chkLanguage);
        }
    }

}