package com.roleslayin.roleslayer;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayerCharacter implements Parcelable {
    String name;
    String info;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(info);
    }

    public static final Parcelable.Creator<PlayerCharacter> CREATOR = new Parcelable.Creator<PlayerCharacter>() {
        public PlayerCharacter createFromParcel(Parcel in) {
            return new PlayerCharacter(in);
        }
        public PlayerCharacter[] newArray(int size) {
            return new PlayerCharacter[size];
        }
    };

    public PlayerCharacter() {}

    private PlayerCharacter(Parcel in) {
        name = in.readString();
        info = in.readString();
    }

    void setName(String name) {
        this.name = name;
    }
    void setInfo(String info) {
        this.info = info;
    }

    String getName() {
        return name;
    }
    String getInfo() {
        return info;
    }
}
