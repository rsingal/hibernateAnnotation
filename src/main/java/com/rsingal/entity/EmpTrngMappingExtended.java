package com.rsingal.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "EMP_TRNG_MAPPING_EXTENDED")
@AssociationOverrides({ @AssociationOverride(name = "empTrngMappingExtId.employee", joinColumns = @JoinColumn(name = "ID_EMPLOYEE")),
		@AssociationOverride(name = "empTrngMappingExtId.training", joinColumns = @JoinColumn(name = "ID_TRAINING")) })
public class EmpTrngMappingExtended {

	private EmpTrngMappingExtendedId empTrngMappingExtId;
	Integer status;

	public EmpTrngMappingExtended() {
	}

	public EmpTrngMappingExtended(EmpTrngMappingExtendedId empTrngMappingExtId, Integer status) {
		this.empTrngMappingExtId = empTrngMappingExtId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmpTrngMappingExtended [empTrngMappingExtendedId = " + empTrngMappingExtId + ", status = " + (status == 1 ? "Training Done" : "Training Pending") + "]";
	}

	@EmbeddedId
	public EmpTrngMappingExtendedId getEmpTrngMappingExtId() {
		return empTrngMappingExtId;
	}

	public void setEmpTrngMappingExtId(EmpTrngMappingExtendedId empTrngMappingExtId) {
		this.empTrngMappingExtId = empTrngMappingExtId;
	}

	@Transient
	public Employee getEmployee() {
		return empTrngMappingExtId.getEmployee();
	}

	public void setEmployee(Employee employee) {
		empTrngMappingExtId.setEmployee(employee);
	}

	@Transient
	public Training getTraining() {
		return empTrngMappingExtId.getTraining();
	}

	public void setTraining(Training training) {
		empTrngMappingExtId.setTraining(training);
	}

	@Column(name = "STATUS", nullable = false)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
