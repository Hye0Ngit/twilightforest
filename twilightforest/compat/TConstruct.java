// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import twilightforest.compat.tcon.trait.TraitVeiled;
import twilightforest.compat.tcon.trait.TraitSynergy;
import twilightforest.compat.tcon.trait.TraitStalwart;
import twilightforest.compat.tcon.trait.TraitPrecipitate;
import twilightforest.compat.tcon.trait.TraitTwilit;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.tools.TinkerTraits;
import slimeknights.tconstruct.library.traits.ITrait;
import twilightforest.item.TFItems;
import twilightforest.compat.tcon.texture.FieryInfoDeserializer;
import slimeknights.tconstruct.library.client.material.MaterialRenderInfoLoader;
import twilightforest.compat.tcon.texture.GradientMapInfoDeserializer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.FMLCommonHandler;
import twilightforest.block.RegisterBlockEvent;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.materials.FletchingMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ArrowShaftMaterialStats;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.IMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.materials.Material;

public class TConstruct
{
    public static final Material nagascale;
    public static final Material steeleaf;
    public static final Material fierymetal;
    public static final Material knightmetal;
    public static final Material ravenFeather;
    public static final AbstractTrait twilit;
    public static final AbstractTrait precipitate;
    public static final AbstractTrait stalwart;
    public static final AbstractTrait synergy;
    public static final AbstractTrait veiled;
    
    static void preInit() {
        TinkerRegistry.addMaterialStats(TConstruct.nagascale, (IMaterialStats)new HeadMaterialStats(460, 8.9f, 4.3f, 1), new IMaterialStats[] { (IMaterialStats)new BowMaterialStats(0.6f, 2.0f, 0.0f), (IMaterialStats)new ArrowShaftMaterialStats(1.4f, 20) });
        TinkerRegistry.integrate(TConstruct.nagascale).preInit();
        TinkerRegistry.addMaterialStats(TConstruct.steeleaf, (IMaterialStats)new HeadMaterialStats(180, 7.0f, 6.0f, 2), new IMaterialStats[] { (IMaterialStats)new HandleMaterialStats(0.8f, 100), (IMaterialStats)new ExtraMaterialStats(90), (IMaterialStats)new BowMaterialStats(1.2f, 1.5f, 2.0f), (IMaterialStats)new ArrowShaftMaterialStats(0.6f, 10), (IMaterialStats)new FletchingMaterialStats(1.0f, 0.8f) });
        TinkerRegistry.integrate(new MaterialIntegration(TConstruct.steeleaf, (Fluid)null, "Steeleaf")).toolforge().preInit();
        TinkerRegistry.addMaterialStats(TConstruct.fierymetal, (IMaterialStats)new HeadMaterialStats(720, 7.2f, 6.6f, 3), new IMaterialStats[] { (IMaterialStats)new HandleMaterialStats(0.7f, 400), (IMaterialStats)new ExtraMaterialStats(200), (IMaterialStats)new BowMaterialStats(1.0f, 0.9f, 4.0f), (IMaterialStats)new ArrowShaftMaterialStats(0.8f, 0) });
        TinkerRegistry.integrate(new MaterialIntegration(TConstruct.fierymetal, RegisterBlockEvent.moltenFiery, "Fiery")).toolforge().preInit();
        TinkerRegistry.addMaterialStats(TConstruct.knightmetal, (IMaterialStats)new HeadMaterialStats(900, 7.0f, 6.0f, 4), new IMaterialStats[] { (IMaterialStats)new HandleMaterialStats(1.25f, 100), (IMaterialStats)new ExtraMaterialStats(400) });
        TinkerRegistry.integrate(new MaterialIntegration(TConstruct.knightmetal, RegisterBlockEvent.moltenKnightmetal, "Knightmetal")).preInit();
        TinkerRegistry.addMaterialStats(TConstruct.ravenFeather, (IMaterialStats)new FletchingMaterialStats(0.95f, 1.15f));
        TinkerRegistry.integrate(TConstruct.ravenFeather).preInit();
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            MaterialRenderInfoLoader.addRenderInfo("gradient_map_colors", (Class)GradientMapInfoDeserializer.class);
            MaterialRenderInfoLoader.addRenderInfo("fierymetal", (Class)FieryInfoDeserializer.class);
        }
    }
    
    static void init() {
        TConstruct.nagascale.addItem(TFItems.naga_scale, 1, 144);
        TConstruct.nagascale.addTrait((ITrait)TConstruct.twilit).addTrait((ITrait)TConstruct.precipitate).setCraftable(true).setCastable(false).setRepresentativeItem(TFItems.naga_scale);
        TConstruct.steeleaf.addCommonItems("Steeleaf");
        TConstruct.steeleaf.addTrait((ITrait)TConstruct.twilit).addTrait((ITrait)TConstruct.synergy).setCraftable(true).setCastable(false).setRepresentativeItem(TFItems.steeleaf_ingot);
        TConstruct.fierymetal.addCommonItems("Fiery");
        TConstruct.fierymetal.addTrait((ITrait)TConstruct.twilit).addTrait((ITrait)TinkerTraits.flammable).addTrait((ITrait)TConstruct.twilit, "head").addTrait((ITrait)TinkerTraits.autosmelt, "head").addTrait((ITrait)TinkerTraits.superheat, "head").addTrait((ITrait)TinkerTraits.flammable, "head").setCraftable(false).setCastable(true).setRepresentativeItem(TFItems.fiery_ingot);
        TConstruct.knightmetal.addCommonItems("Knightmetal");
        TConstruct.knightmetal.addItem(TFItems.armor_shard, 1, 16);
        TConstruct.knightmetal.addItem(TFItems.block_and_chain, 1, 2304);
        TConstruct.knightmetal.addTrait((ITrait)TConstruct.twilit).addTrait((ITrait)TConstruct.stalwart).setCraftable(false).setCastable(true).setRepresentativeItem(TFItems.knightmetal_ingot);
        TConstruct.ravenFeather.addItem(TFItems.raven_feather, 1, 144);
        TConstruct.ravenFeather.addTrait((ITrait)TConstruct.twilit).addTrait((ITrait)TConstruct.veiled).setCraftable(true).setCastable(false).setRepresentativeItem(TFItems.raven_feather);
    }
    
    static void postInit() {
        TinkerRegistry.registerSmelteryFuel(new FluidStack(RegisterBlockEvent.essenceFiery, 50), 1000);
    }
    
    static {
        nagascale = new Material("nagascale", 3300645);
        steeleaf = new Material("steeleaf", 5408570);
        fierymetal = new Material("fierymetal", 16634973);
        knightmetal = new Material("knightmetal", 12904110);
        ravenFeather = new Material("raven_feather", 4672594);
        twilit = (AbstractTrait)new TraitTwilit();
        precipitate = (AbstractTrait)new TraitPrecipitate();
        stalwart = new TraitStalwart();
        synergy = new TraitSynergy();
        veiled = (AbstractTrait)new TraitVeiled();
    }
}
