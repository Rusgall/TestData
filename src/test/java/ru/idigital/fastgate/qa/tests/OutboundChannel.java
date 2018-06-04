package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.qa.ibs.tools.util.datagen.OutboundChannelFarm;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.idigital.fastgate.qa.data.constants.Constants;

public class OutboundChannel extends BaseTestData {

    @Test(description = "Канал отправки")
    public void setOutboundChannel() {
        OutboundChannelFarm.prepareOutboundChannel(Constants.DEFAULT_CHANNEL).withStartHour((byte) 0).withStopHour((byte) 24).withSpamTtl(20L).make();
    }
}
