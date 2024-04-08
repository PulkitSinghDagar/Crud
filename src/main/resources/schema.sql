CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `age` varchar(100) NOT NULL,
  `sex` varchar(20) NOT NULL,
  `kyc_status` varchar(100) NOT NULL,
  `created_at` date ,
  `created_by` varchar(20) ,
  `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);