package com.lyn.jobms.job.impl;


import com.lyn.jobms.job.IJobRepository;
import com.lyn.jobms.job.IJobService;
import com.lyn.jobms.job.Job;
import com.lyn.jobms.job.dto.JobWithCompanyDTO;
import com.lyn.jobms.job.extern.Company;
import com.lyn.jobms.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService implements IJobService {
    IJobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    public JobService(IJobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobWithCompanyDTO> findAllJob() {
        List<Job> jobs = jobRepository.findAll();
        return (jobs.stream().map(this::convertToDto).collect(Collectors.toList()));
    }
    private JobWithCompanyDTO convertToDto(Job job) {
        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
        Company company = restTemplate.getForObject(
                "http://COMPANYMS:8081/companies/" + job.getCompanyId(),
                Company.class);
        jobWithCompanyDTO = JobMapper.mapToJobWithCompanyDto(job, company);
        //jobWithCompanyDTO.setCompany(company);
        return (jobWithCompanyDTO);
    }
    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobWithCompanyDTO findJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job == null)
            return (null);
        return(convertToDto(job));
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return (false);
        }
    }

    @Override
    public boolean putJobById(Long id, Job updateJob) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            job.update(updateJob);
            jobRepository.save(job);
            return (true);
        }
        return (false);
    }
}
