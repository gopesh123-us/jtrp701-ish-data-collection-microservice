package live.learnjava.data_collection_service.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JR701_PLAN_MASTER")
@Data
public class PlanEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer planId;
	
	@Column(length=30)
	private String planName;
	
	private Integer planCategoryId;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Column(length=255)
	private String description;
		
	private String activeSw;;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@CreatedBy
	@Column(length=30)
	private String createdBy;
	
	@LastModifiedBy
	@Column(length=30)
	private String updatedBy;
}
