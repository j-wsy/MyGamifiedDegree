package com.example.juzza.mygamifieddegree;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Course> courseList;
    Dialog dialog;

    public RecyclerViewAdapter(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.courseList = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_layout, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Course course = courseList.get(position);
        holder.courseTitle.setText(course.getCourseTitle());
        /*holder.courseImage.setImageResource(course.getCourseImage());
        holder.courseImage.setImageDrawable(mContext.getResources().getDrawable(course.getCourseImage()));*/
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (courseList.get(position).getIsEnabled() == 1) {
                    //Intent intent = new Intent(mContext,CourseInformation.class);
                    //intent.putExtra("CourseTitle", courseList.get(position).getCourseTitle());
                    //intent.putExtra("CourseDescription", courseList.get(position).getCourseDescription());
                    //mContext.startActivity(intent);
                    dialog = new Dialog(mContext);
                    dialog.setContentView(R.layout.activity_course_information);
                    ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                    TextView courseTitle = (TextView) dialog.findViewById(R.id.courseTitle);
                    TextView courseDescription = (TextView) dialog.findViewById(R.id.courseDescription);
                    courseTitle.setText(courseList.get(position).getCourseTitle());
                    courseDescription.setText(courseList.get(position).getCourseDescription());
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }

                    });
                } else {
                    dialog = new Dialog(mContext);
                    dialog.setContentView(R.layout.activity_course_error);
                    ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                    TextView courseError = (TextView) dialog.findViewById(R.id.courseError);
                    courseError.setText(courseList.get(position).getCourseDescription());
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }

                    });

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView courseTitle;
        ImageView courseImage;
        CardView cardview;

        public MyViewHolder(View itemView) {

            super(itemView);


            courseTitle = (TextView) itemView.findViewById(R.id.courseTitle);
            courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            cardview = (CardView) itemView.findViewById(R.id.cardview_id);
        }

    }

}
