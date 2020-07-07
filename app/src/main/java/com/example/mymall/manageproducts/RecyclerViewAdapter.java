package com.example.mymall.manageproducts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymall.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Product> mValues;
    Context mContext;
    protected ItemListener mListener;

    public RecyclerViewAdapter(Context context, List<Product> values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewtitle,textViewprice;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        Product item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            textViewtitle = (TextView) v.findViewById(R.id.textViewtitle);
            textViewprice = (TextView) v.findViewById(R.id.textViewprice);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);

        }

        public void setData(Product item) {
            this.item = item;

            Glide.with(itemView.getContext()).load(item.getProduct_image_1()).apply(new RequestOptions().placeholder(R.mipmap.icon_placeholder)).into(imageView);
            textViewtitle.setText(item.getProduct_title());
            textViewprice.setText("RS."+item.getProduct_price()+"/-");
            //imageView.setImageResource(item.drawable);
            //relativeLayout.setBackgroundColor(Color.parseColor(item.color));

        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position) {
        Vholder.setData(mValues.get(position));

    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(Product item);
    }
}