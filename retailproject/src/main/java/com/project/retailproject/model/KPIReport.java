package com.project.retailproject.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="kPIReport")
public class KPIReport {
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public KPIReport() {

        super();
    }

    @Override
    public String toString() {
        return "KPIReport{" +
                "reportId=" + reportId +
                ", scope='" + scope + '\'' +
                ", metrics='" + metrics + '\'' +
                ", generatedDate=" + generatedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        KPIReport kpiReport = (KPIReport) o;
        return Objects.equals(reportId, kpiReport.reportId) && Objects.equals(scope, kpiReport.scope) && Objects.equals(metrics, kpiReport.metrics) && Objects.equals(generatedDate, kpiReport.generatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, scope, metrics, generatedDate);
    }
}

