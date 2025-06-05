package com.example.HireStream.job.impl;

import com.example.HireStream.job.Job;
import com.example.HireStream.job.JobRepository;
import com.example.HireStream.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
//        job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
         Optional<Job> jobOptional = jobRepository.findById(id);
    if (jobOptional.isPresent()) {
        Job existingJob = jobOptional.get();
        existingJob.setTitle(updatedJob.getTitle());
        existingJob.setDescription(updatedJob.getDescription());
        existingJob.setMinSalary(updatedJob.getMinSalary());
        existingJob.setMaxSalary(updatedJob.getMaxSalary());
        existingJob.setLocation(updatedJob.getLocation());

        jobRepository.save(existingJob);
        return true;
    }
        return false;

    }


}
