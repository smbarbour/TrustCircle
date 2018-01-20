package de.ellpeck.trustcircle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@SideOnly(Side.CLIENT)
public class GuiFactory implements IModGuiFactory{

    @Override
    public void initialize(Minecraft minecraftInstance){

    }

    @Override
    public boolean hasConfigGui(){
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen){
        return new ConfigGui(parentScreen);
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories(){
        return null;
    }

    public static class ConfigGui extends GuiConfig{

        public ConfigGui(GuiScreen parentScreen){
            super(parentScreen, getConfigElements(), TrustCircle.MOD_ID, false, false, getAbridgedConfigPath(TrustCircle.config.toString()));
        }

        private static List<IConfigElement> getConfigElements(){
            return Collections.singletonList(new ConfigElement(TrustCircle.config.getCategory(Configuration.CATEGORY_GENERAL)));
        }
    }
}
