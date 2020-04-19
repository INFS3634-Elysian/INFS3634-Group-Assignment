package com.example.infs3634groupassignment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Step4bAdapter extends RecyclerView.Adapter<Groupac1ViewHolder> {

    private Context context;
    private int[] images;
    private String[] description;
    private String[] groupacURL;

    Step4bAdapter(Context context, int[] images, String[] description, String[] groupacURL) {
        this.context = context;
        this.images = images;
        this.description = description;
        this.groupacURL = groupacURL;
    }

    //onCreateViewHolder - inflate layout
    @NonNull
    @Override
    public Groupac1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_step4a_item_row, parent, false);
        return new Groupac1ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final Groupac1ViewHolder holder, int position) {
        holder.description1.setText(description[position]);
        holder.image1.setImageResource(images[position]);
        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(groupacURL[holder.getAdapterPosition()]));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}


//GroupacViewHolder = define the views that were created earlier from the recyclerview
class Groupac1ViewHolder extends RecyclerView.ViewHolder {

    ImageView image1;
    TextView description1;
    Button next;

    Groupac1ViewHolder(View itemView) {
        super(itemView);

        image1 = itemView.findViewById(R.id.ivGroupac);
        description1 = itemView.findViewById(R.id.tvDescription);
        next = itemView.findViewById(R.id.btnReadMore);




    }
}
