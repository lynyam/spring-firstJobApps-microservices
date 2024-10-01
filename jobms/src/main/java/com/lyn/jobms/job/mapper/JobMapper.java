package com.lyn.jobms.job.mapper;

import com.lyn.jobms.job.Job;
import com.lyn.jobms.job.dto.JobWithCompanyDTO;
import com.lyn.jobms.job.extern.Company;

public class JobMapper {

    public static JobWithCompanyDTO mapToJobWithCompanyDto(Job job, Company company) {
        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        return (jobWithCompanyDTO);
    }
}
