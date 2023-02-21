package com.exchange.money_exchange.Repository;

import com.exchange.money_exchange.Entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepo extends JpaRepository<Audit,Long> {
}
