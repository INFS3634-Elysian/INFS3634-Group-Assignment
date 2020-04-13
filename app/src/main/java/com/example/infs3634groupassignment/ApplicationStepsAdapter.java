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
//        holder.icon.setImageResource(R.drawable.resume_recycler);
    }


    @Override
    public int getItemCount() {
        return mApplicationDatabase.size();
    }

}
