// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;

public class BlockTFNagastone extends amq
{
    private static final int FACE_LEFT = 64;
    private static final int FACE_RIGHT = 65;
    private static final int CROSS_SECTION = 66;
    private static final int FACE_FRONT = 67;
    private static final int TOP_TIP = 68;
    private static final int TOP_LONG = 69;
    private static final int BOTTOM_TIP = 70;
    private static final int BOTTOM_LONG = 71;
    private static final int LEFT_DOWN = 72;
    private static final int RIGHT_DOWN = 73;
    private static final int LEFT_UP = 74;
    private static final int RIGHT_UP = 75;
    private static final int TIP_LEFT = 76;
    private static final int LONG_SIDE = 77;
    private static final int TIP_RIGHT = 78;
    private static final int TURN_TOP = 79;
    
    public BlockTFNagastone(final int par1) {
        super(par1, agi.e);
        this.cl = 77;
        this.c(1.5f);
        this.b(10.0f);
        this.a(BlockTFNagastone.h);
        this.a((tj)TFItems.creativeTab);
    }
    
    public int d() {
        return TwilightForestMod.proxy.getNagastoneBlockRenderID();
    }
    
    public void a(final yc par1World, final int x, final int y, final int z, final md par5EntityLiving) {
        int type = par1World.h(x, y, z) & 0xC;
        int direction = 0;
        if (type > 0 && this.placePerfectFitBody(par1World, x, y, z)) {
            return;
        }
        if (type == 0 && this.placePerfectFitHead(par1World, x, y, z)) {
            return;
        }
        final int pistonOrient = aoa.b(par1World, x, y, z, (qx)par5EntityLiving);
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
        if (type > 0 && (direction == 0 || direction == 1) && par1World.a(x, y - 1, z) == this.cm) {
            type = 4;
        }
        if (type > 0 && (direction == 0 || direction == 1) && par1World.a(x, y + 1, z) == this.cm) {
            type = 8;
        }
        if (type == 0 || type == 4 || type == 8) {
            direction = determineOrientation(par1World, x, y, z, (qx)par5EntityLiving);
        }
        if (type > 0 && direction == 2) {
            final int connect = this.getOnlyNSEWConnection(par1World, x, y, z);
            if (connect != -1) {
                type = ((pistonOrient == 0) ? 4 : 8);
                direction = connect;
            }
        }
        if (type == 12) {
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
        par1World.c(x, y, z, type | direction);
    }
    
    public void a(final yc par1World, final int x, final int y, final int z, final int neighborID) {
        if (neighborID == this.cm) {
            final int type = par1World.h(x, y, z) & 0xC;
            if (type == 0) {
                this.placePerfectFitHead(par1World, x, y, z);
            }
            else {
                this.placePerfectFitBody(par1World, x, y, z);
            }
        }
    }
    
    public boolean placePerfectFitBody(final yc world, final int x, final int y, final int z) {
        final int firstConnection = this.getPosibleConnection(world, x, y, z, -1, -1);
        final int secondConnection = this.getPosibleConnection(world, x, y, z, firstConnection, -1);
        if (firstConnection == -1 || secondConnection == -1) {
            return false;
        }
        if (this.getPosibleConnection(world, x, y, z, firstConnection, secondConnection) != -1) {
            return false;
        }
        if ((firstConnection == 2 && secondConnection == 3) || (firstConnection == 3 && secondConnection == 2)) {
            world.d(x, y, z, this.cm, 12);
            return true;
        }
        if (firstConnection + secondConnection == 1) {
            world.d(x, y, z, this.cm, 13);
            return true;
        }
        if (firstConnection + secondConnection == 9) {
            world.d(x, y, z, this.cm, 14);
            return true;
        }
        if (firstConnection == 4) {
            world.d(x, y, z, this.cm, 0x4 | secondConnection);
            return true;
        }
        if (firstConnection == 5) {
            world.d(x, y, z, this.cm, 0x8 | secondConnection);
            return true;
        }
        if (secondConnection == 4) {
            world.d(x, y, z, this.cm, 0x4 | firstConnection);
            return true;
        }
        if (secondConnection == 5) {
            world.d(x, y, z, this.cm, 0x8 | firstConnection);
            return true;
        }
        world.d(x, y, z, this.cm, 15);
        return true;
    }
    
    public boolean placePerfectFitHead(final yc world, final int x, final int y, final int z) {
        final int connect = this.getOnlyNSEWConnection(world, x, y, z);
        if (connect == -1) {
            return false;
        }
        switch (connect) {
            case 0: {
                world.d(x, y, z, this.cm, 1);
                return true;
            }
            case 1: {
                world.d(x, y, z, this.cm, 0);
                return true;
            }
            case 2: {
                world.d(x, y, z, this.cm, 3);
                return true;
            }
            case 3: {
                world.d(x, y, z, this.cm, 2);
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public int getOnlyNSEWConnection(final yc world, final int x, final int y, final int z) {
        final int firstConnection = this.getPosibleConnection(world, x, y, z, -1, -1);
        final int secondConnection = this.getPosibleConnection(world, x, y, z, firstConnection, -1);
        if (firstConnection > 0 && firstConnection < 4 && (secondConnection < 0 || secondConnection > 3)) {
            return firstConnection;
        }
        return -1;
    }
    
    public int getOnlyConnection(final yc world, final int x, final int y, final int z) {
        final int firstConnection = this.getPosibleConnection(world, x, y, z, -1, -1);
        final int secondConnection = this.getPosibleConnection(world, x, y, z, firstConnection, -1);
        if (firstConnection > 0 && firstConnection < 6 && secondConnection == -1) {
            return firstConnection;
        }
        return -1;
    }
    
    public int getPosibleConnection(final yc world, final int x, final int y, final int z, final int exclude1, final int exclude2) {
        for (int i = 0; i < 6; ++i) {
            if (i != exclude1 && i != exclude2 && this.isNagaStoneInDirection(world, x, y, z, i)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isNagaStoneInDirection(final yc par1World, final int x, final int y, final int z, final int direction) {
        switch (direction) {
            case 0: {
                return par1World.a(x, y, z - 1) == this.cm;
            }
            case 1: {
                return par1World.a(x, y, z + 1) == this.cm;
            }
            case 2: {
                return par1World.a(x - 1, y, z) == this.cm;
            }
            case 3: {
                return par1World.a(x + 1, y, z) == this.cm;
            }
            case 4: {
                return par1World.a(x, y - 1, z) == this.cm;
            }
            case 5: {
                return par1World.a(x, y + 1, z) == this.cm;
            }
            default: {
                return false;
            }
        }
    }
    
    public static int determineOrientation(final yc par0World, final int par1, final int par2, final int par3, final qx par4EntityPlayer) {
        final int rot = ke.c(par4EntityPlayer.z * 4.0f / 360.0f + 0.5) & 0x3;
        return (rot == 0) ? 0 : ((rot == 1) ? 3 : ((rot == 2) ? 1 : ((rot == 3) ? 2 : 0)));
    }
    
    public int a(final int side, final int meta) {
        final int type = meta & 0xC;
        final int orient = meta & 0x3;
        if (type == 0) {
            if (orient == 0) {
                switch (side) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 68;
                    }
                    case 2: {
                        return 67;
                    }
                    case 3: {
                        return 66;
                    }
                    case 4: {
                        return 64;
                    }
                    case 5: {
                        return 65;
                    }
                }
            }
            else if (orient == 1) {
                switch (side) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 68;
                    }
                    case 2: {
                        return 66;
                    }
                    case 3: {
                        return 67;
                    }
                    case 4: {
                        return 65;
                    }
                    case 5: {
                        return 64;
                    }
                }
            }
            else if (orient == 2) {
                switch (side) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 68;
                    }
                    case 2: {
                        return 65;
                    }
                    case 3: {
                        return 64;
                    }
                    case 4: {
                        return 67;
                    }
                    case 5: {
                        return 66;
                    }
                }
            }
            else if (orient == 3) {
                switch (side) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 68;
                    }
                    case 2: {
                        return 64;
                    }
                    case 3: {
                        return 65;
                    }
                    case 4: {
                        return 66;
                    }
                    case 5: {
                        return 67;
                    }
                }
            }
        }
        if (type == 4) {
            if (orient == 0) {
                switch (side) {
                    case 0: {
                        return 66;
                    }
                    case 1: {
                        return 68;
                    }
                    case 2: {
                        return 66;
                    }
                    case 3: {
                        return 78;
                    }
                    case 4: {
                        return 72;
                    }
                    case 5: {
                        return 73;
                    }
                }
            }
            else if (orient == 1) {
                switch (side) {
                    case 0: {
                        return 66;
                    }
                    case 1: {
                        return 68;
                    }
                    case 2: {
                        return 76;
                    }
                    case 3: {
                        return 66;
                    }
                    case 4: {
                        return 73;
                    }
                    case 5: {
                        return 72;
                    }
                }
            }
            else if (orient == 2) {
                switch (side) {
                    case 0: {
                        return 66;
                    }
                    case 1: {
                        return 68;
                    }
                    case 2: {
                        return 73;
                    }
                    case 3: {
                        return 72;
                    }
                    case 4: {
                        return 66;
                    }
                    case 5: {
                        return 76;
                    }
                }
            }
            else if (orient == 3) {
                switch (side) {
                    case 0: {
                        return 66;
                    }
                    case 1: {
                        return 68;
                    }
                    case 2: {
                        return 72;
                    }
                    case 3: {
                        return 73;
                    }
                    case 4: {
                        return 78;
                    }
                    case 5: {
                        return 66;
                    }
                }
            }
        }
        if (type == 8) {
            if (orient == 0) {
                switch (side) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 66;
                    }
                    case 2: {
                        return 66;
                    }
                    case 3: {
                        return 76;
                    }
                    case 4: {
                        return 74;
                    }
                    case 5: {
                        return 75;
                    }
                }
            }
            else if (orient == 1) {
                switch (side) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 66;
                    }
                    case 2: {
                        return 78;
                    }
                    case 3: {
                        return 66;
                    }
                    case 4: {
                        return 75;
                    }
                    case 5: {
                        return 74;
                    }
                }
            }
            else if (orient == 2) {
                switch (side) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 66;
                    }
                    case 2: {
                        return 75;
                    }
                    case 3: {
                        return 74;
                    }
                    case 4: {
                        return 66;
                    }
                    case 5: {
                        return 76;
                    }
                }
            }
            else if (orient == 3) {
                switch (side) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 66;
                    }
                    case 2: {
                        return 74;
                    }
                    case 3: {
                        return 75;
                    }
                    case 4: {
                        return 76;
                    }
                    case 5: {
                        return 66;
                    }
                }
            }
        }
        if (type == 12) {
            if (orient == 0) {
                switch (side) {
                    case 0: {
                        return 71;
                    }
                    case 1: {
                        return 69;
                    }
                    case 2: {
                        return 77;
                    }
                    case 3: {
                        return 77;
                    }
                    case 4: {
                        return 66;
                    }
                    case 5: {
                        return 66;
                    }
                }
            }
            else if (orient == 1) {
                switch (side) {
                    case 0: {
                        return 71;
                    }
                    case 1: {
                        return 69;
                    }
                    case 2: {
                        return 66;
                    }
                    case 3: {
                        return 66;
                    }
                    case 4: {
                        return 77;
                    }
                    case 5: {
                        return 77;
                    }
                }
            }
            else if (orient == 2) {
                switch (side) {
                    case 0: {
                        return 66;
                    }
                    case 1: {
                        return 66;
                    }
                    case 2: {
                        return 77;
                    }
                    case 3: {
                        return 77;
                    }
                    case 4: {
                        return 77;
                    }
                    case 5: {
                        return 77;
                    }
                }
            }
            else if (orient == 3) {
                switch (side) {
                    case 0: {
                        return 66;
                    }
                    case 1: {
                        return 79;
                    }
                    case 2: {
                        return 77;
                    }
                    case 3: {
                        return 77;
                    }
                    case 4: {
                        return 77;
                    }
                    case 5: {
                        return 77;
                    }
                }
            }
        }
        return 0;
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur(par1, 1, 1));
        par3List.add(new ur(par1, 1, 13));
    }
    
    public int b(final int meta) {
        if (meta < 4) {
            return 1;
        }
        return 13;
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
