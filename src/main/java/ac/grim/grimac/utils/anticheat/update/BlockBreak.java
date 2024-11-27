package ac.grim.grimac.utils.anticheat.update;

import ac.grim.grimac.player.GrimPlayer;
import com.github.retrooper.packetevents.protocol.player.DiggingAction;
import com.github.retrooper.packetevents.protocol.world.BlockFace;
import com.github.retrooper.packetevents.protocol.world.states.WrappedBlockState;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerDigging;
import lombok.Getter;

public class BlockBreak {
    public final Vector3i position;
    public final BlockFace face;
    public final DiggingAction action;
    @Getter
    private boolean cancelled;

    public final WrappedBlockState block;

    public BlockBreak(WrapperPlayClientPlayerDigging packet, GrimPlayer player) {
        this(packet.getBlockPosition(), packet.getBlockFace(), packet.getAction(), player.compensatedWorld.getWrappedBlockStateAt(packet.getBlockPosition()));
    }

    public BlockBreak(Vector3i position, BlockFace face, DiggingAction action, WrappedBlockState block) {
        this.position = position;
        this.face = face;
        this.action = action;
        this.block = block;
    }

    public void cancel() {
        this.cancelled = true;
    }
}
