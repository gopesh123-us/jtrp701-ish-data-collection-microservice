package live.learnjava.data_collection_service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import live.learnjava.data_collection_service.entities.DcChildEntity;

public interface IDcChildRepository extends JpaRepository<DcChildEntity, Integer>{
	// TODO to verify if this works
	public List<DcChildEntity> findByCaseNo(Integer caseNo); 
}
