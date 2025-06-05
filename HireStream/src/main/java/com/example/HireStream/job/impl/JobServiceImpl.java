package com.example.HireStream.job.impl;

import com.example.HireStream.job.Job;
import com.example.HireStream.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
    for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return (job);
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            if (job.getId().equals(id)) {
                updatedJob.setId(id);
                jobs.set(i, updatedJob);
                return true;
            }
        }
        return false;

    }


}
