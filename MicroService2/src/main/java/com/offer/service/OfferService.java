package com.offer.service;

import java.util.List;

import com.offer.model.Offer;
import com.offer.model.request.OfferRequest;

public interface OfferService {
    void addProductOffer(OfferRequest offerRequest);

    List<Offer> getOffers();
}
