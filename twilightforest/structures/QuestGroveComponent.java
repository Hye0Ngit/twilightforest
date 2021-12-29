// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import twilightforest.entity.passive.QuestRamEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import twilightforest.util.ColorUtil;
import net.minecraft.tileentity.DispenserTileEntity;
import net.minecraft.block.DispenserBlock;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.Property;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.block.BlockState;

public class QuestGroveComponent extends TFStructureComponentOld
{
    private static final int RADIUS = 13;
    private static final BlockState MOSSY_STONEBRICK;
    private static final BlockState CHISELED_STONEBRICK;
    protected boolean beastPlaced;
    protected boolean dispenserPlaced;
    
    public QuestGroveComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(TFFeature.TFQuest1, nbt);
        this.beastPlaced = false;
        this.dispenserPlaced = false;
    }
    
    public QuestGroveComponent(final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(TFFeature.TFQuest1, feature, i);
        this.beastPlaced = false;
        this.dispenserPlaced = false;
        this.func_186164_a(Direction.SOUTH);
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -13, 0, -13, 26, 10, 26, Direction.SOUTH);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (final Direction e : Direction.Plane.HORIZONTAL) {
            this.makeWallSide(world, e, sbb);
        }
        for (int x = 10; x < 17; ++x) {
            for (int z = 10; z < 17; ++z) {
                if (x == 10 || x == 16 || z == 10 || z == 16) {
                    if (rand.nextInt(2) > 0) {
                        this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, x, -1, z, sbb);
                    }
                }
                else if (x == 11 || x == 15 || z == 11 || z == 15) {
                    if (rand.nextInt(3) > 0) {
                        this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, x, -1, z, sbb);
                    }
                }
                else {
                    this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, x, -1, z, sbb);
                }
            }
        }
        this.func_175811_a(world, (BlockState)((BlockState)Blocks.field_150430_aB.func_176223_P().func_206870_a((Property)HorizontalFaceBlock.field_196366_M, (Comparable)AttachFace.WALL)).func_206870_a((Property)HorizontalBlock.field_185512_D, (Comparable)Direction.SOUTH), 13, 5, 19, sbb);
        this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, 12, 7, 20, sbb);
        this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, 13, 7, 20, sbb);
        this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, 14, 7, 20, sbb);
        this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, 12, 7, 21, sbb);
        this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, 13, 7, 21, sbb);
        this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, 14, 7, 21, sbb);
        if (!this.dispenserPlaced) {
            final int bx = this.func_74865_a(13, 20);
            final int by = this.func_74862_a(6);
            final int bz = this.func_74873_b(13, 20);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.func_175898_b((Vector3i)pos)) {
                this.dispenserPlaced = true;
                world.func_180501_a(pos, (BlockState)Blocks.field_150367_z.func_176223_P().func_206870_a((Property)DispenserBlock.field_176441_a, (Comparable)Direction.NORTH), 4);
                final DispenserTileEntity ted = (DispenserTileEntity)world.func_175625_s(pos);
                for (int i = 0; i < 4; ++i) {
                    ted.func_70299_a(i, new ItemStack((IItemProvider)ColorUtil.WOOL.getRandomColor(rand), 1));
                }
            }
        }
        if (!this.beastPlaced) {
            final int bx = this.func_74865_a(13, 13);
            final int by = this.func_74862_a(0);
            final int bz = this.func_74873_b(13, 13);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.func_175898_b((Vector3i)pos)) {
                this.beastPlaced = true;
                final QuestRamEntity ram = new QuestRamEntity(TFEntities.quest_ram, (World)world.func_201672_e());
                ram.func_70107_b((double)bx, (double)by, (double)bz);
                ram.func_213390_a(pos, 13);
                ram.func_213386_a((IServerWorld)world, world.func_175649_E(pos), SpawnReason.STRUCTURE, (ILivingEntityData)null, (CompoundNBT)null);
                world.func_217376_c((Entity)ram);
            }
        }
        return true;
    }
    
    private void makeWallSide(final ISeedReader world, final Direction direction, final MutableBoundingBox sbb) {
        final Direction temp = this.func_186165_e();
        this.func_186164_a(direction);
        this.placeOuterArch(world, 3, -1, sbb);
        this.placeOuterArch(world, 11, -1, sbb);
        this.placeOuterArch(world, 19, -1, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 0, 0, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 0, 1, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 0, 2, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 0, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 1, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 2, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 8, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 9, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 10, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 16, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 17, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 18, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 24, 3, 0, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 25, 3, 0, sbb);
        for (int x = 0; x < 9; ++x) {
            for (int y = 0; y < 9; ++y) {
                for (int z = 0; z < 2; ++z) {
                    if (x == 0 || x == 1 || x == 7 || x == 8 || y == 0 || y == 1 || y == 7 || y == 8) {
                        this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, x + 9, y - 2, z + 5, sbb);
                    }
                }
            }
        }
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 6, 0, 6, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 6, 1, 6, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 6, 2, 6, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 6, 3, 6, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 6, 4, 6, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 7, 4, 6, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 8, 4, 6, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 18, 4, 6, sbb);
        this.func_175811_a(world, QuestGroveComponent.CHISELED_STONEBRICK, 19, 4, 6, sbb);
        this.func_186164_a(temp);
    }
    
    private void placeOuterArch(final ISeedReader world, final int ox, final int oy, final MutableBoundingBox sbb) {
        for (int x = 0; x < 5; ++x) {
            for (int y = 0; y < 6; ++y) {
                if (x == 0 || x == 4 || y == 0 || y == 5) {
                    this.func_175811_a(world, QuestGroveComponent.MOSSY_STONEBRICK, x + ox, y + oy, 0, sbb);
                }
            }
        }
    }
    
    static {
        MOSSY_STONEBRICK = Blocks.field_196698_dj.func_176223_P();
        CHISELED_STONEBRICK = Blocks.field_196702_dl.func_176223_P();
    }
}
