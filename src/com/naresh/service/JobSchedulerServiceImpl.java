/**
 * 
 */
package com.naresh.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naresh.io.EDF;
import com.naresh.io.Job;

/**
 * @author Naresh Kumar <br>
 *         email- naresh.nitbhopal@gmail.com
 *
 */
public class JobSchedulerServiceImpl implements JobSchedulerService {

	@Override
	public void shortestJobFirst(int threadNo, List<Job> job) {
		System.out.println("SJF:");
		List<Job> jobs = (List<Job>) ((ArrayList) job).clone();
		jobs.sort(new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				if (j1.getDuration() == j2.getDuration()) {
					return j1.getPriority() - j2.getPriority();
				}
				return (int) (j1.getDuration() - j2.getDuration());
			}
		});

		Map<Integer, List<String>> threads = assignThreadsToJobs(threadNo, jobs);
		displayScheduledJobs(threads);
	}

	@Override
	public void firstComeFirstServe(int threadNo, List<Job> job) {
		System.out.println("FCFS:");

		Map<Integer, List<String>> threads = assignThreadsToJobs(threadNo, job);

		displayScheduledJobs(threads);

	}

	@Override
	public void fixedPriorityScheduling(int threadNo, List<Job> job) {
		System.out.println("FPS:");

		List<Job> jobs = (List<Job>) ((ArrayList) job).clone();
		jobs.sort(new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				if (j1.getPriority() == j2.getPriority()) {
					if (j1.getUserType() == j2.getUserType()) {
						return (int) (j2.getDuration() - j1.getDuration());
					} else {
						return j1.getUserType() - j2.getUserType();
					}
				}
				return (int) (j1.getPriority() - j2.getPriority());
			}
		});

		Map<Integer, List<String>> threads = assignThreadsToJobs(threadNo, jobs);

		displayScheduledJobs(threads);
	}

	@Override
	public void earliestDeadlineFirst(int threadNo, List<Job> job) {

		System.out.println("EDF:");
		List<Job> jobs = (List<Job>) ((ArrayList) job).clone();
		jobs.sort(new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				if (j1.getDeadline() == j2.getDeadline()) {
					if (j1.getPriority() == j2.getPriority()) {
						return (int) (j1.getDuration() - j2.getDuration());
					} else {
						return j1.getPriority() - j2.getPriority();
					}
				}
				return (int) (j1.getDeadline() - j2.getDeadline());
			}
		});
		Map<Integer, EDF> threads = assignThreadsToJobsForEdf(threadNo, jobs);
		displayScheduledJobsForEdf(threads);

	}

	private void displayScheduledJobsForEdf(Map<Integer, EDF> threads) {
		for (Map.Entry<Integer, EDF> entry : threads.entrySet()) {
			System.out.print("Thread:" + entry.getKey() + " - ");
			entry.getValue().getJobNames().forEach(name -> {
				System.out.print(name + " ");
			});
			System.out.println();
		}

	}

	private Map<Integer, EDF> assignThreadsToJobsForEdf(int threadNo, List<Job> jobs) {
		Map<Integer, EDF> threads = new HashMap();
		EDF edf;
		int deadline = 0;
		int thread = 0;
		for (Job j : jobs) {
			if (!threads.containsKey(thread % threadNo)) {
				if (j.getDuration() <= j.getDeadline()) {
					edf = new EDF();
					edf.setJobNames(new ArrayList<String>());
					edf.getJobNames().add(j.getJobName());
					edf.setDeadline(j.getDuration());
					threads.put(thread % threadNo, edf);
					thread++;
				}
			} else {
				edf = threads.get(thread % threadNo);
				if (edf.getDeadline() + j.getDuration() <= j.getDeadline()) {
					edf.setDeadline(edf.getDeadline() + j.getDuration());
					edf.getJobNames().add(j.getJobName());
					thread++;
				}
			}

		}
		return threads;

	}

	private void displayScheduledJobs(Map<Integer, List<String>> threads) {
		for (Map.Entry<Integer, List<String>> entry : threads.entrySet()) {
			System.out.print("Thread:" + entry.getKey() + " - ");
			entry.getValue().forEach(name -> {
				System.out.print(name + " ");
			});
			System.out.println();
		}

	}

	private Map<Integer, List<String>> assignThreadsToJobs(int threadNo, List<Job> job) {
		Map<Integer, List<String>> threads = new HashMap();
		List<String> jobNames;
		int thread = 0;
		for (Job j : job) {
			if (!threads.containsKey(thread % threadNo)) {
				jobNames = new ArrayList<>();
				jobNames.add(j.getJobName());
				threads.put(thread % threadNo, jobNames);
			} else {
				jobNames = threads.get(thread % threadNo);
				jobNames.add(j.getJobName());

			}
			thread++;
		}
		return threads;
	}

}
