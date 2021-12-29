// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Iterator;
import java.util.ArrayList;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import twilightforest.structures.start.StructureStartKnightStronghold;
import java.util.List;

public class TFStrongholdPieces
{
    private static final TFStrongholdPieceWeight[] pieceWeightArray;
    private List<TFStrongholdPieceWeight> pieceList;
    static int totalWeight;
    private static TFStrongholdPieceWeight lastPieceMade;
    
    public static void registerPieces() {
        MapGenStructureIO.func_143034_b((Class)StructureStartKnightStronghold.class, "TFKSt");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdSmallHallway.class, "TFSSH");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdLeftTurn.class, "TFSLT");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdCrossing.class, "TFSCr");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdRightTurn.class, "TFSRT");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdDeadEnd.class, "TFSDE");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdBalconyRoom.class, "TFSBR");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdTrainingRoom.class, "TFSTR");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdSmallStairs.class, "TFSSS");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdTreasureCorridor.class, "TFSTC");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdAtrium.class, "TFSAt");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdFoundry.class, "TFSFo");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdTreasureRoom.class, "TFTreaR");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdBossRoom.class, "TFSBR");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdAccessChamber.class, "TFSAC");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdEntrance.class, "TFSEnter");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdUpperAscender.class, "TFSUA");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdUpperLeftTurn.class, "TFSULT");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdUpperRightTurn.class, "TFSURT");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdUpperCorridor.class, "TFSUCo");
        MapGenStructureIO.func_143031_a((Class)ComponentTFStrongholdUpperTIntersection.class, "TFSUTI");
        MapGenStructureIO.func_143031_a((Class)StructureTFStrongholdShield.class, "TFSShield");
    }
    
    public void prepareStructurePieces() {
        this.pieceList = new ArrayList<TFStrongholdPieceWeight>();
        for (final TFStrongholdPieceWeight piece : TFStrongholdPieces.pieceWeightArray) {
            piece.instancesSpawned = 0;
            this.pieceList.add(piece);
        }
    }
    
    public void markBossRoomUsed() {
        this.pieceList.remove(this.pieceList.size() - 1);
    }
    
    private boolean hasMoreLimitedPieces() {
        boolean flag = false;
        TFStrongholdPieces.totalWeight = 0;
        for (final TFStrongholdPieceWeight piece : this.pieceList) {
            TFStrongholdPieces.totalWeight += piece.pieceWeight;
            if (piece.instancesLimit > 0 && piece.instancesSpawned < piece.instancesLimit) {
                flag = true;
            }
        }
        return flag;
    }
    
    public StructureTFStrongholdComponent getNextComponent(final StructureComponent parent, final List<StructureComponent> list, final Random random, final TFFeature feature, final int index, final EnumFacing facing, final int x, final int y, final int z) {
        if (!this.hasMoreLimitedPieces()) {
            return null;
        }
        for (int i = 0; i < 5; ++i) {
            int counter = random.nextInt(TFStrongholdPieces.totalWeight);
            for (final TFStrongholdPieceWeight piece : this.pieceList) {
                counter -= piece.pieceWeight;
                if (counter < 0) {
                    if (!piece.isDeepEnough(index)) {
                        break;
                    }
                    if (piece == TFStrongholdPieces.lastPieceMade) {
                        break;
                    }
                    final StructureTFStrongholdComponent component = (StructureTFStrongholdComponent)piece.factory.newInstance(feature, index, facing, x, y, z);
                    if (StructureComponent.func_74883_a((List)list, component.func_74874_b()) == null) {
                        final TFStrongholdPieceWeight tfStrongholdPieceWeight = piece;
                        ++tfStrongholdPieceWeight.instancesSpawned;
                        if (!piece.canSpawnMoreStructures()) {
                            this.pieceList.remove(piece);
                        }
                        TFStrongholdPieces.lastPieceMade = piece;
                        return component;
                    }
                    continue;
                }
            }
        }
        final StructureTFStrongholdComponent deadEnd = new ComponentTFStrongholdDeadEnd((parent instanceof StructureTFComponentOld) ? ((StructureTFComponentOld)parent).getFeatureType() : TFFeature.NOTHING, index, facing, x, y, z);
        if (StructureComponent.func_74883_a((List)list, deadEnd.func_74874_b()) == null) {
            return deadEnd;
        }
        return null;
    }
    
    static {
        pieceWeightArray = new TFStrongholdPieceWeight[] { new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdSmallHallway::new, 40, 0), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdLeftTurn::new, 20, 0), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdCrossing::new, 10, 4), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdRightTurn::new, 20, 0), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdDeadEnd::new, 5, 0), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdBalconyRoom::new, 10, 3, 2), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdTrainingRoom::new, 10, 2), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdSmallStairs::new, 10, 0), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdTreasureCorridor::new, 5, 0), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdAtrium::new, 5, 2, 3), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdFoundry::new, 5, 1, 4), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdTreasureRoom::new, 5, 1, 4), new TFStrongholdPieceWeight((StructureTFStrongholdComponent.Factory<T>)ComponentTFStrongholdBossRoom::new, 10, 1, 4) };
        TFStrongholdPieces.totalWeight = 0;
    }
}
