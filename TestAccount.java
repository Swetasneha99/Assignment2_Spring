package com.lti.ex11;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {
	@Test
	void testValidDeposit() throws AmountException {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		AccountBalance a = appCtx.getBean("account", AccountBalance.class);
		a.deposit(2000);
	}

	@Test
	void testInvalidDeposit() throws AmountException {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		AccountBalance a = appCtx.getBean("account", AccountBalance.class);
		a.deposit(-1000);
	}

	@Test
	void testValidWithdraw() throws AmountException, BalanceException {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		AccountBalance a = appCtx.getBean("account", AccountBalance.class);
		a.setBalance(50000);
		a.withdraw(20000);
	}

	@Test
	void testInvalidWithdraw() throws AmountException, BalanceException {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		AccountBalance a = appCtx.getBean("account", AccountBalance.class);
		a.setBalance(60000);
		a.withdraw(-20000);
	}

	@Test
	void testInsufficientWithdraw() throws AmountException, BalanceException {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		AccountBalance a = appCtx.getBean("account", AccountBalance.class);
		a.setBalance(10000);
		a.withdraw(20000);
	}
}