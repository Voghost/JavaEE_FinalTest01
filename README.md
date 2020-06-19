# javaEE础  最终实验（实验5)
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
* 员工的编号 varchar(6) [A-Z][A-Z][0-9][0-9][0-9][0-9]
* 员工的姓名 varchar(15)
* 员工的电话 varchar(11) [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]
* 员工所属部门编号 varchar(3) [0-9][0-9][0-9]
* 员工的私人文件夹编号 varchar(40)

#### 1.2.2 部门表
* 部门编号 varchar(3) [0-9][0-9][0-9]
* 部门的名字 varchar(30)
* 部门所属的城市 varchar(30)

#### 1.2.3 项目表
* 项目编号 varchar(8) [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]
* 项目名字 varchar(15)
* 项目的文件夹编号 varchar(10) [A-Z][A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9]

#### 1.2.4 文件路径表
* 文件夹的编号 varchar(10) [A-Z][A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9]
* 文件夹的名称 varchar(10)
* 文件夹的路径 varchar(30)

#### 1.2.5 任务表
* 任务序号 varchar() [][][][][]
* 具体任务描述
* 任务待完成日期

#### 1.2.6 员工-部门表

#### 1.2.7 软件-部门表

#### 1.2.8 员工-项目表

#### 1.2.9 员工-任务表



#### 这几个实体之间的关系
* 员工可以属于多个部门
* 员工可以同时完成有多个项目
* 员工可以有多个任务，一个任务也可以对应多个员工
* 一个部门可以使用多个软件
* 一个项目对应一个共享文件夹
* 一个员工对应一个共享文件夹

