package tech.harrynull.custom_xp;

import com.ezylang.evalex.Expression;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class CustomXpScaling implements ModInitializer {
    static private Logger logger = LoggerFactory.getLogger("custom-xp-scaling");
    private final tech.harrynull.custom_xp.CustomExpConfig CONFIG = tech.harrynull.custom_xp.CustomExpConfig.createAndLoad();
    private Expression expression = null;
    private final Map<Integer, Integer> cachedValues = new HashMap<>();
    public static CustomXpScaling INSTANCE;

    @Override
    public void onInitialize() {
        INSTANCE = this;
        expression = new Expression(CONFIG.scalingRule());
        CONFIG.subscribeToScalingRule(
            (String rule) -> {
                expression = new Expression(rule);
                cachedValues.clear();
            }
        );
    }

    public Integer evaluateExperience(Integer level) {
        if (expression == null) return null;
        if (cachedValues.containsKey(level)) return cachedValues.get(level);
        try {
            Integer result = expression.with("level", level).evaluate().getNumberValue().intValue();
            cachedValues.put(level, result);
            return result;
        } catch (Exception e) {
            logger.error("Failed to evaluate expression: " + e.getMessage());
            return null;
        }
    }
}