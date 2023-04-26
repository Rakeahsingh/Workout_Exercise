package com.example.workout_exercise_app.modal

import android.os.Parcel
import android.os.Parcelable

data class Triceps(
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

    companion object CREATOR : Parcelable.Creator<Triceps> {
        override fun createFromParcel(parcel: Parcel): Triceps {
            return Triceps(parcel)
        }

        override fun newArray(size: Int): Array<Triceps?> {
            return arrayOfNulls(size)
        }
    }
}
