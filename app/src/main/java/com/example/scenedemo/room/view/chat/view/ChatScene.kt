package com.example.scenedemo.room.view.chat.view

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.scene.ktx.postDelayed
import com.example.scenedemo.R
import com.example.scenedemo.room.view.BaseRoomScene
import com.example.scenedemo.utils.KeyboardFix

class ChatScene : BaseRoomScene() {

    private var vChatRv: RecyclerView? = null
    private var vLayoutManager: LinearLayoutManager? = null
    private var mKeyboardFix: KeyboardFix? = null


    override fun onInflaterViewId(): Int {
        return R.layout.layout_chat
    }

    override fun onBindView(view: View?) {
        vChatRv = findViewById(R.id.chat_rv)
        vChatRv?.apply {
            vLayoutManager =
                LinearLayoutManager(requireSceneContext(), RecyclerView.VERTICAL, true)
            vLayoutManager?.stackFromEnd = true
            layoutManager = vLayoutManager
        }
        mKeyboardFix = KeyboardFix(view)
        mKeyboardFix?.addOnKeyboardChangeListener(object : KeyboardFix.OnKeyboardChangeAdapter() {
            override fun onChange(isVisible: Boolean, contentHeight: Int, usableHeight: Int) {
                scrollToLastMsg()
            }
        })
    }

    override fun bindObserver() {
        mChatViewModel.getChatListData().observe(this, Observer {
            vChatRv?.apply {
                if (adapter == null) {
                    adapter =
                        ChatListAdapter(
                            requireSceneContext(),
                            it
                        )
                }
                adapter?.apply {
                    notifyDataSetChanged()
                    scrollToPosition(0)
                }
            }
        })

        mUIStateViewModel.getShowRewardPanel().observe(this, Observer {
            if (it) {
                scrollToLastMsg()
            }
        })
        mUIStateViewModel.getShowEmojiPanel().observe(this, Observer {
            if (it) {
                scrollToLastMsg()
            }
        })
        mUIStateViewModel.getSoftKeyBoardState().observe(this, Observer {
            if (it) {
                scrollToLastMsg()
            }
        })
    }

    override fun setData() {
        postDelayed(Runnable {
            mChatViewModel.loadChatList()
        }, 1000)
    }

    private fun scrollToLastMsg() {
        vLayoutManager?.scrollToPositionWithOffset(0, 0)
    }

}