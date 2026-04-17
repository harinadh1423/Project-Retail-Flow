package com.project.retailproject.controller;

import com.project.retailproject.dto.ComplianceReportDTO;
import com.project.retailproject.dto.ComplianceReportResponseDTO;
import com.project.retailproject.model.ComplianceReport;
import com.project.retailproject.service.ComplianceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("complianceReport")
public class ComplianceReportController {
    @Autowired
    private ComplianceReportService complianceReportService;

    @PostMapping("/insertComplianceReport")
    public ResponseEntity<ComplianceReportResponseDTO> insertComplianceReport(@RequestBody ComplianceReportDTO complianceReportDTO) {
        ComplianceReport complianceReport = complianceReportService.insertComplianceReport(complianceReportDTO.getComplianceReport());
        ComplianceReportResponseDTO complianceReportResponseDTO = new ComplianceReportResponseDTO();
        complianceReportResponseDTO.setComplianceReport(complianceReport);
        complianceReportResponseDTO.setMessage("Success added compliance report");
        complianceReportResponseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(complianceReportResponseDTO);
    }

    @PutMapping("/updateComplianceReport")
    public ResponseEntity<ComplianceReportResponseDTO> updateComplianceReport(@RequestBody ComplianceReportDTO complianceReportDTO) {
        ComplianceReport complianceReport = complianceReportService.updateComplianceReport(complianceReportDTO.getComplianceReport());
        ComplianceReportResponseDTO complianceReportResponseDTO = new ComplianceReportResponseDTO();
        complianceReportResponseDTO.setComplianceReport(complianceReport);
        complianceReportResponseDTO.setMessage("Successfully updated compliance report");
        complianceReportResponseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(complianceReportResponseDTO);
    }

    @GetMapping("/getAllComplianceReports")
    public ResponseEntity<List<ComplianceReport>> getAllComplianceReports() {
        List<ComplianceReport> compReportList= complianceReportService.getAllComplianceReport();
        return ResponseEntity.ok().body(compReportList);
    }

    @GetMapping("/getComplianceReportById/{reportId}")
    public ResponseEntity<ComplianceReportResponseDTO> getAuditLogById(@PathVariable Long reportId) {
        ComplianceReport complianceReport = complianceReportService.getComplianceReport(reportId);
        ComplianceReportResponseDTO complianceReportDTO = new ComplianceReportResponseDTO();
        complianceReportDTO.setComplianceReport(complianceReport);
        complianceReportDTO.setStatusCode(200);
        complianceReportDTO.setMessage("Found compliance report with ID: " + reportId);
        return ResponseEntity.ok().body(complianceReportDTO);
    }

    @DeleteMapping("deleteComplianceReport/{reportId}")
    public ResponseEntity<String> deleteComplianceReport(@PathVariable Long reportId) {
        complianceReportService.deleteComplianceReport(reportId);
        return ResponseEntity.ok().body("Successfully deleted the compliance report with ID: " + reportId);
    }


}
