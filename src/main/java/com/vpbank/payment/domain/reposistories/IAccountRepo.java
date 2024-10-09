package com.vpbank.payment.domain.reposistories;

import com.vpbank.payment.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepo extends JpaRepository<Account, Long> {
}
