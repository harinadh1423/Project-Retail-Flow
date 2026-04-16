package com.project.retailproject.controller;

import com.project.retailproject.dto.AuditLogDTO;
import com.project.retailproject.dto.AuditResponseDTO;
import com.project.retailproject.dto.UserDTO;
import com.project.retailproject.dto.UserResponseDTO;
import com.project.retailproject.model.AuditLog;
import com.project.retailproject.model.User;
import com.project.retailproject.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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
        return ResponseEntity.status(201).body(dto);
    }

    @PutMapping("/updateAuditLog")
    public ResponseEntity<AuditResponseDTO> updateAuditLog(@RequestBody AuditLogDTO auditLogDTO) {
        AuditLog a = this.auditLogService.updateAuditLog(auditLogDTO.getAuditLog());
        AuditResponseDTO dto = new AuditResponseDTO();
        dto.setAuditLog(a);
        dto.setStatusCode(201);
        dto.setMessage("AuditLog updated successfully");
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping("/getAllAuditLogs")
    public ResponseEntity<List<AuditLog>> getAuditLog() {
        List<AuditLog> logs = auditLogService.getAllAuditLog();
        return ResponseEntity.status(200).body(logs);
    }

    @GetMapping("/getAuditLog/{auditID}")
    public ResponseEntity<AuditResponseDTO> getAuditLog(@PathVariable int auditID) {
        AuditLog a = auditLogService.getAuditLogByID(auditID);
        AuditResponseDTO dto = new AuditResponseDTO();
        dto.setAuditLog(a);
        dto.setStatusCode(201);
        dto.setMessage("Found auditLog with ID: " + auditID);
        return ResponseEntity.status(200).body(dto);
    }


    @DeleteMapping("deleteAuditLog/{auditID}")
    public String deleteAuditLog(@PathVariable int auditID) {
        auditLogService.deleteAuditLog(auditID);
        return "AuditLog with ID deleted successfully";
    }



}
