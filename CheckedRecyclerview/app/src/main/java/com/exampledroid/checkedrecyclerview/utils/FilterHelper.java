package com.exampledroid.checkedrecyclerview.utils;

import android.widget.Filter;

import com.exampledroid.checkedrecyclerview.adapters.SearchLanguageAdapter;

import java.util.ArrayList;

public class FilterHelper extends Filter {
    static ArrayList<Language> currentList;
    static SearchLanguageAdapter adapter;

    public static FilterHelper newInstance(ArrayList<Language> currentList, SearchLanguageAdapter adapter) {
        FilterHelper.adapter=adapter;
        FilterHelper.currentList=currentList;
        return new FilterHelper();
    }

    /*
    - Perform actual filtering.
     */
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults=new FilterResults();

        if(constraint != null && constraint.length()>0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();

            //HOLD FILTERS WE FIND
            ArrayList<Language> foundFilters=new ArrayList<>();

            String language;

            //ITERATE CURRENT LIST
            for (int i=0;i<currentList.size();i++)
            {
                Language map = currentList.get(i);
                language= map.getCountry();
                Boolean isChecked = map.getSelected();
                int mItmPos =  map.getItemPos();
                //SEARCH
                if(language.toUpperCase().contains(constraint))
                {
                    Language nMap = new Language();
                    nMap.setCountry(language);
                    nMap.setSelected(isChecked);
                    nMap.setItemPos(mItmPos);
                    //ADD IF FOUND
                    foundFilters.add(nMap);
                }
            }

            //SET RESULTS TO FILTER LIST
            filterResults.count=foundFilters.size();
            filterResults.values=foundFilters;
        }else
        {
            //NO ITEM FOUND.LIST REMAINS INTACT
            filterResults.count=currentList.size();
            filterResults.values=currentList;
        }

        //RETURN RESULTS
        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        adapter.setLanguages((ArrayList<Language>) filterResults.values);
        adapter.notifyDataSetChanged();
    }
}