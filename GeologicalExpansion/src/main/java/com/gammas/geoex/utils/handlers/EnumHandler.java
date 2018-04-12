package com.gammas.geoex.utils.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {

	public static enum Materials implements IStringSerializable {
		CHUNK_BANDED_IRON("chunk_bandedIron", "null"),
		POWDER_BANDED_IRON("powder_bandedIron", "powderBandedIron"),
		SEPARATED_BANDED_IRON("separated_bandedIron", "dustCrudeIronOre");

		private int ID;
		private String name;
		private String oreDictionaryEntry;
		
		private static int UniID = 0;

		private Materials(String name, String oreDictioaryEntry) {
			this.name = name;
			this.ID = setID();
			this.oreDictionaryEntry = oreDictioaryEntry;
		}
		
		private int setID() {
			return UniID++;
		}

		@Override
		public String getName() {
			return name;
		}

		public int getID() {
			return ID;
		}
		
		public String getOreDictionaryEntry() {
			return oreDictionaryEntry;
		}
		
		@Override
		public String toString() {
			return getName();
		}
		
	}

}
