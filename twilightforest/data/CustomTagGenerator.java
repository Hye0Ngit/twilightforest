// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraftforge.common.ForgeTagHandler;
import twilightforest.TwilightForestMod;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.data.ForgeRegistryTagsProvider;

public class CustomTagGenerator
{
    public static class EnchantmentTagGenerator extends ForgeRegistryTagsProvider<Enchantment>
    {
        public static final Tag.Named<Enchantment> PHANTOM_ARMOR_BANNED_ENCHANTS;
        
        public EnchantmentTagGenerator(final DataGenerator generatorIn, @Nullable final ExistingFileHelper existingFileHelper) {
            super(generatorIn, ForgeRegistries.ENCHANTMENTS, "twilightforest", existingFileHelper);
        }
        
        protected void m_6577_() {
            this.m_126548_((Tag.Named)EnchantmentTagGenerator.PHANTOM_ARMOR_BANNED_ENCHANTS).m_126584_((Object[])new Enchantment[] { Enchantments.f_44963_, Enchantments.f_44975_ });
        }
        
        public String m_6055_() {
            return "Twilight Forest Enchantment Tags";
        }
        
        static {
            PHANTOM_ARMOR_BANNED_ENCHANTS = (Tag.Named)ForgeTagHandler.createOptionalTag(ForgeRegistries.ENCHANTMENTS, TwilightForestMod.prefix("phantom_armor_banned_enchants"));
        }
    }
}
