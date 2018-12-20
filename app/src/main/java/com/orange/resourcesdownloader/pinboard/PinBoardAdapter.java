package com.orange.resourcesdownloader.pinboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.orange.resourcesdownloader.R;
import com.orange.resourcesdownloader.models.Urls;
import com.orange.resourcesdownloadlibrary.core.ResourcesLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This Adapter responsible for making a View for each item in the Pin Board RecyclerView
 * within {@link PinBoardFragment}
 * <p>
 * Created by Safa Amin on 12/20/2018.
 */

public class PinBoardAdapter extends RecyclerView.Adapter<PinBoardAdapter.ViewHolder> {

    private Context context;
    private List<Urls> urlsList;
    private final OnItemClickListener listener;
    private ResourcesLoader resourcesLoader;

    PinBoardAdapter(Context context, List<Urls> urls, OnItemClickListener listener) {
        this.context = context;
        this.urlsList = urls;
        this.listener = listener;
        resourcesLoader = new ResourcesLoader();
    }

    @Override
    @NonNull
    public PinBoardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rootView = inflater.inflate(R.layout.pin_board_item_view, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Urls model = urlsList.get(holder.getAdapterPosition());
        holder.bindData(model, listener);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_product)
        ImageView ivProduct;

        ViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        void bindData(final Urls model, final OnItemClickListener listener) {
            resourcesLoader.initLruCache();
            resourcesLoader.loadResources(context, model.getSmall(), ivProduct);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(model);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Urls item);
    }

    @Override
    public int getItemCount() {
        return urlsList.size();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
