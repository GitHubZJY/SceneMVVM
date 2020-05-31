package com.example.scenedemo.room.view.bottombar.view

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.bytedance.scene.ktx.postDelayed
import com.example.scenedemo.R
import com.example.scenedemo.room.view.BaseRoomScene
import com.example.scenedemo.room.view.bottombar.enums.FooterStates
import com.example.scenedemo.utils.SoftKeyBoardUtil


class BottomBarScene : BaseRoomScene() {

    private var vReward: ImageView? = null
    private var vSend: TextView? = null
    private var vEmoji: ImageView? = null
    private var vInput: EditText? = null


    override fun onInflaterViewId(): Int {
        return R.layout.layout_bottom_bar
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindView(view: View?) {
        vReward = findViewById(R.id.footer_more)
        vSend = findViewById(R.id.footer_send)
        vEmoji = findViewById(R.id.footer_face)
        vInput = findViewById(R.id.footer_input)

        vReward?.setOnClickListener {
            mUIStateViewModel.setSoftKeyBoardState(false)
            mUIStateViewModel.setFooterState(FooterStates.NORMAL_INPUT)
            postDelayed(Runnable { mUIStateViewModel.setShowRewardPanel(true) },200)
            mUIStateViewModel.setShowEmojiPanel(false)
        }

        vInput?.requestFocus()

        vInput?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(inputText: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (TextUtils.isEmpty(inputText)) {
                    vSend?.visibility = View.GONE
                    vReward?.visibility = View.VISIBLE
                } else {
                    vSend?.visibility = View.VISIBLE
                    vReward?.visibility = View.GONE
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        vInput?.setOnTouchListener { _, event ->
            mUIStateViewModel.setFooterState(FooterStates.NORMAL_INPUT)
            mUIStateViewModel.setShowRewardPanel(false)
            mUIStateViewModel.setShowEmojiPanel(false)
            mUIStateViewModel.setSoftKeyBoardState(true)
            false
        }

        vEmoji?.setOnClickListener {
            mUIStateViewModel.setShowRewardPanel(false)
            if (mUIStateViewModel.getFooterState().value == FooterStates.EMOJI_INPUT) {
                mUIStateViewModel.setSoftKeyBoardState(true)
                mUIStateViewModel.setShowEmojiPanel(false)
                mUIStateViewModel.setFooterState(FooterStates.NORMAL_INPUT)
            } else {
                mUIStateViewModel.setSoftKeyBoardState(false)
                postDelayed(Runnable { mUIStateViewModel.setShowEmojiPanel(true) },200)
                mUIStateViewModel.setFooterState(FooterStates.EMOJI_INPUT)
            }
        }

        vSend?.setOnClickListener {
            mChatViewModel.sendMsg(vInput?.text.toString())
            vInput?.setText("")
        }
    }

    override fun bindObserver() {
        mRewardViewModel.getRewardData().observe(this, Observer {

        })

        mUIStateViewModel.getSoftKeyBoardState().observe(this, Observer { show ->
            if (show) {
                vInput?.requestFocus()
                SoftKeyBoardUtil.showKeyboard(vInput)
            } else {
                vInput?.clearFocus()
                SoftKeyBoardUtil.hideKeyboard(vInput)
            }
        })

        mUIStateViewModel.getFooterState().observe(this, Observer { footerState ->
            footerState?.let {
                when (footerState) {
                    FooterStates.NORMAL_INPUT -> {
                        vEmoji?.setImageResource(R.drawable.ic_bottom_bar_face)
                        vReward?.visibility = View.VISIBLE
                        vInput?.visibility = View.VISIBLE
                    }
                    FooterStates.EMOJI_INPUT -> {
                        vEmoji?.setImageResource(R.drawable.ic_bottom_bar_input)
                        vInput?.visibility = View.VISIBLE
                    }

                }
            }
        })


    }

}