package com.project.retailproject.db;

import com.project.retailproject.model.ComplianceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplianceReportRepository extends JpaRepository<ComplianceReport,Long> {
}
