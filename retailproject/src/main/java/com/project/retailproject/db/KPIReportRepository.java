package com.project.retailproject.db;

import com.project.retailproject.model.KPIReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface KPIReportRepository extends JpaRepository<KPIReport,Long> {
    KPIReport findFirstByScopeOrderByGeneratedDateDesc(String  scope);

    List<KPIReport> findByScopeAndGeneratedDateAfter(String scope, Date generatedDateAfter);
}
