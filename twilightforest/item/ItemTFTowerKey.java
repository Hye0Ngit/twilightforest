// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.block.BlockTFTowerDevice;
import twilightforest.block.TFBlocks;

public class ItemTFTowerKey extends ItemTF
{
    protected ItemTFTowerKey(final int par1) {
        super(par1);
    }
    
    public boolean a(final yd itemStack, final ue player, final abv world, final int x, final int y, final int z, final int side, final float fx, final float fy, final float fz) {
        if (!world.I && world.a(x, y, z) == TFBlocks.towerDevice.cF && world.h(x, y, z) == 4) {
            BlockTFTowerDevice.unlockBlock(world, x, y, z);
            --itemStack.b;
            return true;
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
