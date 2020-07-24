package com.app.heterogenousrecyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.heterogenousrecyclerview.R;
import com.app.heterogenousrecyclerview.models.Ads;
import com.app.heterogenousrecyclerview.models.Item;
import com.app.heterogenousrecyclerview.models.News;
import com.app.heterogenousrecyclerview.models.Trip;

import java.util.List;

public class TripsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Item> items;

    public TripsAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Here Types are: 0 - Trips, 1 - Ads , 2 - News - For Creating Views
        if (viewType == 0) {
            return new TripViewHolder(LayoutInflater.from(context).inflate(R.layout.trip_item, parent, false));
        } else if (viewType == 1) {
            return new AdsViewHolder(LayoutInflater.from(context).inflate(R.layout.ads_item, parent, false));
        } else {
            return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //Here Types are: 0 - Trips, 1 - Ads , 2 - News - For Creating Views
        if (getItemViewType(position) == 0) {
            Trip trip = (Trip) items.get(position).getObject();
            ((TripViewHolder) holder).setTripData(trip);
        } else if (getItemViewType(position) == 1) {
            Ads ads = (Ads) items.get(position).getObject();
            ((AdsViewHolder) holder).setAdsData(ads);
        } else {
            News news = (News) items.get(position).getObject();
            ((NewsViewHolder) holder).setNewsData(news);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    /*
    ViewHolders - Trip,Ads,News
    */
    public static class TripViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_trip;
        private TextView text_trip, text_trip_title;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);

            image_trip = itemView.findViewById(R.id.image_trip);
            text_trip = itemView.findViewById(R.id.text_trip);
            text_trip_title = itemView.findViewById(R.id.text_trip_title);
        }

        public void setTripData(Trip tripData) {
            text_trip.setText(tripData.getTrip());
            text_trip_title.setText(tripData.getTripTitle());
            image_trip.setImageResource(tripData.getTripImage());
        }
    }

    public static class AdsViewHolder extends RecyclerView.ViewHolder {

        private TextView text_ads_title, text_ads;

        public AdsViewHolder(@NonNull View itemView) {
            super(itemView);

            text_ads_title = itemView.findViewById(R.id.text_ads_title);
            text_ads = itemView.findViewById(R.id.text_ads);
        }

        public void setAdsData(Ads adsData) {
            text_ads.setText(adsData.getAds());
            text_ads_title.setText(adsData.getAdsTitle());
        }
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        private TextView text_news_title, text_news;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            text_news_title = itemView.findViewById(R.id.text_news_title);
            text_news = itemView.findViewById(R.id.text_news);

        }

        public void setNewsData(News newsData) {
            text_news.setText(newsData.getNews());
            text_news_title.setText(newsData.getNewsTitle());
        }
    }

}
