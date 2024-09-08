package live.learnjava.data_collection_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import live.learnjava.data_collection_service.entities.DcEducationEntity;

public interface IDcEducationRepository extends JpaRepository<DcEducationEntity, Integer>{
	public DcEducationEntity findByCaseNo(Integer caseNo);
}
