// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;

public class BlockTFNagastone extends aqw
{
    private static mr FACE_LEFT;
    private static mr FACE_RIGHT;
    private static mr CROSS_SECTION;
    private static mr FACE_FRONT;
    private static mr TOP_TIP;
    private static mr TOP_LONG;
    private static mr BOTTOM_TIP;
    private static mr BOTTOM_LONG;
    private static mr LEFT_DOWN;
    private static mr RIGHT_DOWN;
    private static mr LEFT_UP;
    private static mr RIGHT_UP;
    private static mr TIP_LEFT;
    private static mr LONG_SIDE;
    private static mr TIP_RIGHT;
    private static mr TURN_TOP;
    
    public BlockTFNagastone(final int par1) {
        super(par1, ajz.e);
        this.c(1.5f);
        this.b(10.0f);
        this.a(BlockTFNagastone.k);
        this.a((wv)TFItems.creativeTab);
    }
    
    public int d() {
        return TwilightForestMod.proxy.getNagastoneBlockRenderID();
    }
    
    public void a(final abv par1World, final int x, final int y, final int z, final oe par5EntityLiving, final yd par6ItemStack) {
        int metadata = par1World.h(x, y, z) & 0xC;
        int direction = 0;
        if (metadata > 0 && this.placePerfectFitBody(par1World, x, y, z)) {
            return;
        }
        if (metadata == 0 && this.placePerfectFitHead(par1World, x, y, z)) {
            return;
        }
        final int pistonOrient = asq.a(par1World, x, y, z, (oe)par5EntityLiving);
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
        if (metadata > 0 && (direction == 0 || direction == 1) && par1World.a(x, y - 1, z) == this.cF) {
            metadata = 4;
        }
        if (metadata > 0 && (direction == 0 || direction == 1) && par1World.a(x, y + 1, z) == this.cF) {
            metadata = 8;
        }
        if (metadata == 0 || metadata == 4 || metadata == 8) {
            direction = determineOrientation(par1World, x, y, z, (ue)par5EntityLiving);
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
        par1World.b(x, y, z, metadata | direction, 3);
    }
    
    public void a(final abv par1World, final int x, final int y, final int z, final int neighborID) {
        final int type = par1World.h(x, y, z) & 0xC;
        if (type == 0) {
            this.placePerfectFitHead(par1World, x, y, z);
        }
        else {
            this.placePerfectFitBody(par1World, x, y, z);
        }
    }
    
    public boolean placePerfectFitBody(final abv world, final int x, final int y, final int z) {
        final int firstConnection = this.getPosibleConnection(world, x, y, z, -1, -1);
        final int secondConnection = this.getPosibleConnection(world, x, y, z, firstConnection, -1);
        if (firstConnection == -1 || secondConnection == -1) {
            return false;
        }
        if (this.getPosibleConnection(world, x, y, z, firstConnection, secondConnection) != -1) {
            return false;
        }
        if ((firstConnection == 2 && secondConnection == 3) || (firstConnection == 3 && secondConnection == 2)) {
            world.b(x, y, z, 12, 3);
            return true;
        }
        if (firstConnection + secondConnection == 1) {
            world.b(x, y, z, 13, 3);
            return true;
        }
        if (firstConnection + secondConnection == 9) {
            world.b(x, y, z, 14, 3);
            return true;
        }
        if (firstConnection == 4) {
            world.b(x, y, z, 0x4 | secondConnection, 3);
            return true;
        }
        if (firstConnection == 5) {
            world.b(x, y, z, 0x8 | secondConnection, 3);
            return true;
        }
        if (secondConnection == 4) {
            world.b(x, y, z, 0x4 | firstConnection, 3);
            return true;
        }
        if (secondConnection == 5) {
            world.b(x, y, z, 0x8 | firstConnection, 3);
            return true;
        }
        world.b(x, y, z, 15, 3);
        return true;
    }
    
    public boolean placePerfectFitHead(final abv world, final int x, final int y, final int z) {
        final int connect = this.getOnlyNSEWConnection(world, x, y, z);
        if (connect == -1) {
            return false;
        }
        switch (connect) {
            case 0: {
                world.f(x, y, z, this.cF, 1, 3);
                return true;
            }
            case 1: {
                world.f(x, y, z, this.cF, 0, 3);
                return true;
            }
            case 2: {
                world.f(x, y, z, this.cF, 3, 3);
                return true;
            }
            case 3: {
                world.f(x, y, z, this.cF, 2, 3);
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public int getOnlyNSEWConnection(final abv world, final int x, final int y, final int z) {
        final int firstConnection = this.getPosibleConnection(world, x, y, z, -1, -1);
        final int secondConnection = this.getPosibleConnection(world, x, y, z, firstConnection, -1);
        if (firstConnection > 0 && firstConnection < 4 && (secondConnection < 0 || secondConnection > 3)) {
            return firstConnection;
        }
        return -1;
    }
    
    public int getOnlyConnection(final abv world, final int x, final int y, final int z) {
        final int firstConnection = this.getPosibleConnection(world, x, y, z, -1, -1);
        final int secondConnection = this.getPosibleConnection(world, x, y, z, firstConnection, -1);
        if (firstConnection > 0 && firstConnection < 6 && secondConnection == -1) {
            return firstConnection;
        }
        return -1;
    }
    
    public int getPosibleConnection(final abv world, final int x, final int y, final int z, final int exclude1, final int exclude2) {
        for (int i = 0; i < 6; ++i) {
            if (i != exclude1 && i != exclude2 && this.isNagaStoneInDirection(world, x, y, z, i)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isNagaStoneInDirection(final abv par1World, final int x, final int y, final int z, final int direction) {
        switch (direction) {
            case 0: {
                return par1World.a(x, y, z - 1) == this.cF;
            }
            case 1: {
                return par1World.a(x, y, z + 1) == this.cF;
            }
            case 2: {
                return par1World.a(x - 1, y, z) == this.cF;
            }
            case 3: {
                return par1World.a(x + 1, y, z) == this.cF;
            }
            case 4: {
                return par1World.a(x, y - 1, z) == this.cF;
            }
            case 5: {
                return par1World.a(x, y + 1, z) == this.cF;
            }
            default: {
                return false;
            }
        }
    }
    
    public static int determineOrientation(final abv par0World, final int par1, final int par2, final int par3, final ue par4EntityPlayer) {
        final int rot = lr.c(par4EntityPlayer.A * 4.0f / 360.0f + 0.5) & 0x3;
        return (rot == 0) ? 0 : ((rot == 1) ? 3 : ((rot == 2) ? 1 : ((rot == 3) ? 2 : 0)));
    }
    
    public mr a(final int side, final int meta) {
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
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 1));
        par3List.add(new yd(par1, 1, 13));
    }
    
    public int a(final int meta) {
        if (meta < 4) {
            return 1;
        }
        return 13;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        BlockTFNagastone.FACE_LEFT = par1IconRegister.a("TwilightForest:nagastone_face_left");
        BlockTFNagastone.FACE_RIGHT = par1IconRegister.a("TwilightForest:nagastone_face_right");
        BlockTFNagastone.CROSS_SECTION = par1IconRegister.a("TwilightForest:nagastone_cross_section");
        BlockTFNagastone.FACE_FRONT = par1IconRegister.a("TwilightForest:nagastone_face_front");
        BlockTFNagastone.TOP_TIP = par1IconRegister.a("TwilightForest:nagastone_top_tip");
        BlockTFNagastone.TOP_LONG = par1IconRegister.a("TwilightForest:nagastone_tip_long");
        BlockTFNagastone.BOTTOM_TIP = par1IconRegister.a("TwilightForest:nagastone_bottom_tip");
        BlockTFNagastone.BOTTOM_LONG = par1IconRegister.a("TwilightForest:nagastone_bottom_long");
        BlockTFNagastone.LEFT_DOWN = par1IconRegister.a("TwilightForest:nagastone_left_down");
        BlockTFNagastone.RIGHT_DOWN = par1IconRegister.a("TwilightForest:nagastone_right_down");
        BlockTFNagastone.LEFT_UP = par1IconRegister.a("TwilightForest:nagastone_left_up");
        BlockTFNagastone.RIGHT_UP = par1IconRegister.a("TwilightForest:nagastone_right_up");
        BlockTFNagastone.TIP_LEFT = par1IconRegister.a("TwilightForest:nagastone_tip_left");
        BlockTFNagastone.LONG_SIDE = par1IconRegister.a("TwilightForest:nagastone_long_side");
        BlockTFNagastone.TIP_RIGHT = par1IconRegister.a("TwilightForest:nagastone_tip_right");
        BlockTFNagastone.TURN_TOP = par1IconRegister.a("TwilightForest:nagastone_turn_top");
    }
}
