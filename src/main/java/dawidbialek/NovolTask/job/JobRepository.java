package dawidbialek.NovolTask.job;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long>{

//    List<Job> findPaged(int pageNumber, int pageSize);
}
