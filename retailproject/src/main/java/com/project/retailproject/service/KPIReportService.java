package com.project.retailproject.service;

import com.project.retailproject.db.KPIReportRepository;
import com.project.retailproject.model.KPIReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class KPIReportService {
    @Autowired
    KPIReportRepository kpiReportRepository;
    public KPIReport saveReport(KPIReport kpiReport){
        return kpiReportRepository.save(kpiReport);
    }

    public KPIReport getReportsByScope(String scope){
        return kpiReportRepository.findFirstByScopeOrderByGeneratedDateDesc(scope);
    }
    public List<KPIReport> getTrendData(String scope, int lastXDays){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -lastXDays);
        Date startDate = cal.getTime();
        return kpiReportRepository.findByScopeAndGeneratedDateAfter(scope, startDate);    }
}
