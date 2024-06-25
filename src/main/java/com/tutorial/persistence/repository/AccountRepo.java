package com.tutorial.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tutorial.persistence.entity.AccountEntity;


public interface AccountRepo extends JpaRepository<AccountEntity, Long> {



}
