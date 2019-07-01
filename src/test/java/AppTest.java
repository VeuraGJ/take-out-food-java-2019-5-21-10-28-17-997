/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void should_use_50_percentage_sales_promotion(){
        List<String> inputs = Arrays.asList("ITEM0001 x 1", "ITEM0013 x 2", "ITEM0022 x 1");
        App app = new App(new ItemRepositoryTestImpl(), new SalesPromotionRepositoryTestImpl());
        String receiptString = app.bestCharge(inputs);
        assertThat(receiptString, is("============= 订餐明细 =============\n" +
                "黄焖鸡 x 1 = 18元\n" +
                "肉夹馍 x 2 = 12元\n" +
                "凉皮 x 1 = 8元\n" +
                "-----------------------------------\n" +
                "使用优惠:\n" +
                "指定菜品半价(黄焖鸡，凉皮)，省13元\n" +
                "-----------------------------------\n" +
                "总计：25元\n" +
                "==================================="));

    }

    @Test
    public void should_use_buy_30_save_6_sales_promotion(){
        List<String> inputs = Arrays.asList("ITEM0013 x 4", "ITEM0022 x 1");

        App app = new App(new ItemRepositoryTestImpl(), new SalesPromotionRepositoryTestImpl());
        String receiptString = app.bestCharge(inputs);

        assertThat(receiptString, is("============= 订餐明细 =============\n" +
                "肉夹馍 x 4 = 24元\n" +
                "凉皮 x 1 = 8元\n" +
                "-----------------------------------\n" +
                "使用优惠:\n" +
                "满30减6元，省6元\n" +
                "-----------------------------------\n" +
                "总计：26元\n" +
                "==================================="));

    }


    @Test
    public void should_use_no_sales_promotion(){
        List<String> inputs = Arrays.asList("ITEM0013 x 4");

        App app = new App(new ItemRepositoryTestImpl(), new SalesPromotionRepositoryTestImpl());
        String receiptString = app.bestCharge(inputs);

        assertThat(receiptString, is("============= 订餐明细 =============\n" +
                "肉夹馍 x 4 = 24元\n" +
                "-----------------------------------\n" +
                "总计：24元\n" +
                "==================================="));

    }
}