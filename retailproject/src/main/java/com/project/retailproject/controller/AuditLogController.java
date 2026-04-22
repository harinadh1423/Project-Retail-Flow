package com.project.retailproject.controller;

import com.project.retailproject.dto.AuditLogDTO;
import com.project.retailproject.dto.AuditResponseDTO;
import com.project.retailproject.model.AuditLog;
import com.project.retailproject.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditLog")
public class AuditLogController {
    @Autowired
    private AuditLogService auditLogService;

    @PostMapping("/insertAuditLog")
    public ResponseEntity<AuditResponseDTO> insertAuditLog(@RequestBody AuditLogDTO auditLogDTO) {
        AuditLog a = this.auditLogService.insertAuditLog(auditLogDTO.getAuditLog());
        AuditResponseDTO dto = new AuditResponseDTO();
        dto.setAuditLog(a);
        dto.setStatusCode(201);
        dto.setMessage("AuditLog created successfully");
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/updateAuditLog")
    public ResponseEntity<AuditResponseDTO> updateAuditLog(@RequestBody AuditLogDTO auditLogDTO) {
        AuditLog a = this.auditLogService.updateAuditLog(auditLogDTO.getAuditLog());
        AuditResponseDTO dto = new AuditResponseDTO();
        dto.setAuditLog(a);
        dto.setStatusCode(201);
        dto.setMessage("AuditLog updated successfully");
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/getAllAuditLogs")
    public ResponseEntity<List<AuditLog>> getAllAuditLogs() {
        List<AuditLog> logs = auditLogService.getAllAuditLog();
        return ResponseEntity.ok().body(logs);
    }

    @GetMapping("/getAuditLog/{auditID}")
    public ResponseEntity<AuditResponseDTO> getAuditLogById(@PathVariable int auditID) {
        AuditLog a = auditLogService.getAuditLogByID(auditID);
        AuditResponseDTO auditResponseDTO = new AuditResponseDTO();
        auditResponseDTO.setAuditLog(a);
        auditResponseDTO.setStatusCode(200);
        auditResponseDTO.setMessage("Found auditLog with ID: " + auditID);
        return ResponseEntity.ok().body(auditResponseDTO);
    }


    @DeleteMapping("deleteAuditLog/{auditID}")
    public ResponseEntity<String> deleteAuditLog(@PathVariable int auditID) {
        auditLogService.deleteAuditLog(auditID);
        return ResponseEntity.ok().body("Successfully deleted the auditLog");
    }



}
