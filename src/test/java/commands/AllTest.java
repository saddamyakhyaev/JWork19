package commands;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CommandTest.class, CloseCommandTest.class, DemandCommandTest.class, NewProductCommandTest.class, PurchaseCommandTest.class, SalesReportCommandTest.class})
public class AllTest {
}
