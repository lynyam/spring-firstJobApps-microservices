package com.lyn.jobms.job;

import com.lyn.jobms.job.dto.JobWithCompanyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private IJobService jobService;

    public JobController(IJobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobWithCompanyDTO>> findAllJob() {
        return ResponseEntity.ok(jobService.findAllJob());
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobWithCompanyDTO> findJobById(@PathVariable Long id) {
        JobWithCompanyDTO jobWithCompanyDTO = jobService.findJobById(id);
        if (jobWithCompanyDTO != null)
            return (new ResponseEntity<>(jobWithCompanyDTO, HttpStatus.OK));
        return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job successful added", HttpStatus.CREATED);
    }
    //@DeleteMapping("/jobs/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
            return (new ResponseEntity<>("Job id: " + id + " deleted", HttpStatus.OK));
        return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //@PutMapping("/jobs/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updateJob) {
        boolean updated = jobService.putJobById(id, updateJob);
        if (updated)
            return (new ResponseEntity<>("Job ID: " + id + " is Succesfull Update", HttpStatus.OK));
        return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
