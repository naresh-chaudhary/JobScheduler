/**
 * 
 */
package com.naresh.io;

/**
 * This class stores information related to a Job.
 * 
 * @author Naresh Kumar <br>
 *         email- naresh.nitbhopal@gmail.com
 *
 */
public class Job {

	private String jobName;
	private double duration;
	private int priority;
	private double deadline;
	private int userType;

	/**
	 * 
	 */
	public Job() {

	}

	/**
	 * @param jobName
	 * @param duration
	 * @param priority
	 * @param deadline
	 * @param userType
	 */
	public Job(String jobName, double duration, int priority, double deadline, int userType) {
		super();
		this.jobName = jobName;
		this.duration = duration;
		this.priority = priority;
		this.deadline = deadline;
		this.userType = userType;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName
	 *            the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the deadline
	 */
	public double getDeadline() {
		return deadline;
	}

	/**
	 * @param deadline
	 *            the deadline to set
	 */
	public void setDeadline(double deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return the userType
	 */
	public int getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(int userType) {
		this.userType = userType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Input [jobName=" + jobName + ", duration=" + duration + ", priority=" + priority + ", deadline="
				+ deadline + ", userType=" + userType + "]";
	}

}
