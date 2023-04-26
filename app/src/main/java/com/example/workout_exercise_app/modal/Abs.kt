package com.example.workout_exercise_app.modal

import android.os.Parcel
import android.os.Parcelable

data class Abs(
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

    companion object CREATOR : Parcelable.Creator<Abs> {
        override fun createFromParcel(parcel: Parcel): Abs {
            return Abs(parcel)
        }

        override fun newArray(size: Int): Array<Abs?> {
            return arrayOfNulls(size)
        }
    }
}
