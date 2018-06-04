package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.befree.qa.ibs.tools.util.datagen.BlockType;
import ru.befree.qa.ibs.tools.util.datagen.BlockingRulesFarm;
import ru.befree.qa.ibs.tools.util.datagen.ImsiFarm;
import ru.idigital.fastgate.qa.BaseTestData;

import java.util.Date;

public class Blocks extends BaseTestData {

    @Test(description = "Блокировки")
    public void insertBlocks(){
        BlockingRulesFarm.prepareBlockListMessage("79818230000").forMsisdn("79818230000")
                .withCreationDate(new Date()).withType(BlockType.PERMANENT_ALL).withDeleted(false).make();
        BlockingRulesFarm.prepareBlockListMessage("79818230001").forMsisdn("79818230001")
                .withCreationDate(new Date()).withType(BlockType.PERMANENT_ALL).withDeleted(false).make();
        BlockingRulesFarm.prepareBlockListMessage("79818230002").forMsisdn("79818230002")
                .withCreationDate(new Date()).withType(BlockType.PERMANENT_ALL).withDeleted(true).make();

        BlockingRulesFarm.prepareBlockListMessage("79818230003").forMsisdn("79818230003")
                .withCreationDate(new Date()).withType(BlockType.PERMANENT_DISTRIBUTION).withDeleted(false).make();
        BlockingRulesFarm.prepareBlockListMessage("79818230004").forMsisdn("79818230004")
                .withCreationDate(new Date()).withType(BlockType.PERMANENT_DISTRIBUTION).withDeleted(false).make();
        BlockingRulesFarm.prepareBlockListMessage("79818230005").forMsisdn("79818230005")
                .withCreationDate(new Date()).withType(BlockType.PERMANENT_DISTRIBUTION).withDeleted(true).make();

        BlockingRulesFarm.prepareBlockListMessage("79818230006").forMsisdn("79818230006")
                .withCreationDate(new Date()).withType(BlockType.TEMP_DISTRIBUTION).withDeleted(false).make();
        BlockingRulesFarm.prepareBlockListMessage("79818230007").forMsisdn("79818230007")
                .withCreationDate(new Date()).withType(BlockType.TEMP_DISTRIBUTION).withDeleted(false).make();
        BlockingRulesFarm.prepareBlockListMessage("79818230008").forMsisdn("79818230008")
                .withCreationDate(new Date()).withType(BlockType.TEMP_DISTRIBUTION).withDeleted(true).make();

        ImsiFarm.prepareImsi("79818230010").withImsi("79818230010").withBlocked(true).withNetwork(95).make();
        ImsiFarm.prepareImsi("79818230011").withImsi("79818230011").withBlocked(false).withNetwork(120).make();
        ImsiFarm.prepareImsi("79818230012").withImsi("79818230012").withBlocked(true).withNetwork(125).make();
        ImsiFarm.prepareImsi("79818230013").withImsi("79818230013").withBlocked(false).withNetwork(125).make();
        ImsiFarm.prepareImsi("79818230014").withImsi("79818230014").withBlocked(false).withNetwork(158).make();
    }
}
