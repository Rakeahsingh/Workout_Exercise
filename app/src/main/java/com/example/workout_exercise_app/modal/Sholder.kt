package com.example.workout_exercise_app.modal

import android.os.Parcel
import android.os.Parcelable

data class Sholder(
    val image : Int,
    val name : String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sholder> {
        override fun createFromParcel(parcel: Parcel): Sholder {
            return Sholder(parcel)
        }

        override fun newArray(size: Int): Array<Sholder?> {
            return arrayOfNulls(size)
        }
    }
}
