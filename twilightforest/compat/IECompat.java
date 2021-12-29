// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import twilightforest.entity.boss.SnowQueen;
import twilightforest.entity.boss.AlphaYeti;
import twilightforest.entity.boss.UrGhast;
import twilightforest.entity.boss.KnightPhantom;
import twilightforest.entity.boss.Hydra;
import twilightforest.entity.boss.Minoshroom;
import twilightforest.entity.boss.Lich;
import twilightforest.entity.boss.Naga;
import blusunrize.immersiveengineering.common.EventHandler;
import twilightforest.compat.ie.IEShaderRegister;
import blusunrize.immersiveengineering.api.crafting.builders.ThermoelectricSourceBuilder;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.entity.projectile.CicadaShot;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.world.entity.player.Player;
import blusunrize.immersiveengineering.api.tool.RailgunHandler;
import net.minecraft.world.item.crafting.Ingredient;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.ItemLike;
import java.util.Iterator;
import net.minecraftforge.registries.IForgeRegistry;
import twilightforest.compat.ie.TFShaderGrabbagItem;
import net.minecraft.world.item.Rarity;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import twilightforest.TwilightForestMod;
import twilightforest.compat.ie.TFShaderItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class IECompat extends TFCompat
{
    public IECompat() {
        super("immersiveengineering");
    }
    
    @Override
    protected void initItems(final RegistryEvent.Register<Item> evt) {
        final IForgeRegistry<Item> r = (IForgeRegistry<Item>)evt.getRegistry();
        r.register((IForgeRegistryEntry)new TFShaderItem().setRegistryName(TwilightForestMod.prefix("shader")));
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
        RailgunHandler.registerProjectile(() -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)((Block)TFBlocks.CICADA.get()).m_5456_() }), (RailgunHandler.IRailgunProjectile)new RailgunHandler.StandardRailgunProjectile(2.0, 0.25) {
            public Entity getProjectile(@Nullable final Player shooter, final ItemStack ammo, final Entity projectile) {
                final Vec3 look = shooter.m_20154_();
                shooter.f_19853_.m_5594_((Player)null, shooter.m_142538_(), TFSounds.CICADA_FLYING, SoundSource.NEUTRAL, 1.0f, 1.0f);
                return (Entity)new CicadaShot(shooter.f_19853_, (LivingEntity)shooter, look.f_82479_ * 20.0, look.f_82480_ * 20.0, look.f_82481_ * 20.0);
            }
            
            public boolean isValidForTurret() {
                return false;
            }
        });
        ThermoelectricSourceBuilder.builder((Block)TFBlocks.FIERY_BLOCK.get()).kelvin(2500);
        IEShaderRegister.initShaders();
        EventHandler.listOfBoringBosses.add(Naga.class);
        EventHandler.listOfBoringBosses.add(Lich.class);
        EventHandler.listOfBoringBosses.add(Minoshroom.class);
        EventHandler.listOfBoringBosses.add(Hydra.class);
        EventHandler.listOfBoringBosses.add(KnightPhantom.class);
        EventHandler.listOfBoringBosses.add(UrGhast.class);
        EventHandler.listOfBoringBosses.add(AlphaYeti.class);
        EventHandler.listOfBoringBosses.add(SnowQueen.class);
    }
    
    @Override
    protected void postInit() {
    }
    
    @Override
    protected void sendIMCs() {
    }
}
