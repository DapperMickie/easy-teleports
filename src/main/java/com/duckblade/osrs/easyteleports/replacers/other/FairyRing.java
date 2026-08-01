package com.duckblade.osrs.easyteleports.replacers.other;

import com.duckblade.osrs.easyteleports.EasyTeleportsConfig;
import com.duckblade.osrs.easyteleports.TeleportReplacement;
import com.duckblade.osrs.easyteleports.replacers.Replacer;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class FairyRing implements Replacer
{
	private static final String[] FAIRY_RING_CODES = {
		"AIQ", "AIR", "AIS", "AJP", "AJQ", "AJR", "AJS", "AKP", "AKQ", "AKR", "AKS", "ALP", "ALQ", "ALR", "ALS",
		"BIP", "BIQ", "BIS", "BJP", "BJR", "BJS", "BKP", "BKQ", "BKR", "BKS", "BLP", "BLQ", "BLR", "BLS",
		"CIP", "CIQ", "CIR", "CIS", "CJQ", "CJR", "CKP", "CKQ", "CKR", "CKS", "CLP", "CLR", "CLS",
		"DIP", "DIQ", "DIR", "DIS", "DJP", "DJR", "DKP", "DKR", "DKS", "DLP", "DLQ", "DLR", "DLS"
	};

	private final List<TeleportReplacement> replacements =
		new ArrayList<>(FAIRY_RING_CODES.length);

	@Getter(onMethod = @__(@Override))
	private boolean enabled = false;

	@Override
	public void onConfigChanged(EasyTeleportsConfig config)
	{
		this.enabled = config.enableFairyRings();
		replacements.clear();

		for (String fairyRingCode : FAIRY_RING_CODES)
		{
			replacements.add(new TeleportReplacement(fairyRingCode, getReplacement(config, fairyRingCode)));
		}
	}

	private String getReplacement(EasyTeleportsConfig config, String code)
	{
		switch (code)
		{
			case "AIQ":
				return config.replacementFairyRingAIQ();
			case "AIR":
				return config.replacementFairyRingAIR();
			case "AIS":
				return config.replacementFairyRingAIS();
			case "AJP":
				return config.replacementFairyRingAJP();
			case "AJQ":
				return config.replacementFairyRingAJQ();
			case "AJR":
				return config.replacementFairyRingAJR();
			case "AJS":
				return config.replacementFairyRingAJS();
			case "AKP":
				return config.replacementFairyRingAKP();
			case "AKQ":
				return config.replacementFairyRingAKQ();
			case "AKR":
				return config.replacementFairyRingAKR();
			case "AKS":
				return config.replacementFairyRingAKS();
			case "ALP":
				return config.replacementFairyRingALP();
			case "ALQ":
				return config.replacementFairyRingALQ();
			case "ALR":
				return config.replacementFairyRingALR();
			case "ALS":
				return config.replacementFairyRingALS();
			case "BIP":
				return config.replacementFairyRingBIP();
			case "BIQ":
				return config.replacementFairyRingBIQ();
			case "BIS":
				return config.replacementFairyRingBIS();
			case "BJP":
				return config.replacementFairyRingBJP();
			case "BJR":
				return config.replacementFairyRingBJR();
			case "BJS":
				return config.replacementFairyRingBJS();
			case "BKP":
				return config.replacementFairyRingBKP();
			case "BKQ":
				return config.replacementFairyRingBKQ();
			case "BKR":
				return config.replacementFairyRingBKR();
			case "BKS":
				return config.replacementFairyRingBKS();
			case "BLP":
				return config.replacementFairyRingBLP();
			case "BLQ":
				return config.replacementFairyRingBLQ();
			case "BLR":
				return config.replacementFairyRingBLR();
			case "BLS":
				return config.replacementFairyRingBLS();
			case "CIP":
				return config.replacementFairyRingCIP();
			case "CIQ":
				return config.replacementFairyRingCIQ();
			case "CIR":
				return config.replacementFairyRingCIR();
			case "CIS":
				return config.replacementFairyRingCIS();
			case "CJQ":
				return config.replacementFairyRingCJQ();
			case "CJR":
				return config.replacementFairyRingCJR();
			case "CKP":
				return config.replacementFairyRingCKP();
			case "CKQ":
				return config.replacementFairyRingCKQ();
			case "CKR":
				return config.replacementFairyRingCKR();
			case "CKS":
				return config.replacementFairyRingCKS();
			case "CLP":
				return config.replacementFairyRingCLP();
			case "CLR":
				return config.replacementFairyRingCLR();
			case "CLS":
				return config.replacementFairyRingCLS();
			case "DIP":
				return config.replacementFairyRingDIP();
			case "DIQ":
				return config.replacementFairyRingDIQ();
			case "DIR":
				return config.replacementFairyRingDIR();
			case "DIS":
				return config.replacementFairyRingDIS();
			case "DJP":
				return config.replacementFairyRingDJP();
			case "DJR":
				return config.replacementFairyRingDJR();
			case "DKP":
				return config.replacementFairyRingDKP();
			case "DKR":
				return config.replacementFairyRingDKR();
			case "DKS":
				return config.replacementFairyRingDKS();
			case "DLP":
				return config.replacementFairyRingDLP();
			case "DLQ":
				return config.replacementFairyRingDLQ();
			case "DLR":
				return config.replacementFairyRingDLR();
			case "DLS":
				return config.replacementFairyRingDLS();
			default:
				return "";
		}
	}

	@Override
	public List<TeleportReplacement> getReplacements()
	{
		return ImmutableList.copyOf(replacements);
	}

	@Override
	public boolean isApplicableToFairyRing(String code)
	{
		for (String fairyRingCode : FAIRY_RING_CODES)
		{
			if (fairyRingCode.equals(code))
			{
				return true;
			}
		}

		return false;
	}
}
