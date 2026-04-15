package com.project.retailproject.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "complianceReport")
public class ComplianceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private String scope;
    private String metrics;


    private Date generatedDate;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public ComplianceReport() {
        super();
    }

    @Override
    public String toString() {
        return "ComplianceReport{" +
                "reportId=" + reportId +
                ", scope='" + scope + '\'' +
                ", metrics='" + metrics + '\'' +
                ", generatedDate=" + generatedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ComplianceReport that = (ComplianceReport) o;
        return Objects.equals(reportId, that.reportId) && Objects.equals(scope, that.scope) && Objects.equals(metrics, that.metrics) && Objects.equals(generatedDate, that.generatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, scope, metrics, generatedDate);
    }
}
