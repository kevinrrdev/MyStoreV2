package com.example.kechaval.mystorev2.modules.cake.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.kechaval.mystorev2.R;
import com.example.kechaval.mystorev2.helper.ImageHandler;
import com.example.kechaval.mystorev2.mvp.model.Cake;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KeChaval on 12/07/2018.
 */

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.Holder> {


    private LayoutInflater mLayoutInflater;
    private List<Cake> mCakeList = new ArrayList<>();

    public CakeAdapter(LayoutInflater inflater){
        mLayoutInflater = inflater;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view= mLayoutInflater.inflate(R.layout.list_item_layout,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(mCakeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCakeList.size();
    }

    public void addCakes(List<Cake> cakes){
        mCakeList.addAll(cakes);
        notifyDataSetChanged();
    }


    public void clearCakes() {
        mCakeList.clear();
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.cake_icon) protected ImageView mCakeIcon;
        @BindView(R.id.textview_title) protected TextView mCakeTitle;
        @BindView(R.id.textview_preview_description) protected TextView mCakePreviewDescription;
        private Context mContext;
        private Cake mCake;
        public Holder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            ButterKnife.bind(this,itemView);
        }

        public void bind(Cake cake) {
            mCake = cake;
            mCakeTitle.setText(cake.getTitle());
            mCakePreviewDescription.setText(cake.getPreviewDescription());

            Glide.with(mContext).load(cake.getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(new ImageHandler(mCakeIcon));
        }
        @Override
        public void onClick(View v) {
            if (mCakeClickListener != null) {
                mCakeClickListener.onClick(mCakeIcon, mCake, getAdapterPosition());
            }
        }
    }

    public void setCakeClickListener(OnCakeClickListener listener) {
        mCakeClickListener = listener;
    }

    private OnCakeClickListener mCakeClickListener;

    public interface OnCakeClickListener {

        void onClick(View v, Cake cake, int position);
    }

}
