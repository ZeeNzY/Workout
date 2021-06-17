package com.example.gymapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<com.example.gymapp.CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList member_id, name, email, location;

    CustomAdapter(Activity activity, Context context, ArrayList member_id, ArrayList name, ArrayList email,
                  ArrayList location){
        this.activity = activity;
        this.context = context;
        this.member_id = member_id;
        this.name = name;
        this.email = email;
        this.location = location;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.member_id_txt.setText(String.valueOf(member_id.get(position)));
        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.email_txt.setText(String.valueOf(email.get(position)));
        holder.location_txt.setText(String.valueOf(location.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(member_id.get(position)));
                intent.putExtra("name", String.valueOf(name.get(position)));
                intent.putExtra("email", String.valueOf(email.get(position)));
                intent.putExtra("location", String.valueOf(location.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return member_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView member_id_txt, name_txt, email_txt, location_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            member_id_txt = itemView.findViewById(R.id.member_id_txt);
            name_txt = itemView.findViewById(R.id.name_txt);
            email_txt = itemView.findViewById(R.id.email_txt);
            location_txt = itemView.findViewById(R.id.location_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
