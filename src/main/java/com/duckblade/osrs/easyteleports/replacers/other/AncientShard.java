package com.duckblade.osrs.easyteleports.replacers.other;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.widgets.Widget;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class AncientShard implements Replacer
{
	private static final String ANCIENT_SHARD_DIALOGUE_HEADER = "Where do you want to go? (1 shard)";

	private final List<TeleportReplacement> replacements = new ArrayList<>(5);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableAncientShard();
		replacements.clear();

		replacements.add(new TeleportReplacement("Demons' Run", config.replacementAncientShardDemonsRun()));
		replacements.add(new TeleportReplacement("Dragons' Den", config.replacementAncientShardDragonsDen()));
		replacements.add(new TeleportReplacement("Reeking Cove", config.replacementAncientShardReekingCove()));
		replacements.add(new TeleportReplacement("The Shallows", config.replacementAncientShardTheShallows()));
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToDialog(Widget root)
	{
		Widget[] children = root.getChildren();
		return children != null &&
				children.length >= 5 &&
				ANCIENT_SHARD_DIALOGUE_HEADER.equals(children[0].getText());
	}
}