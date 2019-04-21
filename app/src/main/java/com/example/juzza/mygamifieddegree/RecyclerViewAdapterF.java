package com.example.juzza.mygamifieddegree;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapterF extends RecyclerView.Adapter<RecyclerViewAdapterF.MyViewHolder> {

    private Context mContext;
    private List<Friend> friendList;
    DbHelperF dbHelperF;

    public RecyclerViewAdapterF(Context mContext, List<Friend> mData) {
        this.mContext = mContext;
        this.friendList = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.peoplescore_layout, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        dbHelperF = new DbHelperF(mContext);
        Friend friend = friendList.get(position);
        holder.friendName.setText(friend.getFriendName());
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView friendName;
        ImageView friendImage;
        CardView cardview;

        public MyViewHolder(View itemView) {

            super(itemView);
            friendName = (TextView) itemView.findViewById(R.id.friendName);
            friendImage = (ImageView) itemView.findViewById(R.id.friendImage);
            cardview = (CardView) itemView.findViewById(R.id.cardview_idF);
        }
    }

}
