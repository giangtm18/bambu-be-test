-- =============================================
-- Create database template MySql
-- =============================================
DROP DATABASE IF EXISTS user_profiling_system;
CREATE DATABASE IF NOT EXISTS user_profiling_system;
USE user_profiling_system;

-- Create table Users
CREATE TABLE IF NOT EXISTS `users` (
   `email` 					VARCHAR(50) PRIMARY KEY,
   `profile` 				VARCHAR(1) NOT NULL CHECK ('A' OR 'B' OR 'C' OR 'D')
);

-- Create table QuestionType
CREATE TABLE IF NOT EXISTS `question_type` (
   `id` 					INT AUTO_INCREMENT PRIMARY KEY,
   `type` 					VARCHAR(50) NOT NULL UNIQUE
);

-- Create table Question
CREATE TABLE IF NOT EXISTS `question` (
   `id` 					INT AUTO_INCREMENT PRIMARY KEY,
   `question_type_id` 		INT NOT NULL, FOREIGN KEY (question_type_id) REFERENCES question_type(id),
   `content` 				NVARCHAR(255) NOT NULL
);

-- Create table Answer
CREATE TABLE IF NOT EXISTS `answer` (
   `id` 					INT AUTO_INCREMENT PRIMARY KEY,
   `content` 				VARCHAR(255) NOT NULL,
   `question_id` 			INT NOT NULL, FOREIGN KEY (question_id) REFERENCES question(id),
   `score`					TINYINT NOT NULL 	 
);

-- import data
INSERT INTO `question_type` (`type`) 
VALUES 		('savings amount'),
			('loan amount');