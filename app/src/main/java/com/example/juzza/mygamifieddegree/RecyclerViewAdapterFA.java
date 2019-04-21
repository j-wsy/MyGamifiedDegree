package com.example.juzza.mygamifieddegree;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapterFA extends RecyclerView.Adapter<RecyclerViewAdapterFA.MyViewHolder> {

    private Context mContext;
    private List<Friend> friendList;
    DbHelperF dbHelperF;

    public RecyclerViewAdapterFA(Context mContext, List<Friend> mData) {
        this.mContext = mContext;
        this.friendList = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.friendadd_layout, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        dbHelperF = new DbHelperF(mContext);
        final Friend friend = friendList.get(position);

        holder.friendName.setText(friend.getFriendName());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelperF.updateIsFriend(friend.getFriendName());
                Toast.makeText(mContext, friend.getFriendName() +" has been added!", Toast.LENGTH_SHORT).show();
                Fragment fragment = (Fragment) ((FragmentActivity) mContext).getSupportFragmentManager().getFragments().get(0);
                FragmentTransaction fragmentTransaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.detach(fragment);
                fragmentTransaction.attach(fragment);
                fragmentTransaction.commit();
            }


        });
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
            friendName = (TextView) itemView.findViewById(R.id.friendName55);
            friendImage = (ImageView) itemView.findViewById(R.id.friendImage55);
            cardview = (CardView) itemView.findViewById(R.id.cardview_idFA);
        }
    }

}
