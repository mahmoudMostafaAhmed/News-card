package remoteconfigapp.ibtikar.com.remoteconfigapp;

import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by mahmoud on 04-Apr-17.
 */

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NewsModel> newsModel;
    private OnItemViewClicked onItemViewClicked;
    private List<NewsModel> newsRelatedList;

    NewsListAdapter(List<NewsModel> newsModels, OnItemViewClicked onItemViewClicked) {
        this.newsModel = newsModels;
        this.onItemViewClicked = onItemViewClicked;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return new MyViewHolder(new NewsCards(parent.getContext()));
            case 2:
                return new MyViewHolderTypeTwo(new SmallNewsCard(parent.getContext()));
        }
        return new MyViewHolder(new NewsCards(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 1:
                MyViewHolder viewHolder = (MyViewHolder) holder;
                viewHolder.cards.bind(newsModel.get(position));
                ((MyViewHolder) holder).cards.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemViewClicked.onItemClicked(holder.getAdapterPosition());
                    }
                });
                break;
            case 2:
                MyViewHolderTypeTwo viewHolder2 = (MyViewHolderTypeTwo) holder;
                viewHolder2.cards.bind(newsModel.get(position));
                viewHolder2.cards.bind(newsModel.get(position));
                ((MyViewHolderTypeTwo) holder).cards.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemViewClicked.onItemClicked(holder.getAdapterPosition());
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0)
            return 1;
        else
            return 2;
    }

    @Override
    public int getItemCount() {
        return newsModel.size();
    }

    public void insertItems(NewsModel newsModels, int index){
        this.newsModel.add(index,newsModels);
        notifyItemChanged(index);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        NewsCards cards;

        MyViewHolder(NewsCards view) {
            super(view);
            this.cards = view;
        }
    }

    class MyViewHolderTypeTwo extends RecyclerView.ViewHolder {
        SmallNewsCard cards;

        MyViewHolderTypeTwo(SmallNewsCard view) {
            super(view);
            this.cards = view;
        }
    }

    public interface OnItemViewClicked{
        void onItemClicked(int pos);
    }

}
