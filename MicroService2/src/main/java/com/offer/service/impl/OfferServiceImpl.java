package com.offer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offer.model.Offer;
import com.offer.model.request.OfferRequest;
import com.offer.repository.OfferRepository;
import com.offer.service.OfferService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

	private final OfferRepository offerRepository;

	@Autowired
	public OfferServiceImpl(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}

	@Transactional
	@Override
	public void addProductOffer(OfferRequest offerRequest) {
		Optional<Offer> offer = offerRepository.findByProductId(offerRequest.getProductId());
		if(offer.isPresent()){
			offer.get().setDiscountOffer(offerRequest.getDiscountOffer());
		}else {
			offer = Optional.ofNullable(new Offer().builder()
					.productId(offerRequest.getProductId())
					.discountOffer(offerRequest.getDiscountOffer())
					.build());
		}
		offerRepository.save(offer.get());
			}

	@Override
	public List<Offer> getOffers() {
		return offerRepository.findAll();
	}
}
