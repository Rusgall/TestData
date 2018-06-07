package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.qa.ibs.tools.util.datagen.ConnectionFarm;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.befree.qa.ibs.tools.util.constants.Constants;

public class Connection extends BaseTestData{

    @Test(description = "Подключение")
    public void setConnection() {
        ConnectionFarm.prepareConnection(Constants.DEFAULT_CONNECTION).withDefault(false).withDescription("Description").make();
        ConnectionFarm.prepareConnection(Constants.TEST_CONNECTION).withDefault(false).withDescription("Description").make();
    }
}
