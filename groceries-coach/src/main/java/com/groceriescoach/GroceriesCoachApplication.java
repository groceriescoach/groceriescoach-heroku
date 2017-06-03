package com.groceriescoach;


import com.groceriescoach.amcal.config.AmcalConfig;
import com.groceriescoach.babyandtoddlertown.BabyAndToddlerTownConfig;
import com.groceriescoach.babybounce.BabyBounceConfig;
import com.groceriescoach.babybunting.BabyBuntingConfig;
import com.groceriescoach.babykingdom.BabyKingdomConfig;
import com.groceriescoach.babyvillage.BabyVillageConfig;
import com.groceriescoach.bigw.BigWConfig;
import com.groceriescoach.chemistwarehouse.ChemistWarehouseConfig;
import com.groceriescoach.coles.config.ColesConfig;
import com.groceriescoach.config.GroceriesCoachConfig;
import com.groceriescoach.nursingangel.NursingAngelConfig;
import com.groceriescoach.pharmacy4less.Pharmacy4LessConfig;
import com.groceriescoach.priceline.PricelineConfig;
import com.groceriescoach.target.TargetConfig;
import com.groceriescoach.woolworths.config.WoolworthsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@Import({
        GroceriesCoachConfig.class, AmcalConfig.class, BabyAndToddlerTownConfig.class,
        BabyBounceConfig.class, BabyBuntingConfig.class, BabyKingdomConfig.class, BabyVillageConfig.class,
        BigWConfig.class, ChemistWarehouseConfig.class, ColesConfig.class, NursingAngelConfig.class,
        Pharmacy4LessConfig.class, PricelineConfig.class, TargetConfig.class, WoolworthsConfig.class
})
@SpringBootApplication
@EnableAsync
public class GroceriesCoachApplication {

    private static final Logger logger = LoggerFactory.getLogger(GroceriesCoachApplication.class);

    public static void main(String[] args) {
        SpringApplication groceriesCoachApp = new SpringApplication(GroceriesCoachApplication.class);
        groceriesCoachApp.run(args);
    }
}
