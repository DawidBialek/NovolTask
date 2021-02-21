package dawidbialek.NovolTask;

import dawidbialek.NovolTask.job.Job;
import dawidbialek.NovolTask.job.JobRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class JobTests {

    @Autowired
    private JobRepository jobRepository;

    @Test
    public void saveAndLoadJob() {
        Job job = new Job(3L, "jobTest");
        jobRepository.save(job);

        Job job2 = jobRepository.findAll().get(2);
        assertEquals("jobTest", job2.getName());
    }

    @Test
    public void loadJob1(){
        Job job1 = jobRepository.findAll().get(0);
        assertEquals("jobTest1", job1.getName());
    }

}
