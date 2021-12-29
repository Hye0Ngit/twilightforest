// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import twilightforest.entity.passive.EntityTFTinyFirefly;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import twilightforest.TwilightForestMod;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;

public class BlockTFFireflyJar extends Block
{
    public static Icon jarTop;
    public static Icon jarSide;
    public static Icon jarCork;
    
    protected BlockTFFireflyJar(final int par1) {
        super(par1, Material.field_76264_q);
        this.func_71905_a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
        this.func_71848_c(0.3f);
        this.func_71884_a(Block.field_71967_e);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
        this.func_71907_b(true);
    }
    
    public boolean func_71886_c() {
        return false;
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public int func_71857_b() {
        return TwilightForestMod.proxy.getComplexBlockRenderID();
    }
    
    public Icon func_71858_a(final int side, final int meta) {
        return (side == 1 || side == 0) ? BlockTFFireflyJar.jarTop : BlockTFFireflyJar.jarSide;
    }
    
    public int getLightValue(final IBlockAccess world, final int x, final int y, final int z) {
        return 8;
    }
    
    public boolean isBlockNormalCube(final World world, final int x, final int y, final int z) {
        return false;
    }
    
    public void func_71902_a(final IBlockAccess world, final int x, final int y, final int z) {
        this.func_71905_a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    public void func_71919_f() {
        this.func_71905_a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_71862_a(final World world, final int x, final int y, final int z, final Random rand) {
        double dx = x + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        double dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
        double dz = z + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        EntityTFTinyFirefly tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
        world.func_72942_c((Entity)tinyfly);
        dx = x + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
        dz = z + ((rand.nextFloat() - rand.nextFloat()) * 0.3f + 0.5f);
        tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
        world.func_72942_c((Entity)tinyfly);
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFFireflyJar.jarTop = par1IconRegister.func_94245_a("twilightforest:fireflyjar_top");
        BlockTFFireflyJar.jarSide = par1IconRegister.func_94245_a("twilightforest:fireflyjar_side");
        BlockTFFireflyJar.jarCork = par1IconRegister.func_94245_a("twilightforest:fireflyjar_cork");
    }
}
