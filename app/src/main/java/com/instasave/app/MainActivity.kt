package com.instasave.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(28, 48, 28, 28)
            setBackgroundColor(Color.rgb(250, 248, 255))
        }

        val heading = TextView(this).apply {
            text = "InstaSave"
            textSize = 32f
            setTextColor(Color.rgb(100, 55, 190))
            gravity = Gravity.CENTER
        }
        page.addView(heading, matchWidth())

        val subtitle = TextView(this).apply {
            text = "Save public Instagram reels"
            textSize = 16f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 12, 0, 32)
        }
        page.addView(subtitle, matchWidth())

        val linkInput = EditText(this).apply {
            hint = "Paste an Instagram reel link"
            textSize = 16f
            singleLine = true
            setPadding(16, 14, 16, 14)
            setBackgroundColor(Color.WHITE)
        }
        page.addView(linkInput, matchWidth())

        val checkButton = Button(this).apply {
            text = "Check link"
            setOnClickListener {
                val link = linkInput.text.toString().trim()
                val valid = link.startsWith("https://www.instagram.com/reel/") ||
                    link.startsWith("https://instagram.com/reel/") ||
                    link.startsWith("https://www.instagram.com/p/") ||
                    link.startsWith("https://instagram.com/p/")

                status.text = if (valid) {
                    "Link looks valid. Download support is the next step."
                } else {
                    "Please paste a valid public Instagram reel or post link."
                }
            }
        }
        val buttonParams = matchWidth().apply { topMargin = 18 }
        page.addView(checkButton, buttonParams)

        val status = TextView(this).apply {
            text = "Paste a public Instagram link to get started."
            textSize = 14f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 0)
        }
        page.addView(status, matchWidth())

        val note = TextView(this).apply {
            text = "Only save content you own or have permission to download."
            textSize = 12f
            setTextColor(Color.GRAY)
            gravity = Gravity.CENTER
            setPadding(0, 36, 0, 0)
        }
        page.addView(note, matchWidth())

        setContentView(page)
    }

    private fun matchWidth(): LinearLayout.LayoutParams =
        LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
}
