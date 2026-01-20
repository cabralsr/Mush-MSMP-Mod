package net.msmp.mod.thirst;

import net.minecraft.nbt.CompoundTag;

public class PlayerThirst {
    private int thirst;
    private final int MAX_THIRST = 20;
    private final int MIN_THIRST = 0;

    public PlayerThirst() {
        this.thirst = MAX_THIRST;
    }

    public int getThirst() {
        return thirst;
    }

    public void addThirst(int add) {
        this.thirst = Math.min(MAX_THIRST, this.thirst + add);
    }

    public void subThirst(int sub) {
        this.thirst = Math.max(MIN_THIRST, this.thirst - sub);
    }

    public void copyFrom(PlayerThirst source) {
        this.thirst = source.thirst;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("thirst", thirst);
    }

    public void loadNBTData(CompoundTag nbt) {
        thirst = nbt.getInt("thirst");
    }
}