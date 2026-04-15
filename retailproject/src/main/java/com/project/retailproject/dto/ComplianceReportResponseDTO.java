package com.project.retailproject.dto;

import com.project.retailproject.model.ComplianceReport;

public class ComplianceReportResponseDTO {

    private ComplianceReport complianceReport;
    private String message;
    private int StatusCode;

    public ComplianceReport getComplianceReport() {
        return complianceReport;
    }

    public void setComplianceReport(ComplianceReport complianceReport) {
        this.complianceReport = complianceReport;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }
}
