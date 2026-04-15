package com.project.retailproject.db;

import com.project.retailproject.model.KPIReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KPIReportRepository extends JpaRepository<KPIReport,Long> {
}
