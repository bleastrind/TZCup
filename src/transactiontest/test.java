package transactiontest;

import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

public class test {

	NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
	TransactionProxyFactoryBean bean = new TransactionProxyFactoryBean();
	{
		//bean.setTransactionAttributes()
	}
}

