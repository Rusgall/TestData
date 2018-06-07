package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.qa.ibs.tools.util.datagen.InboundChannelsFarm;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.befree.qa.ibs.tools.util.constants.Constants;

public class InboundChannel extends BaseTestData {

    @Test(description = "Канал получения")
    public void setInboundChannel() {
        InboundChannelsFarm.prepareInboundChannel(Constants.DEFAULT_INBOUND_CHANNEL)
                .withDefault(true).withDescription("Description").make();
        InboundChannelsFarm.prepareInboundChannel(Constants.TEST_INBOUND_CHANNEL)
                .withDefault(false).withDescription("Description").make();
        InboundChannelsFarm.prepareInboundChannel(Constants.TEST_INBOUND_CHANNEL_DELETE)
                .withDefault(false).withDescription("Description").make();
    }
}
