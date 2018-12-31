package com.example.dell.androidramp_up;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
    private int totalPreviousItem = 0;
    private boolean loading = true;

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount = recyclerView.getChildCount();
        int totalItem = recyclerView.getLayoutManager().getItemCount();
        int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        if (loading) {
            if (totalItem > totalPreviousItem) {
                loading = false;
                totalPreviousItem = totalItem;
            }
        }
        int threshold = 0;
        if (!loading && (totalItem - visibleItemCount) <= (firstVisibleItem + threshold)) {
            loadMore();
            loading = true;
        }
    }

    public abstract void loadMore();
}
