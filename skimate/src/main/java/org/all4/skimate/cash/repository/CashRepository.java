package org.all4.skimate.cash.repository;

import org.all4.skimate.cash.entity.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CashRepository extends JpaRepository<Cash, Integer> {

}
