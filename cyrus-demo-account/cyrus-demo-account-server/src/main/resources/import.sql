

DROP TABLE IF EXISTS `T_ROLE`;

CREATE TABLE `T_ROLE` (
  `ROLEID` bigint(20) NOT NULL,
  `ROLENAME` varchar(128) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

/*Table structure for table `T_USER` */

DROP TABLE IF EXISTS `T_USER`;

CREATE TABLE `T_USER` (
  `USERID` bigint(20) NOT NULL,
  `NAME` varchar(127) DEFAULT NULL COMMENT '姓名',
  `PASSWORD` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Table structure for table `T_USER_role` */

DROP TABLE IF EXISTS `T_USER_ROLE`;

CREATE TABLE `T_USER_ROLE` (
  `USERROLEID` bigint(20) NOT NULL COMMENT '用户角色Id',
  `ROLEID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `USERID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`USERROLEID`),
  KEY `IDX_USERROLE_ROLE` (`ROLEID`),
  KEY `IDX_USERROLE_USER` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色映射表';

/*Table structure for table `DYNAMIC_RECORD` */

DROP TABLE IF EXISTS `T_DYNAMIC_RECORD`;

CREATE TABLE `T_DYNAMIC_RECORD` (
  `DRID` bigint(20) NOT NULL COMMENT '系统记录Id',
   `OPERATOR` varchar(127) DEFAULT NULL COMMENT '用户名',
  `DACTION` varchar(50) NOT NULL COMMENT '用户行为',
  `COMMENT` varchar(50) NOT NULL COMMENT '用户操作备注',
  `OPERATEDTIME` varchar(50) NOT NULL COMMENT '用户操作时间',
  PRIMARY KEY (`DRID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统记录表';

