package net.msmp.mod.entity.projectile;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import net.msmp.mod.entity.ModEntityTypes;

public class PregoEntity extends AbstractArrow {
    public PregoEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public PregoEntity(Level pLevel, double x, double y, double z) {
        super(ModEntityTypes.PREGO_PROJECTILE.get(), x, y, z, pLevel);
    }

    public PregoEntity(Level pLevel, LivingEntity shooter) {
        super(ModEntityTypes.PREGO_PROJECTILE.get(), shooter, pLevel);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
