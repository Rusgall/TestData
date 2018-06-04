package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.qa.ibs.tools.util.datagen.ShortNumberFarm;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.idigital.fastgate.qa.data.constants.Constants;

public class SenderName extends BaseTestData {

    @Test(description = "Имя отправителя")
    public void setSender() {
        ShortNumberFarm.prepareInfoServiceNumber(Constants.DEFAULT_SENDER).withContentTypes("0,1,4,6").make();
        ShortNumberFarm.prepareInfoServiceNumber(Constants.TEST_SENDER).withContentTypes("0,1,4,6").make();
    }

}
