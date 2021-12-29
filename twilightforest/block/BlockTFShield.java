// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFShield extends aqw
{
    public static mr sprSide;
    private mr sprInside;
    private mr sprOutside;
    
    public BlockTFShield(final int id) {
        super(id, ajz.e);
        this.b(2000.0f);
        this.r();
        this.a(aqw.l);
        this.a((wv)TFItems.creativeTab);
    }
    
    public mr a(final int side, final int meta) {
        if (side == meta) {
            return this.sprInside;
        }
        return this.sprOutside;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.sprInside = par1IconRegister.a("TwilightForest:shield_inside");
        this.sprOutside = par1IconRegister.a("TwilightForest:shield_outside");
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
    }
    
    public int n() {
        return 0;
    }
    
    public boolean c() {
        return true;
    }
    
    public boolean b() {
        return true;
    }
    
    public int a(final int meta) {
        return 0;
    }
    
    public int a(final Random par1Random) {
        return 0;
    }
    
    public void a(final abv par1World, final int par2, final int par3, final int par4, final oe par5EntityLiving, final yd par6ItemStack) {
        final int l = asq.a(par1World, par2, par3, par4, par5EntityLiving);
        par1World.b(par2, par3, par4, l, 2);
    }
    
    public float a(final ue player, final abv world, final int x, final int y, final int z) {
        final asx mop = this.getPlayerPointVec(world, player, 6.0);
        final int facing = (mop != null) ? mop.e : -1;
        final int meta = world.h(x, y, z);
        if (facing == meta) {
            return player.getCurrentPlayerStrVsBlock(aqw.y, false, 0) / 1.5f / 100.0f;
        }
        return super.a(player, world, x, y, z);
    }
    
    private asx getPlayerPointVec(final abv worldObj, final ue player, final double range) {
        final asz position = worldObj.V().a(player.u, player.v + player.f(), player.w);
        final asz look = player.j(1.0f);
        final asz dest = position.c(look.c * range, look.d * range, look.e * range);
        return worldObj.a(position, dest);
    }
}
