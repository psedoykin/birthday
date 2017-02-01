package com.psedoykin.birthday.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.psedoykin.birthday.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DotsListViewAdapter extends RecyclerView.Adapter<DotsListViewAdapter.ViewHolderImpl> {

    private int mCount;
    private int mCurrentId;

    public DotsListViewAdapter(int count) {
        mCount = count;
    }

    @Override
    public ViewHolderImpl onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderImpl(LayoutInflater.from(parent.getContext()).inflate(R.layout.dot_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderImpl holder, int position) {

        if (position == mCurrentId) {
            holder.mIndicator.setAlpha(1f);
        } else {
            holder.mIndicator.setAlpha(0.5f);
        }
    }

    public void updatePosition(int position) {
        if (position < mCount) {
            mCurrentId = position;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    public class ViewHolderImpl extends RecyclerView.ViewHolder {

        @BindView(R.id.dot_indicator) ImageView mIndicator;

        public ViewHolderImpl(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
