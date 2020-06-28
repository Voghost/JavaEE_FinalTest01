/*
 Navicat Premium Data Transfer

 Source Server         : aliyunMySQL
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : voghost-server.mysql.rds.aliyuncs.com:3306
 Source Schema         : business_management

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 26/06/2020 23:49:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `DepartmentId` char(4) NOT NULL,
  `DepartmentName` varchar(40) DEFAULT NULL,
  `DepartmentAddress` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`DepartmentId`),
  CONSTRAINT `department_chk_1` CHECK (regexp_like(`DepartmentId`,_utf8mb4'D[0-9][0-9][0-9]'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for folder
-- ----------------------------
DROP TABLE IF EXISTS `folder`;
CREATE TABLE `folder` (
  `FolderId` char(9) NOT NULL,
  `FolderPath` varchar(30) DEFAULT NULL,
  `FolderRemark` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`FolderId`),
  CONSTRAINT `folder_chk_1` CHECK (regexp_like(`FolderId`,_utf8mb4'F[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `ProjectId` char(9) NOT NULL,
  `ProjectName` varchar(30) DEFAULT NULL,
  `ProjectPathId` char(9) DEFAULT NULL,
  `ProjectRemark` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ProjectId`),
  KEY `FK_Project_FileId` (`ProjectPathId`),
  CONSTRAINT `FK_Project_FileId` FOREIGN KEY (`ProjectPathId`) REFERENCES `folder` (`FolderId`),
  CONSTRAINT `project_chk_1` CHECK (regexp_like(`ProjectId`,_utf8mb3'P[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')),
  CONSTRAINT `project_chk_2` CHECK (regexp_like(`ProjectPathId`,_utf8mb3'F[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `StaffId` char(6) NOT NULL,
  `StaffName` varchar(40) DEFAULT NULL,
  `StaffPhone` varchar(15) DEFAULT NULL,
  `StafFileId` char(9) DEFAULT NULL,
  `StaffPassword` varchar(15) NOT NULL,
  PRIMARY KEY (`StaffId`),
  KEY `FK_Staff_FileId` (`StafFileId`),
  CONSTRAINT `FK_Staff_FileId` FOREIGN KEY (`StafFileId`) REFERENCES `folder` (`FolderId`),
  CONSTRAINT `staff_chk_1` CHECK (regexp_like(`StaffId`,_utf8mb3'S[0-9][0-9][0-9][0-9][0-9]')),
  CONSTRAINT `staff_chk_2` CHECK (regexp_like(`StafFileId`,_utf8mb3'F[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for staff_department
-- ----------------------------
DROP TABLE IF EXISTS `staff_department`;
CREATE TABLE `staff_department` (
  `StaffId` char(6) NOT NULL,
  `DepartmentId` char(4) NOT NULL,
  PRIMARY KEY (`StaffId`,`DepartmentId`),
  KEY `FK_SD_Department` (`DepartmentId`),
  CONSTRAINT `FK_SD_Department` FOREIGN KEY (`DepartmentId`) REFERENCES `department` (`DepartmentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_SD_StaffId` FOREIGN KEY (`StaffId`) REFERENCES `staff` (`StaffId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for staff_project
-- ----------------------------
DROP TABLE IF EXISTS `staff_project`;
CREATE TABLE `staff_project` (
  `StaffId` char(6) NOT NULL,
  `ProjectId` char(9) NOT NULL,
  `ProjectStatus` bit(1) DEFAULT NULL,
  PRIMARY KEY (`StaffId`,`ProjectId`),
  KEY `FK_SP_ProjectId` (`ProjectId`),
  CONSTRAINT `FK_SP_ProjectId` FOREIGN KEY (`ProjectId`) REFERENCES `project` (`ProjectId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_SP_StaffId` FOREIGN KEY (`StaffId`) REFERENCES `staff` (`StaffId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for staff_task
-- ----------------------------
DROP TABLE IF EXISTS `staff_task`;
CREATE TABLE `staff_task` (
  `StaffId` char(6) NOT NULL,
  `TaskId` char(9) NOT NULL,
  `TaskStatus` bit(1) DEFAULT NULL,
  PRIMARY KEY (`StaffId`,`TaskId`),
  KEY `FK_ST_TaskId` (`TaskId`),
  CONSTRAINT `FK_ST_StaffId` FOREIGN KEY (`StaffId`) REFERENCES `staff` (`StaffId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ST_TaskId` FOREIGN KEY (`TaskId`) REFERENCES `task` (`TaskId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `TaskId` char(9) NOT NULL,
  `TaskName` varchar(30) DEFAULT NULL,
  `TaskRemark` varchar(45) DEFAULT NULL,
  `TaskStartDate` date DEFAULT NULL,
  `TaskEndDate` date DEFAULT NULL,
  PRIMARY KEY (`TaskId`),
  CONSTRAINT `task_chk_1` CHECK (regexp_like(`TaskId`,_utf8mb4'T[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
