package com.example.infs3634groupassignment;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ApplicationStepsAdapter extends RecyclerView.Adapter<ApplicationStepsAdapter.ApplicationStepsViewHolder> {
    private ArrayList<ApplicationDatabase> mApplicationDatabase;
    private RecyclerViewClickListener mListener;
//    private int[] images = {R.drawable.resume_recycler};

    public ApplicationStepsAdapter(ArrayList<ApplicationDatabase> database, RecyclerViewClickListener listener){
        mApplicationDatabase = database;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class ApplicationStepsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView icon;
        public TextView name;
        private RecyclerViewClickListener mListener;


        public ApplicationStepsViewHolder(View v, RecyclerViewClickListener listener){
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            icon = v.findViewById(R.id.ivIcon);
            name= v.findViewById(R.id.tvName);

        }

        @Override
        public void onClick(View view){
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public ApplicationStepsAdapter.ApplicationStepsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.applicationstep_list, parent, false);
        return new ApplicationStepsViewHolder(v, mListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ApplicationStepsViewHolder holder, int position) {
        ApplicationDatabase applicationDatabase =mApplicationDatabase.get(position);
        holder.name.setText(applicationDatabase.getName());
        if (applicationDatabase.getIcon().equals("home_resume")){
            holder.icon.setImageResource((R.drawable.home_resume));
        }
        if (applicationDatabase.getIcon().equals("home_cv")){
            holder.icon.setImageResource((R.drawable.home_cv));
        }
        if (applicationDatabase.getIcon().equals("home_behavioural")){
            holder.icon.setImageResource((R.drawable.home_behavioural));
        }
        if (applicationDatabase.getIcon().equals("home_cognitive")){
            holder.icon.setImageResource((R.drawable.home_cognitive));
        }
        if (applicationDatabase.getIcon().equals("home_numerical")){
            holder.icon.setImageResource((R.drawable.home_numerical));
        }
        if (applicationDatabase.getIcon().equals("home_video")){
            holder.icon.setImageResource((R.drawable.home_video));
        }
        if (applicationDatabase.getIcon().equals("home_groupwork")){
            holder.icon.setImageResource((R.drawable.home_groupwork));
        }
        if (applicationDatabase.getIcon().equals("home_interview")){
            holder.icon.setImageResource((R.drawable.home_interview));
        }
        if (applicationDatabase.getIcon().equals("home_outcome")){
            holder.icon.setImageResource((R.drawable.home_outcome));
        }
        if (applicationDatabase.getIcon().equals("home_firstday")){
            holder.icon.setImageResource((R.drawable.home_firstday));
        }
        if (applicationDatabase.getIcon().equals("home_networking")){
            holder.icon.setImageResource((R.drawable.home_networking));
        }
        if (applicationDatabase.getIcon().equals("home_career")){
            holder.icon.setImageResource((R.drawable.home_career));
        }
//        holder.icon.setImageResource(R.drawable.resume_recycler);
    }


    @Override
    public int getItemCount() {
        return mApplicationDatabase.size();
    }

}
