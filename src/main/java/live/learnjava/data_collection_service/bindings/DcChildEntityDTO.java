package live.learnjava.data_collection_service.bindings;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DcChildEntityDTO {
	private Integer childId;
	private Integer caseNo;
	private LocalDate childDOB;
	private Integer childSSN;
}
