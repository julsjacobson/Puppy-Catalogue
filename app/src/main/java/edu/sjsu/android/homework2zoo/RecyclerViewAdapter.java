package edu.sjsu.android.homework2zoo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> puppy_names = new ArrayList<>();
    private ArrayList<String> puppy_img = new ArrayList<>();
    private ArrayList<String> puppy_desc = new ArrayList<>();
    private Context context;


    public RecyclerViewAdapter(ArrayList<String> puppy_names, ArrayList<String> puppy_img, ArrayList<String> puppy_desc,  Context context) {
        this.puppy_names = puppy_names;
        this.puppy_img = puppy_img;
        this.puppy_desc = puppy_desc;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // responsible for inflating the view
        // recycling the view holders
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context)
                .asBitmap()
                .load(puppy_img.get(position)) // load bitmap image into position of circle view
                .into(holder.icon);

        holder.name.setText(puppy_names.get(position));

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sets on click listener for when clicking the item
                //Toast.makeText(context, puppy_names.get(position), Toast.LENGTH_LONG ).show();

                if (puppy_names.get(position) == puppy_names.get(puppy_names.size() - 1)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Warning! \nThis puppy barks loudly!");
                    builder.setCancelable(true);

                    builder.setPositiveButton(
                            "Continue",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    Intent intent = new Intent(context, PuppyActivity.class);
                                    intent.putExtra("image_url", puppy_img.get(position));
                                    intent.putExtra("name", puppy_names.get(position));
                                    intent.putExtra("desc", puppy_desc.get(position));
                                    context.startActivity(intent);

                                }
                            }
                    );

                    builder.setNegativeButton(
                            "Nevermind",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            }
                    );

                    AlertDialog alert = builder.create();
                    alert.show();


                }
                else {
                    Intent intent = new Intent(context, PuppyActivity.class);
                    intent.putExtra("image_url", puppy_img.get(position));
                    intent.putExtra("name", puppy_names.get(position));
                    intent.putExtra("desc", puppy_desc.get(position));
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        // tells how many list items
        return puppy_names.size();
    }

    // holds each individual view in memory
    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView icon;
        TextView name;
        RelativeLayout parent_layout;
        //OnListener onListener;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
            parent_layout = itemView.findViewById(R.id.parent_layout);
            //this.onListener = onListener;

            //itemView.setOnClickListener(this);
        }

        /*

        @Override
        public void onClick(View view) {
            onListener.onClick(getAdapterPosition());
        }*/
    }
/*
    public interface OnListener {
        void onClick(int position);

    }*/
}
