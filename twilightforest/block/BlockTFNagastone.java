// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import java.util.List;
import net.minecraft.util.MathHelper;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import twilightforest.TwilightForestMod;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;

public class BlockTFNagastone extends Block
{
    private static Icon FACE_LEFT;
    private static Icon FACE_RIGHT;
    private static Icon CROSS_SECTION;
    private static Icon FACE_FRONT;
    private static Icon TOP_TIP;
    private static Icon TOP_LONG;
    private static Icon BOTTOM_TIP;
    private static Icon BOTTOM_LONG;
    private static Icon LEFT_DOWN;
    private static Icon RIGHT_DOWN;
    private static Icon LEFT_UP;
    private static Icon RIGHT_UP;
    private static Icon TIP_LEFT;
    private static Icon LONG_SIDE;
    private static Icon TIP_RIGHT;
    private static Icon TURN_TOP;
    
    public BlockTFNagastone(final int par1) {
        super(par1, Material.field_76246_e);
        this.func_71848_c(1.5f);
        this.func_71894_b(10.0f);
        this.func_71884_a(BlockTFNagastone.field_71976_h);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_71857_b() {
        return TwilightForestMod.proxy.getNagastoneBlockRenderID();
    }
    
    public void func_71860_a(final World par1World, final int x, final int y, final int z, final EntityLiving par5EntityLiving, final ItemStack par6ItemStack) {
        int metadata = par1World.func_72805_g(x, y, z) & 0xC;
        int direction = 0;
        if (metadata > 0 && this.placePerfectFitBody(par1World, x, y, z)) {
            return;
        }
        if (metadata == 0 && this.placePerfectFitHead(par1World, x, y, z)) {
            return;
        }
        final int pistonOrient = BlockPistonBase.func_72116_b(par1World, x, y, z, (EntityLiving)par5EntityLiving);
        switch (pistonOrient) {
            case 0:
            case 1: {
                direction = 2;
                break;
            }
            case 2:
            case 3: {
                direction = 1;
                break;
            }
            case 4:
            case 5: {
                direction = 0;
                break;
            }
        }
        if (metadata > 0 && (direction == 0 || direction == 1) && par1World.func_72798_a(x, y - 1, z) == this.field_71990_ca) {
            metadata = 4;
        }
        if (metadata > 0 && (direction == 0 || direction == 1) && par1World.func_72798_a(x, y + 1, z) == this.field_71990_ca) {
            metadata = 8;
        }
        if (metadata == 0 || metadata == 4 || metadata == 8) {
            direction = determineOrientation(par1World, x, y, z, (EntityPlayer)par5EntityLiving);
        }
        if (metadata > 0 && direction == 2) {
            final int connect = this.getOnlyNSEWConnection(par1World, x, y, z);
            if (connect != -1) {
                metadata = ((pistonOrient == 0) ? 4 : 8);
                direction = connect;
            }
        }
        if (metadata == 12) {
            final int connect = this.getOnlyConnection(par1World, x, y, z);
            if (connect != -1) {
                switch (connect) {
                    case 0:
                    case 1: {
                        direction = 1;
                        break;
                    }
                    case 2:
                    case 3: {
                        direction = 0;
                        break;
                    }
                    case 4:
                    case 5: {
                        direction = 2;
                        break;
                    }
                }
            }
        }
        par1World.func_72921_c(x, y, z, metadata | direction, 3);
    }
    
    public void func_71863_a(final World par1World, final int x, final int y, final int z, final int neighborID) {
        final int type = par1World.func_72805_g(x, y, z) & 0xC;
        if (type == 0) {
            this.placePerfectFitHead(par1World, x, y, z);
        }
        else {
            this.placePerfectFitBody(par1World, x, y, z);
        }
    }
    
    public boolean placePerfectFitBody(final World world, final int x, final int y, final int z) {
        final int firstConnection = this.getPosibleConnection(world, x, y, z, -1, -1);
        final int secondConnection = this.getPosibleConnection(world, x, y, z, firstConnection, -1);
        if (firstConnection == -1 || secondConnection == -1) {
            return false;
        }
        if (this.getPosibleConnection(world, x, y, z, firstConnection, secondConnection) != -1) {
            return false;
        }
        if ((firstConnection == 2 && secondConnection == 3) || (firstConnection == 3 && secondConnection == 2)) {
            world.func_72921_c(x, y, z, 12, 3);
            return true;
        }
        if (firstConnection + secondConnection == 1) {
            world.func_72921_c(x, y, z, 13, 3);
            return true;
        }
        if (firstConnection + secondConnection == 9) {
            world.func_72921_c(x, y, z, 14, 3);
            return true;
        }
        if (firstConnection == 4) {
            world.func_72921_c(x, y, z, 0x4 | secondConnection, 3);
            return true;
        }
        if (firstConnection == 5) {
            world.func_72921_c(x, y, z, 0x8 | secondConnection, 3);
            return true;
        }
        if (secondConnection == 4) {
            world.func_72921_c(x, y, z, 0x4 | firstConnection, 3);
            return true;
        }
        if (secondConnection == 5) {
            world.func_72921_c(x, y, z, 0x8 | firstConnection, 3);
            return true;
        }
        world.func_72921_c(x, y, z, 15, 3);
        return true;
    }
    
    public boolean placePerfectFitHead(final World world, final int x, final int y, final int z) {
        final int connect = this.getOnlyNSEWConnection(world, x, y, z);
        if (connect == -1) {
            return false;
        }
        switch (connect) {
            case 0: {
                world.func_72832_d(x, y, z, this.field_71990_ca, 1, 3);
                return true;
            }
            case 1: {
                world.func_72832_d(x, y, z, this.field_71990_ca, 0, 3);
                return true;
            }
            case 2: {
                world.func_72832_d(x, y, z, this.field_71990_ca, 3, 3);
                return true;
            }
            case 3: {
                world.func_72832_d(x, y, z, this.field_71990_ca, 2, 3);
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public int getOnlyNSEWConnection(final World world, final int x, final int y, final int z) {
        final int firstConnection = this.getPosibleConnection(world, x, y, z, -1, -1);
        final int secondConnection = this.getPosibleConnection(world, x, y, z, firstConnection, -1);
        if (firstConnection > 0 && firstConnection < 4 && (secondConnection < 0 || secondConnection > 3)) {
            return firstConnection;
        }
        return -1;
    }
    
    public int getOnlyConnection(final World world, final int x, final int y, final int z) {
        final int firstConnection = this.getPosibleConnection(world, x, y, z, -1, -1);
        final int secondConnection = this.getPosibleConnection(world, x, y, z, firstConnection, -1);
        if (firstConnection > 0 && firstConnection < 6 && secondConnection == -1) {
            return firstConnection;
        }
        return -1;
    }
    
    public int getPosibleConnection(final World world, final int x, final int y, final int z, final int exclude1, final int exclude2) {
        for (int i = 0; i < 6; ++i) {
            if (i != exclude1 && i != exclude2 && this.isNagaStoneInDirection(world, x, y, z, i)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isNagaStoneInDirection(final World par1World, final int x, final int y, final int z, final int direction) {
        switch (direction) {
            case 0: {
                return par1World.func_72798_a(x, y, z - 1) == this.field_71990_ca;
            }
            case 1: {
                return par1World.func_72798_a(x, y, z + 1) == this.field_71990_ca;
            }
            case 2: {
                return par1World.func_72798_a(x - 1, y, z) == this.field_71990_ca;
            }
            case 3: {
                return par1World.func_72798_a(x + 1, y, z) == this.field_71990_ca;
            }
            case 4: {
                return par1World.func_72798_a(x, y - 1, z) == this.field_71990_ca;
            }
            case 5: {
                return par1World.func_72798_a(x, y + 1, z) == this.field_71990_ca;
            }
            default: {
                return false;
            }
        }
    }
    
    public static int determineOrientation(final World par0World, final int par1, final int par2, final int par3, final EntityPlayer par4EntityPlayer) {
        final int rot = MathHelper.func_76128_c(par4EntityPlayer.field_70177_z * 4.0f / 360.0f + 0.5) & 0x3;
        return (rot == 0) ? 0 : ((rot == 1) ? 3 : ((rot == 2) ? 1 : ((rot == 3) ? 2 : 0)));
    }
    
    public Icon func_71858_a(final int side, final int meta) {
        final int type = meta & 0xC;
        final int orient = meta & 0x3;
        if (type == 0) {
            if (orient == 0) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_TIP;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_TIP;
                    }
                    case 2: {
                        return BlockTFNagastone.FACE_FRONT;
                    }
                    case 3: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 4: {
                        return BlockTFNagastone.FACE_LEFT;
                    }
                    case 5: {
                        return BlockTFNagastone.FACE_RIGHT;
                    }
                }
            }
            else if (orient == 1) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_TIP;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_TIP;
                    }
                    case 2: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 3: {
                        return BlockTFNagastone.FACE_FRONT;
                    }
                    case 4: {
                        return BlockTFNagastone.FACE_RIGHT;
                    }
                    case 5: {
                        return BlockTFNagastone.FACE_LEFT;
                    }
                }
            }
            else if (orient == 2) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_TIP;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_TIP;
                    }
                    case 2: {
                        return BlockTFNagastone.FACE_RIGHT;
                    }
                    case 3: {
                        return BlockTFNagastone.FACE_LEFT;
                    }
                    case 4: {
                        return BlockTFNagastone.FACE_FRONT;
                    }
                    case 5: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                }
            }
            else if (orient == 3) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_TIP;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_TIP;
                    }
                    case 2: {
                        return BlockTFNagastone.FACE_LEFT;
                    }
                    case 3: {
                        return BlockTFNagastone.FACE_RIGHT;
                    }
                    case 4: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 5: {
                        return BlockTFNagastone.FACE_FRONT;
                    }
                }
            }
        }
        if (type == 4) {
            if (orient == 0) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_TIP;
                    }
                    case 2: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 3: {
                        return BlockTFNagastone.TIP_RIGHT;
                    }
                    case 4: {
                        return BlockTFNagastone.LEFT_DOWN;
                    }
                    case 5: {
                        return BlockTFNagastone.RIGHT_DOWN;
                    }
                }
            }
            else if (orient == 1) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_TIP;
                    }
                    case 2: {
                        return BlockTFNagastone.TIP_LEFT;
                    }
                    case 3: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 4: {
                        return BlockTFNagastone.RIGHT_DOWN;
                    }
                    case 5: {
                        return BlockTFNagastone.LEFT_DOWN;
                    }
                }
            }
            else if (orient == 2) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_TIP;
                    }
                    case 2: {
                        return BlockTFNagastone.RIGHT_DOWN;
                    }
                    case 3: {
                        return BlockTFNagastone.LEFT_DOWN;
                    }
                    case 4: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 5: {
                        return BlockTFNagastone.TIP_LEFT;
                    }
                }
            }
            else if (orient == 3) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_TIP;
                    }
                    case 2: {
                        return BlockTFNagastone.LEFT_DOWN;
                    }
                    case 3: {
                        return BlockTFNagastone.RIGHT_DOWN;
                    }
                    case 4: {
                        return BlockTFNagastone.TIP_RIGHT;
                    }
                    case 5: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                }
            }
        }
        if (type == 8) {
            if (orient == 0) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_TIP;
                    }
                    case 1: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 2: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 3: {
                        return BlockTFNagastone.TIP_LEFT;
                    }
                    case 4: {
                        return BlockTFNagastone.LEFT_UP;
                    }
                    case 5: {
                        return BlockTFNagastone.RIGHT_UP;
                    }
                }
            }
            else if (orient == 1) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_TIP;
                    }
                    case 1: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 2: {
                        return BlockTFNagastone.TIP_RIGHT;
                    }
                    case 3: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 4: {
                        return BlockTFNagastone.RIGHT_UP;
                    }
                    case 5: {
                        return BlockTFNagastone.LEFT_UP;
                    }
                }
            }
            else if (orient == 2) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_TIP;
                    }
                    case 1: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 2: {
                        return BlockTFNagastone.RIGHT_UP;
                    }
                    case 3: {
                        return BlockTFNagastone.LEFT_UP;
                    }
                    case 4: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 5: {
                        return BlockTFNagastone.TIP_LEFT;
                    }
                }
            }
            else if (orient == 3) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_TIP;
                    }
                    case 1: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 2: {
                        return BlockTFNagastone.LEFT_UP;
                    }
                    case 3: {
                        return BlockTFNagastone.RIGHT_UP;
                    }
                    case 4: {
                        return BlockTFNagastone.TIP_LEFT;
                    }
                    case 5: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                }
            }
        }
        if (type == 12) {
            if (orient == 0) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_LONG;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_LONG;
                    }
                    case 2: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                    case 3: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                    case 4: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 5: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                }
            }
            else if (orient == 1) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.BOTTOM_LONG;
                    }
                    case 1: {
                        return BlockTFNagastone.TOP_LONG;
                    }
                    case 2: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 3: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 4: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                    case 5: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                }
            }
            else if (orient == 2) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 1: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 2: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                    case 3: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                    case 4: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                    case 5: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                }
            }
            else if (orient == 3) {
                switch (side) {
                    case 0: {
                        return BlockTFNagastone.CROSS_SECTION;
                    }
                    case 1: {
                        return BlockTFNagastone.TURN_TOP;
                    }
                    case 2: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                    case 3: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                    case 4: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                    case 5: {
                        return BlockTFNagastone.LONG_SIDE;
                    }
                }
            }
        }
        return null;
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 13));
    }
    
    public int func_71899_b(final int meta) {
        if (meta < 4) {
            return 1;
        }
        return 13;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFNagastone.FACE_LEFT = par1IconRegister.func_94245_a("twilightforest:nagastone_face_left");
        BlockTFNagastone.FACE_RIGHT = par1IconRegister.func_94245_a("twilightforest:nagastone_face_right");
        BlockTFNagastone.CROSS_SECTION = par1IconRegister.func_94245_a("twilightforest:nagastone_cross_section");
        BlockTFNagastone.FACE_FRONT = par1IconRegister.func_94245_a("twilightforest:nagastone_face_front");
        BlockTFNagastone.TOP_TIP = par1IconRegister.func_94245_a("twilightforest:nagastone_top_tip");
        BlockTFNagastone.TOP_LONG = par1IconRegister.func_94245_a("twilightforest:nagastone_tip_long");
        BlockTFNagastone.BOTTOM_TIP = par1IconRegister.func_94245_a("twilightforest:nagastone_bottom_tip");
        BlockTFNagastone.BOTTOM_LONG = par1IconRegister.func_94245_a("twilightforest:nagastone_bottom_long");
        BlockTFNagastone.LEFT_DOWN = par1IconRegister.func_94245_a("twilightforest:nagastone_left_down");
        BlockTFNagastone.RIGHT_DOWN = par1IconRegister.func_94245_a("twilightforest:nagastone_right_down");
        BlockTFNagastone.LEFT_UP = par1IconRegister.func_94245_a("twilightforest:nagastone_left_up");
        BlockTFNagastone.RIGHT_UP = par1IconRegister.func_94245_a("twilightforest:nagastone_right_up");
        BlockTFNagastone.TIP_LEFT = par1IconRegister.func_94245_a("twilightforest:nagastone_tip_left");
        BlockTFNagastone.LONG_SIDE = par1IconRegister.func_94245_a("twilightforest:nagastone_long_side");
        BlockTFNagastone.TIP_RIGHT = par1IconRegister.func_94245_a("twilightforest:nagastone_tip_right");
        BlockTFNagastone.TURN_TOP = par1IconRegister.func_94245_a("twilightforest:nagastone_turn_top");
    }
}
