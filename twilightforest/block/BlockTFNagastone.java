// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import twilightforest.TwilightForestMod;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFNagastone extends Block
{
    private static IIcon FACE_LEFT;
    private static IIcon FACE_RIGHT;
    private static IIcon CROSS_SECTION;
    private static IIcon FACE_FRONT;
    private static IIcon TOP_TIP;
    private static IIcon TOP_LONG;
    private static IIcon BOTTOM_TIP;
    private static IIcon BOTTOM_LONG;
    private static IIcon LEFT_DOWN;
    private static IIcon RIGHT_DOWN;
    private static IIcon LEFT_UP;
    private static IIcon RIGHT_UP;
    private static IIcon TIP_LEFT;
    private static IIcon LONG_SIDE;
    private static IIcon TIP_RIGHT;
    private static IIcon TURN_TOP;
    
    public BlockTFNagastone() {
        super(Material.field_151576_e);
        this.func_149711_c(1.5f);
        this.func_149752_b(10.0f);
        this.func_149672_a(Block.field_149769_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_149645_b() {
        return TwilightForestMod.proxy.getNagastoneBlockRenderID();
    }
    
    public int func_149660_a(final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ, final int metadata) {
        final int type = metadata & 0xC;
        int orient = 0;
        if (type == 0) {
            switch (side) {
                default: {
                    orient = 1;
                    break;
                }
                case 2: {
                    orient = 0;
                    break;
                }
                case 3: {
                    orient = 1;
                    break;
                }
                case 4: {
                    orient = 2;
                    break;
                }
                case 5: {
                    orient = 3;
                    break;
                }
            }
        }
        if (type == 12) {
            switch (side) {
                case 0:
                case 1: {
                    orient = 2;
                    break;
                }
                case 2:
                case 3: {
                    orient = 1;
                    break;
                }
                case 4:
                case 5: {
                    orient = 0;
                    break;
                }
            }
        }
        return type | orient;
    }
    
    public void func_149695_a(final World par1World, final int x, final int y, final int z, final Block neighborID) {
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
                world.func_147465_d(x, y, z, (Block)this, 1, 3);
                return true;
            }
            case 1: {
                world.func_147465_d(x, y, z, (Block)this, 0, 3);
                return true;
            }
            case 2: {
                world.func_147465_d(x, y, z, (Block)this, 3, 3);
                return true;
            }
            case 3: {
                world.func_147465_d(x, y, z, (Block)this, 2, 3);
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
                return par1World.func_147439_a(x, y, z - 1) == this;
            }
            case 1: {
                return par1World.func_147439_a(x, y, z + 1) == this;
            }
            case 2: {
                return par1World.func_147439_a(x - 1, y, z) == this;
            }
            case 3: {
                return par1World.func_147439_a(x + 1, y, z) == this;
            }
            case 4: {
                return par1World.func_147439_a(x, y - 1, z) == this;
            }
            case 5: {
                return par1World.func_147439_a(x, y + 1, z) == this;
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
    
    public IIcon func_149691_a(final int side, final int meta) {
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
                        return BlockTFNagastone.TIP_RIGHT;
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
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 13));
    }
    
    public int func_149692_a(final int meta) {
        return meta;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        BlockTFNagastone.FACE_LEFT = par1IconRegister.func_94245_a("TwilightForest:nagastone_face_left");
        BlockTFNagastone.FACE_RIGHT = par1IconRegister.func_94245_a("TwilightForest:nagastone_face_right");
        BlockTFNagastone.CROSS_SECTION = par1IconRegister.func_94245_a("TwilightForest:nagastone_cross_section");
        BlockTFNagastone.FACE_FRONT = par1IconRegister.func_94245_a("TwilightForest:nagastone_face_front");
        BlockTFNagastone.TOP_TIP = par1IconRegister.func_94245_a("TwilightForest:nagastone_top_tip");
        BlockTFNagastone.TOP_LONG = par1IconRegister.func_94245_a("TwilightForest:nagastone_tip_long");
        BlockTFNagastone.BOTTOM_TIP = par1IconRegister.func_94245_a("TwilightForest:nagastone_bottom_tip");
        BlockTFNagastone.BOTTOM_LONG = par1IconRegister.func_94245_a("TwilightForest:nagastone_bottom_long");
        BlockTFNagastone.LEFT_DOWN = par1IconRegister.func_94245_a("TwilightForest:nagastone_left_down");
        BlockTFNagastone.RIGHT_DOWN = par1IconRegister.func_94245_a("TwilightForest:nagastone_right_down");
        BlockTFNagastone.LEFT_UP = par1IconRegister.func_94245_a("TwilightForest:nagastone_left_up");
        BlockTFNagastone.RIGHT_UP = par1IconRegister.func_94245_a("TwilightForest:nagastone_right_up");
        BlockTFNagastone.TIP_LEFT = par1IconRegister.func_94245_a("TwilightForest:nagastone_tip_left");
        BlockTFNagastone.LONG_SIDE = par1IconRegister.func_94245_a("TwilightForest:nagastone_long_side");
        BlockTFNagastone.TIP_RIGHT = par1IconRegister.func_94245_a("TwilightForest:nagastone_tip_right");
        BlockTFNagastone.TURN_TOP = par1IconRegister.func_94245_a("TwilightForest:nagastone_turn_top");
    }
}
