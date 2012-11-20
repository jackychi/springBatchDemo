package org.rubik.demo.batch.writer;

import java.util.List;

import org.rubik.demo.dao.LedgerDao;
import org.rubik.demo.pojo.Ledger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ledger写入数据。
 * 
 */
@Component("ledgerWriter")
public class LedgerWriter implements ItemWriter<Ledger> {

	@Autowired
	private LedgerDao ledgerDao;

	/**
	 * 写入数据
	 * 
	 * @param ledgers
	 */
	public void write(List<? extends Ledger> ledgers) throws Exception {
		for (Ledger ledger : ledgers) {
			ledgerDao.save(ledger);
		}
	}

}