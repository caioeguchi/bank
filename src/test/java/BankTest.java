import org.junit.Test;

import com.caionilson.core.tema16.Bank;
import com.caionilson.core.tema16.command.Deposit;
import com.caionilson.core.tema16.command.Withdraw;

import junit.framework.Assert;

public class BankTest {

	Bank bank = new Bank();

	@Test
	public void depositIsWorking() {
		Deposit deposit = new Deposit(bank, 10);
		deposit.execute();

		Assert.assertTrue(10 == deposit.getValue());
	}

	@Test
	public void withdrawIsWorking() {
		Withdraw withdraw = new Withdraw(bank, 10);
		withdraw.execute();

		Assert.assertTrue(10 == withdraw.getValue());
	}

	@Test
	public void balanceIsWorking() {
		Deposit deposit = new Deposit(bank, 10);
		Withdraw withdraw = new Withdraw(bank, 2);
		deposit.execute();
		withdraw.execute();

		Assert.assertTrue(8 == bank.balance());
	}
}
