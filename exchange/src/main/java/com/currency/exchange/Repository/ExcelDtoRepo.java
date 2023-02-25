package com.currency.exchange.Repository;

import com.currency.exchange.Model.ExcelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelDtoRepo extends JpaRepository<ExcelDto,Long> {
}
