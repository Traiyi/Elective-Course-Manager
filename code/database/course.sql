CREATE TABLE `admin` (
`id` integer NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
`username` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '管理员账户',
`password` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '管理员密码',
PRIMARY KEY (`id`) 
);
CREATE TABLE `student` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '学生编号',
`student_number` varchar(20) NOT NULL DEFAULT '1601010101' COMMENT '学号',
`username` varchar(20) NOT NULL DEFAULT 'username' COMMENT '用户名',
`password` varchar(20) NOT NULL DEFAULT 'password' COMMENT '密码',
`name` varchar(30) NOT NULL DEFAULT '姓名' COMMENT '姓名',
`grade_id` int NOT NULL DEFAULT 1 COMMENT '年级编号',
`specialty_id` int NOT NULL DEFAULT 1 COMMENT '专业编号',
PRIMARY KEY (`id`, `student_number`) 
);
CREATE TABLE `elective_course` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '选修课编号',
`name` varchar(30) NOT NULL DEFAULT '选修课名字' COMMENT '选修课名字',
`grade_id` int NOT NULL DEFAULT 1 COMMENT '年级编号',
`specislty_id` int NOT NULL DEFAULT 1 COMMENT '专业编号',
`credit` double NOT NULL DEFAULT 2.0 COMMENT '学分',
`student_quantity` int NOT NULL DEFAULT 30 COMMENT '学生数量',
PRIMARY KEY (`id`) 
);
CREATE TABLE `grade` (
`id` integer NOT NULL AUTO_INCREMENT COMMENT '年级编号',
`name` varchar(30) NULL DEFAULT '年级名' COMMENT '年级名',
PRIMARY KEY (`id`) 
);
CREATE TABLE `specialty` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) NOT NULL DEFAULT '专业名1' COMMENT '专业名',
`grade_id` int NOT NULL DEFAULT 1 COMMENT '年级编号',
PRIMARY KEY (`id`) 
);
CREATE TABLE `elective` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选修编号',
`student_id` int NOT NULL DEFAULT 1 COMMENT '学生编号',
`course_id` int NOT NULL DEFAULT 1 COMMENT '选修课编号',
`student_credit` double NOT NULL DEFAULT 2.0 COMMENT '学生所取得的学分',
PRIMARY KEY (`id`) 
);
CREATE TABLE `question_answer` (
`id` int NULL COMMENT '问题编号',
`student_id` int NULL COMMENT '学生编号',
`admin_id` int NULL COMMENT '管理员编号',
`question` varchar(255) NULL COMMENT '问题',
`answer` varchar(255) NULL COMMENT '回答'
);
