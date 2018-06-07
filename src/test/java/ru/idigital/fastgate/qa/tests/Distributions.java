package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.ibs.agent.OutboundChannel;
import ru.befree.ibs.core.Priority;
import ru.befree.ibs.distribution.DistributionState;
import ru.befree.ibs.distribution.SpeedPeriodEnum;
import ru.befree.ibs.msgproc.Template;
import ru.befree.qa.ibs.tools.util.datagen.DistributionFarm;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.befree.qa.ibs.tools.util.constants.Constants;

import java.text.ParseException;

public class Distributions extends BaseTestData {

    @Test(description = "Рассылки")
    public void insertDistributions() throws ParseException {
        Template template = getTemplateByName(Constants.TEST_DISTRIB_TEMPLATE);
        OutboundChannel outboundChannel = template.getOutboundChannel();
        String message = "{\"SMS\": {\"text\": \"\\u0422\\u0435\\u043a\\u0441\\u0442\", \"sender\": \"testSender\", \"content_type\": \"text\"}}";
        DistributionFarm.prepareDistribution(Constants.TEST_DISTRIB)
                .withTemplate(template).withOutboundChannel(outboundChannel).withPriority(Priority.MEDIUM)
                .withLimitSpeed(true).withMessagesReady(false).withSpeedPeroid(SpeedPeriodEnum.SEC)
                .withDeliveryProbability(0).withSendSpeed(1).withState(DistributionState.CREATED)
                .withOwnerId(1).withStartHour((byte) 0).withStopHour((byte) 24).withDeliveryDays(template.getDeliveryDays())
                .withType(0).withResendTimeout(60).withContentTypes("0").withMessage(message).make();
    }

    @Test(description = "Постоянные Рассылки")
    public void insertPermanentDistributions() throws ParseException {
        OutboundChannel outboundChannel = getOutboundChannelByName(Constants.DEFAULT_CHANNEL);
        String message = "{\"PUSH\": {\"text\": \"{text}\"}, \"VIBER\": {\"text\": \"{text}\"}, \"SMS\": {\"text\": \"{text}\"}, \"VK\": {\"text\": \"{text}\"}}";
        DistributionFarm.prepareDistribution(Constants.TEST_PERMANENT_DISTRIB)
                .withOutboundChannel(outboundChannel).withPriority(Priority.MEDIUM)
                .withLimitSpeed(true).withMessagesReady(false).withSpeedPeroid(SpeedPeriodEnum.MIN)
                .withDeliveryProbability(0).withSendSpeed(1000).withState(DistributionState.CREATED)
                .withOwnerId(1).withStartHour((byte) 0).withStopHour((byte) 24).withDeliveryDays(Byte.valueOf("127"))
                .withType(1).withContentTypes("0").withMessage(message).make();

        DistributionFarm.prepareDistribution(Constants.TEST_PERMANENT_DISTRIB_IN_PROCESS+1)
                .withOutboundChannel(outboundChannel).withPriority(Priority.MEDIUM)
                .withLimitSpeed(true).withMessagesReady(false).withSpeedPeroid(SpeedPeriodEnum.MIN)
                .withDeliveryProbability(0).withSendSpeed(1000).withState(DistributionState.INPROCESS)
                .withOwnerId(1).withStartHour((byte) 0).withStopHour((byte) 24).withDeliveryDays(Byte.valueOf("127"))
                .withType(1).withContentTypes("0").withMessage(message).make();

        DistributionFarm.prepareDistribution(Constants.TEST_PERMANENT_DISTRIB_IN_PROCESS+2)
                .withOutboundChannel(outboundChannel).withPriority(Priority.MEDIUM)
                .withLimitSpeed(true).withMessagesReady(false).withSpeedPeroid(SpeedPeriodEnum.MIN)
                .withDeliveryProbability(0).withSendSpeed(1000).withState(DistributionState.INPROCESS)
                .withOwnerId(1).withStartHour((byte) 0).withStopHour((byte) 24).withDeliveryDays(Byte.valueOf("127"))
                .withType(1).withContentTypes("0").withMessage(message).make();

        DistributionFarm.prepareDistribution(Constants.TEST_PERMANENT_DISTRIB_IN_PAUSE)
                .withOutboundChannel(outboundChannel).withPriority(Priority.MEDIUM)
                .withLimitSpeed(true).withMessagesReady(false).withSpeedPeroid(SpeedPeriodEnum.MIN)
                .withDeliveryProbability(0).withSendSpeed(1000).withState(DistributionState.PAUSED)
                .withOwnerId(1).withStartHour((byte) 0).withStopHour((byte) 24).withDeliveryDays(Byte.valueOf("127"))
                .withType(1).withContentTypes("0").withMessage(message).make();

    }


}
