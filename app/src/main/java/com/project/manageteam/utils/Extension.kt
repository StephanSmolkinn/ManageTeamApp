package com.project.manageteam.utils

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragment(
    container: Int,
    fragment: Fragment,
    tag: String = fragment.javaClass.simpleName
) = supportFragmentManager
    .beginTransaction()
    .replace(container, fragment, tag)
    .commit()

// Navigation from fragments
fun transaction(container: Int, fragment: Fragment, activity: AppCompatActivity, bundle: Bundle?) {
    fragment.arguments = bundle
    val transaction = activity.supportFragmentManager.beginTransaction()
    transaction.replace(container, fragment)
    transaction.addToBackStack("fragments")
    transaction.commit()
}

// Implement BackPressed
fun setupOnBackPressed(activity: AppCompatActivity) {
    activity.onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (isEnabled) {
                isEnabled = false
                activity.onBackPressed()
            }
        }
    })
}