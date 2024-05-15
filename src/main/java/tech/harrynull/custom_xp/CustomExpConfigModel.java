package tech.harrynull.custom_xp;

import com.ezylang.evalex.Expression;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Hook;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.PredicateConstraint;

@Modmenu(modId = "custom-xp-scaling")
@Config(name = "custom-exp-config", wrapperName = "CustomExpConfig")
public class CustomExpConfigModel {
    @Hook
    @PredicateConstraint("validateRule")
    public String scalingRule = "IF(level >= 31, level * 9 - 158, IF(level >= 16, 5 * level - 38, 2 * level + 7))";

    public static boolean validateRule(String rule) {
        try {
            new Expression(rule).with("level", 1).evaluate().getNumberValue().intValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
