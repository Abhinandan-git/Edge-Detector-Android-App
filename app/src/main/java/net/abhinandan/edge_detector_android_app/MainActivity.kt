package net.abhinandan.edge_detector_android_app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import net.abhinandan.edge_detector_android_app.ui.theme.EdgeDetectorAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (!hasRequiredPermission()) {
            ActivityCompat.requestPermissions(
                this, arrayOf(CAMERA_PERMISSION), 0
            )
        }

        setContent {
            EdgeDetectorAndroidAppTheme {

            }
        }
    }

    private fun hasRequiredPermission(): Boolean {
        return ContextCompat.checkSelfPermission(applicationContext, CAMERA_PERMISSION) == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        private const val CAMERA_PERMISSION = Manifest.permission.CAMERA
    }
}
