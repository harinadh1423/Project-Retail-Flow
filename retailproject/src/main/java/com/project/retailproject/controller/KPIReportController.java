package com.project.retailproject.controller;

import com.project.retailproject.dto.KPIReportDTO;
import com.project.retailproject.dto.KPIReportResponseDTO;
import com.project.retailproject.model.KPIReport;
import com.project.retailproject.service.KPIReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kpireport")
public class KPIReportController {

    @Autowired
    private KPIReportService kpiReportService;

    @PostMapping("/save")
    public ResponseEntity<KPIReportResponseDTO> saveReport(@RequestBody KPIReportDTO kpiReportDTO) {
        KPIReport k = this.kpiReportService.saveReport(kpiReportDTO.getKpiReport());
        KPIReportResponseDTO dto = new KPIReportResponseDTO();
        dto.setKpiReport(k);
        dto.setMessage("Report Saved Successfully");
        dto.setStatusCode(201);
        return ResponseEntity.status(201).body(dto);

    }
    @GetMapping("/latest/{scope}")
    public ResponseEntity<KPIReportResponseDTO> getLatestByScope(@PathVariable String scope) {
        KPIReport report=kpiReportService.getReportsByScope(scope);
        KPIReportResponseDTO dto=new KPIReportResponseDTO();
        dto.setKpiReport(report);
        dto.setStatusCode(200);
        dto.setMessage("Latest report for scope: " + scope);
        return  ResponseEntity.ok(dto);
    }
    @GetMapping("/trend/{scope}/{days}")
    public ResponseEntity<List<KPIReport>> getTrend(@PathVariable String scope, @PathVariable int days) {
        List<KPIReport> trends = kpiReportService.getTrendData(scope, days);

        // For lists, we usually return the list directly,
        // but you could wrap this in a ResponseDTO too if you add a List field to it.
        return ResponseEntity.ok(trends);
    }
}
