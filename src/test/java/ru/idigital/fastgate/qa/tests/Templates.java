package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.ibs.core.LanguageCode;
import ru.befree.ibs.msgproc.TemplateType;
import ru.befree.qa.ibs.tools.util.datagen.TemplatesFarm;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.idigital.fastgate.qa.data.constants.Constants;

public class Templates extends BaseTestData {

    @Test(description = "Шаблоны рассылок")
    public void insertDistribTemplates() {
//        TemplatesFarm.prepareTemplate(Constants.TEST_DISTRIB_TEMPLATE)
//                .withChannel(Constants.DEFAULT_CHANNEL).withShortNumber(getSenderNumber(Constants.TEST_SENDER))
//                .withDays(Byte.valueOf("127")).withDuration(1).withResendTimeout(60)
//                .withType(TemplateType.Distribution).withTemplateVariant(LanguageCode.Rus, "Текст").make();

        TemplatesFarm.prepareTemplate(Constants.TEST_DISTRIB_TEMPLATE_NOT_USE)
                .withChannel(Constants.DEFAULT_CHANNEL).withShortNumber(getSenderNumber(Constants.TEST_SENDER))
                .withDays(Byte.valueOf("127")).withDuration(1).withResendTimeout(60)
                .withType(TemplateType.Distribution).withTemplateVariant(LanguageCode.Rus, "Текст").make();
    }
}
