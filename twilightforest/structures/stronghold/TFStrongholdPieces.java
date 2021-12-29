// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class TFStrongholdPieces
{
    private static final TFStrongholdPieceWeight[] pieceWeightArray;
    private List pieceList;
    static int totalWeight;
    private static Class lastPieceMade;
    
    public void prepareStructurePieces() {
        this.pieceList = new ArrayList();
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
    
    public StructureTFStrongholdComponent getNextComponent(final StructureComponent parent, final List list, final Random random, final int index, final int facing, final int x, final int y, final int z) {
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
                    if (piece.pieceClass == TFStrongholdPieces.lastPieceMade) {
                        break;
                    }
                    final StructureTFStrongholdComponent component = instantiateComponent(piece.pieceClass, index, facing, x, y, z);
                    if (StructureComponent.func_74883_a(list, component.func_74874_b()) == null) {
                        final TFStrongholdPieceWeight tfStrongholdPieceWeight = piece;
                        ++tfStrongholdPieceWeight.instancesSpawned;
                        if (!piece.canSpawnMoreStructures()) {
                            this.pieceList.remove(piece);
                        }
                        TFStrongholdPieces.lastPieceMade = piece.pieceClass;
                        return component;
                    }
                    continue;
                }
            }
        }
        final StructureTFStrongholdComponent deadEnd = new ComponentTFStrongholdDeadEnd(index, facing, x, y, z);
        if (StructureComponent.func_74883_a(list, deadEnd.func_74874_b()) == null) {
            return deadEnd;
        }
        return null;
    }
    
    private static StructureTFStrongholdComponent instantiateComponent(final Class pieceClass, final int index, final int facing, final int x, final int y, final int z) {
        try {
            return pieceClass.getConstructor(Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE).newInstance(index, facing, x, y, z);
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        }
        catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        }
        catch (SecurityException e6) {
            e6.printStackTrace();
        }
        return null;
    }
    
    static {
        pieceWeightArray = new TFStrongholdPieceWeight[] { new TFStrongholdPieceWeight(ComponentTFStrongholdSmallHallway.class, 40, 0), new TFStrongholdPieceWeight(ComponentTFStrongholdLeftTurn.class, 20, 0), new TFStrongholdPieceWeight(ComponentTFStrongholdCrossing.class, 10, 4), new TFStrongholdPieceWeight(ComponentTFStrongholdRightTurn.class, 20, 0), new TFStrongholdPieceWeight(ComponentTFStrongholdDeadEnd.class, 5, 0), new TFStrongholdPieceWeight(ComponentTFStrongholdBalconyRoom.class, 10, 3, 2), new TFStrongholdPieceWeight(ComponentTFStrongholdTrainingRoom.class, 10, 2), new TFStrongholdPieceWeight(ComponentTFStrongholdSmallStairs.class, 10, 0), new TFStrongholdPieceWeight(ComponentTFStrongholdTreasureCorridor.class, 5, 0), new TFStrongholdPieceWeight(ComponentTFStrongholdAtrium.class, 5, 2, 3), new TFStrongholdPieceWeight(ComponentTFStrongholdFoundry.class, 5, 1, 4), new TFStrongholdPieceWeight(ComponentTFStrongholdTreasureRoom.class, 5, 1, 4), new TFStrongholdPieceWeight(ComponentTFStrongholdBossRoom.class, 10, 1, 4) };
        TFStrongholdPieces.totalWeight = 0;
    }
}
