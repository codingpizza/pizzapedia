package codingpizza.com.pizzapedia;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Arrays;
import java.util.List;

/**
 * Created by giuseppe on 11/12/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private List<Pizza> mPizzaList;
    private OnRecyclerViewItemClickListener listener;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvPizzaName;
        public ImageView mIvPizza;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvPizzaName = itemView.findViewById(R.id.tv_pizzaname);
            mIvPizza = itemView.findViewById(R.id.iv_pizza);
        }

        public void bind(final Pizza pizza, final OnRecyclerViewItemClickListener listener) {
            mIvPizza.setImageResource(pizza.getPizza_img());
            mTvPizzaName.setText(pizza.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(pizza);
                }
            });

        }
    }

    public CustomAdapter(List<Pizza> mPizzaList, OnRecyclerViewItemClickListener listener) {
        this.mPizzaList = mPizzaList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(mPizzaList.get(position),listener);
    }


    @Override
    public int getItemCount() {
        return mPizzaList.size();
    }
}
