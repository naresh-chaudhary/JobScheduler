/**
 * 
 */
package com.naresh.io;

import java.util.List;

/**
 * 
 * @author Naresh Kumar <br>
 *         email- naresh.nitbhopal@gmail.com
 *
 */
public class EDF {
	private List<String> jobNames;
	private double deadline;

	/**
	 * @return the jobNames
	 */
	public List<String> getJobNames() {
		return jobNames;
	}

	/**
	 * @param jobNames
	 *            the jobNames to set
	 */
	public void setJobNames(List<String> jobNames) {
		this.jobNames = jobNames;
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

}
