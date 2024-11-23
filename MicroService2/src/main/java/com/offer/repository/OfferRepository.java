package com.offer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offer.model.Offer;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
    Optional<Offer> findByProductId(Integer productId);
}
