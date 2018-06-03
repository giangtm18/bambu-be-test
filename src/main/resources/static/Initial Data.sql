USE user_profiling_system;

INSERT INTO `question` (`question_type_id`, `content`) 
VALUES 		(1	,'Content of savings amount'), 
			(2	,'Content of loan amount');
			
INSERT INTO `answer` (`question_id`, `content`, `score`) 
VALUES 		(1	,'2000' ,	1), 
			(1	,'4000'	,	2), 
			(1	,'6000'	,	3), 
			(1	,'8000'	,	4),
            (1	,'10000',	5),
            (2	,'2000'	,	5), 
			(2	,'4000'	,	4), 
			(2	,'6000'	,	3), 
			(2	,'8000'	,	2),
            (2	,'10000',	1);
            