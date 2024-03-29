package com.example.medbutler.classes.model

import java.io.Serializable

class Med:Serializable {

    var id: String = ""
    private var name: String = ""
    private var period: Int = 0
    private var duration: Int = 0
    private var startTimeMinute:Int = 0
    private var startTimeHour:Int = 0
    private var allowNotification:Boolean = false

    constructor(){
    }

    constructor(id: String, name: String, period: Int, duration: Int, startTimeMinute:Int, startTimeHour:Int, allowNotification:Boolean){
        this.id = id
        this.name = name
        this.period = period
        this.duration = duration
        this.startTimeMinute = startTimeMinute
        this.startTimeHour = startTimeHour
        this.allowNotification = allowNotification
    }

    override fun toString(): String {
        return name
    }

    fun toStringAllAtributes(): String {
        var hour:String = ('0' + startTimeHour.toString())
        var minute:String = ('0' + startTimeMinute.toString())
        var durationModif:String
        if (duration == 0){
            durationModif = "forever"
        }else if(duration == 1){
            durationModif = "for just one day"
        }else{
            durationModif = "for "+ duration + " days"
        }
        var string: String = name + " - every " + period + " hours - "+ durationModif + " - " + hour.substring(hour.length-2) + ":" + minute.substring(minute.length-2)
        if (allowNotification){
            return (string + " - notification ON")
        }else{
            return (string + " - notification OFF")
        }
    }

    fun getname(): String? {
        return this.name
    }
    fun setname(newName:String){
        this.name=newName
    }
    fun getperiod(): Int? {
        return this.period
    }
    fun setperiod(newPeriod:Int){
        this.period=newPeriod
    }
    fun getduration(): Int? {
        return this.duration
    }
    fun setduration(newduration:Int){
        this.duration=newduration
    }
    fun getstartTimeMinute(): Int? {
        return this.startTimeMinute
    }
    fun setstartTimeMinute(newstartTimeMinute:Int){
        this.startTimeMinute=newstartTimeMinute
    }
    fun getstartTimeHour(): Int? {
        return this.startTimeHour
    }
    fun setstartTimeHour(newstartTimeHour:Int){
        this.startTimeHour=newstartTimeHour
    }
    fun getallowNotification(): Boolean? {
        return this.allowNotification
    }
    fun setallowNotification(allowNotification:Boolean){
        this.allowNotification = allowNotification
    }
}