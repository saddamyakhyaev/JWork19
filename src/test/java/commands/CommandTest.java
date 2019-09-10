package commands;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class CommandTest {


    String date;
    String setting;

    boolean expectedDate;
    int expectedSetting;

    public CommandTest(String date, String setting, boolean expectedDate, int expectedSetting) {
        this.date = date;
        this.setting = setting;
        this.expectedDate = expectedDate;
        this.expectedSetting = expectedSetting;
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {"31.02.2018", "PURCHASE iphone 1 1000 01.01.2017",false,4},
                {"28.02.2018", "PURCHASE iphone 1 ", true, 2}
        });
    }



    @Test
    public void idDateValid() {
        System.out.println("Test: Command idDateValid()");
        Command cm = new CloseCommand(setting);
        boolean result = cm.idDateValid(date);
        assertEquals(expectedDate, result);
    }


    @Test
    public void getCountSetting() {
        System.out.println("Test: Command getCountSetting()");
        Command cm = new CloseCommand(setting);
        int result = cm.getCountSetting();
        assertEquals(expectedSetting, result);
    }
}