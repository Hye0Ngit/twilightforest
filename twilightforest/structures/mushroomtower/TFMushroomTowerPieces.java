// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.world.gen.structure.MapGenStructureIO;

public class TFMushroomTowerPieces
{
    public static void registerPieces() {
        MapGenStructureIO.func_143031_a((Class)ComponentTFMushroomTowerMain.class, "TFMTMai");
        MapGenStructureIO.func_143031_a((Class)ComponentTFMushroomTowerWing.class, "TFMTWin");
        MapGenStructureIO.func_143031_a((Class)ComponentTFMushroomTowerBridge.class, "TFMTBri");
        MapGenStructureIO.func_143031_a((Class)ComponentTFMushroomTowerMainBridge.class, "TFMTMB");
        MapGenStructureIO.func_143031_a((Class)ComponentTFTowerRoofMushroom.class, "TFMTRoofMush");
    }
}
