package com.example.medbutler.classes.view

import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.medbutler.R
import com.example.medbutler.classes.controller.MainController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)
        updateAppearance()
    }

    override fun onResume() {
        updateAppearance()
        super.onResume()
    }

    fun updateAppearance(){

        // Set PorterDuffColorFilter with color and mode
        val mode = PorterDuff.Mode.ADD //ADD
        val mode2 = PorterDuff.Mode.OVERLAY

        // profileImagePerson
        val profileImagePerson:ImageView = findViewById(R.id.profileImagePerson)
        val context: Context = profileImagePerson.getContext()
        val id: Int = context.getResources().getIdentifier(MainController.getcurrent().getappearanceInfo().getprofileImagePersonId(), "drawable", context.getPackageName())
        profileImagePerson.setImageResource(id)

        // background
        val backgroundLay:LinearLayout = findViewById(R.id.backgroundLayout)
        val idBack = resources.getIdentifier(MainController.getcurrent().getappearanceInfo().getbackground(), "drawable", packageName)
        // val drawable = resources.getDrawable(idBack)
        backgroundLay.setBackgroundResource(idBack)

        // profileImageBackground
        val profileImageBackground:ImageView = findViewById(R.id.profileImageBackground)
        val id2: Int = context.getResources().getIdentifier(MainController.getcurrent().getappearanceInfo().getprofileImageBackgroundId(), "drawable", context.getPackageName())
        profileImageBackground.setImageResource(id2)
        profileImageBackground.setColorFilter(MainController.getcurrent().getappearanceInfo().getcolorTheme(), mode)
        val profileLayoutBackground:RelativeLayout = findViewById(R.id.profileLayout)
        profileLayoutBackground.setBackgroundColor(MainController.getcurrent().getappearanceInfo().getcolorTheme())

        // calendarImage
        val calendarImage:ImageView = findViewById(R.id.calendarImage)
        val id3: Int = context.getResources().getIdentifier(MainController.getcurrent().getappearanceInfo().getcalendarImageId(), "drawable", context.getPackageName())
        calendarImage.setImageResource(id3)

        // calendarImageBackground
        val calendarImageBackground:ImageView = findViewById(R.id.calendarImageBackground)
        val id4: Int = context.getResources().getIdentifier(MainController.getcurrent().getappearanceInfo().getcalendarImageBackgroundId(), "drawable", context.getPackageName())
        calendarImageBackground.setImageResource(id4)
        calendarImageBackground.setColorFilter(MainController.getcurrent().getappearanceInfo().getcolorTheme(), mode)
        val calendarLayoutBackground:RelativeLayout = findViewById(R.id.calendarLayout)
        calendarLayoutBackground.setBackgroundColor(MainController.getcurrent().getappearanceInfo().getcolorTheme())

        // settingsImage
        val settingsImage:ImageView = findViewById(R.id.settingsImage)
        val id5: Int = context.getResources().getIdentifier(MainController.getcurrent().getappearanceInfo().getsettingsImageId(), "drawable", context.getPackageName())
        settingsImage.setImageResource(id5)

        // settingsImageBackground
        val settingsImageBackground:ImageView = findViewById(R.id.settingsImageBackground)
        val id6: Int = context.getResources().getIdentifier(MainController.getcurrent().getappearanceInfo().getsettingsImageBackgroundId(), "drawable", context.getPackageName())
        settingsImageBackground.setImageResource(id6)
        settingsImageBackground.setColorFilter(MainController.getcurrent().getappearanceInfo().getcolorTheme(), mode2)
        val settingsLayoutBackground:RelativeLayout = findViewById(R.id.settingsLayout)
        settingsLayoutBackground.setBackgroundColor(MainController.getcurrent().getappearanceInfo().getcolorTheme())

        // treatmentImageFirst
        val treatmentImageFirst:ImageView = findViewById(R.id.treatmentImageFirst)
        val id7: Int = context.getResources().getIdentifier(MainController.getcurrent().getappearanceInfo().gettreatmentImageFirstId(), "drawable", context.getPackageName())
        treatmentImageFirst.setImageResource(id7)

        // treatmentImageSecond
        val treatmentImageSecond:ImageView = findViewById(R.id.treatmentImageSecond)
        val id8: Int = context.getResources().getIdentifier(MainController.getcurrent().getappearanceInfo().gettreatmentImageSecondId(), "drawable", context.getPackageName())
        treatmentImageSecond.setImageResource(id8)
        val treatmentLayoutBackground:RelativeLayout = findViewById(R.id.treatmentLayout)
        treatmentLayoutBackground.setBackgroundColor(MainController.getcurrent().getappearanceInfo().getcolorTheme())

        animacio(treatmentImageFirst,treatmentImageSecond)

        findViewById<TextView>(R.id.welcomeLaber).text = getString(R.string.greeting, MainController.getcurrent().getfullname().substringBefore(' '))
    }

    fun animacio(imageFluix:ImageView,imageFort:ImageView){

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.addUpdateListener(object: ValueAnimator.AnimatorUpdateListener{
            override fun onAnimationUpdate(animation: ValueAnimator?) {
                val animatedValue =animation?.animatedValue as Float
                imageFort.setAlpha(animation.animatedValue as Float)
            }
        })

        animator.duration = 1500
        animator.repeatMode = ValueAnimator.REVERSE
        animator.repeatCount = -1
        animator.start()
    }

    fun actionCalendar(view: View){
        val intent= Intent(this, Calendar::class.java)
        startActivity(intent)
    }
    fun actionUser(view: View){
        val intent= Intent(this, UserProfile::class.java)
        startActivity(intent)
    }
    fun actionMeds(view: View){
        val intent= Intent(this, MedListActivity::class.java)
        startActivity(intent)
    }
    fun actionSettings(view: View){
        val intentSettings= Intent(this, SettingsActivity::class.java)
        startActivity(intentSettings)
    }
}
