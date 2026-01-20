package net.msmp.mod.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.msmp.mod.client.ClientThirstData;

import java.util.function.Supplier;

public class ThirstDataSyncS2CPacket {
    private final int thirst;

    // Construtor usado no Servidor (para criar o pacote)
    public ThirstDataSyncS2CPacket(int thirst) {
        this.thirst = thirst;
    }

    // Construtor usado pelo descodificador (para ler os dados recebidos)
    public ThirstDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.thirst = buf.readInt();
    }

    // Escreve os dados no buffer para envio
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(thirst);
    }

    // O que acontece quando o pacote chega ao Cliente
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // AQUI: Atualiza o valor no Cliente para a barra mexer
            // Certifique-se de que tem a classe ClientThirstData criada
            ClientThirstData.set(thirst);
        });
        return true;
    }
}