package com.tbb.models;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name="TASKS")
public class Tasks {

    @Id
    @Column(name="task_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="task_seq")
    @SequenceGenerator(name="task_seq", sequenceName="task_seq", allocationSize = 1)
    private int taskId;

    @NotNull
    @Column(name="task_name")
    private String taskName;

    @NotNull
    @Column(name="task_desc")
    private String taskDesc;

    @NotNull
    @Column(name="task_submitted_date")
    private String taskSubmittedDate;

    @NotNull
    @Column(name="task_due_date")
    private String taskDueDate;

    @NotNull
    @Column(name="task_status")
    private String taskStatus;

    @NotNull
    @Column(name="task_estimated_cost")
    private double taskEstimatedCost;

    @Column(name="task_final_cost")
    private double taskFinalCost;

    @NotNull
    @Column(name="task_estimated_effort")
    private double taskEstimatedEffort;

    @Column(name="task_actual_effort")
    private double taskActualEffort;

    @NotNull
    @Column(name="task_cost_per_hour")
    private double taskCostPerHour;
    
    @Column(name="task_completed_date")
    private String taskCompletedDate;
    
    @Column(name="admin_id")
    private String adminId;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="invoice_id")
    private Invoices invoices;

    @NotNull
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private Users user;

    public Tasks() {
    }

	public Tasks(@NotNull String taskName, @NotNull String taskDesc, @NotNull String taskSubmittedDate,
			@NotNull String taskDueDate, @NotNull String taskStatus, @NotNull double taskEstimatedCost,
			double taskFinalCost, @NotNull double taskEstimatedEffort, double taskActualEffort,
			@NotNull double taskCostPerHour, String taskCompletedDate, String adminId) {
		super();
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.taskSubmittedDate = taskSubmittedDate;
		this.taskDueDate = taskDueDate;
		this.taskStatus = taskStatus;
		this.taskEstimatedCost = taskEstimatedCost;
		this.taskFinalCost = taskFinalCost;
		this.taskEstimatedEffort = taskEstimatedEffort;
		this.taskActualEffort = taskActualEffort;
		this.taskCostPerHour = taskCostPerHour;
		this.taskCompletedDate = taskCompletedDate;
		this.adminId = adminId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getTaskSubmittedDate() {
		return taskSubmittedDate;
	}

	public void setTaskSubmittedDate(String taskSubmittedDate) {
		this.taskSubmittedDate = taskSubmittedDate;
	}

	public String getTaskDueDate() {
		return taskDueDate;
	}

	public void setTaskDueDate(String taskDueDate) {
		this.taskDueDate = taskDueDate;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public double getTaskEstimatedCost() {
		return taskEstimatedCost;
	}

	public void setTaskEstimatedCost(double taskEstimatedCost) {
		this.taskEstimatedCost = taskEstimatedCost;
	}

	public double getTaskFinalCost() {
		return taskFinalCost;
	}

	public void setTaskFinalCost(double taskFinalCost) {
		this.taskFinalCost = taskFinalCost;
	}

	public double getTaskEstimatedEffort() {
		return taskEstimatedEffort;
	}

	public void setTaskEstimatedEffort(double taskEstimatedEffort) {
		this.taskEstimatedEffort = taskEstimatedEffort;
	}

	public double getTaskActualEffort() {
		return taskActualEffort;
	}

	public void setTaskActualEffort(double taskActualEffort) {
		this.taskActualEffort = taskActualEffort;
	}

	public double getTaskCostPerHour() {
		return taskCostPerHour;
	}

	public void setTaskCostPerHour(double taskCostPerHour) {
		this.taskCostPerHour = taskCostPerHour;
	}

	public String getTaskCompletedDate() {
		return taskCompletedDate;
	}

	public void setTaskCompletedDate(String taskCompletedDate) {
		this.taskCompletedDate = taskCompletedDate;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public Invoices getInvoices() {
		return invoices;
	}

	public void setInvoices(Invoices invoices) {
		this.invoices = invoices;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((invoices == null) ? 0 : invoices.hashCode());
		long temp;
		temp = Double.doubleToLongBits(taskActualEffort);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((taskCompletedDate == null) ? 0 : taskCompletedDate.hashCode());
		temp = Double.doubleToLongBits(taskCostPerHour);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((taskDesc == null) ? 0 : taskDesc.hashCode());
		result = prime * result + ((taskDueDate == null) ? 0 : taskDueDate.hashCode());
		temp = Double.doubleToLongBits(taskEstimatedCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taskEstimatedEffort);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taskFinalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + taskId;
		result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
		result = prime * result + ((taskStatus == null) ? 0 : taskStatus.hashCode());
		result = prime * result + ((taskSubmittedDate == null) ? 0 : taskSubmittedDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasks other = (Tasks) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (invoices == null) {
			if (other.invoices != null)
				return false;
		} else if (!invoices.equals(other.invoices))
			return false;
		if (Double.doubleToLongBits(taskActualEffort) != Double.doubleToLongBits(other.taskActualEffort))
			return false;
		if (taskCompletedDate == null) {
			if (other.taskCompletedDate != null)
				return false;
		} else if (!taskCompletedDate.equals(other.taskCompletedDate))
			return false;
		if (Double.doubleToLongBits(taskCostPerHour) != Double.doubleToLongBits(other.taskCostPerHour))
			return false;
		if (taskDesc == null) {
			if (other.taskDesc != null)
				return false;
		} else if (!taskDesc.equals(other.taskDesc))
			return false;
		if (taskDueDate == null) {
			if (other.taskDueDate != null)
				return false;
		} else if (!taskDueDate.equals(other.taskDueDate))
			return false;
		if (Double.doubleToLongBits(taskEstimatedCost) != Double.doubleToLongBits(other.taskEstimatedCost))
			return false;
		if (Double.doubleToLongBits(taskEstimatedEffort) != Double.doubleToLongBits(other.taskEstimatedEffort))
			return false;
		if (Double.doubleToLongBits(taskFinalCost) != Double.doubleToLongBits(other.taskFinalCost))
			return false;
		if (taskId != other.taskId)
			return false;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
		if (taskStatus == null) {
			if (other.taskStatus != null)
				return false;
		} else if (!taskStatus.equals(other.taskStatus))
			return false;
		if (taskSubmittedDate == null) {
			if (other.taskSubmittedDate != null)
				return false;
		} else if (!taskSubmittedDate.equals(other.taskSubmittedDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tasks [taskId=" + taskId + ", taskName=" + taskName + ", taskDesc=" + taskDesc + ", taskSubmittedDate="
				+ taskSubmittedDate + ", taskDueDate=" + taskDueDate + ", taskStatus=" + taskStatus
				+ ", taskEstimatedCost=" + taskEstimatedCost + ", taskFinalCost=" + taskFinalCost
				+ ", taskEstimatedEffort=" + taskEstimatedEffort + ", taskActualEffort=" + taskActualEffort
				+ ", taskCostPerHour=" + taskCostPerHour + ", taskCompletedDate=" + taskCompletedDate + ", adminId="
				+ adminId + "]";
	}


}
