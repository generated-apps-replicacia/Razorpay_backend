package com.apps.petcare.repository;


import com.apps.petcare.model.PaymentDetails;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class PaymentDetailsRepository extends SimpleJpaRepository<PaymentDetails, String> {
    private final EntityManager em;
    public PaymentDetailsRepository(EntityManager em) {
        super(PaymentDetails.class, em);
        this.em = em;
    }
    @Override
    public List<PaymentDetails> findAll() {
        return em.createNativeQuery("Select * from \"petcare\".\"Document\"", PaymentDetails.class).getResultList();
    }
}