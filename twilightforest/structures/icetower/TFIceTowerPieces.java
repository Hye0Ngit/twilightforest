// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import twilightforest.structures.start.StructureStartAuroraPalace;

public class TFIceTowerPieces
{
    public static void registerPieces() {
        MapGenStructureIO.func_143034_b((Class)StructureStartAuroraPalace.class, "TFAP");
        MapGenStructureIO.func_143031_a((Class)ComponentTFIceTowerMain.class, "TFITMai");
        MapGenStructureIO.func_143031_a((Class)ComponentTFIceTowerWing.class, "TFITWin");
        MapGenStructureIO.func_143031_a((Class)ComponentTFIceTowerRoof.class, "TFITRoof");
        MapGenStructureIO.func_143031_a((Class)ComponentTFIceTowerBeard.class, "TFITBea");
        MapGenStructureIO.func_143031_a((Class)ComponentTFIceTowerBossWing.class, "TFITBoss");
        MapGenStructureIO.func_143031_a((Class)ComponentTFIceTowerEntrance.class, "TFITEnt");
        MapGenStructureIO.func_143031_a((Class)ComponentTFIceTowerBridge.class, "TFITBri");
        MapGenStructureIO.func_143031_a((Class)ComponentTFIceTowerStairs.class, "TFITSt");
    }
}
