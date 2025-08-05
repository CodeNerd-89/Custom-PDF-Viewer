package com.tahmid.l2t2allpdf;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.PdfViewHolder> implements Filterable {

    private Context context;
    private List<PdfModel> pdfList;
    private List<PdfModel> pdfListFiltered;

    public PdfAdapter(Context context, List<PdfModel> pdfList) {
        this.context = context;
        this.pdfList = pdfList;
        this.pdfListFiltered = pdfList;
    }

    @NonNull
    @Override
    public PdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new PdfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PdfViewHolder holder, int position) {
        PdfModel pdfModel = pdfListFiltered.get(position);
        holder.textView.setText(pdfModel.getTitle());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);
            MainActivity.assetName = pdfListFiltered.get(position).getPdfName();
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pdfListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    pdfListFiltered = pdfList;
                } else {
                    List<PdfModel> filteredList = new ArrayList<>();
                    for (PdfModel row : pdfList) {
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    pdfListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = pdfListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                pdfListFiltered = (ArrayList<PdfModel>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class PdfViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public PdfViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
