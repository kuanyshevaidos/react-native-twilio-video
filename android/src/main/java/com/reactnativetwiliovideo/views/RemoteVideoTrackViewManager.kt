package com.reactnativetwiliovideo.views

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.reactnativetwiliovideo.TwilioVideoModule
import com.reactnativetwiliovideo.models.videoScaleTypeFromReactScaleType
import com.twilio.video.VideoScaleType

class RemoteVideoTrackViewManager(private val context: ReactApplicationContext) : SimpleViewManager<VideoTrackView>() {
  override fun getName(): String {
    return "RemoteVideoTrackView"
  }

  override fun createViewInstance(reactContext: ThemedReactContext): VideoTrackView {
    return VideoTrackView(reactContext)
  }

  @ReactProp(name = "sid")
  fun setName(view: VideoTrackView, sid: String?) {
    val localVideoTrack = if (sid != null) context.getNativeModule(TwilioVideoModule::class.java)?.findRemoteVideoTrack(sid) else null
    view.videoTrack = localVideoTrack
  }

  @ReactProp(name = "scaleType")
  fun setScaleType(view: VideoTrackView, scaleType: String?) {
    view.videoScaleType = videoScaleTypeFromReactScaleType(scaleType) ?: VideoScaleType.ASPECT_FIT
  }

  @ReactProp(name = "mirror")
  fun setMirror(view: VideoTrackView, mirror: Boolean?) {
    view.mirror = mirror ?: false
  }
}
