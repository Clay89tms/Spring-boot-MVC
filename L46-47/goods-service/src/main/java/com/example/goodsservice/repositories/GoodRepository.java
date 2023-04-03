package com.example.goodsservice.repositories;

import com.example.goodsservice.model.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GoodRepository extends JpaRepository<GoodEntity, UUID> {

    Optional<GoodEntity> findByName(String name);

}
