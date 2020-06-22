# javaEE基础  最终实验（实验5)
## 说明:
* 这个一个设计公司的人员管理、项目管理的系统
## 1. 需求分析

###	1.1 基本需求分析　
#### 1.1.1 基本要求
1. 拥有**行政部门**，不同地区的**工作室**，以及一个工作室的多个**部门**,部门使用的**软件**
2. 行政部门管理不同的地区的工作室
3. 工作室分布在不同的地区
4. 一个工作室下有多个的部门
5. 不同的部门使用不同类的软件
6. 工作室下面拥有多个的项目
7. 部门下面有员工，员工可以上传文件到服务器
8. 每个员工拥有自己单独的文件夹，和共享的项目文件夹,以及拥有自己的工作任务
9. 客户可以查看某些成果文件

#### 1.1.2 分以下三大人员,以及所具有的功能(权限)
1. **行政部门人员**
	* 可以对员工的基本信息进行**增删改查**
	* 可以对员工**分配任务**
	* 可以对不同地区的部门进行增删改

2. **员工**
	* 可以查看自己的**任务**
	* 可以查看服务器上自己的文件夹，并且可以提交自己的文件
	* 可以将自己做好的文件传入服务器上的共享文件夹(所拥有的项目)，并且查看共享文件夹

3. <s>**客户** <b>(暂不考虑客户)</b>
	* 客户可以查看工作的成果</s>

### 1.2 基本数据库
#### 1.2.1 员工表
* 员工的编号 char(6) [A-Z][A-Z][0-9][0-9][0-9][0-9]
* 员工的姓名 varchar(15)
* 员工的电话 varchar(11) [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]
* 员工所属部门编号 varchar(3) [0-9][0-9][0-9]
* 员工私人文件夹的编号 varchar(10) [A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9]

#### 1.2.2 部门表
* 部门编号 char(3) [0-9][0-9][0-9]
* 部门的名字 varchar(30)
* 部门所属的城市 varchar(30)

#### 1.2.3 项目表
* 项目编号 char(8) [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]
* 项目名字 varchar(30)
* 项目描述 varchar(45)
* 项目文件夹的编号 varchar(10) [A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9]
* 项目状态 BIT

#### 1.2.4 文件路径表
* 文件夹的编号 char(10) [A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9]
* 文件夹的名称 varchar(10)
* 文件夹的路径 varchar(30)

#### 1.2.5 任务表
* 任务序号 char() [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]
* 任务名字 varchar(30)
* 具体任务描述 varchar(45)
* 任务开始时间 DATE
* 任务结束时间 DATE
* 任务状态 BIT


#### 1.2.6 员工-部门表

#### 1.2.7 软件-部门表

#### 1.2.8 员工-项目表

#### 1.2.9 员工-任务表



#### 这几个实体之间的关系
* 员工可以属于多个部门
* 员工可以同时完成有多个项目
* 员工可以有多个任务，一个任务也可以对应多个员工
* 一个项目对应一个共享文件夹
* 一个员工对应一个共享文件夹

#### 具体表的语句
##### (1) 员工表 (Staff)
```sql
CREATE TABLE Staff  (
		`StaffId` char(6) NOT NULL CHECK(StaffId LIKE 'S[0-9][0-9][0-9][0-9][0-9]'),
		`StaffName` varchar(40) NULL ,
		`StaffPhone` varchar(15) NULL,
		`StafFileId` char(9) NULL CHECK(StafFileId LIKE 'F[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
		`StaffPassword` varchar(15) NOT NULL ,
		PRIMARY KEY (`StaffId`)
		);
```
|      列名     |     类型    | 是否主键 | 是否外键 |       备注       |
|:-------------:|:-----------:|:--------:|:--------:|:----------------:|
|    StaffId    |   char(6)   |    是    |    否    |      员工id      |
|   StaffName   | varchar(40) |    否    |    否    |      员工名      |
|   StaffPhone  | varchar(15) |    否    |    否    |     员工电话     |
|   StafFileId  | varchar(10) |    否    |    是    | 员工所属文件编号 |
| StaffPassword | varchar(15) |    否    |    否    |     员工密码     |

##### (2) 部门表(Department)
```sql
CREATE TABLE DepartmentId  (
`DepartmentId` char(4) NOT NULL CHECK(DepartmentId LIKE 'D[0-9][0-9][0-9]'),
  `DepartmentName` varchar(40) NULL,
  `DepartmentAddress` varchar(40) NULL,
  PRIMARY KEY (`DepartmentId`)
)
```

|        列名       |     类型    | 是否主键 | 是否外键 |   备注   |
|:-----------------:|:-----------:|:--------:|:--------:|:--------:|
|    DepartmentId   |   char(4)   |    是    |    否    | 部门编号 |
|   DepartmentName  | varchar(40) |    否    |    否    | 部门名称 |
| DepartmentAddress | varchar(40) |    否    |    否    | 部门地址 |



##### (3) 目录表(Folder)
```sql
CREATE TABLE Folder  (
  `FolderId` char(9) NOT NULL CHECK(FolderId LIKE 'F[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
  `FolderPath` varchar(30) NULL,
  `FolderRemark` varchar(45) NULL,
  PRIMARY KEY (`FolderId`)
)
```

|     列名     |     类型    | 是否主键 | 是否外键 |   备注   |
|:------------:|:-----------:|:--------:|:--------:|:--------:|
|   FolderId   |   char(9)  |    是    |    否    | 目录编号 |
|  FolderPath  | varchar(30) |    否    |    否    | 目录路径 |
| FolderRemark | varchar(45) |    否    |    否    | 目录备注 |

##### (4) 项目表 (Project)
```sql
CREATE TABLE Project  (
  `ProjectId` char(9) NOT NULL CHECK(ProjectId LIKE 'P[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])'),
  `ProjectName` varchar(30) NULL,
  `ProjectPathId` char(9) NULL CHECK(ProjectPathId LIKE 'F[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' ),
  `ProjectRemark` varchar(45) NULL,
  PRIMARY KEY (`ProjectId`)
)
```

|      列名     |     类型    | 是否主键 | 是否外键 |        备注        |
|:-------------:|:-----------:|:--------:|:--------:|:------------------:|
|   ProjectId   |   char(9)  |    是    |    否    |      项目编号      |
|  ProjectName  | varchar(30) |    否    |    否    |       项目名       |
| ProjectPathId | varchar(30) |    否    |    是    |      项目路径      |
| ProjectRemark | varchar(45) |    否    |    否    |      项目备注      |
| ProjectStatus |     BIT     |    否    |    否    | 项目状态(是否完结) |


##### (5) 任务表(Task)
```sql
CREATE TABLE task(
`TaskId` char(9) NOT NULL CHECK(TaskId LIKE 'T[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
  `TaskName` varchar(30) NULL,
  `TaskRemark` varchar(45) NULL,
  `TaskStartDate` DATE NULL,
  `TaskEndDate` DATE NULL,
  PRIMARY KEY (`TaskId`)
);
```
|      列名     |     类型    | 是否主键 | 是否外键 |        备注        |
|:-------------:|:-----------:|:--------:|:--------:|:------------------:|
|     TaskId    |   char(9)  |    是    |    否    |       任务ID       |
|    TaskName   | varchar(30) |    否    |    否    |       任务名       |
|   TaskRemark  | varchar(45) |    否    |    否    |      任务描述      |
| TaskStartDate |     DATE    |    否    |    否    |      开始时间      |
|  TaskEndDate  |     DATE    |    否    |    否    |      结束时间      |


##### (6) 员工-部门表 (Staff_Department)
```sql
CREATE TABLE Staff_Department(
  `StaffId` char(6) NOT NULL,
  `DepartmentId` char(4) NOT NULL,
  PRIMARY KEY (`StaffId`, `DepartmentId`),
  CONSTRAINT `FK_SD_StaffId` FOREIGN KEY (`StaffId`) REFERENCES `business_management`.`staff` (`StaffId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_SD_Department` FOREIGN KEY (`DepartmentId`) REFERENCES `business_management`.`departmentid` (`DepartmentId`) ON DELETE CASCADE ON UPDATE CASCADE
);
```
|     列名     |   类型   | 是否主键 | 是否外键 |   备注   |
|:------------:|:--------:|:--------:|:--------:|:--------:|
|    StaffId   |  char(6) |    是    |    是    | 员工编号 |
| DepartmentId | char(10) |    是    |    是    | 部门编号 |

##### (7) 员工-项目表 (Staff_Project)
```sql
CREATE TABLE Staff_Project (
  `StaffId` char(6) NOT NULL,
  `ProjectId` char(11) NOT NULL,
  `ProjectStatus` BIT NULL,
  PRIMARY KEY (`StaffId`, `ProjectId`),
  CONSTRAINT `FK_SP_StaffId` FOREIGN KEY (`StaffId`) REFERENCES `business_management`.`staff` (`StaffId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_SP_ProjectId` FOREIGN KEY (`ProjectId`) REFERENCES `business_management`.`project` (`ProjectId`) ON DELETE CASCADE ON UPDATE CASCADE
);
```

|      列名     |   类型   | 是否主键 | 是否外键 |        备注        |
|:-------------:|:--------:|:--------:|:--------:|:------------------:|
|    StaffId    |  char(6) |    是    |    是    |      员工编号      |
|   ProjectId   | char(9) |    是    |    是    |      部门编号      |
| ProjectStatus |    BIT   |    否    |    否    | 项目状态(是否完结) |


##### (8) 员工-任务表 (Staff_Task)
```sql
CREATE TABLE Staff_Task (
  `StaffId` char(6) NOT NULL,
  `TaskId` char(9) NOT NULL,
  `TaskStatus` BIT,
  PRIMARY KEY (`StaffId`, `TaskId`),
  CONSTRAINT `FK_ST_StaffId` FOREIGN KEY (`StaffId`) REFERENCES `business_management`.`staff` (`StaffId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ST_TaskId` FOREIGN KEY (`TaskId`) REFERENCES `business_management`.`task` (`TaskId`) ON DELETE CASCADE ON UPDATE CASCADE
);

```
|    列名    |   类型   | 是否主键 | 是否外键 |        备注        |
|:----------:|:--------:|:--------:|:--------:|:------------------:|
|   StaffId  |  char(6) |    是    |    是    |      员工编号      |
|   TaskId   | char(9) |    是    |    是    |      部门编号      |
| TaskStatus |    BIT   |    否    |    否    | 任务状态(是否完结) |

### 1.3 数据库功能设计 （数据库功能类 DatabaseProcess）
#### 1.3.1 插入员工（insertStaff）
```java
public int insertStaff(StaffInfo staffInfo);
```
#### 1.3.2 修改员工数据（updateStaff）
```java
public int updateStaff(StaffInfo staffInfo);
```

#### 1.3.3 删除员工数据(deleteStaff)
```java
public int deleteStaff();
```

#### 1.3.4 查找员工(searchStaff)
```java
public StaffInfo[] searchStaff(String key,int paramNo); 
```
#### 1.3.5 给员工分配任务(assigningTask)
```java
public int assigningTask(String staffId,TaskInfo taskId);
```

#### 1.3.6 增加部门(insertDepartment)
```java
public int insertDepartment(DepartmentInfo departmentInfo);
```

#### 1.3.7 删除部门(deleteDepartment)
```java
public int deleteDepartment(String departmentId);
```

#### 1.3.8 修改部门信息(updateDepartment)
```java
public int updateDepartment(DepartmentInfo departmentInfo);
```

#### 1.3.9 分配部门(assignDepartment)
```java
public int assignDepartment(String staffId,String departmentId);
```

#### 1.3.10 创建项目(insertProject)
```java
public int insertProject(ProjectInfo projectInfo);
```

#### 1.3.11 修改项目(updateProject)
```java
public int updateProject(ProjectInfo projectInfo);
```

#### 1.3.12 删除项目(deleteProject)
```java
public int deleteProject(String projectId);
```

#### 1.3.13 分配项目(assignProject)
```java
public int assignProject(String projectId);
```

#### 1.3.14 新建任务(insertTask)
```java
public int insertTask(TaskInfo taskInfo);
```

#### 1.3.15 修改任务(updateTask)
```java
public int updateTask(TaskInfo taskInfo);
```

#### 1.3.16 删除任务(deleteTask)
```java
public int deleteTask(String taskId);
```

#### 1.3.17 员工查看任务(searchTask)
```java
public int searchTask(String staffId);
```

#### 1.3.18 新建文件目录(insertFolder)
```java
public int insertFolder(FolderInfo folderInfo);
```

#### 1.3.19 修改文件目录(updateFolder)
```java
public int updateFolder(FolderInfo folderInfo);
```

#### 1.3.20 删除文件目录(deleteFolder)
```java
public int deleteFolder(String folderId);
```

#### 1.3.21 给项目分配文件目录(assignFolderForProject)
```java
public int assignFolderForProject(String folderId,String projectId);
```

#### 1.3.22 给员工分配文件目录(assignFolderForStaff)
```java
public int assignFolderForStaff(String folder,String staffId);
```
