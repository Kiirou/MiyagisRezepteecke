package com.example.miyagisrezepteecke;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Steps> stepsList;

    public RecipeListAdapter(Context context, int layout, ArrayList<Steps> stepsList) {
        this.context = context;
        this.layout = layout;
        this.stepsList = stepsList;
    }

    @Override
    public int getCount() {
        return stepsList.size();
    }

    @Override
    public Object getItem(int position) {
        return stepsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{

        TextView txtRecipesteps;
        TextView txtName;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtRecipesteps = (TextView) row.findViewById(R.id.txtRecipesteps);

            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Steps steps = stepsList.get(position);

        holder.txtName.setText(steps.getName());



        return row;
    }
}
