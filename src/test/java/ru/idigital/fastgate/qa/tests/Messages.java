package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.ibs.core.Priority;
import ru.befree.ibs.msglog.report.MsgStateReport;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.idigital.fastgate.qa.data.constants.Constants;

import java.util.Date;
import java.util.UUID;

public class Messages extends BaseTestData{

    @Test(description = "Сообщения: Статусы доставки")
    public void generateMessagesByStatus() {

        for (int i = 0; i < 3; i++) {
            MsgStateReport report = new MsgStateReport(
                    false, UUID.randomUUID(), Constants.DEFAULT_PHONE_NUMBER, Constants.DEFAULT_SENDER,
                    new Date(), 80, new Date(), new Date(), null, null, null,
                    3, Constants.DEFAULT_CHANNEL, "Сгенерированное сообщение", "eID", null, Priority.HIGH, null,
                    null, 1, null, "44", "UNKNOWN", "UNKNOWN"
            );
            updatemsgReportState(report);
        }

        for (int i = 0; i < 3; i++) {
            MsgStateReport report = new MsgStateReport(
                    false, UUID.randomUUID(), Constants.DEFAULT_PHONE_NUMBER, Constants.DEFAULT_SENDER,
                    new Date(), 81, new Date(), new Date(), null, null, null,
                    3, Constants.DEFAULT_CHANNEL, "Сгенерированное сообщение", "eID", null, Priority.HIGH, null,
                    null, 1, null, "44", "UNKNOWN", "UNKNOWN"
            );
            updatemsgReportState(report);
        }

        for (int i = 0; i < 3; i++) {
            MsgStateReport report = new MsgStateReport(
                    false, UUID.randomUUID(), Constants.DEFAULT_PHONE_NUMBER, Constants.DEFAULT_SENDER,
                    new Date(), 90, new Date(), new Date(), null, null, null,
                    3, Constants.DEFAULT_CHANNEL, "Сгенерированное сообщение", "eID", null, Priority.HIGH, null,
                    null, 1, null, "44", "UNKNOWN", "UNKNOWN"
            );
            updatemsgReportState(report);
        }

        for (int i = 0; i < 3; i++) {
            MsgStateReport report = new MsgStateReport(
                    false, UUID.randomUUID(), Constants.DEFAULT_PHONE_NUMBER, Constants.DEFAULT_SENDER,
                    new Date(), 70, new Date(), new Date(), null, null, null,
                    3, Constants.DEFAULT_CHANNEL, "Сгенерированное сообщение", "eID", null, Priority.HIGH, null,
                    null, 1, null, "44", "UNKNOWN", "UNKNOWN"
            );
            updatemsgReportState(report);
        }

        for (int i = 0; i < 3; i++) {
            MsgStateReport report = new MsgStateReport(
                    false, UUID.randomUUID(), Constants.DEFAULT_PHONE_NUMBER, Constants.DEFAULT_SENDER,
                    new Date(), 25, new Date(), new Date(), null, null, null,
                    3, Constants.DEFAULT_CHANNEL, "Сгенерированное сообщение", "eID", null, Priority.HIGH, null,
                    null, 1, null, "44", "UNKNOWN", "UNKNOWN"
            );
            updatemsgReportState(report);
        }

        for (int i = 0; i < 3; i++) {
            MsgStateReport report = new MsgStateReport(
                    false, UUID.randomUUID(), Constants.DEFAULT_PHONE_NUMBER, Constants.DEFAULT_SENDER,
                    new Date(), 60, new Date(), new Date(), null, null, null,
                    3, Constants.DEFAULT_CHANNEL, "Сгенерированное сообщение", "eID", null, Priority.HIGH, null,
                    null, 1, null, "44", "UNKNOWN", "UNKNOWN"
            );
            updatemsgReportState(report);
        }

        for (int i = 0; i < 3; i++) {
            MsgStateReport report = new MsgStateReport(
                    false, UUID.randomUUID(), Constants.DEFAULT_PHONE_NUMBER, Constants.DEFAULT_SENDER,
                    new Date(), 85, new Date(), new Date(), null, null, null,
                    3, Constants.DEFAULT_CHANNEL, "Сгенерированное сообщение", "eID", null, Priority.HIGH, null,
                    null, 1, null, "44", "UNKNOWN", "UNKNOWN"
            );
            updatemsgReportState(report);
        }
    }

    @Test(description = "Сообщения: Статусы доставки")
    public void generateMessagesBySender() {

        for (int i = 0; i < 3; i++) {
            MsgStateReport report = new MsgStateReport(
                    false, UUID.randomUUID(), Constants.DEFAULT_PHONE_NUMBER, Constants.TEST_SENDER,
                    new Date(), 80, new Date(), new Date(), null, null, null,
                    3, Constants.DEFAULT_CHANNEL, "Сгенерированное сообщение", "eID", null, Priority.HIGH, null,
                    null, 1, null, "44", "UNKNOWN", "UNKNOWN"
            );
            updatemsgReportState(report);
        }
    }
}
