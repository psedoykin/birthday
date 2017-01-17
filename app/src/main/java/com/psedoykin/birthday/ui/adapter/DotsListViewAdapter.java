package com.psedoykin.birthday.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psedoykin.birthday.databinding.DotItemBinding;

public class DotsListViewAdapter extends RecyclerView.Adapter<DotsListViewAdapter.ViewHolderImpl> {

    private int mCount;
    private int mCurrentId;

    public DotsListViewAdapter(int count) {
        mCount = count;
    }

    @Override
    public ViewHolderImpl onCreateViewHolder(ViewGroup parent, int viewType) {
        DotItemBinding dotItemBinding = DotItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolderImpl(dotItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolderImpl holder, int position) {

        if (position == mCurrentId) {
            holder.dotItemBinding.dotIndicator.setAlpha(1f);
        } else {
            holder.dotItemBinding.dotIndicator.setAlpha(0.5f);
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

        public DotItemBinding dotItemBinding;

        public ViewHolderImpl(View view) {
            super(view);
            dotItemBinding = DataBindingUtil.bind(view);
        }
    }
}
