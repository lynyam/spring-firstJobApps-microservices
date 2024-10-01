package com.lyn.jobms.job;

import com.lyn.jobms.job.dto.JobWithCompanyDTO;

import java.util.List;

public interface IJobService {
    public List<JobWithCompanyDTO> findAllJob();
    public void createJob(Job job);

    public JobWithCompanyDTO findJobById(Long id);

    boolean deleteJobById(Long id);

    boolean putJobById(Long id, Job updateJob);
}
