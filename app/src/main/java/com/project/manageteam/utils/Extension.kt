package com.project.manageteam.utils

import android.os.Bundle
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

fun transaction(container: Int, fragment: Fragment, activity: AppCompatActivity, bundle: Bundle?) {
    fragment.arguments = bundle
    val transaction = activity?.supportFragmentManager?.beginTransaction()
    transaction?.replace(container, fragment)
    transaction?.disallowAddToBackStack()
    transaction?.commit()
}