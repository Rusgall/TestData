package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.ibs.core.LanguageCode;
import ru.befree.ibs.msgproc.TemplateType;
import ru.befree.ibs.ui.Department;
import ru.befree.qa.ibs.tools.util.constants.Constants;
import ru.befree.qa.ibs.tools.util.datagen.TemplatesFarm;
import ru.idigital.fastgate.qa.BaseTestData;

public class Templates extends BaseTestData {

    @Test(description = "Шаблоны рассылок")
    public void insertDistribTemplates() {
        TemplatesFarm.prepareTemplate(Constants.TEST_DISTRIB_TEMPLATE)
                .withChannel(Constants.DEFAULT_CHANNEL).withShortNumber(getSenderNumber(Constants.TEST_SENDER))
                .withDays(Byte.valueOf("127")).withDuration(1).withResendTimeout(60)
                .withType(TemplateType.Distribution).withTemplateVariant(LanguageCode.Rus, "Текст").make();

        TemplatesFarm.prepareTemplate(Constants.TEST_DISTRIB_TEMPLATE_NOT_USE)
                .withChannel(Constants.DEFAULT_CHANNEL).withShortNumber(getSenderNumber(Constants.TEST_SENDER))
                .withDays(Byte.valueOf("127")).withDuration(1).withResendTimeout(60)
                .withType(TemplateType.Distribution).withTemplateVariant(LanguageCode.Rus, "Текст").make();
    }

    @Test(description = "Шаблоны сообщений")
    public void insertMessageTemplates() {
        TemplatesFarm.prepareTemplate(Constants.TEST_MESSAGE_TEMPLATE)
                .withChannel(Constants.DEFAULT_CHANNEL).withShortNumber(getSenderNumber(Constants.TEST_SENDER))
                .withDays(Byte.valueOf("127")).withType(TemplateType.Single).withResendTimeout(60).withDays(null)
                .withSendSpeed(null).withSpeedPeriod(null).withStartHour(0).withStopHour(24)
                .withTemplateVariant(LanguageCode.Rus, "Текст").withTemplateVariant(LanguageCode.Eng, "Text")
                .withTemplateVariant(LanguageCode.Trl, "Text").make();

        TemplatesFarm.prepareTemplate(Constants.TEST_MESSAGE_TEMPLATE_DELETE)
                .withChannel(Constants.DEFAULT_CHANNEL).withShortNumber(getSenderNumber(Constants.TEST_SENDER))
                .withDays(Byte.valueOf("127")).withType(TemplateType.Single).withResendTimeout(60).withDays(null)
                .withSendSpeed(null).withSpeedPeriod(null).withStartHour(0).withStopHour(24)
                .withTemplateVariant(LanguageCode.Rus, "Текст").withTemplateVariant(LanguageCode.Eng, "Text")
                .withTemplateVariant(LanguageCode.Trl, "Text").make();
    }
}
