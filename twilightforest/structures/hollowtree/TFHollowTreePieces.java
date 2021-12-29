// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.world.gen.structure.MapGenStructureIO;

public class TFHollowTreePieces
{
    public static void registerPieces() {
        MapGenStructureIO.func_143031_a((Class)ComponentTFHollowTreeLargeBranch.class, "TFHTLB");
        MapGenStructureIO.func_143031_a((Class)ComponentTFHollowTreeMedBranch.class, "TFHTMB");
        MapGenStructureIO.func_143031_a((Class)ComponentTFHollowTreeSmallBranch.class, "TFHTSB");
        MapGenStructureIO.func_143031_a((Class)ComponentTFHollowTreeTrunk.class, "TFHTTr");
        MapGenStructureIO.func_143031_a((Class)ComponentTFLeafSphere.class, "TFHTLS");
        MapGenStructureIO.func_143031_a((Class)ComponentTFHollowTreeRoot.class, "TFHTRo");
        MapGenStructureIO.func_143031_a((Class)StructureTFHollowTreeStart.class, "TFHTLSt");
        MapGenStructureIO.func_143031_a((Class)ComponentTFHollowTreeLeafDungeon.class, "TFHTLD");
    }
}
