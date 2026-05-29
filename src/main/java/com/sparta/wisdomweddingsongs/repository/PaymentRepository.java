package com.sparta.wisdomweddingsongs.repository;

import com.sparta.wisdomweddingsongs.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

