package live.learnjava.data_collection_service.bindings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DcIncomeEntityDTO {
	private Integer incomeId; //do not collect from the user
	private Integer caseNo;
	private Double employmentIncome;
	private Double propertyIncome;
}
