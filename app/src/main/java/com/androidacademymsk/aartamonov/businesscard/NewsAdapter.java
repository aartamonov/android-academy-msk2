package com.androidacademymsk.aartamonov.businesscard;

        import android.app.Activity;
        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
//        import androidx.annotation.NonNull;
//        import androidx.annotation.Nullable;
//        import androidx.recyclerview.widget.RecyclerView;

        import com.androidacademymsk.aartamonov.businesscard.data.NewsItem;
        import com.bumptech.glide.Glide;
        import com.bumptech.glide.RequestManager;
        import com.bumptech.glide.request.RequestOptions;
        import java.util.List;
//        import ru.androidacademy.msk.lists.data.Actor;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    @NonNull
    private final List<NewsItem> newsList;
    @NonNull
    private final LayoutInflater inflater;
    @NonNull
    private final Context context;
    @Nullable
    private final OnItemClickListener clickListener;
//    @NonNull
//    private final RequestManager imageLoader;

    public NewsAdapter(@NonNull Context context, @NonNull List<NewsItem> newsList,
                                @Nullable OnItemClickListener clickListener) {
        this.newsList = newsList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.clickListener = clickListener;

//        RequestOptions imageOption = new RequestOptions()
//                .placeholder(R.drawable.avatar_placeholder)
//                .fallback(R.drawable.avatar_placeholder)
//                .centerCrop();
//        this.imageLoader = Glide.with(context).applyDefaultRequestOptions(imageOption);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_news, parent, false), clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Activity activity, NewsItem newsItem);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgView;
        private final TextView categoryView;
        private final TextView captionView;
        private final TextView contentView;
        private final TextView dateView;

        ViewHolder(@NonNull View itemView, @Nullable OnItemClickListener listener) {
            super(itemView);
//            itemView.setOnClickListener(view -> {
//                int position = getAdapterPosition();
//                if (listener != null && position != RecyclerView.NO_POSITION) {
//                    listener.onItemClick(actors.get(position));
//                }
//            });
            final OnItemClickListener listener1 = listener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener1 != null && position != RecyclerView.NO_POSITION) {
                        listener1.onItemClick((Activity)view.getContext(), newsList.get(position));
                    }
                }
            });
            imgView = itemView.findViewById(R.id.news_img);
            categoryView = itemView.findViewById(R.id.news_category);
            captionView = itemView.findViewById(R.id.news_caption);
            contentView = itemView.findViewById(R.id.news_content);
            dateView = itemView.findViewById(R.id.news_date);
        }

        void bind(NewsItem newsItem) {

<<<<<<< Updated upstream
//            imageLoader.load(actor.getAvatarUrl()).into(avatarView);
            Glide.with(context).load(newsItem.getImageUrl()).into(imgView);
            categoryView.setText(newsItem.getCategory().getName());
=======
            imageLoader.load(newsItem.getImageUrl()).into(imgView);
//            Glide.with(context).load(newsItem.getImageUrl()).into(imgView);
            categoryView.setText(newsItem.getCategory().getName().toUpperCase());
>>>>>>> Stashed changes
            captionView.setText(newsItem.getTitle());
            contentView.setText(newsItem.getFullText());
            dateView.setText(Utils.dateFormat(newsItem.getPublishDate()));

//            nameView.setText(actor.getName());
//            oscarView.setVisibility(actor.hasOscar() ? View.VISIBLE : View.GONE);
        }
    }
}
