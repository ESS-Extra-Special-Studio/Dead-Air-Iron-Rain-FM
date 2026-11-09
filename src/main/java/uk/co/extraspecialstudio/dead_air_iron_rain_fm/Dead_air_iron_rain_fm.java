package uk.co.extraspecialstudio.dead_air_iron_rain_fm;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

import java.util.List;

@Mod(Dead_air_iron_rain_fm.MODID)
public class Dead_air_iron_rain_fm {
    public static final String MODID = "dead_air_iron_rain_fm";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final List<String> TRACK_SLUGS = List.of(
        "archive_of_unfinished_reactions",
        "artificial_bloom_refuses_decay",
        "basalt_memory_engine",
        "biome_shift_breakdown",
        "ceiling_learns_to_forget_gravity",
        "compass_without_north",
        "echo_quarry",
        "echoes_that_learned_my_name",
        "event_horizon_drifts",
        "fractured_circuit",
        "glass_spine_arithmetic",
        "grammar_for_things_that_won_t_stay_still",
        "gravemind_alloy",
        "iron_vein_overclock",
        "neon_bedrock_protocol",
        "nullstone_harmonics",
        "obsidian_return_cycle",
        "pickaxe_paradox_engine",
        "quantum_ore_drift",
        "rotting_compass_still_points_down",
        "sculk_resonance_engine",
        "silk_with_a_serrated_edge",
        "snow_layer_liturgy",
        "spawnpoint_aftermath_protocol",
        "subterrain_pulse_array",
        "teeth_like_exit_signs",
        "the_lantern_that_ate_its_keeper",
        "three-phase_wither_equation",
        "velocity_pickaxe_protocol",
        "you_rewritten_in_margins"
    );

    public Dead_air_iron_rain_fm(IEventBus modEventBus) {
        modEventBus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        event.register(Registries.SOUND_EVENT, registry -> {
            for (String slug : TRACK_SLUGS) {
                ResourceLocation id = new ResourceLocation(MODID, "music." + slug);
                registry.register(id, SoundEvent.createVariableRangeEvent(id));
            }
        });
        LOGGER.info("[Iron Rain FM] Registered {} tracks.", TRACK_SLUGS.size());
    }
}
