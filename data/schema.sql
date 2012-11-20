create table ledger_temp (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  rcv_dt date DEFAULT NULL,
  mbr_nm varchar(20) DEFAULT NULL,
  chk_nbr varchar(20) DEFAULT NULL,
  chk_dt date DEFAULT NULL,
  pymt_typ varchar(20) DEFAULT NULL,
  dpst_amt decimal(4,2) DEFAULT NULL,
  pymt_amt decimal(4,2) DEFAULT NULL,
  comments varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table ledger (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  rcv_dt date DEFAULT NULL,
  mbr_nm varchar(20) DEFAULT NULL,
  chk_nbr varchar(20) DEFAULT NULL,
  chk_dt date DEFAULT NULL,
  pymt_typ varchar(20) DEFAULT NULL,
  dpst_amt decimal(4,2) DEFAULT NULL,
  pymt_amt decimal(4,2) DEFAULT NULL,
  comments varchar(20) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;