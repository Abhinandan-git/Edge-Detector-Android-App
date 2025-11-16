package net.abhinandan.edge_detector_android_app

import java.nio.ByteBuffer

object NativeBridge {
    init {
        System.loadLibrary("native-lib")
    }

    external fun processFrame(
        buffer: ByteBuffer,
        width: Int,
        height: Int
    )
}
