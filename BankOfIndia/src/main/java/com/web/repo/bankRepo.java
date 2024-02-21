package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.BankEntity;
@Repository
public interface bankRepo extends JpaRepository<BankEntity, Long> {

}
