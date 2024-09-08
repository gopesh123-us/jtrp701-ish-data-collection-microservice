package live.learnjava.data_collection_service.entities;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "JR701_DC_INCOME")
@Data
public class DcIncomeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer incomeId;
	private Integer caseNo;
	private Double employmentIncome;
	private Double propertyIncome;
	
	@CreatedDate
	private Date createdAt;
	
	@LastModifiedDate
	private LocalDate updatedAt;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedBy
	private String updatedBy;
}
