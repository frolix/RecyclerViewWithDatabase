package com.example.recyclerviewwithdatabase.adapter;

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int from,int to);
    void onItemDismiss(int position);
}
