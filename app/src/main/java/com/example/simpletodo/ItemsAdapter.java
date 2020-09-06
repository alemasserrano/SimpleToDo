package com.example.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Responsible for taking the data in a particular position and putting it into the view holder
//Responsible for displaying data from the model into a row in the recycler view

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    public interface OnLongClickListener{
        void onItemLongClicked(int position);
    }

    List<String> items;
    OnLongClickListener longClickListener;

    public ItemsAdapter(List<String> items, OnLongClickListener longClickListener) {
        this.items = items;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    //creates each view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Use  layout inflator to inflate a view
        //wrap it inside a View Holder and return it

        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(todoView);
    }

    @Override
    //taking data at a particular position and putting it into a view holder
    //responsible for binding data to a particular view holder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Grab the item at the position
        String item = items.get(position);

        //Bind the item into the specified view holder
        holder.bind(item);
    }

    @Override
    //simply number of items available in data
    //Tells RV how many items are in the list
    public int getItemCount() {
        return items.size();
    }

    //Define view holder, container to provide easy access to views that represent each row of the list
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
        }

        //responsible to update the view inside of the view holder with this data
        public void bind(String item) {
            tvItem.setText(item);
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    //notifying the listener which position was the one that was long pressed
                    longClickListener.onItemLongClicked(getAdapterPosition());
                    return true;

                }
            });
        }
    }
}
