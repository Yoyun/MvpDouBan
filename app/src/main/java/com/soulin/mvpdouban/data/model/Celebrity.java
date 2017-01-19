package com.soulin.mvpdouban.data.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class Celebrity {

	@Nullable
	@SerializedName("alt")
	public abstract String alt();

	@SerializedName("name")
	public abstract String name();

	@Nullable
	@SerializedName("id")
	public abstract String id();

	@Nullable
	@SerializedName("avatars")
	public abstract Avatars avatars();

	public static TypeAdapter<Celebrity> typeAdapter(Gson gson) {
		return new AutoValue_Celebrity.GsonTypeAdapter(gson);
	}

	public static Builder builder() {
		return new AutoValue_Celebrity.Builder();
	}

	@AutoValue.Builder
	public abstract static class Builder {
		public abstract Builder setAlt(@Nullable String alt);

		public abstract Builder setName(String name);

		public abstract Builder setId(@Nullable String id);

		public abstract Builder setAvatars(@Nullable Avatars avatars);

		public abstract Celebrity build();
	}
}