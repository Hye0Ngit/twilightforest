// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.TFTreasure;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFTrollVault extends StructureTFComponent
{
    public ComponentTFTrollVault() {
    }
    
    public ComponentTFTrollVault(final int index, int x, int y, int z) {
        super(index);
        this.setCoordBaseMode(0);
        x = x >> 2 << 2;
        y = y / 4 * 4;
        z = z >> 2 << 2;
        this.spawnListIndex = -1;
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 12, 12, 12, 0);
    }
    
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_151556_a(world, sbb, 0, 0, 0, 11, 11, 11, TFBlocks.giantObsidian, 0, TFBlocks.giantObsidian, 0, false);
        this.func_74878_a(world, sbb, 4, 4, 4, 7, 7, 7);
        this.func_151556_a(world, sbb, 5, 5, 5, 6, 5, 6, Blocks.field_150347_e, 0, Blocks.field_150347_e, 0, false);
        this.func_151550_a(world, (Block)Blocks.field_150486_ae, 0, 5, 6, 5, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 5, 6, 6, TFTreasure.troll_vault, false, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 6, 6, 5, TFTreasure.troll_garden, true, sbb);
        this.func_151550_a(world, Blocks.field_150447_bR, 0, 6, 6, 6, sbb);
        return true;
    }
}
