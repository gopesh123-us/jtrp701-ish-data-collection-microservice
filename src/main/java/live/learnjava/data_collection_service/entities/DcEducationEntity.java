package live.learnjava.data_collection_service.entities;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
@Table(name="JR701_DC_EDUCATION")
@Data
public class DcEducationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer educationId;
	private Integer caseNo;	
	
	@Column(length=255)
	private String highestQualification;
	private Integer passOutYear;
	
	@CreationTimestamp()
	@Column(insertable = true, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp()
	@Column(insertable = false, updatable = true)
	private LocalDate updatedAt;
	
	@CreatedBy
	@Column(length=30)
	private String createdBy;
	
	@LastModifiedBy
	@Column(length=30)
	private String updatedBy;
}
