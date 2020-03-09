package homework.suites;

import homework.tests.AccountTest;
import homework.tests.SearchTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SearchTest.class,
        AccountTest.class
})
public class AccountAndSearchTestSuite {

}
