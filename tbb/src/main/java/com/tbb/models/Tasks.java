package com.tbb.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private Date taskSubmittedDate;

    @NotNull
    @Column(name="task_due_date")
    private Date taskDueDate;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="invoice_id")
    private Invoices invoices;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Users user;



    public Tasks() {
    }



	public Tasks(int taskId, @NotNull String taskName, @NotNull String taskDesc, @NotNull Date taskSubmittedDate,
			@NotNull Date taskDueDate, @NotNull String taskStatus, @NotNull double taskEstimatedCost,
			double taskFinalCost, @NotNull double taskEstimatedEffort, double taskActualEffort,
			@NotNull double taskCostPerHour, Invoices invoices, @NotNull Users user) {
		super();
		this.taskId = taskId;
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
		this.invoices = invoices;
		this.user = user;
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



	public Date getTaskSubmittedDate() {
		return taskSubmittedDate;
	}



	public void setTaskSubmittedDate(Date taskSubmittedDate) {
		this.taskSubmittedDate = taskSubmittedDate;
	}



	public Date getTaskDueDate() {
		return taskDueDate;
	}



	public void setTaskDueDate(Date taskDueDate) {
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
	public String toString() {
		return "Tasks [taskId=" + taskId + ", taskName=" + taskName + ", taskDesc=" + taskDesc + ", taskSubmittedDate="
				+ taskSubmittedDate + ", taskDueDate=" + taskDueDate + ", taskStatus=" + taskStatus
				+ ", taskEstimatedCost=" + taskEstimatedCost + ", taskFinalCost=" + taskFinalCost
				+ ", taskEstimatedEffort=" + taskEstimatedEffort + ", taskActualEffort=" + taskActualEffort
				+ ", taskCostPerHour=" + taskCostPerHour + ", invoices=" + invoices + ", user=" + user + "]";
	}
    
    
    
}
