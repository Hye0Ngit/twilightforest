// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.Rotation;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.util.RotationUtil;
import net.minecraft.world.World;
import twilightforest.block.BlockTFForceField;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.EnumDyeColor;
import twilightforest.block.BlockTFCastleMagic;
import twilightforest.block.TFBlocks;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleBossGazebo extends StructureTFComponentOld
{
    public ComponentTFFinalCastleBossGazebo() {
    }
    
    public ComponentTFFinalCastleBossGazebo(final TFFeature feature, final Random rand, final int i, final StructureTFComponentOld keep) {
        super(feature, i);
        this.spawnListIndex = -1;
        this.func_186164_a(keep.func_186165_e());
        this.field_74887_e = new StructureBoundingBox(keep.func_74874_b().field_78897_a + 14, keep.func_74874_b().field_78894_e + 2, keep.func_74874_b().field_78896_c + 14, keep.func_74874_b().field_78893_d - 14, keep.func_74874_b().field_78894_e + 13, keep.func_74874_b().field_78892_f - 14);
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        this.deco = new StructureTFDecoratorCastle();
        this.deco.blockState = TFBlocks.castle_rune_brick.func_176223_P().func_177226_a((IProperty)BlockTFCastleMagic.COLOR, (Comparable)EnumDyeColor.BLUE);
        this.deco.fenceState = TFBlocks.force_field.func_176223_P().func_177226_a((IProperty)BlockTFForceField.COLOR, (Comparable)EnumDyeColor.PURPLE);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 0, 0, 0, 0, 10, 20, this.deco.fenceState, rotation);
        }
        this.func_175804_a(world, sbb, 0, 11, 0, 20, 11, 20, this.deco.fenceState, this.deco.fenceState, false);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "Final Boss Here", true, 2.3f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "You win!", true, 2.0f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "You can join the Twilight Forest Discord server to follow", true, 1.0f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "the latest updates on this castle and other content at:", true, 0.7f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "discord.experiment115.com", true, 0.4f);
        this.func_175811_a(world, TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.FINAL_BOSS), 10, 1, 10, sbb);
        return true;
    }
}
