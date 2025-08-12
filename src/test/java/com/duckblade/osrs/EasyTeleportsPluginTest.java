package com.duckblade.osrs;

import com.duckblade.osrs.easyteleports.EasyTeleportsPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class EasyTeleportsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(EasyTeleportsPlugin.class);
		RuneLite.main(args);
	}
}