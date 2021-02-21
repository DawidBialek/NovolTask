package dawidbialek.NovolTask.job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class JobController {

    private final JobRepository repository;

    JobController(JobRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/jobs")
    List<Job> all() {
        System.out.println("jobs");
        return repository.findAll();
    }

    @GetMapping(value = "/jobs", params = {"sort"})
    List<Job> sort(@RequestParam("sort") List<String> sort) {
        System.out.println("sort");
        return repository.findAll(Sort.by(Sort.Direction.valueOf(sort.get(1).toUpperCase(Locale.ROOT)), sort.get(0)));
    }

    @GetMapping(value = "/jobs", params = {"page, size"})
    List<Job> allPaging(@RequestParam("page") int page, @RequestParam("size") int size) {
        List<Job> jobs = repository.findAll();

        Pageable paging = PageRequest.of(page, size);
        Page<Job> pagedResult = repository.findAll(paging);

        return pagedResult.toList();
    }

    @PostMapping("/jobs")
    Job newJob(@RequestBody Job newJob) {
        return repository.save(newJob);
    }

    @GetMapping("/jobs/{id}")
    Job one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    @PutMapping("/jobs/{id}")
    Job replaceJob(@RequestBody Job newJob, @PathVariable Long id) {

        return repository.findById(id)
                .map(Job -> {
                    Job.setName(newJob.getName());
                    return repository.save(Job);
                })
                .orElseGet(() -> {
                    newJob.setId(id);
                    return repository.save(newJob);
                });
    }

    @DeleteMapping("/jobs/{id}")
    void deleteJob(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
