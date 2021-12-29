// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.WorldServer;
import net.minecraft.entity.EntityList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import twilightforest.TFTeleporter;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockBreakable;

public class BlockTFPortal extends BlockBreakable
{
    public BlockTFPortal() {
        super("TFPortal", Material.field_151567_E, false);
        this.func_149711_c(-1.0f);
        this.func_149672_a(Block.field_149778_k);
        this.func_149715_a(0.75f);
    }
    
    public AxisAlignedBB func_149668_a(final World world, final int i, final int j, final int k) {
        return null;
    }
    
    public void func_149719_a(final IBlockAccess iblockaccess, final int i, final int j, final int k) {
        this.func_149676_a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        return Blocks.field_150427_aO.func_149691_a(side, meta);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
    }
    
    public boolean tryToCreatePortal(final World world, final int dx, final int dy, final int dz) {
        if (this.isGoodPortalPool(world, dx, dy, dz)) {
            world.func_72942_c((Entity)new EntityLightningBolt(world, (double)dx, (double)dy, (double)dz));
            this.transmuteWaterToPortal(world, dx, dy, dz);
            return true;
        }
        return false;
    }
    
    public void transmuteWaterToPortal(final World world, final int dx, final int dy, final int dz) {
        int px = dx;
        int pz = dz;
        if (world.func_147439_a(px - 1, dy, pz).func_149688_o() == Material.field_151586_h) {
            --px;
        }
        if (world.func_147439_a(px, dy, pz - 1).func_149688_o() == Material.field_151586_h) {
            --pz;
        }
        world.func_147465_d(px + 0, dy, pz + 0, TFBlocks.portal, 0, 2);
        world.func_147465_d(px + 1, dy, pz + 0, TFBlocks.portal, 0, 2);
        world.func_147465_d(px + 1, dy, pz + 1, TFBlocks.portal, 0, 2);
        world.func_147465_d(px + 0, dy, pz + 1, TFBlocks.portal, 0, 2);
    }
    
    public boolean isGoodPortalPool(final World world, final int dx, final int dy, final int dz) {
        boolean flag = false;
        flag |= this.isGoodPortalPoolStrict(world, dx + 0, dy, dz + 0);
        flag |= this.isGoodPortalPoolStrict(world, dx - 1, dy, dz - 1);
        flag |= this.isGoodPortalPoolStrict(world, dx + 0, dy, dz - 1);
        flag |= this.isGoodPortalPoolStrict(world, dx + 1, dy, dz - 1);
        flag |= this.isGoodPortalPoolStrict(world, dx - 1, dy, dz + 0);
        flag |= this.isGoodPortalPoolStrict(world, dx + 1, dy, dz + 0);
        flag |= this.isGoodPortalPoolStrict(world, dx - 1, dy, dz + 1);
        flag |= this.isGoodPortalPoolStrict(world, dx + 0, dy, dz + 1);
        flag |= this.isGoodPortalPoolStrict(world, dx + 1, dy, dz + 1);
        return flag;
    }
    
    public boolean isGoodPortalPoolStrict(final World world, final int dx, final int dy, final int dz) {
        boolean flag = true;
        flag &= (world.func_147439_a(dx + 0, dy, dz + 0).func_149688_o() == Material.field_151586_h);
        flag &= (world.func_147439_a(dx + 1, dy, dz + 0).func_149688_o() == Material.field_151586_h);
        flag &= (world.func_147439_a(dx + 1, dy, dz + 1).func_149688_o() == Material.field_151586_h);
        flag &= (world.func_147439_a(dx + 0, dy, dz + 1).func_149688_o() == Material.field_151586_h);
        flag &= this.isGrassOrDirt(world, dx - 1, dy, dz - 1);
        flag &= this.isGrassOrDirt(world, dx - 1, dy, dz + 0);
        flag &= this.isGrassOrDirt(world, dx - 1, dy, dz + 1);
        flag &= this.isGrassOrDirt(world, dx - 1, dy, dz + 2);
        flag &= this.isGrassOrDirt(world, dx + 0, dy, dz - 1);
        flag &= this.isGrassOrDirt(world, dx + 1, dy, dz - 1);
        flag &= this.isGrassOrDirt(world, dx + 0, dy, dz + 2);
        flag &= this.isGrassOrDirt(world, dx + 1, dy, dz + 2);
        flag &= this.isGrassOrDirt(world, dx + 2, dy, dz - 1);
        flag &= this.isGrassOrDirt(world, dx + 2, dy, dz + 0);
        flag &= this.isGrassOrDirt(world, dx + 2, dy, dz + 1);
        flag &= this.isGrassOrDirt(world, dx + 2, dy, dz + 2);
        flag &= world.func_147439_a(dx + 0, dy - 1, dz + 0).func_149688_o().func_76220_a();
        flag &= world.func_147439_a(dx + 1, dy - 1, dz + 0).func_149688_o().func_76220_a();
        flag &= world.func_147439_a(dx + 1, dy - 1, dz + 1).func_149688_o().func_76220_a();
        flag &= world.func_147439_a(dx + 0, dy - 1, dz + 1).func_149688_o().func_76220_a();
        flag &= this.isNatureBlock(world, dx - 1, dy + 1, dz - 1);
        flag &= this.isNatureBlock(world, dx - 1, dy + 1, dz + 0);
        flag &= this.isNatureBlock(world, dx - 1, dy + 1, dz + 1);
        flag &= this.isNatureBlock(world, dx - 1, dy + 1, dz + 2);
        flag &= this.isNatureBlock(world, dx + 0, dy + 1, dz - 1);
        flag &= this.isNatureBlock(world, dx + 1, dy + 1, dz - 1);
        flag &= this.isNatureBlock(world, dx + 0, dy + 1, dz + 2);
        flag &= this.isNatureBlock(world, dx + 1, dy + 1, dz + 2);
        flag &= this.isNatureBlock(world, dx + 2, dy + 1, dz - 1);
        flag &= this.isNatureBlock(world, dx + 2, dy + 1, dz + 0);
        flag &= this.isNatureBlock(world, dx + 2, dy + 1, dz + 1);
        flag &= this.isNatureBlock(world, dx + 2, dy + 1, dz + 2);
        return flag;
    }
    
    public boolean isNatureBlock(final World world, final int dx, final int dy, final int dz) {
        final Material mat = world.func_147439_a(dx, dy, dz).func_149688_o();
        return mat == Material.field_151585_k || mat == Material.field_151582_l || mat == Material.field_151584_j;
    }
    
    public void func_149695_a(final World world, final int x, final int y, final int z, final Block notUsed) {
        boolean good = true;
        if (world.func_147439_a(x - 1, y, z) == this) {
            good &= this.isGrassOrDirt(world, x + 1, y, z);
        }
        else {
            good = (world.func_147439_a(x + 1, y, z) == this && (good & this.isGrassOrDirt(world, x - 1, y, z)));
        }
        if (world.func_147439_a(x, y, z - 1) == this) {
            good &= this.isGrassOrDirt(world, x, y, z + 1);
        }
        else {
            good = (world.func_147439_a(x, y, z + 1) == this && (good & this.isGrassOrDirt(world, x, y, z - 1)));
        }
        if (!good) {
            world.func_147465_d(x, y, z, Blocks.field_150355_j, 0, 3);
        }
    }
    
    protected boolean isGrassOrDirt(final World world, final int dx, final int dy, final int dz) {
        return world.func_147439_a(dx, dy, dz).func_149688_o() == Material.field_151577_b || world.func_147439_a(dx, dy, dz).func_149688_o() == Material.field_151578_c;
    }
    
    public int func_149745_a(final Random random) {
        return 0;
    }
    
    public int func_149701_w() {
        return 1;
    }
    
    public void func_149670_a(final World world, final int i, final int j, final int k, final Entity entity) {
        if (entity.field_70154_o == null && entity.field_70153_n == null && entity.field_71088_bW <= 0) {
            if (entity instanceof EntityPlayerMP) {
                final EntityPlayerMP playerMP = (EntityPlayerMP)entity;
                if (playerMP.field_71088_bW > 0) {
                    playerMP.field_71088_bW = 10;
                }
                else if (playerMP.field_71093_bK != TwilightForestMod.dimensionID) {
                    playerMP.func_71029_a((StatBase)TFAchievementPage.twilightPortal);
                    playerMP.func_71029_a((StatBase)TFAchievementPage.twilightArrival);
                    System.out.println("Player touched the portal block.  Sending the player to dimension 7");
                    playerMP.field_71133_b.func_71203_ab().transferPlayerToDimension(playerMP, TwilightForestMod.dimensionID, (Teleporter)new TFTeleporter(playerMP.field_71133_b.func_71218_a(TwilightForestMod.dimensionID)));
                    playerMP.func_82242_a(0);
                    playerMP.func_71029_a((StatBase)TFAchievementPage.twilightPortal);
                    playerMP.func_71029_a((StatBase)TFAchievementPage.twilightArrival);
                    final int spawnX = MathHelper.func_76128_c(playerMP.field_70165_t);
                    final int spawnY = MathHelper.func_76128_c(playerMP.field_70163_u);
                    final int spawnZ = MathHelper.func_76128_c(playerMP.field_70161_v);
                    playerMP.setSpawnChunk(new ChunkCoordinates(spawnX, spawnY, spawnZ), true, TwilightForestMod.dimensionID);
                }
                else {
                    playerMP.field_71133_b.func_71203_ab().transferPlayerToDimension(playerMP, 0, (Teleporter)new TFTeleporter(playerMP.field_71133_b.func_71218_a(0)));
                    playerMP.func_82242_a(0);
                }
            }
            else if (entity.field_71093_bK == TwilightForestMod.dimensionID) {
                this.sendEntityToDimension(entity, 0);
            }
        }
    }
    
    public void sendEntityToDimension(final Entity entity, final int par1) {
        if (!entity.field_70170_p.field_72995_K && !entity.field_70128_L) {
            entity.field_70170_p.field_72984_F.func_76320_a("changeDimension");
            final MinecraftServer minecraftserver = MinecraftServer.func_71276_C();
            final int dim = entity.field_71093_bK;
            final WorldServer worldserver = minecraftserver.func_71218_a(dim);
            final WorldServer worldserver2 = minecraftserver.func_71218_a(par1);
            entity.field_71093_bK = par1;
            entity.field_70170_p.func_72900_e(entity);
            entity.field_70128_L = false;
            entity.field_70170_p.field_72984_F.func_76320_a("reposition");
            minecraftserver.func_71203_ab().transferEntityToWorld(entity, dim, worldserver, worldserver2, (Teleporter)new TFTeleporter(worldserver2));
            entity.field_70170_p.field_72984_F.func_76318_c("reloading");
            final Entity transferEntity = EntityList.func_75620_a(EntityList.func_75621_b(entity), (World)worldserver2);
            if (transferEntity != null) {
                transferEntity.func_82141_a(entity, true);
                worldserver2.func_72838_d(transferEntity);
            }
            entity.field_70128_L = true;
            entity.field_70170_p.field_72984_F.func_76319_b();
            worldserver.func_82742_i();
            worldserver2.func_82742_i();
            entity.field_70170_p.field_72984_F.func_76319_b();
        }
    }
    
    public void func_149734_b(final World world, final int i, final int j, final int k, final Random random) {
        if (random.nextInt(100) == 0) {
            world.func_72908_a(i + 0.5, j + 0.5, k + 0.5, "portal.portal", 1.0f, random.nextFloat() * 0.4f + 0.8f);
        }
        for (int l = 0; l < 4; ++l) {
            double d = i + random.nextFloat();
            final double d2 = j + random.nextFloat();
            double d3 = k + random.nextFloat();
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            final int i2 = random.nextInt(2) * 2 - 1;
            d4 = (random.nextFloat() - 0.5) * 0.5;
            d5 = (random.nextFloat() - 0.5) * 0.5;
            d6 = (random.nextFloat() - 0.5) * 0.5;
            if (world.func_147439_a(i - 1, j, k) == this || world.func_147439_a(i + 1, j, k) == this) {
                d3 = k + 0.5 + 0.25 * i2;
                d6 = random.nextFloat() * 2.0f * i2;
            }
            else {
                d = i + 0.5 + 0.25 * i2;
                d4 = random.nextFloat() * 2.0f * i2;
            }
            world.func_72869_a("portal", d, d2, d3, d4, d5, d6);
        }
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
}
