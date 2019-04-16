package com.myapp.testandorecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHoler> {

    public static class MyViewHoler extends RecyclerView.ViewHolder {
        private TextView tv;
        public MyViewHoler(final Context ctx, @NonNull View view) {
            super(view);
            this.tv = view.findViewById(R.id.textView);
            this.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ctx, "OK " + tv.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public TextView getTextView() {
            return this.tv;
        }
    }

    private List<String> dataset;
    private Context ctx;
    public MyAdapter(Context ctx, List<String> dataset) {
        this.ctx = ctx;
        this.dataset = dataset;
    }

    public void add(String value) {
        dataset.add(value);
        notifyItemInserted(getItemCount());
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.item_layout, viewGroup, false);
        return new MyViewHoler(ctx, view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler myViewHoler, int i) {
        myViewHoler.getTextView().setText(dataset.get(i));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


}
