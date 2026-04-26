package com.project.retailproject.service;

import com.project.retailproject.db.ComplianceReportRepository;
import com.project.retailproject.model.ComplianceReport;
import com.project.retailproject.model.KPIReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceReportService {

    @Autowired
    private ComplianceReportRepository complianceReportRepository;

    public ComplianceReport insertComplianceReport(ComplianceReport complianceReport) {
        return complianceReportRepository.save(complianceReport);
    }

    public ComplianceReport updateComplianceReport(ComplianceReport complianceReport) {
        return complianceReportRepository.save(complianceReport);
    }

    public void deleteComplianceReport(Long reportId) {
        complianceReportRepository.deleteById(reportId);
    }

    public ComplianceReport getComplianceReport(Long reportId) {
        return complianceReportRepository.findById(reportId).get();
    }

    public List<ComplianceReport> getAllComplianceReport() {
        return complianceReportRepository.findAll();
    }

    public Page<ComplianceReport> getAllPagesWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return complianceReportRepository.findAll(pageable);
    }
}
