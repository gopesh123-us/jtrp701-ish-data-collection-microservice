package live.learnjava.data_collection_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import live.learnjava.data_collection_service.entities.DcIncomeEntity;

public interface IDcIncomeRepository extends JpaRepository<DcIncomeEntity, Integer>{
	public DcIncomeEntity findByCaseNo(Integer caseNo);
}
