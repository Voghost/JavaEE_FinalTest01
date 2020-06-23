CREATE TABLE Staff (
	`StaffId` CHAR ( 6 ) NOT NULL CHECK ( StaffId regexp 'S[0-9][0-9][0-9][0-9][0-9]' ),
	`StaffName` VARCHAR ( 40 ) NULL,
	`StaffPhone` VARCHAR ( 15 ) NULL,
	`StafFileId` CHAR ( 9 ) NULL CHECK ( StafFileId regexp 'F[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
	`StaffPassword` VARCHAR ( 15 ) NOT NULL,
	PRIMARY KEY ( `StaffId` )
);
CREATE TABLE DepartmentId (
	`DepartmentId` CHAR ( 4 ) NOT NULL CHECK ( DepartmentId regexp 'D[0-9][0-9][0-9]' ),
	`DepartmentName` VARCHAR ( 40 ) NULL,
	`DepartmentAddress` VARCHAR ( 40 ) NULL,
	PRIMARY KEY ( `DepartmentId` )
);
CREATE TABLE Folder (
	`FolderId` CHAR ( 9 ) NOT NULL CHECK ( FolderId regexp 'F[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
	`FolderPath` VARCHAR ( 30 ) NULL,
	`FolderRemark` VARCHAR ( 45 ) NULL,
	PRIMARY KEY ( `FolderId` )
);
CREATE TABLE Project (
	`ProjectId` CHAR ( 9 ) NOT NULL CHECK ( ProjectId regexp 'P[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])' ),
`ProjectName` VARCHAR ( 30 ) NULL,
`ProjectPathId` CHAR ( 9 ) NULL CHECK ( ProjectPathId regexp 'F[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
`ProjectRemark` VARCHAR ( 45 ) NULL,
PRIMARY KEY ( `ProjectId` )

);
CREATE TABLE task (
	`TaskId` CHAR ( 9 ) NOT NULL CHECK ( TaskId regexp 'T[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
	`TaskName` VARCHAR ( 30 ) NULL,
	`TaskRemark` VARCHAR ( 45 ) NULL,
	`TaskStartDate` DATE NULL,
	`TaskEndDate` DATE NULL,
	PRIMARY KEY ( `TaskId` )

);
CREATE TABLE Staff_Department (
	`StaffId` CHAR ( 6 ) NOT NULL,
	`DepartmentId` CHAR ( 4 ) NOT NULL,
	PRIMARY KEY ( `StaffId`, `DepartmentId` ),
	CONSTRAINT `FK_SD_StaffId` FOREIGN KEY ( `StaffId` ) REFERENCES `business_management`.`staff` ( `StaffId` ) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `FK_SD_Department` FOREIGN KEY ( `DepartmentId` ) REFERENCES `business_management`.`departmentid` ( `DepartmentId` ) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE Staff_Project (
	`StaffId` CHAR ( 6 ) NOT NULL,
	`ProjectId` CHAR ( 9 ) NOT NULL,
	`ProjectStatus` BIT NULL,
	PRIMARY KEY ( `StaffId`, `ProjectId` ),
	CONSTRAINT `FK_SP_StaffId` FOREIGN KEY ( `StaffId` ) REFERENCES `business_management`.`staff` ( `StaffId` ) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `FK_SP_ProjectId` FOREIGN KEY ( `ProjectId` ) REFERENCES `business_management`.`project` ( `ProjectId` ) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE Staff_Task (
	`StaffId` CHAR ( 6 ) NOT NULL,
	`TaskId` CHAR ( 9 ) NOT NULL,
	`TaskStatus` BIT,
	PRIMARY KEY ( `StaffId`, `TaskId` ),
	CONSTRAINT `FK_ST_StaffId` FOREIGN KEY ( `StaffId` ) REFERENCES `business_management`.`staff` ( `StaffId` ) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `FK_ST_TaskId` FOREIGN KEY ( `TaskId` ) REFERENCES `business_management`.`task` ( `TaskId` ) ON DELETE CASCADE ON UPDATE CASCADE
);-- 添加外键
ALTER TABLE `business_management`.`staff` ADD CONSTRAINT `FK_Staff_FileId` FOREIGN KEY ( `StafFileId` ) REFERENCES `business_management`.`folder` ( `FolderId` );
ALTER TABLE `business_management`.`project` ADD CONSTRAINT `FK_Project_FileId` FOREIGN KEY ( `ProjectPathId` ) REFERENCES `business_management`.`folder` ( `FolderId` );
