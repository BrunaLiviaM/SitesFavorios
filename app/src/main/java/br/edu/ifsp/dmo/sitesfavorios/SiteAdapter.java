package br.edu.ifsp.dmo.sitesfavorios;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.ViewHolder> {

    private Context context;
    private List<Site> dataset;
    private SiteItemClick listener;

    public SiteAdapter(Context context, List<Site> dataset, SiteItemClick listener){
        this.context = context;
        this.dataset = dataset;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.site_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Site site = dataser.get(position);
        holder.apelido.setText(Site.getApelido());
        holder.url.settext(site.getUrl());
        if(site.isFavorito()){
            holder.coracao.setColorFilter(context.getColor(R.color.red));
        }else{
            holder.coaraco.setColorFilter(context.getColor(R.color.gray));
        }
        holder.coaracao.setOnClickListener(v -> listener.clickCoracaoItem(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView apelido;
        public TextView url;
        public ImageView coracao;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            apelido = itemView.findViewById(R.id.textview_apelido);
            url = itemView.findViewById(R.id.textview_url);
            coracao = itemView.findViewById(R.id.img_coracao);
        }
    }
}
