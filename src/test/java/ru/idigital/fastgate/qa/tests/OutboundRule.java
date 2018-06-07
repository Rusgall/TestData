package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.ibs.core.ContentType;
import ru.befree.qa.ibs.tools.util.datagen.OutboundRulesFarm;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.befree.qa.ibs.tools.util.constants.Constants;

import java.util.Arrays;

public class OutboundRule extends BaseTestData {

    @Test(description = "Канал отправки")
    public void setOutboundRules() {
        OutboundRulesFarm.prepareOutboundRule(Constants.DEFAULT_OUTBOUND_RULE)
                .forConnection(getConnection(Constants.DEFAULT_CONNECTION))
                .withContentTypes(Arrays.asList(ContentType.SMS, ContentType.PUSH, ContentType.VIBER, ContentType.VK))
                .withPriority(10).make();

        OutboundRulesFarm.prepareOutboundRule(Constants.TEST_OUTBOUND_RULE)
                .forConnection(getConnection(Constants.TEST_CONNECTION))
                .withContentTypes(Arrays.asList(ContentType.SMS, ContentType.PUSH, ContentType.VIBER, ContentType.VK))
                .withPriority(1).make();
    }
}
