package com.ats.service;
import java.util.List;

import com.ats.entity.Admin;
import com.ats.entity.CurrentAdminSession;
import com.ats.exception.AdminException;
import com.ats.repository.IAdminRepository;
import com.ats.repository.ICurrentAdminSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService{
    private final IAdminRepository adminRepository;
    private final ICurrentAdminSessionRepository adminSessionRepository;

    @Autowired
    public AdminServiceImpl(IAdminRepository adminRepository, ICurrentAdminSessionRepository adminSessionRepository) {
        this.adminRepository = adminRepository;
        this.adminSessionRepository = adminSessionRepository;
    }

    @Override
    public Admin createAdmin(Admin admin) throws AdminException {
        List<Admin> admins = adminRepository.findByEmail(admin.getEmail());

        if(!admins.isEmpty()) throw new AdminException("Admin already present with the given email: " + admin.getEmail());

        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin, String key) throws AdminException {
        CurrentAdminSession adminSession = adminSessionRepository.findByaid(key);
        if(adminSession == null) throw new AdminException("Please enter valid key or login first!");
        if(!admin.getAdminID().equals(adminSession.getAdminID())) throw new AdminException("Invalid admin details, please login for updating admin!");
        return adminRepository.save(admin);
    }
}
