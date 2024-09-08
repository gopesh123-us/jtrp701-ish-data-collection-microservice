package live.learnjava.data_collection_service.bindings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DcCasePlanEntityDTO {
	private Integer caseNo;
	private Integer appId;
	private Integer planId; 
	private String planName; //display purpose
	
}
