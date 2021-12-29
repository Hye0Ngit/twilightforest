// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFOreMeter extends ItemTF
{
    protected ItemTFOreMeter(final int par1) {
        super(par1);
    }
    
    public boolean a(final kp par1ItemStack, final ih player, final ge world, final int useX, final int useY, final int useZ, final int side) {
        if (!world.F) {
            this.countOreInArea(player, world, useX, useZ, 3);
        }
        return true;
    }
    
    private void countOreInChunk(final ih player, final ge world, final int useX, final int useZ) {
        final int chunkX = useX >> 4;
        final int chunkZ = useZ >> 4;
        final int countStone = this.countBlockInChunk(world, vz.t.bO, chunkX, chunkZ);
        final int countDirt = this.countBlockInChunk(world, vz.v.bO, chunkX, chunkZ);
        final int countGravel = this.countBlockInChunk(world, vz.F.bO, chunkX, chunkZ);
        final int countCoal = this.countBlockInChunk(world, vz.I.bO, chunkX, chunkZ);
        final int countIron = this.countBlockInChunk(world, vz.H.bO, chunkX, chunkZ);
        final int countGold = this.countBlockInChunk(world, vz.G.bO, chunkX, chunkZ);
        final int countDiamond = this.countBlockInChunk(world, vz.aw.bO, chunkX, chunkZ);
        final int countLapis = this.countBlockInChunk(world, vz.N.bO, chunkX, chunkZ);
        final int countRedstone = this.countBlockInChunk(world, vz.aN.bO, chunkX, chunkZ);
        final int total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone;
        player.a("Ore Meter!");
        player.a("Metering chunk  [" + chunkX + ", " + chunkZ + "]");
        player.a("Coal - " + countCoal + " " + this.percent(countCoal, total));
        player.a("Iron - " + countIron + " " + this.percent(countIron, total));
        player.a("Gold - " + countGold + " " + this.percent(countGold, total));
        player.a("Diamond - " + countDiamond + " " + this.percent(countDiamond, total));
        player.a("Lapis - " + countLapis + " " + this.percent(countLapis, total));
        player.a("Redstone - " + countRedstone + " " + this.percent(countRedstone, total));
    }
    
    private void countOreInArea(final ih player, final ge world, final int useX, final int useZ, final int radius) {
        final int chunkX = useX >> 4;
        final int chunkZ = useZ >> 4;
        int countStone = 0;
        int countDirt = 0;
        int countGravel = 0;
        int countCoal = 0;
        int countIron = 0;
        int countGold = 0;
        int countDiamond = 0;
        int countLapis = 0;
        int countRedstone = 0;
        int total = 0;
        for (int cx = chunkX - radius; cx <= chunkX + radius; ++cx) {
            for (int cz = chunkZ - radius; cz <= chunkZ + radius; ++cz) {
                countStone += this.countBlockInChunk(world, vz.t.bO, chunkX, chunkZ);
                countDirt += this.countBlockInChunk(world, vz.v.bO, chunkX, chunkZ);
                countGravel += this.countBlockInChunk(world, vz.F.bO, chunkX, chunkZ);
                countCoal += this.countBlockInChunk(world, vz.I.bO, chunkX, chunkZ);
                countIron += this.countBlockInChunk(world, vz.H.bO, chunkX, chunkZ);
                countGold += this.countBlockInChunk(world, vz.G.bO, chunkX, chunkZ);
                countDiamond += this.countBlockInChunk(world, vz.aw.bO, chunkX, chunkZ);
                countLapis += this.countBlockInChunk(world, vz.N.bO, chunkX, chunkZ);
                countRedstone += this.countBlockInChunk(world, vz.aN.bO, chunkX, chunkZ);
            }
        }
        total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone;
        player.a("Ore Meter!");
        player.a("Metering chunk  [" + chunkX + ", " + chunkZ + "]");
        player.a("Coal - " + countCoal + " " + this.percent(countCoal, total));
        player.a("Iron - " + countIron + " " + this.percent(countIron, total));
        player.a("Gold - " + countGold + " " + this.percent(countGold, total));
        player.a("Diamond - " + countDiamond + " " + this.percent(countDiamond, total));
        player.a("Lapis - " + countLapis + " " + this.percent(countLapis, total));
        player.a("Redstone - " + countRedstone + " " + this.percent(countRedstone, total));
    }
    
    public float percent(final int count, final int total) {
        return count / (float)total * 100.0f;
    }
    
    public int countBlockInChunk(final ge world, final int blockID, final int cx, final int cz) {
        final my chunk = world.d(cx, cz);
        int count = 0;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    if (chunk.a(x, y, z) == blockID) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
}
