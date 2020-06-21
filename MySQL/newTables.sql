CREATE TABLE Staff (
	`StaffId` CHAR ( 6 ) NOT NULL CHECK ( StaffId LIKE '[A-Z][A-Z][0-9][0-9][0-9][0-9]' ),
	`StaffName` VARCHAR ( 40 ) NULL,
	`StaffPhone` VARCHAR ( 15 ) NULL,
	`StafFileId` CHAR ( 10 ) NULL CHECK ( StafFileId LIKE '[A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
	`StaffPassword` VARCHAR ( 15 ) NOT NULL,
	PRIMARY KEY ( `StaffId` )
);
CREATE TABLE DepartmentId (
	`DepartmentId` CHAR ( 3 ) NOT NULL CHECK ( DepartmentId LIKE '[0-9][0-9][0-9]' ),
	`DepartmentName` VARCHAR ( 40 ) NULL,
	`DepartmentAddress` VARCHAR ( 40 ) NULL,
	PRIMARY KEY ( `DepartmentId` )
);
CREATE TABLE Folder (
	`FolderId` CHAR ( 10 ) NOT NULL CHECK ( FolderId LIKE '[A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
	`FolderPath` VARCHAR ( 30 ) NULL,
	`FolderRemark` VARCHAR ( 45 ) NULL,
	PRIMARY KEY ( `FolderId` )
);
CREATE TABLE Project (
	`ProjectId` CHAR ( 10 ) NOT NULL CHECK (ProjectId LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])'),
`ProjectName` VARCHAR ( 30 ) NULL,
`ProjectPathId` CHAR ( 10 ) NULL CHECK ( ProjectPathId LIKE '[A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
`ProjectRemark` VARCHAR ( 45 ) NULL,
PRIMARY KEY ( `ProjectId` )
	);
	CREATE TABLE task (
		`TaskId` CHAR ( 10 ) NOT NULL CHECK ( TaskId LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
		`TaskName` VARCHAR ( 30 ) NULL,
		`TaskRemark` VARCHAR ( 45 ) NULL,
		`TaskStartDate` DATE NULL,
		`TaskEndDate` DATE NULL,
		PRIMARY KEY ( `TaskId` )
	);

	CREATE TABLE Staff_Department(
		`StaffId` char(6) NOT NULL,
		`DepartmentId` char(10) NOT NULL,
		PRIMARY KEY (`StaffId`, `DepartmentId`),
		CONSTRAINT `FK_SD_StaffId` FOREIGN KEY (`StaffId`) REFERENCES `business_management`.`staff` (`StaffId`) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT `FK_SD_Department` FOREIGN KEY (`DepartmentId`) REFERENCES `business_management`.`departmentid` (`DepartmentId`) ON DELETE CASCADE ON UPDATE CASCADE
	);

	CREATE TABLE Staff_Project (
		`StaffId` char(6) NOT NULL,
		`ProjectId` char(10) NOT NULL,
		`ProjectStatus` BIT NULL,
		PRIMARY KEY (`StaffId`, `ProjectId`),
		CONSTRAINT `FK_SP_StaffId` FOREIGN KEY (`StaffId`) REFERENCES `business_management`.`staff` (`StaffId`) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT `FK_SP_ProjectId` FOREIGN KEY (`ProjectId`) REFERENCES `business_management`.`project` (`ProjectId`) ON DELETE CASCADE ON UPDATE CASCADE
	);

	CREATE TABLE Staff_Task (
		`StaffId` char(6) NOT NULL,
		`TaskId` char(10) NOT NULL,
		`TaskStatus` BIT,
		PRIMARY KEY (`StaffId`, `TaskId`),
		CONSTRAINT `FK_ST_StaffId` FOREIGN KEY (`StaffId`) REFERENCES `business_management`.`staff` (`StaffId`) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT `FK_ST_TaskId` FOREIGN KEY (`TaskId`) REFERENCES `business_management`.`task` (`TaskId`) ON DELETE CASCADE ON UPDATE CASCADE
	);

