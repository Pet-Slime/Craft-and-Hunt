package com.aavri.craftandhunt.blocks;

import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import com.aavri.craftandhunt.init.RegisterBlocks;

public class FilledlPumicBlock extends WetSpongeBlock {
    public FilledlPumicBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        long count = iceDirectionStreamProvider(worldIn, pos)
                .count();
        if (count >= 5) {
            worldIn.setBlockState(pos, RegisterBlocks.pumice.get().getDefaultState(), 3);
            worldIn.playEvent(2001, pos, Block.getStateId(Blocks.ICE.getDefaultState()));
            iceDirectionStreamProvider(worldIn, pos)
                    .forEach(direction -> worldIn.setBlockState(pos.offset(direction), Blocks.WATER.getDefaultState(), 3));
        }
    }

    private Stream<Direction> iceDirectionStreamProvider(World worldIn, BlockPos pos) {
        return Arrays.stream(Direction.values())
                .filter(direction -> worldIn.getBlockState(pos.offset(direction)).getBlock().getTags().contains(new ResourceLocation("minecraft:ice")));
    }
    
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (!entityIn.isImmuneToFire() && entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn)) {
           entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
        }
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        Direction direction = Direction.getRandomDirection(rand);
        if (direction != Direction.UP) {
            BlockPos blockpos = pos.offset(direction);
            BlockState blockstate = worldIn.getBlockState(blockpos);
            if (!stateIn.isSolid() || !blockstate.isSolidSide(worldIn, blockpos, direction.getOpposite())) {
                double d0 = pos.getX();
                double d1 = pos.getY();
                double d2 = pos.getZ();
                if (direction == Direction.DOWN) {
                    d1 = d1 - 0.05D;
                    d0 += rand.nextDouble();
                    d2 += rand.nextDouble();
                } else {
                    d1 = d1 + rand.nextDouble() * 0.8D;
                    if (direction.getAxis() == Direction.Axis.X) {
                        d2 += rand.nextDouble();
                        if (direction == Direction.EAST) {
                            ++d0;
                        } else {
                            d0 += 0.05D;
                        }
                    } else {
                        d0 += rand.nextDouble();
                        if (direction == Direction.SOUTH) {
                            ++d2;
                        } else {
                            d2 += 0.05D;
                        }
                    }
                }
                worldIn.addParticle(ParticleTypes.DRIPPING_LAVA, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
