// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import twilightforest.entity.boss.SnowQueenEntity;
import twilightforest.entity.boss.AlphaYetiEntity;
import twilightforest.entity.boss.UrGhastEntity;
import twilightforest.entity.boss.KnightPhantomEntity;
import twilightforest.entity.boss.HydraEntity;
import twilightforest.entity.boss.MinoshroomEntity;
import twilightforest.entity.boss.LichEntity;
import twilightforest.entity.boss.NagaEntity;
import blusunrize.immersiveengineering.common.EventHandler;
import twilightforest.compat.ie.IEShaderRegister;
import blusunrize.immersiveengineering.api.energy.ThermoelectricHandler;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.LivingEntity;
import twilightforest.entity.projectile.CicadaShotEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.entity.player.PlayerEntity;
import blusunrize.immersiveengineering.api.tool.RailgunHandler;
import net.minecraft.item.crafting.Ingredient;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.IItemProvider;
import java.util.Iterator;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import twilightforest.compat.ie.TFShaderGrabbagItem;
import net.minecraft.item.Rarity;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import twilightforest.TwilightForestMod;
import twilightforest.compat.ie.TFShaderItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class IECompat extends TFCompat
{
    public IECompat() {
        super("immersiveengineering");
    }
    
    @Override
    protected void initItems(final RegistryEvent.Register<Item> evt) {
        final IForgeRegistry<Item> r = (IForgeRegistry<Item>)evt.getRegistry();
        r.register(new TFShaderItem().setRegistryName(TwilightForestMod.prefix("shader")));
        for (final Rarity rarity : ShaderRegistry.rarityWeightMap.keySet()) {
            r.register((IForgeRegistryEntry)new TFShaderGrabbagItem(rarity));
        }
    }
    
    @Override
    protected boolean preInit() {
        ShaderRegistry.rarityWeightMap.put(TwilightForestMod.getRarity(), 1);
        return true;
    }
    
    @Override
    protected void init() {
        RailgunHandler.registerProjectile(() -> Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)((Block)TFBlocks.cicada.get()).func_199767_j() }), (RailgunHandler.IRailgunProjectile)new RailgunHandler.StandardRailgunProjectile(2.0, 0.25) {
            public Entity getProjectile(@Nullable final PlayerEntity shooter, final ItemStack ammo, final Entity projectile) {
                final Vector3d look = shooter.func_70040_Z();
                return (Entity)new CicadaShotEntity(shooter.func_130014_f_(), (LivingEntity)shooter, look.field_72450_a * 20.0, look.field_72448_b * 20.0, look.field_72449_c * 20.0);
            }
            
            public boolean isValidForTurret() {
                return false;
            }
        });
        ThermoelectricHandler.registerSourceInKelvin((Block)TFBlocks.fiery_block.get(), 2500);
        IEShaderRegister.initShaders();
        EventHandler.listOfBoringBosses.add(NagaEntity.class);
        EventHandler.listOfBoringBosses.add(LichEntity.class);
        EventHandler.listOfBoringBosses.add(MinoshroomEntity.class);
        EventHandler.listOfBoringBosses.add(HydraEntity.class);
        EventHandler.listOfBoringBosses.add(KnightPhantomEntity.class);
        EventHandler.listOfBoringBosses.add(UrGhastEntity.class);
        EventHandler.listOfBoringBosses.add(AlphaYetiEntity.class);
        EventHandler.listOfBoringBosses.add(SnowQueenEntity.class);
    }
    
    @Override
    protected void postInit() {
    }
    
    @Override
    protected void sendIMCs() {
    }
}
