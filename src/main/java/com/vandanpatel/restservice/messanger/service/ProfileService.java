package com.vandanpatel.restservice.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vandanpatel.restservice.messanger.database.DatabaseClass;
import com.vandanpatel.restservice.messanger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Vandan", new Profile(1L, "Vandan", "Vandan", "Patel"));
		profiles.put("Preeti", new Profile(2L, "Preeti", "Preeti", "Patel"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
