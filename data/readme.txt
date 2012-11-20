
>> 导入CSV数据到指定表中：

load data local infile '/Users/chjq/springsource/sts-3.1.0.RELEASE/workspace/springBatchDemo/data/ledger.csv' into table ledger_temp fields terminated by ',' lines terminated by '\n'  (@adate, mbr_nm, chk_nbr, @bdate, pymt_typ, dpst_amt, pymt_amt, comments) SET rcv_dt = IF(LENGTH(@adate)=8,STR_TO_DATE(@adate,'%m/%d/%y'),STR_TO_DATE(@adate,'%m/%d/%Y')), chk_dt = IF(LENGTH(@bdate)=8,STR_TO_DATE(@bdate,'%m/%d/%y'),STR_TO_DATE(@bdate,'%m/%d/%Y'));