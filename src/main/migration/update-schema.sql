ALTER TABLE student
DROP
FOREIGN KEY student_teacher_id_fk;

CREATE TABLE teacher_student
(
    id         INT AUTO_INCREMENT NOT NULL,
    student_id INT NULL,
    teacher_id INT NULL,
    CONSTRAINT pk_teacher_student PRIMARY KEY (id)
);

ALTER TABLE teacher_student
    ADD CONSTRAINT FK_TEACHER_STUDENT_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student (id);

ALTER TABLE teacher_student
    ADD CONSTRAINT FK_TEACHER_STUDENT_ON_TEACHER FOREIGN KEY (teacher_id) REFERENCES teacher (id);

ALTER TABLE student
DROP
COLUMN teacher_id;

ALTER TABLE student
    MODIFY age INT NULL;

ALTER TABLE teacher
    MODIFY age INT NULL;

ALTER TABLE teacher
    MODIFY name VARCHAR (255);

ALTER TABLE teacher
    MODIFY name VARCHAR (255) NULL;

ALTER TABLE university
    MODIFY name VARCHAR (255);

ALTER TABLE university
    MODIFY name VARCHAR (255) NULL;

ALTER TABLE student
    MODIFY stependiya DECIMAL;

ALTER TABLE teacher
    MODIFY surname VARCHAR (255);

ALTER TABLE teacher
    MODIFY surname VARCHAR (255) NULL;
ALTER TABLE student
    DROP FOREIGN KEY student_teacher_id_fk;

CREATE TABLE teacher_student
(
    id         INT AUTO_INCREMENT NOT NULL,
    student_id INT                NULL,
    teacher_id INT                NULL,
    CONSTRAINT pk_teacher_student PRIMARY KEY (id)
);

ALTER TABLE teacher_student
    ADD CONSTRAINT FK_TEACHER_STUDENT_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student (id);

ALTER TABLE teacher_student
    ADD CONSTRAINT FK_TEACHER_STUDENT_ON_TEACHER FOREIGN KEY (teacher_id) REFERENCES teacher (id);

ALTER TABLE student
    DROP COLUMN teacher_id;

ALTER TABLE student
    MODIFY age INT NULL;

ALTER TABLE teacher
    MODIFY age INT NULL;

ALTER TABLE teacher
    MODIFY name VARCHAR(255);

ALTER TABLE teacher
    MODIFY name VARCHAR(255) NULL;

ALTER TABLE university
    MODIFY name VARCHAR(255);

ALTER TABLE university
    MODIFY name VARCHAR(255) NULL;

ALTER TABLE student
    MODIFY stependiya DECIMAL;

ALTER TABLE teacher
    MODIFY surname VARCHAR(255);

ALTER TABLE teacher
    MODIFY surname VARCHAR(255) NULL;