use db1;

create table `t_user_info` (
    `id` int unsigned not null auto_increment primary key comment 'uid',
    `open_id` varchar(64) not null default '' comment '三方id',
    `insert_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `upd_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    unique key `uniq_open_id` (`open_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4  COMMENT='用户登录表';

create table `t_account_info` (
    `id` int unsigned not null primary key comment 'uid',
    `account` varchar(64) not null default '' comment '账户',
    `password` varchar(64) not null default '' comment '密码',
    `insert_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `upd_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    unique key `uniq_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT='账号密码表';

create table `t_role_info` (
    `id` int unsigned not null auto_increment primary key comment 'id',
    `uid` int not null comment 'uid',
    `sec` varchar(64) not null comment '区服id',
    `role_name` varchar(64) not null default '' comment '角色名称',
    `insert_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `upd_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    key `idx_uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4  COMMENT='用户角色表';