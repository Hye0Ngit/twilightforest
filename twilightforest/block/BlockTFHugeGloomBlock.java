// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFHugeGloomBlock extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon capTex;
    @SideOnly(Side.CLIENT)
    private IIcon stemTex;
    @SideOnly(Side.CLIENT)
    private IIcon insideTex;
    
    public BlockTFHugeGloomBlock() {
        super(Material.field_151575_d);
        this.func_149711_c(0.2f);
        this.func_149672_a(BlockTFHugeGloomBlock.field_149766_f);
        this.func_149658_d("TwilightForest:huge_gloom");
        this.func_149715_a(0.3125f);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int side, final int meta) {
        return (meta == 10 && side > 1) ? this.stemTex : ((meta >= 1 && meta <= 9 && side == 1) ? this.capTex : ((meta >= 1 && meta <= 3 && side == 2) ? this.capTex : ((meta >= 7 && meta <= 9 && side == 3) ? this.capTex : (((meta == 1 || meta == 4 || meta == 7) && side == 4) ? this.capTex : (((meta == 3 || meta == 6 || meta == 9) && side == 5) ? this.capTex : ((meta == 14) ? this.capTex : ((meta == 15) ? this.stemTex : this.insideTex)))))));
    }
    
    public int func_149745_a(final Random rand) {
        int i = rand.nextInt(10) - 7;
        if (i < 0) {
            i = 0;
        }
        return i;
    }
    
    public Item func_149650_a(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.func_150899_d(Block.func_149682_b(TFBlocks.plant));
    }
    
    @SideOnly(Side.CLIENT)
    public Item func_149694_d(final World p_149694_1_, final int p_149694_2_, final int p_149694_3_, final int p_149694_4_) {
        return Item.func_150899_d(Block.func_149682_b(TFBlocks.plant));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.capTex = iconRegister.func_94245_a(this.func_149641_N() + "_cap");
        this.insideTex = iconRegister.func_94245_a(this.func_149641_N() + "_inside");
        this.stemTex = iconRegister.func_94245_a(this.func_149641_N() + "_stem");
    }
}
