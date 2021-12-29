// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import twilightforest.world.components.structures.finalcastle.StructureTFDecoratorCastle;
import twilightforest.world.components.structures.stronghold.StrongholdDecorator;
import twilightforest.world.components.structures.mushroomtower.MushroomTowerDecorator;
import twilightforest.world.components.structures.icetower.IceTowerDecorator;
import twilightforest.world.components.structures.darktower.StructureDecoratorDarkTower;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.block.state.BlockState;

public class TFStructureDecorator
{
    public BlockState blockState;
    public BlockState accentState;
    public BlockState stairState;
    public BlockState fenceState;
    public BlockState pillarState;
    public BlockState platformState;
    public BlockState floorState;
    public BlockState roofState;
    public StructurePiece.BlockSelector randomBlocks;
    
    public TFStructureDecorator() {
        this.blockState = Blocks.f_50069_.m_49966_();
        this.accentState = Blocks.f_50652_.m_49966_();
        this.stairState = Blocks.f_50635_.m_49966_();
        this.fenceState = Blocks.f_50132_.m_49966_();
        this.pillarState = Blocks.f_50222_.m_49966_();
        this.platformState = Blocks.f_50404_.m_49966_();
        this.floorState = Blocks.f_50222_.m_49966_();
        this.roofState = Blocks.f_50222_.m_49966_();
        this.randomBlocks = new StrongholdStones();
    }
    
    public static String getDecoString(final TFStructureDecorator deco) {
        if (deco instanceof StructureDecoratorDarkTower) {
            return "DecoDarkTower";
        }
        if (deco instanceof IceTowerDecorator) {
            return "DecoIceTower";
        }
        if (deco instanceof MushroomTowerDecorator) {
            return "DecoMushroomTower";
        }
        if (deco instanceof StrongholdDecorator) {
            return "DecoStronghold";
        }
        if (deco instanceof StructureTFDecoratorCastle) {
            return "DecoCastle";
        }
        return "";
    }
    
    public static TFStructureDecorator getDecoFor(final String decoString) {
        if (decoString.equals("DecoDarkTower")) {
            return new StructureDecoratorDarkTower();
        }
        if (decoString.equals("DecoIceTower")) {
            return new IceTowerDecorator();
        }
        if (decoString.equals("DecoMushroomTower")) {
            return new MushroomTowerDecorator();
        }
        if (decoString.equals("DecoStronghold")) {
            return new StrongholdDecorator();
        }
        if (decoString.equals("DecoCastle")) {
            return new StructureTFDecoratorCastle();
        }
        return new TFStructureDecorator();
    }
}
