// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import twilightforest.structures.start.StructureStartLichTower;

public class TFLichTowerPieces
{
    public static void registerPieces() {
        MapGenStructureIO.func_143034_b((Class)StructureStartLichTower.class, "TFLT");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerBeard.class, "TFLTBea");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerBeardAttached.class, "TFLTBA");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerBridge.class, "TFLTBri");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerMain.class, "TFLTMai");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerOutbuilding.class, "TFLTOut");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoof.class, "TFLTRoo");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofAttachedSlab.class, "TFLTRAS");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofFence.class, "TFLTRF");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofGableForwards.class, "TFLTRGF");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofPointy.class, "TFLTRP");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofPointyOverhang.class, "TFLTRPO");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofSlab.class, "TFLTRS");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofSlabForwards.class, "TFLTRSF");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofStairs.class, "TFLTRSt");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofStairsOverhang.class, "TFLTRStO");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerWing.class, "TFLTWin");
    }
}
