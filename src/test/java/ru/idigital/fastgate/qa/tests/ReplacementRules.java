package ru.idigital.fastgate.qa.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import ru.befree.qa.ibs.tools.util.datagen.ReplacementRulesFarm;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.befree.qa.ibs.tools.util.constants.Constants;

import java.util.Collections;

public class ReplacementRules extends BaseTestData {

    @Test(description = "Правила подмены")
    public void insertReplacementRules(){
        ru.befree.ibs.ui.Connection connection = getConnection(Constants.TEST_CONNECTION);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("textTransliteration", true);

        ReplacementRulesFarm.prepareReplacementRule("withConnection")
                .withConnections(Collections.singleton(connection))
                .withReplacementValue(jsonObject.toJSONString())
                .make();
    }
}
