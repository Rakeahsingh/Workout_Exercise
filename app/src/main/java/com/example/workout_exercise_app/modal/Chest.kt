package com.example.workout_exercise_app.modal

import android.os.Parcel
import android.os.Parcelable

data class Chest(
    val Image : Int,
    val name : String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Chest> {
        override fun createFromParcel(parcel: Parcel): Chest {
            return Chest(parcel)
        }

        override fun newArray(size: Int): Array<Chest?> {
            return arrayOfNulls(size)
        }
    }
}
