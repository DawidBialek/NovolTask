DROP TABLE IF EXISTS JOB;

CREATE TABLE JOB (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO JOB VALUES (1, 'job1');
INSERT INTO JOB VALUES (2, 'job2');
INSERT INTO JOB VALUES (3, 'job3');