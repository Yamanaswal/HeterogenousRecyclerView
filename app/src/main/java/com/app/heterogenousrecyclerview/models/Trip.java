package com.app.heterogenousrecyclerview.models;

public class Trip {

    private String tripTitle, trip;
    private int tripImage;

    public Trip(String tripTitle, String trip, int tripImage) {
        this.tripTitle = tripTitle;
        this.trip = trip;
        this.tripImage = tripImage;
    }

    public String getTripTitle() {
        return tripTitle;
    }

    public String getTrip() {
        return trip;
    }

    public int getTripImage() {
        return tripImage;
    }
}
