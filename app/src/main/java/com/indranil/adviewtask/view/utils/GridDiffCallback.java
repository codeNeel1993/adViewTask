package com.indranil.adviewtask.view.utils;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.indranil.adviewtask.model.pojo.GridResultModel;

import java.util.List;

/**
 * Created by pc on 1/5/2018.
 */

public class GridDiffCallback  extends DiffUtil.Callback {

    private final List<GridResultModel> mOldGridList;
    private final List<GridResultModel> mNewGridList;

    public GridDiffCallback(List<GridResultModel> oldEmployeeList, List<GridResultModel> newEmployeeList) {
        this.mOldGridList = oldEmployeeList;
        this.mNewGridList = newEmployeeList;
    }

    @Override
    public int getOldListSize() {
        return mOldGridList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewGridList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldGridList.get(oldItemPosition).getName() == mNewGridList.get(
                newItemPosition).getName();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final GridResultModel oldGridList = mOldGridList.get(oldItemPosition);
        final GridResultModel newGridList = mNewGridList.get(newItemPosition);

        return oldGridList.getName().equals(newGridList.getName());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}

