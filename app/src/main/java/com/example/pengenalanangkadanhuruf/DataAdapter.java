package com.example.pengenalanangkadanhuruf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    ArrayList<ViewPagerItem> viewPagerItemArrayList;

    private onTtsClickListener listener;

    public DataAdapter(ArrayList<ViewPagerItem> viewPagerItemArrayList) {
        this.viewPagerItemArrayList = viewPagerItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewpager_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewPagerItem viewPagerItem = viewPagerItemArrayList.get(position);
        holder.alphabet.setText(viewPagerItem.alphabet);
    }

    @Override
    public int getItemCount() {
        return viewPagerItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView alphabet;
        ImageButton textToSpeechBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            alphabet = itemView.findViewById(R.id.displayText);
            textToSpeechBtn = itemView.findViewById(R.id.textToSpeechBtn);

            textToSpeechBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    listener.onTtsClick(position);
                }
            });
        }
    }

    public interface onTtsClickListener {
        void onTtsClick(int position);
    }

    public void onTtsClickListener(onTtsClickListener listener) {
        this.listener = listener;
    }
}
