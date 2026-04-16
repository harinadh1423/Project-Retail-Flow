package com.project.retailproject.service;

import com.project.retailproject.db.AuditLogRepository;
import com.project.retailproject.model.AuditLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {
    @Autowired
    AuditLogRepository auditLogRepository;

    public AuditLog insertAuditLog(AuditLog auditLog) {
       return auditLogRepository.save(auditLog);

    }


    public AuditLog updateAuditLog(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);

    }

    public void deleteAuditLog(int id) {
        auditLogRepository.deleteById(id);
    }

    public AuditLog getAuditLogByID(int id) {
        return auditLogRepository.findById(id).get();
    }

    public List<AuditLog> getAllAuditLog() {
        return auditLogRepository.findAll();
    }

}
