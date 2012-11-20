package org.rubik.demo;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 程序入口，启动定时调度。
 * 
 * 该示例演示：
 *   定时将数据从临时表ledger_temp迁移到正式表ledger，
 *   定时调度时间可以通过修改applicationContext-batch.xml中的ledgerCronTrigger的cronExpression属性。
 * 
 * 测试数据在csv中，可以通过readme.txt来导入到mysql中，建表脚本在schema.sql文件中。
 * 数据库及连接使用的用户名密码请修改applicationContext.xml中的dataSource配置。
 * 
 * TODO: 在我机器上跑20w数据的迁移用时65s，机器比较烂。。。
 *       可以采用多线程来提升性能或者对于超大数据量处理采用hadoop。
 * 
 */
public class RunApp {

	public static void main(String[] args) throws FileNotFoundException {
		new ClassPathXmlApplicationContext("applicationContext-batch.xml");
	}
}
