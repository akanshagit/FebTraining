package com.currency.exchange.Repository;

import com.currency.exchange.Model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepo extends JpaRepository<Audit,Long> {
}
